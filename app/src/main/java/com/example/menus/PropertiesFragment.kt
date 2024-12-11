package com.example.menus

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class PropertiesFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("onCreateView","PropertiesFragment")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_properties, container, false)
    }

    override fun onAttach(context: Context) {
        val actionBar: ActionBar? = (requireActivity() as AppCompatActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        Log.i("onAttach","PropertiesFragment")
        super.onAttach(context)
    }
}