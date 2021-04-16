package com.example.package_delivery_app.ui.driver



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.package_delivery_app.R
import com.example.package_delivery_app.data.Datasource
import com.google.android.material.floatingactionbutton.FloatingActionButton


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
        /*val textView: TextView = root.findViewById(R.id.text_driver)
        driverViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        val myDataset = Datasource().loadAffirmations()

        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)

        val itemType: String = "New Driver"
        val fab: FloatingActionButton = root.findViewById(R.id.floating_action_btn_1)
        fab.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(DriverFragmentDirections.actionNavDriverToAddNewItemFragment(itemType))
        }

        return root
    }
}