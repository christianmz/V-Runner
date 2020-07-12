package com.meazza.v_runner.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.meazza.v_runner.R


@BindingAdapter("setTextDistance")
fun setTextDistance(textView: TextView, distance: Float) {
    textView.text = textView.resources.getString(R.string.distance, distance.toString())
}

@BindingAdapter("setTextSpeed")
fun setTextSpeed(textView: TextView, speed: Float) {
    textView.text = textView.resources.getString(R.string.speed, speed.toString())
}

@BindingAdapter("setTextTimestamp")
fun setTextTimestamp(textView: TextView, timestamp: Long) {
    textView.text = textView.resources.getString(R.string.timestamp, timestamp.toString())
}

@BindingAdapter("setTextTime")
fun setTextTime(textView: TextView, time: Long) {
    textView.text = textView.resources.getString(R.string.time, time.toString())
}

@BindingAdapter("setTextCalories")
fun setTextCaloriesBurned(textView: TextView, calories: Int) {
    textView.text = textView.resources.getString(R.string.calories, calories.toString())
}