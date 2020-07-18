package com.meazza.v_runner.ui.runs

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.meazza.v_runner.R
import com.meazza.v_runner.common.Constants.REQUEST_CODE_LOCATION_PERMISSION
import com.meazza.v_runner.common.Permissions
import com.meazza.v_runner.databinding.FragmentRunsBinding
import com.meazza.v_runner.ui.runs.adapter.RunAdapter
import kotlinx.android.synthetic.main.fragment_runs.*
import org.jetbrains.anko.support.v4.toast
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions


class RunsFragment : Fragment(R.layout.fragment_runs), EasyPermissions.PermissionCallbacks {

    private val runsViewModel by viewModels<RunsViewModel>()
    private val runAdapter by lazy { RunAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DataBindingUtil.bind<FragmentRunsBinding>(view)?.apply {
            lifecycleOwner = this@RunsFragment
            viewModel = runsViewModel
        }

        requestPermissions()
        setUpRecyclerView()
        setUiAction()

        runAdapter.setOnClickListener {
            toast("${it.caloriesBurned}")
        }

        runsViewModel.getRun().observe(viewLifecycleOwner, Observer { runs ->
            runAdapter.differ.submitList(runs)
        })
    }

    private fun setUiAction(){
        fab_new_run.setOnClickListener {
            findNavController().navigate(R.id.action_new_run)
        }
    }

    private fun setUpRecyclerView() {
        rv_runs.run {
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            layoutManager = LinearLayoutManager(context)
            adapter = runAdapter
        }
    }

    private fun requestPermissions() {
        if(Permissions.hasLocationPermissions(requireContext())) {
            return
        }
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            EasyPermissions.requestPermissions(
                this,
                getString(R.string.you_need_to_accept_location_permissions),
                REQUEST_CODE_LOCATION_PERMISSION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        } else {
            EasyPermissions.requestPermissions(
                this,
                getString(R.string.you_need_to_accept_location_permissions),
                REQUEST_CODE_LOCATION_PERMISSION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if(EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        } else {
            requestPermissions()
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {}

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }
}