package com.meazza.business.repository

import com.meazza.business.data.Run

interface RunsDataSource {

    suspend fun newRun(run: Run)
}