package com.example.package_delivery_app.ui.vendor

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.package_delivery_app.R
import com.example.package_delivery_app.ui.home.HomeFragmentDirections
import com.google.android.material.floatingactionbutton.FloatingActionButton

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
        val itemType: String = "New Vendor"
        val fab: FloatingActionButton = root.findViewById(R.id.floating_action_btn_1)
        fab.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(VendorFragmentDirections.actionNavVendorToAddNewItemFragment(itemType))
            //Navigation.findNavController(view).navigate(HomeFragmentDirections.actionNavHomeToPackageDetailFragment(100))
        }

/*
        // add underline
        val test1: TextView = root.findViewById(R.id.test_btn1)
        test1?.setOnClickListener {
            test1.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        }
*/

        return root
    }
}