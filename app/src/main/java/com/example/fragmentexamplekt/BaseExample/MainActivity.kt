package com.example.fragmentexamplekt.BaseExample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.fragmentexamplekt.R
import com.example.fragmentexamplekt.RecyclerViewExample.RecyclerViewActivity
import com.example.fragmentexamplekt.ViewPagerExemple.ViewPagerActivity
import com.example.fragmentexamplekt.BaseExample.Utils.MyObserverActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myObserverLifecycler: MyObserverActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myObserverLifecycler = MyObserverActivity()
        lifecycle.addObserver(myObserverLifecycler)

        button1.setOnClickListener {
            val textFragment = TextFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container, textFragment)
            transaction.addToBackStack(null)

            transaction.commit()
        }

        button2.setOnClickListener{


            val imageFragment = ImageFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()

            transaction.replace(R.id.fragment_container, imageFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    fun secondActivity(view: View) {

        goViewPagerActivity()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){R.id.ViewPagerActivity_menu->{goViewPagerActivity()}}
        when(item?.itemId){R.id.RecyclerViewActivity_menu->{goRecyclerViewActivity()}}

        return super.onOptionsItemSelected(item)
    }

    fun goViewPagerActivity(){
        val randomIntent = Intent(this, ViewPagerActivity::class.java)
        startActivity(randomIntent)
    }

    fun goRecyclerViewActivity(){
        val randomIntent = Intent(this, RecyclerViewActivity::class.java)
        startActivity(randomIntent)
    }

}