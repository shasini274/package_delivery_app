package com.example.package_delivery_app.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.iterator
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.package_delivery_app.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.home_on_the_way)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        // get package data and show in listView, need to get data from database later using SimpleCursorAdapter 
        val vendorArray = resources.getStringArray(R.array.package_ontheway_vendor_array)
        val arrayAdapter1 = this.context?.let { ArrayAdapter<String>(
                it, android.R.layout.simple_expandable_list_item_1, vendorArray) }

        val listview1 = root.findViewById<ListView>(R.id.package_listView)
        listview1.adapter = arrayAdapter1
        //listview1.setOnItemClickListener() {adapterView, view, position: Int, id -> Toast.makeText(this.context, "Working on it", Toast.LENGTH_LONG).show()}
        //for (item in listview1) { item.setOnClickListener {it.setBackgroundColor(Color.GRAY)} }


        return root
    }
}










