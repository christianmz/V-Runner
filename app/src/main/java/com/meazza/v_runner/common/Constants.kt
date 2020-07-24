package com.meazza.v_runner.common

 object Constants {
    const val REQUEST_CODE_LOCATION_PERMISSION = 0

    const val ACTION_START_OR_RESUME_SERVICE = "ACTION_START_OR_RESUME_SERVICE"
    const val ACTION_PAUSE_SERVICE = "ACTION_PAUSE_SERVICE"
    const val ACTION_STOP_SERVICE = "ACTION_STOP_SERVICE"
    const val ACTION_SHOW_TRACKING_FRAGMENT = "ACTION_SHOW_TRACKING_FRAGMENT"

    const val TIMER_UPDATE_INTERVAL = 50L
    const val LOCATION_UPDATE_INTERVAL = 5000L
    const val FASTEST_LOCATION_INTERVAL = 2000L

    const val POLYLINE_WIDTH = 8f
    const val MAP_ZOOM = 15f

    const val NOTIFICATION_CHANNEL_ID = "tracking_channel"
    const val NOTIFICATION_CHANNEL_NAME = "tracking"
    const val NOTIFICATION_ID = 1

    const val EMPTY_FIELDS = 101
    const val INVALID_EMAIL = 102
    const val INVALID_PASSWORD = 103
    const val EMAIL_ALREADY_EXISTS = 104
    const val USER_NOT_FOUND = 105
    const val WRONG_PASSWORD = 106
    const val REGISTRATION_ERROR = 107
    const val LOGIN_ERROR = 108
    const val TRY_AGAIN = 109

    const val OK = 200
}
