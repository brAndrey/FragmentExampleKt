package com.example.fragmentexamplekt.ViewPagerExemple

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter (fm:FragmentManager): FragmentPagerAdapter(fm){

    override fun getCount(): Int {
    return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position){
            0-> FirstFragment()
            1-> SecondFragment()
            else -> {return ThirdFragment()}
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "First Tab"
            1 -> "Second Tab"
            else -> {
                return "Third Tab"
            }
        }

    }
}