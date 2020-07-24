package com.meazza.v_runner.data.network.auth

interface AuthService {
    suspend fun signUpByEmail(email: String, password: String)
    suspend fun loginByEmail(email: String, password: String)
    suspend fun resetPassword(email: String)
}