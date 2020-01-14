package com.wanttobuy.garagekit.data.http

import com.wanttobuy.garagekit.network.api.GarageKitApi
import com.wanttobuy.garagekit.utils.RetrofitClient

/**
 *
 * @ClassName:      GarageKitNetwork
 * @Description:
 * @Author:         Jeremy
 * @CreateDate:     2020/1/11 上午 11:25
 */
class GarageKitNetwork {

    private val mService by lazy {
        RetrofitClient.getInstance().create(GarageKitApi::class.java)
    }

    suspend fun register(code:String,mobile:String,password:String) = mService.register(code,mobile,password)

    suspend fun login(jsCode:String,grant_type:String) = mService.login(jsCode,grant_type)

    suspend fun logout() = mService.logout()

    suspend fun signIn() = mService.signIn()

    suspend fun getCategory() = mService.getCategory()

    suspend fun getUploadToken() = mService.getUploadToken()

    suspend fun getBannerList() = mService.getBannerList()

    companion object{

        @Volatile
        private var netWork: GarageKitNetwork? = null

        fun getInstance() = netWork?: synchronized(this){
            netWork?:GarageKitNetwork().also { netWork = it }
        }

    }

}