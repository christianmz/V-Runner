package com.meazza.v_runner.data.repository.auth

interface AuthRepository {
    suspend fun signUpByEmail(email: String, password: String)
    suspend fun loginByEmail(email: String, password: String)
    suspend fun resetPassword(email: String)
}