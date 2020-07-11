package com.meazza.v_runner.ui.profile

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.meazza.v_runner.R

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val profileViewModel by viewModels<ProfileViewModel>()
}