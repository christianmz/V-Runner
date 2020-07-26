package com.meazza.v_runner.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object FirebaseModule {

    @Singleton
    @Provides
    fun providesFirebaseAuth() = FirebaseAuth.getInstance()

    @Singleton
    @Provides
    fun providesFirebaseFirestore() = FirebaseFirestore.getInstance()

    @Singleton
    @Provides
    fun providesFirebaseStorage() = FirebaseStorage.getInstance()

    @Singleton
    @Provides
    fun providesCrashlytics() = FirebaseCrashlytics.getInstance()
}