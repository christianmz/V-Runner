package com.meazza.v_runner.ui.runs

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
import com.meazza.v_runner.databinding.FragmentRunsBinding
import com.meazza.v_runner.ui.runs.adapter.RunAdapter
import kotlinx.android.synthetic.main.fragment_runs.*
import org.jetbrains.anko.support.v4.toast


class RunsFragment : Fragment(R.layout.fragment_runs) {

    private val runsViewModel by viewModels<RunsViewModel>()
    private val runAdapter by lazy { RunAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DataBindingUtil.bind<FragmentRunsBinding>(view)?.apply {
            lifecycleOwner = this@RunsFragment
            viewModel = runsViewModel
        }

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
}