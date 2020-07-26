package com.meazza.v_runner.data.model

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Run(
    var image: Bitmap? = null,
    var timestamp: Long = 0L,
    var averageSpeedInKmH: Float = 0f,
    var distanceInMeters: Int = 0,
    var timeInMillis: Long = 0L,
    var caloriesBurned: Int = 0,
    var runId: String = ""
) : Parcelable
