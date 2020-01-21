package com.wanttobuy.garagekit.utils

import android.R.attr
import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
import com.facebook.drawee.view.SimpleDraweeView
import com.youth.banner.loader.ImageLoader


/**
 *
 * @ClassName:      FrescoImageLoader
 * @Description:
 * @Author:         Jeremy
 * @CreateDate:     2020/1/21 上午 11:27
 */
class FrescoImageLoader :ImageLoader(){
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {

        imageView?.scaleType = ImageView.ScaleType.FIT_XY
        Glide.with(context!!).load(path).into(imageView!!);

    }


}