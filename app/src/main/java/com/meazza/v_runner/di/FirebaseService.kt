package com.meazza.v_runner.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object FirebaseService {

    @Singleton
    @Provides
    fun providesFirebaseAuth() = FirebaseAuth.getInstance()
}