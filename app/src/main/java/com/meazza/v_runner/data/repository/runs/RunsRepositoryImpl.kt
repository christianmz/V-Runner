package com.meazza.v_runner.data.repository.runs

import com.meazza.v_runner.data.model.Run
import javax.inject.Inject


class RunsRepositoryImpl @Inject constructor() : RunsRepository {

    override suspend fun newRun(run: Run) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteRun(run: Run) {
        TODO("Not yet implemented")
    }

    override suspend fun getRunsByDate(): List<Run> {
        TODO("Not yet implemented")
    }

    override suspend fun getRunsByDistance(): List<Run> {
        TODO("Not yet implemented")
    }

    override suspend fun getRunsByRunningTime(): List<Run> {
        TODO("Not yet implemented")
    }

    override suspend fun getRunsByAverageSpeed(): List<Run> {
        TODO("Not yet implemented")
    }

    override suspend fun getRunsByCaloriesBurned(): List<Run> {
        TODO("Not yet implemented")
    }
}