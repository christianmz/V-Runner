package com.meazza.v_runner.data.model

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.meazza.v_runner.common.Constants.TABLE_NAME_RUNNING


@Entity(tableName = TABLE_NAME_RUNNING)
data class Run(
    @ColumnInfo(name = "image")
    var image: Bitmap? = null,

    @ColumnInfo(name = "time_stamp")
    var timestamp: Long = 0L,

    @ColumnInfo(name = "average_speed_in_kmh")
    var averageSpeedInKmH: Float = 0f,

    @ColumnInfo(name = "distance_in_meters")
    var distanceInMeters: Int = 0,

    @ColumnInfo(name = "time_in_millis")
    val timeInMillis: Long = 0L,

    @ColumnInfo(name = "calories_burned")
    var caloriesBurned: Int = 0
) : Parcelable {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Bitmap::class.java.classLoader),
        parcel.readLong(),
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readLong(),
        parcel.readInt()
    ) {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(image, flags)
        parcel.writeLong(timestamp)
        parcel.writeFloat(averageSpeedInKmH)
        parcel.writeInt(distanceInMeters)
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
