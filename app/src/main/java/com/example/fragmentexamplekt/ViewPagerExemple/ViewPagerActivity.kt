package com.example.fragmentexamplekt.ViewPagerExemple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentexamplekt.R
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_view_pager)

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewpager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewpager)

//        tabs.setup


    }
}