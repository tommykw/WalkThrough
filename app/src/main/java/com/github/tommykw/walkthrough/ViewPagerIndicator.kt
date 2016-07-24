package com.github.tommykw.walkthrough

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.View

/**
 * Created by tommy on 2016/03/28.
 */
class ViewPagerIndicator @JvmOverloads constructor(context: Context,
                                                   attrs: AttributeSet? = null,
                                                   defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    init {
        prepare(context)
    }

    private var radius = 0.0f
    private var distance = 0.0f
    private var wholeViewCount = 0
    private var position = 0
    private lateinit var viewPager: ViewPager
    private var indicatorCount = 5
    private var defaultColor= ContextCompat.getColor(context, R.color.viewpager_indicator_default)
    private var selectorColor = ContextCompat.getColor(context, R.color.viewpager_indicator_selector)

    fun setIndicatorCount(count: Int) {
        indicatorCount = count
    }

    fun setIndicatorColor(defaultColorId: Int, selectorColorId: Int) {
        defaultColor = ContextCompat.getColor(context, defaultColorId)
        selectorColor = ContextCompat.getColor(context, selectorColorId)
    }

    fun setPosition(currentPosition: Int) {
        if (currentPosition < wholeViewCount) {
            position = currentPosition
            viewPager.let { it.currentItem = currentPosition }
            invalidate()
        }
    }

    fun setViewPager(vp: ViewPager) {
        viewPager = vp
        wholeViewCount = viewPager.adapter.let { it.count }
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                wholeViewCount = viewPager.adapter.let { it.count }
                setPosition(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
        })
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint().apply {
            strokeWidth = 1.0f
            strokeCap = Paint.Cap.ROUND
            isAntiAlias = true
        }

        for (i in 0..wholeViewCount-1) {
            canvas.drawCircle(
                    (width - (wholeViewCount - 1) * distance) / 2 + i * distance,
                    height / 2.0f,
                    radius,
                    paint.apply {
                        color = if (position == i) selectorColor else defaultColor
                        style = Paint.Style.FILL_AND_STROKE
                    }
            )
        }
    }

    private fun prepare(context: Context) {
        radius = DisplayUtil.dipToPixcelFloat(
                context,
                resources.getInteger(R.integer.indicator_cirlce_diameter).toFloat()
        )
        distance = DisplayUtil.dipToPixcelFloat(
                context,
                (resources.getInteger(R.integer.indicator_cirlce_diameter) * indicatorCount).toFloat()
        )
    }
}
