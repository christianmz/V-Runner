package com.meazza.v_runner.ui.stats

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.meazza.v_runner.R


class StatsFragment : Fragment(R.layout.fragment_stats) {

    private val statsViewModel by viewModels<StatsViewModel>()
}