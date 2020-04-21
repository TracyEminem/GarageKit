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

        SharedPreferenceUtils.putString(PREF_ACCESS_TOKEN_AUTH,"BearereyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvYXBpLmdrLmFpZHJlYW1haS5jblwvY2xpZW50XC9hY2NvdW50XC9sb2dpbiIsImlhdCI6MTU4NTcyMjk4MiwiZXhwIjoxNTkwOTA2OTgyLCJuYmYiOjE1ODU3MjI5ODIsImp0aSI6ImpKMFFCMzM0cktOVG1sR2MiLCJzdWIiOjI0LCJwcnYiOiJlMGJiMTY5M2Y0Yzc1OTU0ODA0OTI0MTRlMGY2NDM4ZjFjNjI0OTE3In0.GSCqfa_pH4-VI66La9WoHwv2GqXe2N5KL5K0nNsuwJY",this)

        var listenerset : MutableSet<RequestListener> = HashSet()
        listenerset.add(FrescoTraceListener())
        var imagePipelineConfig = ImagePipelineConfig.newBuilder(instance).setRequestListeners(listenerset)
            .build()
        Fresco.initialize(instance,imagePipelineConfig)


    }

}