package com.meazza.v_runner.data.network.auth

import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


@ActivityRetainedScoped
class AuthServiceImpl @Inject constructor(private val mAuth: FirebaseAuth) : AuthService {

    override suspend fun signUpByEmail(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password).await()
    }

    override suspend fun loginByEmail(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password).await()
    }

    override suspend fun resetPassword(email: String) {
        mAuth.sendPasswordResetEmail(email).await()
    }
}