package com.example.fragmentexamplekt.BaseExample

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragmentexamplekt.R
import com.example.fragmentexamplekt.BaseExample.Utils.MyObserverFragment

class TextFragment: Fragment() {

    lateinit var myObserverLifecycler: MyObserverFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        myObserverLifecycler = MyObserverFragment()

        lifecycle.addObserver(myObserverLifecycler)

        val view = inflater!!.inflate(R.layout.layout_text_fragment,container,false)
        val tv = view.findViewById<TextView>(R.id.text_view)
        tv.setOnClickListener {
            tv.setTextColor(Color.RED)
            // Show click confirmation
            Toast.makeText(view.context,"TextView clicked.",Toast.LENGTH_SHORT).show()
        }

        return view
    }
}