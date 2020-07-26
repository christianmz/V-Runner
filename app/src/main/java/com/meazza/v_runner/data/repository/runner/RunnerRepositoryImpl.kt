package com.meazza.v_runner.data.repository.runner

import android.net.Uri
import com.meazza.v_runner.data.model.Runner
import com.meazza.v_runner.data.network.runner.RunnerService
import javax.inject.Inject


class RunnerRepositoryImpl @Inject constructor(
    private val runnerService: RunnerService
) : RunnerRepository {

    override suspend fun createRunner(runner: Runner) {
        TODO("Not yet implemented")
    }

    override suspend fun getRunner(runnerId: String): Runner {
        TODO("Not yet implemented")
    }

    override suspend fun uploadRunnerPhoto(photo: Uri) {
        TODO("Not yet implemented")
    }

    override suspend fun updateRunnerInfo(runner: Runner) {
        TODO("Not yet implemented")
    }
}