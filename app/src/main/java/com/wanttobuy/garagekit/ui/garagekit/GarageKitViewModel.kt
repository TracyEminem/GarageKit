package com.wanttobuy.garagekit.ui.garagekit

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aleyn.mvvm.base.BaseViewModel
import com.aleyn.mvvm.network.ExceptionHandle
import com.aleyn.mvvm.network.ResponseThrowable
import com.blankj.utilcode.util.LogUtils
import com.wanttobuy.garagekit.data.banner.BannerData
import com.wanttobuy.garagekit.data.category.Category
import com.wanttobuy.garagekit.data.garageKit.Data
import com.wanttobuy.garagekit.data.garageKit.GarageKitList
import com.wanttobuy.garagekit.utils.InjectorUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

class GarageKitViewModel : BaseViewModel() {


    private val garageKitRepository by lazy { InjectorUtil.getGarageKitRepository() }

    var mBanners = MutableLiveData<List<BannerData>>()
    var category = MutableLiveData<Category>()
    var itemBinding = MutableLiveData<GarageKitList>()
    var garageKitItem = ObservableArrayList<Data>()

//    fun getBanner(){
//        launchOnlyresult({ garageKitRepository.getBannerList() },{mBanners.value = it})
//    }

    fun getGarakitList(){
        launchOnlyresult({
            garageKitRepository.getPageList()
        },{})
    }

    @ExperimentalCoroutinesApi
    @FlowPreview
    fun getHomeData(){
        launchUI {
            launchFlow{garageKitRepository.getBannerList()}
                .flatMapConcat{
                    return@flatMapConcat if(it.isSuccess()){
                        mBanners.value = it.data
                        launchFlow{
                            garageKitRepository.getCategory()
                        }
                    }else throw ResponseThrowable(it.code,it.message)
                }.onStart { defUI.showDialog.postValue(null) }
                .flowOn(Dispatchers.Main)
                .onCompletion { defUI.dismissDialog.call() }
                .catch {
                    // 错误处理
                    val err = ExceptionHandle.handleException(it)
                    LogUtils.d("${err.code}: ${err.message}")
                }
                .collect {
                    if(it.isSuccess()) category.value = it.data
                }
        }
    }

}