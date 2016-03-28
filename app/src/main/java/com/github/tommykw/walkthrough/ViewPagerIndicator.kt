package com.github.tommykw.walkthrough

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.View

/**
 * Created by tommy on 2016/03/28.
 */
class ViewPagerIndicator : View {
    private var radius = 0.0f
    private var distance = 0.0f
    private var viewNumber = 0
    private var position = 0
    private lateinit var viewPager: ViewPager

    constructor(context: Context?) : super(context) {

    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private fun prepare(context: Context) { }
}