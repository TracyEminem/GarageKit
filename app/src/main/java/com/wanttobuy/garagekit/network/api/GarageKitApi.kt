package com.wanttobuy.garagekit.network.api

import com.wanttobuy.garagekit.base.BaseListResponse
import com.wanttobuy.garagekit.base.BaseResponse
import com.wanttobuy.garagekit.data.account.Register
import com.wanttobuy.garagekit.data.banner.BannerData
import com.wanttobuy.garagekit.data.bbs.PostListData
import com.wanttobuy.garagekit.data.bbs.bbs
import com.wanttobuy.garagekit.data.category.Category
import com.wanttobuy.garagekit.data.comment.CommentDetail
import com.wanttobuy.garagekit.data.comment.Comments
import com.wanttobuy.garagekit.data.comment.PagedComments
import com.wanttobuy.garagekit.data.evaluate.Evaluate
import com.wanttobuy.garagekit.data.garageKit.GarageKitDetail
import com.wanttobuy.garagekit.data.garageKit.GarageKitList
import com.wanttobuy.garagekit.data.mine.MyHome
import com.wanttobuy.garagekit.data.mine.Userinfo
import com.wanttobuy.garagekit.data.notification.ReplayMsg
import com.wanttobuy.garagekit.data.notification.SysMsg
import com.wanttobuy.garagekit.data.notification.ZanMsg
import com.wanttobuy.garagekit.data.search.SearchHistory
import com.wanttobuy.garagekit.data.sign.SignInData
import com.wanttobuy.garagekit.data.token.UpLoadToken
import retrofit2.http.*
import java.util.*

/**
 *
 * @ClassName:      GarageKitApi
 * @Description:
 * @Author:         Jeremy
 * @CreateDate:     2020/1/11 上午 11:35
 */
interface GarageKitApi {

    @POST("client/account/reg")
    @FormUrlEncoded
    suspend fun register(@Field("mobile") mobile:String,@Field("code") code:String,@Field("password") password:String) : BaseResponse<Register>

    @POST("client/account/login")
    @FormUrlEncoded
    suspend fun login(@Field("js_code") js_code:String,@Field("grant_type") grant_type:String)

    @POST("client/account/logout")
    suspend fun logout()

    @POST("client/bbs/signIn")
    suspend fun signIn():BaseResponse<Any>

    @GET("client/category/getList")
    suspend fun getCategory():BaseResponse<Category>

    @GET("client/file/getUploadToken")
    suspend fun getUploadToken():BaseResponse<UpLoadToken>

    @GET("client/ad/getBannerList")
    suspend fun getBannerList():BaseResponse<List<BannerData>>

    @POST("client/hobby/commentShare")
    @FormUrlEncoded
    suspend fun commentShare(@Field("id") id:String)

    @POST("client/hobby/getSearchHistory")
    suspend fun getSearchHistory():BaseResponse<SearchHistory>

    @POST("client/hobby/unCollect")
    @FormUrlEncoded
    suspend fun unCollect(@Field("hobby_id") hobby_id:String)

    @GET("client/hobby/getPagedList")
    suspend fun getPageList():BaseResponse<GarageKitList>

    @GET("client/bbs/getPagedList")
    suspend fun getBBSList():BaseResponse<BaseListResponse<List<PostListData>>>

    @GET("client/hobby/getDetailInfo")
    suspend fun getDetail(@Query("id") id: String): BaseResponse<GarageKitDetail>

    @POST("client/hobby/collect")
    @FormUrlEncoded
    suspend fun collect(@Field("hobby_id") hobby_id:String)

    @GET("client/hobby/getItemComment")
    suspend fun getItemComment(@Query("hobby_id") hobby_id:String)

    @POST("client/hobby/create")
    @FormUrlEncoded
    suspend fun createHobby(@FieldMap hobby:MutableMap<String,String>):BaseResponse<Any>

    @POST("client/hobby/comment")
    @FormUrlEncoded
    suspend fun comment(@FieldMap comment: MutableMap<String,String>):BaseResponse<Any>

    @GET("client/hobby/getPagedCommentList")
    suspend fun getPagedCommentList(@Query("id") id:String,@Query("page") page:String,@Query("page_size") page_size:String):BaseResponse<List<Comments>>

    @POST("client/hobby/commentAgree")
    @FormUrlEncoded
    suspend fun agreeComemnt(@Field("id") id:String):BaseResponse<Any>

