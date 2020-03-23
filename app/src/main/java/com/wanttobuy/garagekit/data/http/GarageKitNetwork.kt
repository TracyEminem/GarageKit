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

    suspend fun commentShare(id:String) = mService.commentShare(id)

    suspend fun getSearchHistory() = mService.getSearchHistory()

    suspend fun unCollect(hobby_id:String) = mService.unCollect(hobby_id)

    suspend fun getPageList() = mService.getPageList()

    suspend fun getDetail(id:String) = mService.getDetail(id)

    suspend fun collect(hobby_id:String) = mService.collect(hobby_id)

    suspend fun getItemComment(hobby_id:String) = mService.getItemComment(hobby_id)

    suspend fun createHobby(hobby:MutableMap<String,String>) = mService.createHobby(hobby)

    suspend fun comment(comment:MutableMap<String,String>) = mService.comment(comment)

    suspend fun getPagedCommentList(id:String,page:String,pagesize:String) = mService.getPagedCommentList(id,page,pagesize)

    suspend fun agreeComemnt(id:String) = mService.agreeComemnt(id)

    suspend fun postAdvice(title:String,content:String) = mService.postAdvice(title, content)

    suspend fun editInfo(infoMap:MutableMap<String,String>) = mService.editInfo(infoMap)

    suspend fun getZanMsgList(page:Int) = mService.getZanMsgList(page)

    suspend fun getSysMsgList(page: Int) = mService.getSysMsgList(page)

    suspend fun getReplayMsgList(page: Int) = mService.getReplayMsgList(page)

    suspend fun getMyHomePage() = mService.getMyHomePage()

    suspend fun getOtherHome() = mService.getOtherHome()

    suspend fun getEvaluateList(id:String,page: Int,page_size:String) = mService.getEvaluateList(id, page, page_size)

    suspend fun evaliate(hobby_id:String,recommend:String,style:String,coating:String,sculpture:String,title:String,content:String) = mService.evaliate(hobby_id, recommend, style, coating, sculpture, title, content)

    suspend fun getCommonEvaluate(hobby_id:String,recommend:String,style:String,coating:String,sculpture:String,view:String,images:String) = mService.getCommonEvaluate(hobby_id, recommend, style, coating, sculpture, view, images)

    suspend fun getInfo(id:String) = mService.getInfo(id)

    suspend fun getDetailComments(id:String) = mService.getDetailComments(id)

    suspend fun getPagedComments(bbs_id:String,uid:String,page:String) = mService.getPagedComments(bbs_id, uid, page)

    suspend fun PostBBSComments(bbs_id:String,content: String) = mService.PostBBSComments(bbs_id, content)

    suspend fun getUserInfo() = mService.getUserInfo()

    suspend fun zan(id: String) = mService.zan(id)

//    suspend fun


    companion object{

        @Volatile
        private var netWork: GarageKitNetwork? = null

        fun getInstance() = netWork?: synchronized(this){
            netWork?:GarageKitNetwork().also { netWork = it }
        }

    }

}