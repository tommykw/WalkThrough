package com.github.tommykw.walkthrough

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout

/**
 * Created by tommy on 2016/03/29.
 */
class ViewPagerAdapter : PagerAdapter {
    private val walkThroughImageIds = listOf<Int>(
            R.drawable.walkthrough,
            R.drawable.walkthrough,
            R.drawable.walkthrough,
            R.drawable.walkthrough,
            R.drawable.walkthrough
    )
    private lateinit var inflater: LayoutInflater

    constructor(context: Context) {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun instantiateItem(container: ViewGroup, position: Int): RelativeLayout {
        val layout = inflater.inflate(R.layout.view_pager, null) as RelativeLayout
        (layout.findViewById(R.id.walk_through_image) as ImageView).apply {
            setImageResource(walkThroughImageIds[position])
        }
        container.addView(layout)
        return layout
    }

    override fun getCount() = walkThroughImageIds.size
    override fun isViewFromObject(view: View, obj: Any) = view == obj
    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) =
            container.removeView(obj as View)
}