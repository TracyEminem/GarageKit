package com.wanttobuy.garagekit.ui.garagekit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aleyn.mvvm.base.BaseViewModel

class GarageKitViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}