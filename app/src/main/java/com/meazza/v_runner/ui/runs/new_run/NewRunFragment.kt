package com.meazza.v_runner.ui.runs.new_run

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.meazza.v_runner.R
import com.meazza.v_runner.service.TrackingService
import kotlinx.android.synthetic.main.fragment_new_run.*


class NewRunFragment : Fragment(R.layout.fragment_new_run) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        map_view.onCreate(savedInstanceState)

        map_view.getMapAsync {
        }
    }

    private fun sendCommandToService(action: String) =
        Intent(requireContext(), TrackingService::class.java).also {
            it.action = action
            requireContext().startService(it)
        }

    override fun onResume() {
        super.onResume()
        map_view?.onResume()
    }

    override fun onStart() {
        super.onStart()
        map_view?.onStart()
    }

    override fun onStop() {
        super.onStop()
        map_view?.onStop()
    }

    override fun onPause() {
        super.onPause()
        map_view?.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        map_view?.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        map_view?.onSaveInstanceState(outState)
    }
}