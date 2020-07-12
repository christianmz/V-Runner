package com.meazza.v_runner.ui.runs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.meazza.v_runner.data.Run
import com.meazza.v_runner.ui.runs.adapter.RunAdapter


class RunsViewModel : ViewModel() {

    val adapter = MutableLiveData<RunAdapter>()

    fun getRun() = liveData {
        val runs = (0..20).map {
            Run(null, 582734627, 22.5F, 6.3F, 16723152, 521)
        }
        emit(runs)
    }

    fun setAdapter(runs: List<Run>) {
        adapter.value?.differ?.submitList(runs)
    }
}