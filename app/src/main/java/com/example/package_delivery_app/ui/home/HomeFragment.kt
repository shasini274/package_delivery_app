package com.example.package_delivery_app.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.package_delivery_app.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        /*
        val textView: TextView = root.findViewById(R.id.home_on_the_way)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
         */

        // get package data and show in listView, need to get data from database later using SimpleCursorAdapter
        val vendorArray = resources.getStringArray(R.array.package_ontheway_vendor_array)
        val buildingArray = resources.getStringArray(R.array.package_ontheway_building_array)
        val driverArray = resources.getStringArray(R.array.package_ontheway_driver_array)
        val listview1 = root.findViewById<ListView>(R.id.package_listView)
        val packageList = ArrayList<HashMap<String, String>>()

        //val arrayAdapter1 = this.context?.let { ArrayAdapter<String>(it, android.R.layout.simple_expandable_list_item_1, vendorArray) } // single string
        for (i in vendorArray.indices) {
            val map = HashMap<String, String>()

            // data entry in HashMap
            map["vendor"] = vendorArray[i]
            map["building"] = buildingArray[i]
            map["driver"] = driverArray[i]

            // add the HashMap to ArrayList
            packageList.add(map)
        }

        //fourth parameter of SimpleAdapter
        val from = arrayOf("vendor", "building", "driver")
        //fifth parameter of SimpleAdapter
        val to = intArrayOf(R.id.home_ontheway_vendor_text, R.id.home_ontheway_building_text, R.id.home_ontheway_driver_text)

        val simpleAdapter = this.context?.let { SimpleAdapter (it, packageList, R.layout.package_list_ontheway, from, to) }

        listview1.adapter = simpleAdapter
        listview1.setOnItemClickListener {
                adapterView, view, position, id ->
            Navigation.findNavController(view).navigate(HomeFragmentDirections.actionNavHomeToPackageDetailFragment(position))
            //Navigation.findNavController(view).navigate(HomeFragmentDirections.actionNavHomeToAddNewItemFragment(position.toString()))
        }

        // Floating Action Button
        val itemType: String = "New Package"
        val fab: FloatingActionButton = root.findViewById(R.id.floating_action_btn_1)
        fab.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(HomeFragmentDirections.actionNavHomeToAddNewItemFragment(itemType))
            //Navigation.findNavController(view).navigate(HomeFragmentDirections.actionNavHomeToPackageDetailFragment(100))
        }

        //two button: On the way, pending
        val onthewayBtn = root.findViewById<TextView>(R.id.home_ontheway_btn)
        val pendingBtn = root.findViewById<TextView>(R.id.home_pending_btn)
        /*val homeBtnViews: List<View> =
                listOf(onthewayBtn, pendingBtn)
        for (item in homeBtnViews) {
            when(item.id) {
                R.id.home_ontheway_btn -> {
                    item.setOnClickListener {it.setBackgroundResource(R.color.white)}
                    pendingBtn.setBackgroundResource(R.color.grey_light)
                }
                R.id.home_pending_btn -> {
                    item.setOnClickListener {it.setBackgroundResource(R.color.white)}
                    onthewayBtn.setBackgroundResource(R.color.grey_light)
                }
            }

        }*/

//        setBtnListener()
        /*
        pendingBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_nav_home_to_packageDetailFragment)
        )
         */

        return root
    }
//    private fun setBtnListener() {}

}










