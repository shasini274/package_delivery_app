package com.example.package_delivery_app.ui.building

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BuildingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is building Fragment"
    }
    val text: LiveData<String> = _text
}