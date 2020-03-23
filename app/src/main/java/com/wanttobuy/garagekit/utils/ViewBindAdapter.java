package com.wanttobuy.garagekit.utils;

import android.net.Uri;
import android.text.TextUtils;

import androidx.databinding.BindingAdapter;

import com.facebook.drawee.view.SimpleDraweeView;

public class ViewBindAdapter {
    @BindingAdapter({"bind:url"})
    public static void setImgUrl(SimpleDraweeView imageView, String uri) {
        if (!TextUtils.isEmpty(uri)) {
            imageView.setImageURI(Uri.parse(uri));
        }
    }
}
