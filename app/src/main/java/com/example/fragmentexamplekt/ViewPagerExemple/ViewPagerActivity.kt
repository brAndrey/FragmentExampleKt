package com.example.fragmentexamplekt.ViewPagerExemple

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentexamplekt.BaseExample.MainActivity
import com.example.fragmentexamplekt.R
import com.example.fragmentexamplekt.RecyclerViewExample.RecyclerViewActivity
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_view_pager)

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewpager.adapter = fragmentAdapter
        tabs_tabbet.setupWithViewPager(viewpager)

//        tabs.setup



    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.meny_view_pager_activity,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){R.id.MainActivity_menu->{goMainActivity()}}
        when(item?.itemId){R.id.RecyclerViewActivity_menu->{goRecyclerViewActivity()}}

        return super.onOptionsItemSelected(item)
    }

    fun goRecyclerViewActivity(){
        val randomIntent = Intent(this, RecyclerViewActivity::class.java)
        startActivity(randomIntent)
    }


    fun goMainActivity(){
        val randomIntent = Intent(this, MainActivity::class.java)
        startActivity(randomIntent)
    }

}