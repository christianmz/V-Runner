package com.meazza.v_runner.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.meazza.v_runner.data.model.RunEntity


@Dao
interface RunDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: RunEntity)

    @Delete
    suspend fun deleteRun(run: RunEntity)

    @Query("SELECT * FROM runs_table WHERE id LIKE :id")
    fun getRun(id: Int): LiveData<RunEntity>

    @Query("SELECT * FROM runs_table ORDER BY time_stamp DESC")
    fun getAllRunsSortedByDate(): LiveData<List<RunEntity>>

    @Query("SELECT * FROM runs_table ORDER BY time_in_millis DESC")
    fun getAllRunsSortedByTimeInMillis(): LiveData<List<RunEntity>>

    @Query("SELECT * FROM runs_table ORDER BY calories_burned DESC")
    fun getAllRunsSortedByCaloriesBurned(): LiveData<List<RunEntity>>

    @Query("SELECT * FROM runs_table ORDER BY average_speed_in_kmh DESC")
    fun getAllRunsSortedByAvgSpeed(): LiveData<List<RunEntity>>

    @Query("SELECT * FROM runs_table ORDER BY distance_in_meters DESC")
    fun getAllRunsSortedByDistance(): LiveData<List<RunEntity>>

    @Query("SELECT SUM(time_in_millis) FROM runs_table")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("SELECT SUM(calories_burned) FROM runs_table")
    fun getTotalCaloriesBurned(): LiveData<Int>

    @Query("SELECT SUM(distance_in_meters) FROM runs_table")
    fun getTotalDistance(): LiveData<Int>

    @Query("SELECT AVG(average_speed_in_kmh) FROM runs_table")
    fun getTotalAverageSpeed(): LiveData<Float>
}