package com.meazza.v_runner.data.repository.runs

import com.meazza.v_runner.data.model.Run
import com.meazza.v_runner.data.network.runs.RunsService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class RunsRepositoryImpl @Inject constructor(
    private val runsService: RunsService
) : RunsRepository {

    override suspend fun insertRun(run: Run) {
        runsService.insertRun(run)
    }

    override suspend fun deleteRun(run: Run) {
        runsService.deleteRun(run)
    }

    override suspend fun getRunsByDate(): Flow<List<Run>> {
        return runsService.getRunsByDate()
    }

    override suspend fun getRunsByDistance(): Flow<List<Run>> {
        return runsService.getRunsByDistance()
    }

    override suspend fun getRunsByRunningTime(): Flow<List<Run>> {
        return runsService.getRunsByRunningTime()
    }

    override suspend fun getRunsByAverageSpeed(): Flow<List<Run>> {
        return runsService.getRunsByAverageSpeed()
    }

    override suspend fun getRunsByCaloriesBurned(): Flow<List<Run>> {
        return runsService.getRunsByCaloriesBurned()
    }
}