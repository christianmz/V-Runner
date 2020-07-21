package com.meazza.business.usecase

import com.meazza.business.data.Run
import com.meazza.business.repository.RunsRepository


class NewRun(private val repository: RunsRepository) {
    suspend operator fun invoke(run: Run) = repository.newRun(run)
} 