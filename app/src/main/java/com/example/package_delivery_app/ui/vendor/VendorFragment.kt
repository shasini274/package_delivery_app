package com.example.package_delivery_app.ui.vendor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.package_delivery_app.R

class VendorFragment : Fragment() {

    private lateinit var vendorViewModel: VendorViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        vendorViewModel =
                ViewModelProvider(this).get(VendorViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_vendor, container, false)
        val textView: TextView = root.findViewById(R.id.text_vendor)
        vendorViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}