package com.wanttobuy.garagekit.ui.wiki

import androidx.lifecycle.MutableLiveData
import com.aleyn.mvvm.base.BaseViewModel
import com.wanttobuy.garagekit.data.banner.BannerData
import com.wanttobuy.garagekit.utils.InjectorUtil

class MyWikiViewmodel :BaseViewModel() {

    private val garageKitRepository by lazy { InjectorUtil.getGarageKitRepository() }


}