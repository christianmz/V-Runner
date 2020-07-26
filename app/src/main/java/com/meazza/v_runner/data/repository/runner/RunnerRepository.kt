package com.meazza.v_runner.data.repository.runner

import android.net.Uri
import com.meazza.v_runner.data.model.Runner


interface RunnerRepository {
    suspend fun createRunner(runner: Runner)
    suspend fun getRunner(runnerId: String): Runner
    suspend fun uploadRunnerPhoto(photo: Uri)
    suspend fun updateRunnerInfo(runner: Runner)
}