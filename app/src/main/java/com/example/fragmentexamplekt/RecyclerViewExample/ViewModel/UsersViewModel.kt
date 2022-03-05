package com.example.fragmentexamplekt.RecyclerViewExample.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodelkt.User
import com.example.viewmodelkt.UserData

class UsersViewModel:ViewModel() {

    var flag:Int=0

    var userList: MutableLiveData<List<User>> = MutableLiveData()

    var onTimeStart:String

    lateinit var ouner:String

    init {
        onTimeStart = System.currentTimeMillis().toString()
        Log.i("init UsersViewModel"," "+System.currentTimeMillis() +" "+onTimeStart)
        userList.value = UserData.getUsers()
    }

    fun setOunet(ouner:String){
        this.ouner=ouner
        Log.i("ouner"," "+ouner+"  "+flag)
    }

    fun getListUsers() = userList

    fun updateListUsers(){
        Log.i("updateLIstUsers"," UsersViewModel "+System.currentTimeMillis() +" "+onTimeStart+"  "+flag)
        if (flag==0)
        {userList.value = UserData.getAnotherUsers();flag=1}
        else {userList.value = UserData.getUsers();flag=0}
    }
}