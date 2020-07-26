package com.meazza.v_runner.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.meazza.v_runner.data.network.runner.RunnerService
import com.meazza.v_runner.data.network.runner.RunnerServiceImpl
import com.meazza.v_runner.data.repository.runner.RunnerRepository
import com.meazza.v_runner.data.repository.runner.RunnerRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped


@Module
@InstallIn(ActivityRetainedComponent::class)
object RunnerModule {

    @ActivityRetainedScoped
    @Provides
    fun providesRunnerService(
        firebaseAuth: FirebaseAuth,
        firebaseFirestore: FirebaseFirestore,
        firebaseStorage: FirebaseStorage
    ): RunnerService {
        return RunnerServiceImpl(firebaseAuth, firebaseFirestore, firebaseStorage)
    }

    @ActivityRetainedScoped
    @Provides
    fun providesRunnerRepository(runnerService: RunnerService): RunnerRepository {
        return RunnerRepositoryImpl(runnerService)
    }
}