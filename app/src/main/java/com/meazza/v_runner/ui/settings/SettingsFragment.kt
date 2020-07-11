package com.meazza.v_runner.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.meazza.v_runner.R


class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}