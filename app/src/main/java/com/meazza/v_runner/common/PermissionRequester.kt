package com.meazza.v_runner.common

import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.fragment.app.Fragment


class PermissionRequester(
    fragment: Fragment,
    private val permission: String,
    private val onRationale: () -> Unit = {},
    private val onDenied: () -> Unit = {}
) {

    private var onGranted: () -> Unit = {}

    private val permissionLauncher =
        fragment.registerForActivityResult(RequestPermission()) { isGranted ->
            when {
                isGranted -> onGranted()
                fragment.shouldShowRequestPermissionRationale(permission) -> onRationale()
                else -> onDenied()
            }
        }

    fun runWithPermission(body: () -> Unit) {
        onGranted = body
        permissionLauncher.launch(permission)
    }
}