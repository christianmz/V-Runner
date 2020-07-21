package com.meazza.business.data

data class Run(
    var image: String? = "",
    var timestamp: Long = 0L,
    var averageSpeedInKmH: Float = 0f,
    var distanceInMeters: Int = 0,
    var timeInMillis: Long = 0L,
    var caloriesBurned: Int = 0
)