package com.meazza.business.repository

import com.meazza.business.data.Run

class RunsRepository(private val dataSource: RunsDataSource) {

    suspend fun newRun(run: Run) = dataSource.newRun(run)
}