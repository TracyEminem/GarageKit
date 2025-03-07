package com.wanttobuy.garagekit.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 检查网络状态工具类
 */
public class NetworkUtil {

    public static final int TYPE_NOT_CONNECTED = 0;
    public static final int TYPE_WIFI = 1;
    public static final int TYPE_MOBILE = 2;


    public static int getConnectivityStatus(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (null != activeNetwork) {

            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;

            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;
        }
        return TYPE_NOT_CONNECTED;
    }

    public static String getConnectivityStatusString(Context context) {

        int conn = NetworkUtil.getConnectivityStatus(context);

        String status = null;
        if (conn == NetworkUtil.TYPE_WIFI) {
            //status = "Wifi enabled";
            status = "Internet connection available";
        } else if (conn == NetworkUtil.TYPE_MOBILE) {
            //status = "Mobile data enabled";
            status = "Internet connection available";
        } else if (conn == NetworkUtil.TYPE_NOT_CONNECTED) {
            status = "Not connected to Internet";
        }
        return status;
    }

    /**
     * 判断网络是否连接
     *
     * @param context
     * @return
     */
    public static boolean isConnected(Context context) {

        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (null != connectivity) {

            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (null != info && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

}