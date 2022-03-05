package com.example.fragmentexamplekt.RecyclerViewExample

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentexamplekt.R
import com.example.fragmentexamplekt.RecyclerViewExample.ViewModel.UsersViewModel

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
        when(item?.itemId){R.id.refresh->{userViwModel.updateListUsers()}}

        return super.onOptionsItemSelected(item)
    }
}