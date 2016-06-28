package com.github.tommykw.walkthrough

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val adapter = ViewPagerAdapter(this)
//        wlkthroughViewpager.adapter = adapter
//        walkthroughIndicator.setIndicatorCount(adapter.count)
//        walkthroughIndicator.setIndicatorColor(R.color.white, R.color.black)
//        walkthroughIndicator.setViewPager(
//                binding.contentLogin.loginWalkthroughViewpager
//        )
    }
}
