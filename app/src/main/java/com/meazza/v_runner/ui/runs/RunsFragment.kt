package com.meazza.v_runner.ui.runs

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.meazza.v_runner.R
import com.meazza.v_runner.databinding.FragmentRunsBinding
import org.jetbrains.anko.support.v4.toast


class RunsFragment : Fragment(R.layout.fragment_runs) {

    private val runsViewModel by viewModels<RunsViewModel>()
    private val TAG = "AppDebug"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DataBindingUtil.bind<FragmentRunsBinding>(view)?.apply {
            lifecycleOwner = this@RunsFragment
            viewModel = runsViewModel
        }

        runsViewModel.run {
            getRun().observe(viewLifecycleOwner, Observer { runs ->
                setAdapter(runs)
                adapter.value?.setOnClickListener {
                    for (run in runs) {
                        toast("${it.distanceInMeters}")
                    }
                }
            })
        }
    }
}