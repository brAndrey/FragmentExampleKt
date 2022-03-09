package com.example.fragmentexamplekt.TabbetExample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class TabbetViewModel:ViewModel() {

    private val _index = MutableLiveData<Int>()

    val text: LiveData<String> = Transformations.map(_index){
        "Секция $it"
    }

    fun setIndex(index:Int){_index.value = index}


}