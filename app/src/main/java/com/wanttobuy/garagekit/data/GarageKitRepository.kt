package com.wanttobuy.garagekit.data

import com.aleyn.mvvm.base.BaseModel
import com.wanttobuy.garagekit.base.BaseListResponse
import com.wanttobuy.garagekit.base.BaseResponse
import com.wanttobuy.garagekit.data.banner.BannerData
import com.wanttobuy.garagekit.data.bbs.PostListData
import com.wanttobuy.garagekit.data.category.Category
import com.wanttobuy.garagekit.data.garageKit.GarageKitList
import com.wanttobuy.garagekit.data.http.GarageKitNetwork
import com.wanttobuy.garagekit.data.sign.SignInData

/**
 *
 * @ClassName:      GarageKitRepository
 * @Description:
 * @Author:         Jeremy
 * @CreateDate:     2020/1/11 上午 11:25
 */
class GarageKitRepository private constructor(private val network: GarageKitNetwork):BaseModel(){

    suspend fun register(code:String,mobile:String,password:String){
        network.register(code,mobile,password)
    }

    suspend fun login(jsCode:String,grant_type:String){
        network.login(jsCode, grant_type)
    }

    suspend fun logout(){
        network.logout()
    }

    suspend fun signIn() : BaseResponse<Any>{
        return network.signIn()
    }

    suspend fun getCategory() : BaseResponse<Category>{
        return network.getCategory()
    }

    suspend fun getUploadToken(){
        network.getUploadToken()
    }

    suspend fun getBannerList() : BaseResponse<List<BannerData>> {
        return network.getBannerList()
    }

    suspend fun commentShare(id:String){
        network.commentShare(id)
    }

    suspend fun getSearchHistory(){
        network.getSearchHistory()
    }

    suspend fun unCollect(id:String){
        network.unCollect(id)
    }

    suspend fun getPageList() : BaseResponse<GarageKitList>{
        return network.getPageList()
    }

    suspend fun getDetail(id:String){
        network.getDetail(id)
    }

    suspend fun collect(id:String){
        network.collect(id)
    }

    suspend fun getItemComment(id:String){
        network.getItemComment(id)
    }


    suspend fun getBBSList() : BaseResponse<BaseListResponse<List<PostListData>>>{
        return network.getBBSList()
    }


    companion object{

        @Volatile
        private var INSTANCE : GarageKitRepository? = null

        fun getInstance(network: GarageKitNetwork) = INSTANCE ?: synchronized(this){
            INSTANCE ?: GarageKitRepository(network).also { INSTANCE = it }
        }

    }

}