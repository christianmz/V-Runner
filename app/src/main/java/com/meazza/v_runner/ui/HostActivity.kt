package com.meazza.v_runner.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.meazza.v_runner.R
import kotlinx.android.synthetic.main.activity_host.*


class HostActivity : AppCompatActivity(R.layout.activity_host) {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }
    private val appBarConfiguration by lazy {
        AppBarConfiguration(
            setOf(R.id.nav_runs, R.id.nav_stats, R.id.nav_profile, R.id.nav_settings),
            drawer_layout
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tb_main.setupWithNavController(navController, appBarConfiguration)
        nav_view.setupWithNavController(navController)
        setLogoVisibility()
    }

    private fun setLogoVisibility() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.nav_runs -> iv_logo.visibility = View.VISIBLE
                else -> iv_logo.visibility = View.GONE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START))
            drawer_layout.closeDrawer(GravityCompat.START)
        else super.onBackPressed()
    }
}