package com.example.fragmentexamplekt.TabbetExample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.Placeholder
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentexamplekt.BaseExample.Utils.MyObserverActivity
import com.example.fragmentexamplekt.R
import kotlinx.android.synthetic.main.layout_text_fragment.*

class TabbletFragment:Fragment() {

    lateinit var myObserverLifecycler: MyObserverActivity
    private lateinit var pageViewModel: TabbetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel=ViewModelProvider(this).get(TabbetViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?:1)
        }

        myObserverLifecycler = MyObserverActivity()
        myObserverLifecycler.setObjectName(javaClass.simpleName)
        lifecycle.addObserver(myObserverLifecycler)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var inflater=inflater!!.inflate(R.layout.fragment_tabbet, container, false)

        val textView = inflater.findViewById<TextView>(R.id.section_label)

        pageViewModel.text.observe(viewLifecycleOwner,{
            if (textView != null) {
                textView.text = it
            }
            else(Log.i("TabbletFragment","textView = null"))
        })
        //var inflater=inflater!!.inflate(R.layout.fragment_tabbet, container, false)

        Log.i("TabbletFragment","onCreateView")

        return  inflater
    //super.onCreateView(inflater, container, savedInstanceState)
    }


    companion object{

        private const val ARG_SECTION_NUMBER =  "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int):TabbletFragment{
            return TabbletFragment().apply {
                arguments = Bundle().apply { putInt(ARG_SECTION_NUMBER,sectionNumber) }
            }

        }
    }
}