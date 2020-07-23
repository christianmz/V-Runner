package com.meazza.v_runner.data.model


data class Runner(
    val id: String,
    val name: String,
    val photoUrl: String,
    val weight: Int,
    val height: Float,
    val runningTime: Long,
    val totalDistance: Long,
    val caloriesBurned: Int,
    val averageSpeed: Float
)
