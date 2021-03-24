package com.example.package_delivery_app.ui.building

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.package_delivery_app.R

class BuildingFragment : Fragment() {

    private lateinit var buildingViewModel: BuildingViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        buildingViewModel =
                ViewModelProvider(this).get(BuildingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_building, container, false)
        val textView: TextView = root.findViewById(R.id.home_on_the_way)
        buildingViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}