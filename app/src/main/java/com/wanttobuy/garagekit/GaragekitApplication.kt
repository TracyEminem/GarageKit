package com.wanttobuy.garagekit

import com.aleyn.mvvm.base.BaseApplication
import com.blankj.utilcode.util.LogUtils
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.facebook.imagepipeline.listener.RequestListener
import com.wanttobuy.garagekit.common.PREF_ACCESS_TOKEN_AUTH
import com.wanttobuy.garagekit.utils.FrescoTraceListener
import com.wanttobuy.garagekit.utils.SharedPreferenceUtils
import java.util.HashSet

/**
 *
 * @ClassName:      GaragekitApplication
 * @Description:
 * @Author:         Jeremy
 * @CreateDate:     2020/1/11 上午 11:22
 */
class GaragekitApplication : BaseApplication() {

    companion object{
        var instance :GaragekitApplication? =null
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        LogUtils.getConfig().run {
            isLogSwitch = BuildConfig.DEBUG
            setSingleTagSwitch(true)
        }

        SharedPreferenceUtils.putString(PREF_ACCESS_TOKEN_AUTH,"BearereyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hcGkuZ2suYWlkcmVhbWFpLmNuXC9jbGllbnRcL2FjY291bnRcL2xvZ2luQnlNb2JpbGUiLCJpYXQiOjE1Nzk1NzQ0MDMsImV4cCI6MTU4NDc1ODQwMywibmJmIjoxNTc5NTc0NDAzLCJqdGkiOiJqb0VhUGlqTk1mUUIxYnR4Iiwic3ViIjoxMywicHJ2IjoiZTBiYjE2OTNmNGM3NTk1NDgwNDkyNDE0ZTBmNjQzOGYxYzYyNDkxNyJ9._Rti6NO06gcWGExqbltJ17ueI4Wbu3ga4xTp2X07adI",this)

        var listenerset : MutableSet<RequestListener> = HashSet()
        listenerset.add(FrescoTraceListener())
        var imagePipelineConfig = ImagePipelineConfig.newBuilder(instance).setRequestListeners(listenerset)
            .build()
        Fresco.initialize(instance,imagePipelineConfig)


    }

}