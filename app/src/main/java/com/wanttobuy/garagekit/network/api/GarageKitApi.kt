package com.wanttobuy.garagekit.network.api

import com.wanttobuy.garagekit.base.BaseResponse
import com.wanttobuy.garagekit.data.account.Register
import com.wanttobuy.garagekit.data.banner.BannerData
import com.wanttobuy.garagekit.data.category.Category
import com.wanttobuy.garagekit.data.comment.Comments
import com.wanttobuy.garagekit.data.garageKit.GarageKitDetail
import com.wanttobuy.garagekit.data.garageKit.GarageKitList
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
    suspend fun signIn():BaseResponse<SignInData>

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

}