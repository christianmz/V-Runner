package com.meazza.v_runner.ui.runs

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.meazza.v_runner.R
import com.meazza.v_runner.common.Constants.REQUEST_CODE_LOCATION_PERMISSION
import com.meazza.v_runner.common.PermissionRequester
import com.meazza.v_runner.databinding.FragmentRunsBinding
import com.meazza.v_runner.ui.runs.adapter.RunAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_runs.*
import org.jetbrains.anko.support.v4.toast
import pub.devrel.easypermissions.EasyPermissions
import javax.inject.Inject


@AndroidEntryPoint
class RunsFragment : Fragment(R.layout.fragment_runs) {

    @Inject
    lateinit var mAuth: FirebaseAuth

    private val runsViewModel by viewModels<RunsViewModel>()
    private val runAdapter by lazy { RunAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DataBindingUtil.bind<FragmentRunsBinding>(view)?.apply {
            lifecycleOwner = this@RunsFragment
            viewModel = runsViewModel
        }

        ifRunnerLogged(view)
        setUpRecyclerView()
        setUiAction()

        runAdapter.setOnClickListener {
            toast("${it.caloriesBurned}")
        }

        runsViewModel.getRuns().observe(viewLifecycleOwner, Observer { runs ->
            runAdapter.differ.submitList(runs)
        })
    }

    private fun ifRunnerLogged(view: View) {
        if (mAuth.currentUser == null) {
            view.findNavController().navigate(
                R.id.action_global_welcome, null,
                NavOptions.Builder().setPopUpTo(R.id.nav_runs, true).build()
            )
        }
    }

    private fun setUiAction() {
        fab_new_run.setOnClickListener {
            PermissionRequester(this, Manifest.permission.ACCESS_COARSE_LOCATION).apply {
                runWithPermission {
                    findNavController().navigate(R.id.action_new_run)
                }
            }
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
}