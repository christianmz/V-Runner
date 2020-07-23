package com.meazza.v_runner.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Run(
    var id: String,
    var image: String? = "",
    var timestamp: Long = 0L,
    var averageSpeedInKmH: Float = 0f,
    var distanceInMeters: Int = 0,
    val timeInMillis: Long = 0L,
    var caloriesBurned: Int = 0
) : Parcelable
