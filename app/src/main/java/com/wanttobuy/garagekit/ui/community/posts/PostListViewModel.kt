package com.wanttobuy.garagekit.ui.community.posts

import androidx.lifecycle.MutableLiveData
import com.aleyn.mvvm.base.BaseViewModel
import com.blankj.utilcode.util.ToastUtils
import com.wanttobuy.garagekit.data.bbs.PostListData
import com.wanttobuy.garagekit.data.sign.SignInData
import com.wanttobuy.garagekit.utils.InjectorUtil

class PostListViewModel : BaseViewModel(){

    private val garageKitRepository by lazy { InjectorUtil.getGarageKitRepository() }

    var postData = MutableLiveData<List<PostListData>>()

//    var signInData = MutableLiveData<SignInData>()
//
//    fun signIn(){
//        launchOnlyresult({garageKitRepository.signIn()},{ signInData.value = it})
//    }

    fun getBBSPagesList(){
//        launchOnlyresult({garageKitRepository.getBBSList()},{postData.value = it})
        launchOnlyresult({garageKitRepository.getBBSList()},{postData.value = it.data})
    }

}