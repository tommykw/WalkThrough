package com.github.tommykw.walkthrough

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

/**
 * Created by tommy on 2016/03/29.
 */
class ViewPagerAdapter : PagerAdapter {
    private val totalPage = 5
    private lateinit var inflater: LayoutInflater

    constructor(context: Context) {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun instantiateItem(container: ViewGroup, position: Int) {

    }

    override fun getCount(): Int {
        throw UnsupportedOperationException()
    }

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        throw UnsupportedOperationException()
    }


}