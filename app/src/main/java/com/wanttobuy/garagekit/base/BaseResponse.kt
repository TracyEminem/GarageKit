package com.wanttobuy.garagekit.base

import com.aleyn.mvvm.base.IBaseResponse

/**
 *
 * @ClassName:      BaseResponse
 * @Description:
 * @Author:         Jeremy
 * @CreateDate:     2020/1/13 下午 6:49
 */
class BaseResponse<T>(val code:Int,val message:String,val data: T) : IBaseResponse<T> {
    override fun code(): Int {
        return code
    }

    override fun data(): T {
        return data
    }

    override fun isSuccess(): Boolean {
        return true
    }

    override fun msg(): String {
        return message
    }
}