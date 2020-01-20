package com.wanttobuy.garagekit.ui.garagekit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aleyn.mvvm.base.BaseViewModel
import com.wanttobuy.garagekit.data.banner.BannerData
import com.wanttobuy.garagekit.utils.InjectorUtil

class GarageKitViewModel : BaseViewModel() {


    private val garageKitRepository by lazy { InjectorUtil.getGarageKitRepository() }

    var mBanners = MutableLiveData<List<BannerData>>()

    fun getBanner(){
        launchOnlyresult({ garageKitRepository.getBannerList() },{mBanners.value = it})
    }

}