package com.meazza.v_runner.ui.runs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.meazza.v_runner.data.model.Run


class RunsViewModel : ViewModel() {

    fun getRun() = liveData {
        val runs = (0..3).map {
            Run(
                null,
                72342,
                22.5F,
                6.3F,
                16723152,
                (7 * it)
            )
        }
        emit(runs)
    }
}