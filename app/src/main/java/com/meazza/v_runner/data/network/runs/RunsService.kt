package com.meazza.v_runner.data.network.runs

import com.meazza.v_runner.data.model.Run
import kotlinx.coroutines.flow.Flow


interface RunsService {
    suspend fun insertRun(run: Run)
    suspend fun deleteRun(run: Run)
    suspend fun getRunsByDate(): Flow<List<Run>>
    suspend fun getRunsByDistance(): Flow<List<Run>>
    suspend fun getRunsByRunningTime(): Flow<List<Run>>
    suspend fun getRunsByAverageSpeed(): Flow<List<Run>>
    suspend fun getRunsByCaloriesBurned(): Flow<List<Run>>
}