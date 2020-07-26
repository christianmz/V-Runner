package com.meazza.v_runner.util

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.Settings
import java.nio.ByteBuffer


fun Context.openSettings() {
    Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
        addCategory(Intent.CATEGORY_DEFAULT)
        data = Uri.parse("package:$packageName")
    }.let(::startActivity)
}

fun Bitmap.convertToByteArray(): ByteArray {

    val size = this.byteCount
    val buffer = ByteBuffer.allocate(size)
    val bytes = ByteArray(size)

    this.copyPixelsToBuffer(buffer)
    buffer.rewind()
    buffer.get(bytes)

    return bytes
}