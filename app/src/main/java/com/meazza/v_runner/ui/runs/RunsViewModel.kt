package com.meazza.v_runner.ui.runs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.meazza.v_runner.data.model.RunEntity


class RunsViewModel : ViewModel() {

    fun getRun() = liveData {
        val runs = (0..3).map {
            RunEntity(
                null,
                72342,
                22.5F,
                64,
                16723152,
                (7 * it)
            )
        }
        emit(runs)
    }
}