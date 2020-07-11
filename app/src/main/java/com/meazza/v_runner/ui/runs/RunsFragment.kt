package com.meazza.v_runner.ui.runs

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.meazza.v_runner.R


class RunsFragment : Fragment(R.layout.fragment_runs) {

    private val homeViewModel by viewModels<RunsViewModel>()
}