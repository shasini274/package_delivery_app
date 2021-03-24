package com.example.package_delivery_app.ui.vendor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VendorViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is vendor Fragment"
    }
    val text: LiveData<String> = _text
}