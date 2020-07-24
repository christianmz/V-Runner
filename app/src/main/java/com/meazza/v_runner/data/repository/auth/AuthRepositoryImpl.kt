package com.meazza.v_runner.data.repository.auth

import com.meazza.v_runner.data.network.auth.AuthService
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService
) : AuthRepository {

    override suspend fun signUpByEmail(email: String, password: String) {
        authService.signUpByEmail(email, password)
    }

    override suspend fun loginByEmail(email: String, password: String) {
        authService.loginByEmail(email, password)
    }

    override suspend fun resetPassword(email: String) {
        authService.resetPassword(email)
    }
}