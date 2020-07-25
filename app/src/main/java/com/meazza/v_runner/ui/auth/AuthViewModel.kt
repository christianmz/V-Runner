package com.meazza.v_runner.ui.auth

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
import kotlinx.coroutines.launch


class AuthViewModel @ViewModelInject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _authResult = MutableLiveData<Int>()
    val authResult: LiveData<Int> get() = _authResult

    val runnerName = MutableLiveData<String>()
    val runnerEmail = MutableLiveData<String>()
    val runnerPassword = MutableLiveData<String>()

    fun signUpWithEmailAndPassword() {

        val name = runnerName.value
        val email = runnerEmail.value
        val password = runnerPassword.value

        viewModelScope.launch {
            if (!name.isNullOrEmpty() && !email.isNullOrEmpty() && !password.isNullOrEmpty()) {
                try {
                    when {
                        !isValidEmail(email) -> _authResult.value = INVALID_EMAIL
                        !isValidPassword(password) -> _authResult.value = INVALID_PASSWORD
                        isValidEmail(email) && isValidPassword(password) -> {
                            authRepository.signUpByEmail(email, password)
                            _authResult.value = OK
                        }
                    }
                } catch (e: FirebaseAuthUserCollisionException) {
                    _authResult.value = EMAIL_ALREADY_EXISTS
                } catch (e: Exception) {
                    _authResult.value = REGISTRATION_ERROR
                    e.printStackTrace()
                }
            } else {
                _authResult.value = EMPTY_FIELDS
            }
        }
    }

    fun loginWithEmailAndPassword() {

        val email = runnerEmail.value
        val password = runnerPassword.value

        viewModelScope.launch {
            if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
                try {
                    authRepository.loginByEmail(email, password)
                    _authResult.value = OK
                } catch (e: FirebaseAuthInvalidCredentialsException) {
                    _authResult.value = WRONG_PASSWORD
                } catch (e: FirebaseAuthInvalidUserException) {
                    _authResult.value = USER_NOT_FOUND
                } catch (e: Exception) {
                    _authResult.value = LOGIN_ERROR
                    e.printStackTrace()
                }
            } else {
                _authResult.value = EMPTY_FIELDS
            }
        }
    }

    fun resetPassword() {

        val email = runnerEmail.value

        viewModelScope.launch {
            if (!email.isNullOrEmpty()) {
                try {
                    when {
                        !isValidEmail(email) -> _authResult.value = INVALID_EMAIL
                        isValidEmail(email) -> {
                            authRepository.resetPassword(email)
                            _authResult.value = OK
                        }
                    }
                } catch (e: FirebaseAuthInvalidUserException) {
                    _authResult.value = USER_NOT_FOUND
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                _authResult.value = EMPTY_FIELDS
            }
        }
    }
}