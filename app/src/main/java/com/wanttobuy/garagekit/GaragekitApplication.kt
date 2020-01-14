package com.wanttobuy.garagekit

import com.aleyn.mvvm.base.BaseApplication
import com.blankj.utilcode.util.LogUtils

/**
 *
 * @ClassName:      GaragekitApplication
 * @Description:
 * @Author:         Jeremy
 * @CreateDate:     2020/1/11 上午 11:22
 */
class GaragekitApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        LogUtils.getConfig().run {
            isLogSwitch = BuildConfig.DEBUG
            setSingleTagSwitch(true)
        }

    }

}