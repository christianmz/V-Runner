package com.meazza.v_runner.util

import com.meazza.business.data.Run
import com.meazza.v_runner.data.model.RunEntity


fun Run.toRunEntity(run: Run) = RunEntity(
    run.image,
    run.timestamp,
    run.averageSpeedInKmH,
    run.distanceInMeters,
    run.timeInMillis,
    run.caloriesBurned
)

/*
fun RunEntity.toRun(runEntity: RunEntity) = Run(
    runEntity.image,
    runEntity.timestamp,
    runEntity.averageSpeedInKmH,
    runEntity.distanceInMeters,
    runEntity.timeInMillis,
    runEntity.caloriesBurned
)*/
