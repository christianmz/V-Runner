package com.meazza.v_runner.di

import android.content.Context
import androidx.room.Room
import com.meazza.v_runner.common.Constants.DATABASE_NAME
import com.meazza.v_runner.data.db.VRunnerDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesDbInstance(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            VRunnerDB::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun providesRunDAO(db: VRunnerDB) = db.getRunDAO()
}