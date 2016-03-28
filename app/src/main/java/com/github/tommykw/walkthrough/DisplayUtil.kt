package com.github.tommykw.walkthrough

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics

/**
 * Created by tommy on 2016/03/28.
 */
class DisplayUtil {
    companion object {
        fun displayMetricsFrom(context: Context): DisplayMetrics = DisplayMetrics().apply {
            (context as Activity).windowManager.defaultDisplay.getMetrics(this)
        }

        fun dipToPixcelFloat(context: Context, dip: Float) =
                displayMetricsFrom(context).density  * dip

        fun dipToPixcelInt(context: Context, dip: Float) =
                (displayMetricsFrom(context).density * dip).toInt()
    }
}