    @POST("client/user/advice")
    @FormUrlEncoded
    suspend fun postAdvice(@Field("title") title:String,@Field("content") content:String):BaseResponse<Any>

    @POST("client/user/editInfo")
    @FormUrlEncoded
    suspend fun editInfo(@FieldMap map:Map<String,String>):BaseResponse<Any>

    @GET("client/msg/getZanMsgList")
    suspend fun getZanMsgList(@Query("page") page:Int):BaseResponse<List<ZanMsg>>

    @GET("client/msg/getSysMsgList")
    suspend fun getSysMsgList(@Query("page") page: Int):BaseResponse<List<SysMsg>>

    @GET("client/msg/getReplayMsgList")
    suspend fun getReplayMsgList(@Query("page") page: Int):BaseResponse<List<ReplayMsg>>

    @GET("client/home/me")
    suspend fun getMyHomePage():BaseResponse<MyHome>

    @GET("client/home/other")
    suspend fun getOtherHome():BaseResponse<MyHome>

    @GET("client/hobby/getEvaluateList")
    suspend fun getEvaluateList(@Query("id") id: String,@Query("page") page: Int,@Query("page_size") page_size:String):BaseResponse<Evaluate>

    @POST("client/hobby/evaluate")
    @FormUrlEncoded
    suspend fun evaliate(@Field("hobby_id") hobby_id:String,@Field("recommend") recommend:String,@Field("style") style:String,@Field("coating") coating:String,@Field("sculpture") sculpture:String,@Field("title") title:String,@Field("content") content:String) :BaseResponse<Any>

    @POST("client/hobby/commonEvaluate")
    @FormUrlEncoded
    suspend fun getCommonEvaluate(@Field("hobby_id") hobby_id:String,@Field("recommend") recommend:String,@Field("style") style:String,@Field("coating") coating:String,@Field("sculpture") sculpture:String,@Field("view") view:String,@Field("images") images:String):BaseResponse<Any>

//
//    @POST("/client/hobby/supplement")
//    @FormUrlEncoded
//    suspend fun postSupplement(@Field)

    @GET("client/bbs/getInfo")
    suspend fun getInfo(@Query("id") id:String):BaseResponse<bbs>

    @GET("client/bbs/getDetailComments")
    suspend fun getDetailComments(@Query("id") id: String):BaseResponse<CommentDetail>

    @GET("client/bbs/getPagedComments")
    suspend fun getPagedComments(@Query("bbs_id") bbs_id:String,@Query("uid") uid:String,@Query("page") page:String):BaseResponse<PagedComments>

    @POST("client/bbs/comment")
    suspend fun PostBBSComments(@Query("bbs_id") bbs_id:String,@Query("content") content:String)

    @GET("client/bbs/getUserInfo")
    suspend fun getUserInfo():BaseResponse<Userinfo>

    @POST("client/bbs/zan")
    @FormUrlEncoded
    suspend fun zan(@Field("id") id:String):BaseResponse<Any>

    @POST("client/bbs/commentZan")
    @FormUrlEncoded
    suspend fun commentZan(@Field("comment_id") comment_id:String):BaseResponse<Any>

    @POST("client/bbs/commentReport")
    @FormUrlEncoded
    suspend fun commentReport(@Field("comment_id") comment_id:String):BaseResponse<Any>


    @POST("client/bbs/replayComment")
    @FormUrlEncoded
    suspend fun replayComment(@Field("comment_id") comment_id:String,@Field("content") content:String):BaseResponse<Any>

    @POST("client/bbs/updateOrCreate")
    @FormUrlEncoded
    suspend fun updateOrCreate(@Field("id") id:String,@Field("hobby_id") hobby_id:String,@Field("title") title:String,@Field("content") content:String):BaseResponse<Any>

    @POST("client/bbs/report")
    @FormUrlEncoded
    suspend fun report(@Field("id") id:String):BaseResponse<Any>

    @POST("client/user/cancelFollow")
    @FormUrlEncoded
    suspend fun cancelFollow(@Field("uid") uid:String):BaseResponse<Any>

    @POST("client/user/follow")
    @FormUrlEncoded
    suspend fun follow(@Field("uid") uid:String):BaseResponse<Any>
//
//    @POST("client/feedback/report")
//    @FormUrlEncoded
//    suspend fun feedbackreport(@Field(""))

    @POST("client/feedback/advice")
    @FormUrlEncoded
    suspend fun advice(@Field("type") type:String,@Field("content") content:String):BaseResponse<Any> // 1. 手拌错误 2. 产品bug 3. 其他建议


}