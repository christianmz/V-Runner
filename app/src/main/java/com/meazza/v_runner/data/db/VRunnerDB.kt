package com.meazza.v_runner.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.meazza.v_runner.common.Constants.DATABASE_VERSION
import com.meazza.v_runner.data.db.dao.RunDAO
import com.meazza.v_runner.data.model.RunEntity


@Database(
    entities = [RunEntity::class],
    version = DATABASE_VERSION
)
@TypeConverters(Converters::class)
abstract class VRunnerDB : RoomDatabase() {

    abstract fun getRunDAO(): RunDAO
}