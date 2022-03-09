package com.example.fragmentexamplekt.RecyclerViewExample

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentexamplekt.BaseExample.MainActivity
import com.example.fragmentexamplekt.R
import com.example.fragmentexamplekt.RecyclerViewExample.ViewModel.UsersViewModel
import com.example.fragmentexamplekt.ViewPagerExemple.ViewPagerActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class RecyclerViewActivity : AppCompatActivity(){

    private val userViwModel by lazy { ViewModelProvider(this).get(UsersViewModel::class.java)}


    //private val viewModel: MyViewModel by lazy {        ViewModelProvider(this).get(MyViewModel::class.java)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recucler_view)
        userViwModel.setOunet(javaClass.simpleName )

        val recyclerViewFragmint = RecyclerViewFragmint()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, recyclerViewFragmint)
        transaction.addToBackStack(null)
        transaction.commit()

        //val fab: FloatingActionButton = findViewById(R.id.fab_RecyclerView)
        //fab.setOnClickListener( -> userViwModel.updateListUsers() )

        val fab: View = findViewById(R.id.fab_RecyclerView)
        fab.setOnClickListener { view ->
            userViwModel.updateListUsers()
        }


//        val adapter= RecyclerViewUserAdapter()
//        var userList: RecyclerView = findViewById(R.id.userList)
//        userList.layoutManager = LinearLayoutManager(this)
//        userList.adapter=adapter
//
//        userViwModel.getListUsers().observe(this, Observer{it?.let { Log.i("RecyclerViewActivity"," it.size= "+it.size) }})

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_recycler_view_activity,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when(item?.itemId){R.id.ViewPagerActivity_menu->{goViewPagerActivity()}}
            when(item?.itemId){R.id.MainActivity_menu->{goMainActivity()}}

        return super.onOptionsItemSelected(item)
    }

    fun goViewPagerActivity(){
        val randomIntent = Intent(this, ViewPagerActivity::class.java)
        startActivity(randomIntent)
    }

    fun goMainActivity(){
        val randomIntent = Intent(this, MainActivity::class.java)
        startActivity(randomIntent)
    }

}

