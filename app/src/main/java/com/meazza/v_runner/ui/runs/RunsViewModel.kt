package com.meazza.v_runner.ui.runs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.meazza.v_runner.data.model.Run


class RunsViewModel : ViewModel() {

    fun getRun() = liveData {
        val runs = (0..3).map {
            Run(
                "2378",
                "72342",
                22,
                64.7F,
                16724,
                1512766,
                167
            )
        }
        emit(runs)
    }
}