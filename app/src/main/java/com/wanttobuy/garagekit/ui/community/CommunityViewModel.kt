package com.wanttobuy.garagekit.ui.community

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aleyn.mvvm.base.BaseViewModel
import com.blankj.utilcode.util.ToastUtils
import com.wanttobuy.garagekit.data.banner.BannerData
import com.wanttobuy.garagekit.data.sign.SignInData
import com.wanttobuy.garagekit.utils.InjectorUtil

class CommunityViewModel : BaseViewModel() {

    private val garageKitRepository by lazy { InjectorUtil.getGarageKitRepository() }

    var signInData = MutableLiveData<Any>()

    fun signIn(){
        launchOnlyresult({garageKitRepository.signIn()},{signInData.value = it})
    }



}