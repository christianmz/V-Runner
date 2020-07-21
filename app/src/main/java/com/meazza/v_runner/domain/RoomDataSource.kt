package com.meazza.v_runner.domain

import com.meazza.business.data.Run
import com.meazza.business.repository.RunsDataSource
import com.meazza.v_runner.data.db.dao.RunDAO
import com.meazza.v_runner.util.toRunEntity


class RoomDataSource(private val runDAO: RunDAO): RunsDataSource {

    override suspend fun newRun(run: Run) {
      runDAO.insertRun(run.toRunEntity(run))
    }
}