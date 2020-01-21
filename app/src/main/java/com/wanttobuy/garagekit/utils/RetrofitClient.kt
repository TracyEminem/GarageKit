package com.wanttobuy.garagekit.utils

import com.aleyn.mvvm.network.interceptor.Level
import com.aleyn.mvvm.network.interceptor.LoggingInterceptor
import com.wanttobuy.garagekit.BuildConfig
import com.wanttobuy.garagekit.GaragekitApplication
import com.wanttobuy.garagekit.common.Constant.BASE_URL
import com.wanttobuy.garagekit.common.PREF_ACCESS_TOKEN_AUTH
import okhttp3.*
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 *
 * @ClassName:      RetrofitClient
 * @Description:
 * @Author:         Jeremy
 * @CreateDate:     2020/1/11 上午 11:26
 */
class RetrofitClient {

    companion object{

        fun getInstance() = SingletonHolder.INSTANCE
        private lateinit var retrofit: Retrofit

    }

    private object SingletonHolder{
        val INSTANCE = RetrofitClient()
    }

    init {
        retrofit = Retrofit.Builder()
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    internal class TokenAuthInterceptor : Interceptor {

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            if (alreadyHasAuthorizationHeader(originalRequest)) {
                return chain.proceed(originalRequest)
            }
            val authorised = originalRequest.newBuilder()
                .header(
                    "Authorization",
                    SharedPreferenceUtils.getString(
                        PREF_ACCESS_TOKEN_AUTH,
                        GaragekitApplication.instance?.applicationContext!!
                    ))
                .header("Content-Type", "application/json; charset=utf-8")
                .build()
            return chain.proceed(authorised)
        }

        private fun alreadyHasAuthorizationHeader(request: Request): Boolean {
            return request.headers().get("Authorization") != null
        }

    }

    internal class TokenAuthenticator : Authenticator {
        override fun authenticate(
            route: Route?,
            response: Response
        ): Request? { //todo
//刷新token
            return response.request().newBuilder()
                .header(
                    "Authorization",
                    SharedPreferenceUtils.getString(
                        PREF_ACCESS_TOKEN_AUTH,
                        GaragekitApplication.instance?.applicationContext!!
                    ))
                .build()
        }
    }

    private fun getOkHttpClient():OkHttpClient{
        return OkHttpClient.Builder()
            .connectTimeout(20L,TimeUnit.SECONDS)
            .addNetworkInterceptor(LoggingInterceptor().apply {
                isDebug = BuildConfig.DEBUG
                level = Level.BASIC
                type = Platform.INFO
                requestTag = "Request"
                requestTag = "Response"
            })
            .addInterceptor(TokenAuthInterceptor())
            .authenticator(TokenAuthenticator())
            .writeTimeout(20L,TimeUnit.SECONDS)
            .connectionPool(ConnectionPool(8,15,TimeUnit.SECONDS))
            .build()
    }

    fun <T> create(service: Class<T>?): T = retrofit.create(service!!)?:throw RuntimeException("Api service is null")

}