package com.meazza.v_runner.data

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable


data class Run(
    var image: Bitmap? = null,

    var timestamp: Long = 0L,

    var averageSpeedInKmH: Float = 0f,

    var distanceInMeters: Float = 0f,

    val timeInMillis: Long = 0L,

    var caloriesBurned: Int = 0
) : Parcelable {

    var id: Int? = null

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Bitmap::class.java.classLoader),
        parcel.readLong(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readLong(),
        parcel.readInt()
    ) {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(image, flags)
        parcel.writeLong(timestamp)
        parcel.writeFloat(averageSpeedInKmH)
        parcel.writeFloat(distanceInMeters)
        parcel.writeLong(timeInMillis)
        parcel.writeInt(caloriesBurned)
        parcel.writeValue(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Run> {
        override fun createFromParcel(parcel: Parcel): Run {
            return Run(parcel)
        }

        override fun newArray(size: Int): Array<Run?> {
            return arrayOfNulls(size)
        }
    }
}
