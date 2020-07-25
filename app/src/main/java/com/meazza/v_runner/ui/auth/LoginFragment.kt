package com.meazza.v_runner.ui.auth

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.meazza.v_runner.R
import com.meazza.v_runner.common.Constants.EMPTY_FIELDS
import com.meazza.v_runner.common.Constants.INVALID_EMAIL
import com.meazza.v_runner.common.Constants.INVALID_PASSWORD
import com.meazza.v_runner.common.Constants.LOGIN_ERROR
import com.meazza.v_runner.common.Constants.OK
import com.meazza.v_runner.common.Constants.USER_NOT_FOUND
import com.meazza.v_runner.common.Constants.WRONG_PASSWORD
import com.meazza.v_runner.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import org.jetbrains.anko.okButton
import org.jetbrains.anko.support.v4.alert


@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val authViewModel by viewModels<AuthViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DataBindingUtil.bind<FragmentLoginBinding>(view)?.apply {
            lifecycleOwner = this@LoginFragment
            viewModel = authViewModel
        }

        loginHandler()
    }

    private fun loginHandler() {
        authViewModel.authResult.observe(viewLifecycleOwner, Observer { messageCode ->
            when (messageCode) {
                OK -> findNavController().navigate(R.id.nav_runs)
                EMPTY_FIELDS -> showAlert(resources.getString(R.string.empty_fields))
                INVALID_EMAIL -> showAlert(resources.getString(R.string.invalid_email))
                INVALID_PASSWORD -> showAlert(resources.getString(R.string.invalid_password))
                WRONG_PASSWORD -> showAlert(resources.getString(R.string.wrong_password))
                USER_NOT_FOUND -> showAlert(resources.getString(R.string.user_not_found))
                LOGIN_ERROR -> showAlert(resources.getString(R.string.login_error))
                else -> showAlert(resources.getString(R.string.error))
            }
        })
    }

    private fun showAlert(message: String) {
        alert(message) {
            okButton { it.dismiss() }
        }.show()
    }
}
