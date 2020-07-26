package com.meazza.v_runner.ui.runs

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.meazza.v_runner.data.model.Run
import com.meazza.v_runner.data.repository.runs.RunsRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class RunsViewModel @ViewModelInject constructor(
    private val runsRepository: RunsRepository
) : ViewModel() {

    fun insertRun(run: Run) {
        viewModelScope.launch {
            runsRepository.insertRun(run)
        }
    }

    fun getRuns() = liveData(IO) {
        runsRepository.getRunsByDate().collect {
            emit(it)
        }
    }
}


