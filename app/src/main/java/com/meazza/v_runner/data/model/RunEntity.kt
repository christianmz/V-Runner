package com.meazza.v_runner.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.meazza.v_runner.common.Constants.TABLE_NAME_RUNNING


@Entity(tableName = TABLE_NAME_RUNNING)
data class RunEntity(
    @ColumnInfo(name = "image")
    var image: String? = "",

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
        parcel.readString(),
        parcel.readLong(),
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readLong(),
        parcel.readInt()
    ) {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(image)
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

    companion object CREATOR : Parcelable.Creator<RunEntity> {
        override fun createFromParcel(parcel: Parcel): RunEntity {
            return RunEntity(parcel)
        }

        override fun newArray(size: Int): Array<RunEntity?> {
            return arrayOfNulls(size)
        }
    }
}
