package com.meazza.v_runner.di

import com.google.firebase.auth.FirebaseAuth
import com.meazza.v_runner.data.network.auth.AuthService
import com.meazza.v_runner.data.network.auth.AuthServiceImpl
import com.meazza.v_runner.data.repository.auth.AuthRepository
import com.meazza.v_runner.data.repository.auth.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped


@Module
@InstallIn(ActivityRetainedComponent::class)
object AuthModule {

    @ActivityRetainedScoped
    @Provides
    fun providesAuthService(firebaseAuth: FirebaseAuth): AuthService {
        return AuthServiceImpl(firebaseAuth)
    }

    @ActivityRetainedScoped
    @Provides
    fun providesAuthRepository(authService: AuthService): AuthRepository {
        return AuthRepositoryImpl(authService)
    }
}