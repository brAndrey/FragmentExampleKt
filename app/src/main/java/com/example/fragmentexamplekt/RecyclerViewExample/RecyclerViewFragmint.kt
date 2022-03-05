package com.example.fragmentexamplekt.RecyclerViewExample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentexamplekt.R
import com.example.fragmentexamplekt.BaseExample.Utils.MyObserverFragment
import com.example.fragmentexamplekt.RecyclerViewExample.Adapter.RecyclerViewUserAdapter
import com.example.fragmentexamplekt.RecyclerViewExample.ViewModel.UsersViewModel

class RecyclerViewFragmint : Fragment() {

    lateinit var myObserverLifecycler: MyObserverFragment

    // это ленивая инициализация
    //private val userViwModel by lazy { ViewModelProvider(this).get(UsersViewModel::class.java)}

    // это инициализация от activity
    private val userViwModel: UsersViewModel by activityViewModels()

    lateinit var adapter: RecyclerViewUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //getActivity().getApplicationContext()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        userViwModel.setOunet(javaClass.simpleName)

        myObserverLifecycler = MyObserverFragment()
        lifecycle.addObserver(myObserverLifecycler)

        val view = inflater!!.inflate(R.layout.fragment_recyclerview, container, false)
        //val
        adapter = RecyclerViewUserAdapter()

        var userList: RecyclerView = view.findViewById(R.id.userList)

        // context
        requireActivity().application
        var contextUApp = view.getContext()
        // context

        userList.layoutManager = LinearLayoutManager(getActivity())
        userList.adapter = adapter


//        userViwModel.getListUsers().observe(viewLifecycleOwner, Observer {
//            it?.let {
//                Log.i("RecyclerViewFragmint", "onCreateView it.size= " + it.size)
//                adapter.refreshingUsers(it)
//            }
//        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // https://developer.android.com/topic/libraries/architecture/viewmodel
        userViwModel.getListUsers()
            .observe(viewLifecycleOwner, Observer {
                Log.i("RecyclerViewFragmint", "onViewCreated it.size= " + it.size)
                it?.let { adapter.refreshingUsers(it) }
            })
    }

}