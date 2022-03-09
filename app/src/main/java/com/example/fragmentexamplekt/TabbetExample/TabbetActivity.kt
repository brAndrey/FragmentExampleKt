package com.example.fragmentexamplekt.TabbetExample

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.fragmentexamplekt.BaseExample.MainActivity
import com.example.fragmentexamplekt.BaseExample.Utils.MyObserverActivity
import com.example.fragmentexamplekt.R
import com.example.fragmentexamplekt.RecyclerViewExample.RecyclerViewActivity
import com.example.fragmentexamplekt.ViewPagerExemple.ViewPagerActivity
import com.google.android.material.tabs.TabLayout

class TabbetActivity:AppCompatActivity() {

    lateinit var myObserverLifecycler: MyObserverActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState )
        setContentView(R.layout.activity_tabbet)

        myObserverLifecycler = MyObserverActivity()
        myObserverLifecycler.setObjectName(javaClass.simpleName)
        lifecycle.addObserver(myObserverLifecycler)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager:ViewPager = findViewById(R.id.view_pager_tabbet)

        viewPager.adapter=sectionsPagerAdapter
        val tabs:TabLayout=findViewById(R.id.tabs_tabbet)

        tabs.setupWithViewPager(viewPager)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_transition,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){R.id.ViewPagerActivity_menu->{goViewPagerActivity()}}
        when(item?.itemId){R.id.MainActivity_menu->{goMainActivity()}}
        when(item?.itemId){R.id.RecyclerViewActivity_menu->{goRecyclerViewActivity()}}
        when(item?.itemId){R.id.TabbetActivity_menu->{goTabbetActivity()}}

        return super.onOptionsItemSelected(item)
    }

    fun goMainActivity(){
        val randomIntent = Intent(this, MainActivity::class.java)
        startActivity(randomIntent)
    }

    fun goViewPagerActivity(){
        val randomIntent = Intent(this, ViewPagerActivity::class.java)
        startActivity(randomIntent)
    }

    fun goRecyclerViewActivity(){
        val randomIntent = Intent(this, RecyclerViewActivity::class.java)
        startActivity(randomIntent)
    }

    fun goTabbetActivity(){
        val randomIntent = Intent(this, TabbetActivity::class.java)
        startActivity(randomIntent)
    }

}