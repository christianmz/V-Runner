package com.meazza.v_runner.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.meazza.v_runner.data.network.runs.RunsService
import com.meazza.v_runner.data.network.runs.RunsServiceImpl
import com.meazza.v_runner.data.repository.runs.RunsRepository
import com.meazza.v_runner.data.repository.runs.RunsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.ExperimentalCoroutinesApi


@Module
@InstallIn(ActivityRetainedComponent::class)
object RunsModule {

    @ExperimentalCoroutinesApi
    @ActivityRetainedScoped
    @Provides
    fun providesRunsService(
        firebaseAuth: FirebaseAuth,
        firebaseFirestore: FirebaseFirestore,
        firebaseStorage: FirebaseStorage
    ): RunsService {
        return RunsServiceImpl(firebaseAuth, firebaseFirestore, firebaseStorage)
    }

    @ActivityRetainedScoped
    @Provides
    fun providesRunsRepository(runsService: RunsService): RunsRepository {
        return RunsRepositoryImpl(runsService)
    }
}