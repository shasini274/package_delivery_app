package com.example.package_delivery_app.ui.driver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.package_delivery_app.R

class DriverFragment : Fragment() {

    private lateinit var driverViewModel: DriverViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        driverViewModel =
                ViewModelProvider(this).get(DriverViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_driver, container, false)
        val textView: TextView = root.findViewById(R.id.text_driver)
        driverViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}