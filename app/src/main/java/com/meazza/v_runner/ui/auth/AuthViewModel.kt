package com.meazza.v_runner.ui.auth

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.meazza.v_runner.common.Constants.EMAIL_ALREADY_EXISTS
import com.meazza.v_runner.common.Constants.EMPTY_FIELDS
import com.meazza.v_runner.common.Constants.INVALID_EMAIL
import com.meazza.v_runner.common.Constants.INVALID_PASSWORD
import com.meazza.v_runner.common.Constants.LOGIN_ERROR
import com.meazza.v_runner.common.Constants.OK
import com.meazza.v_runner.common.Constants.REGISTRATION_ERROR
import com.meazza.v_runner.common.Constants.USER_NOT_FOUND
import com.meazza.v_runner.common.Constants.WRONG_PASSWORD
import com.meazza.v_runner.data.repository.auth.AuthRepository
import com.meazza.v_runner.util.isValidEmail
import com.meazza.v_runner.util.isValidPassword
import kotlinx.coroutines.Dispatchers.IO


class AuthViewModel @ViewModelInject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    val runnerName = MutableLiveData<String>()
    val runnerEmail = MutableLiveData<String>()
    val runnerPassword = MutableLiveData<String>()

    fun signUp() = liveData(IO) {

        val name = runnerName.value
        val email = runnerEmail.value
        val password = runnerPassword.value

        if (!name.isNullOrEmpty() && !email.isNullOrEmpty() && !password.isNullOrEmpty()) {
            try {
                when {
                    !isValidEmail(email) -> emit(INVALID_EMAIL)
                    !isValidPassword(password) -> emit(INVALID_PASSWORD)
                    isValidEmail(email) && isValidPassword(password) -> {
                        authRepository.signUpByEmail(email, password)
                        emit(OK)
                    }
                }
            } catch (e: FirebaseAuthUserCollisionException) {
                emit(EMAIL_ALREADY_EXISTS)
            } catch (e: Exception) {
                emit(REGISTRATION_ERROR)
                e.printStackTrace()
            }
        } else {
            emit(EMPTY_FIELDS)
        }
    }

    fun loginWithEmailAndPassword() = liveData(IO) {
        val email = runnerEmail.value
        val password = runnerPassword.value

        if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
            try {
                authRepository.loginByEmail(email, password)
                emit(OK)
            } catch (e: FirebaseAuthInvalidCredentialsException) {
                emit(WRONG_PASSWORD)
            } catch (e: FirebaseAuthInvalidUserException) {
                emit(USER_NOT_FOUND)
            } catch (e: Exception) {
                emit(LOGIN_ERROR)
                e.printStackTrace()
            }
        } else {
            emit(EMPTY_FIELDS)
        }
    }

    fun resetPassword() = liveData(IO) {

        val email = runnerEmail.value

        if (!email.isNullOrEmpty()) {
            try {
                when {
                    !isValidEmail(email) -> emit(INVALID_EMAIL)
                    isValidEmail(email) -> {
                        authRepository.resetPassword(email)
                        emit(OK)
                    }
                }
            } catch (e: FirebaseAuthInvalidUserException) {
                emit(USER_NOT_FOUND)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            emit(EMPTY_FIELDS)
        }
    }
}