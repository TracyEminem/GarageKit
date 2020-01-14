package com.wanttobuy.garagekit.ui.community

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aleyn.mvvm.base.BaseViewModel

class CommunityViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}