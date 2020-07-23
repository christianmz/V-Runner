package com.meazza.v_runner.data.repository.runs

import com.meazza.v_runner.data.model.Run


interface RunsRepository {
    suspend fun newRun(run: Run)
    suspend fun deleteRun(run: Run)
    suspend fun getRunsByDate(): List<Run>
    suspend fun getRunsByDistance(): List<Run>
    suspend fun getRunsByRunningTime(): List<Run>
    suspend fun getRunsByAverageSpeed(): List<Run>
    suspend fun getRunsByCaloriesBurned(): List<Run>
}