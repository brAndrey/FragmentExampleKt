package com.example.fragmentexamplekt.TabbetExample

import android.content.Context
import androidx.constraintlayout.widget.Placeholder
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.fragmentexamplekt.R

class SectionsPagerAdapter(private val context: Context, fragmentManager: FragmentManager ):
    FragmentPagerAdapter(fragmentManager) {

    private val TAB_TITLE = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2,
        R.string.tab_text_3,
        R.string.tab_text_4
    )

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLE[position])
    }


    // определяет колличество страниц
    override fun getCount(): Int = TAB_TITLE.size

    override fun getItem(position: Int): Fragment {
    // берёт номер позиции и отправляет его в фрагмент
    return TabbletFragment.newInstance(position+1)
    }
}