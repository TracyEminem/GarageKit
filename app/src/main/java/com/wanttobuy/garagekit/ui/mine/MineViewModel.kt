package com.wanttobuy.garagekit.ui.mine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aleyn.mvvm.base.BaseViewModel

class MineViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}