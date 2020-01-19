package com.wanttobuy.garagekit.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager
import java.util.jar.Attributes

/**
 * Created by TracyEminem on 2019-08-29 15:09.
 */
class  NonScrollableViewPager(context: Context,attributes: AttributeSet) : ViewPager(context,attributes){

    var isCanScroll = false

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        //触摸时禁止事件
        return isCanScroll && super.onTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return isCanScroll && super.onInterceptTouchEvent(ev)
    }

    override fun setCurrentItem(item: Int, smoothScroll: Boolean) {
        super.setCurrentItem(item, smoothScroll)
    }

    override fun setCurrentItem(item: Int) {
        //禁止滑动动画
        super.setCurrentItem(item,false)
    }

}