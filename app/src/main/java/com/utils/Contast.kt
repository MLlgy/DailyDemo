package com.utils

import android.app.ActivityManager
import android.content.Context

/**
 * @author liguoying
 * @date 2017/11/2.
 */

/**
 * 判断本应用是否存活
 * 如果需要判断本应用是否在后台还是前台用getRunningTask
 * */
fun isAppLive(mContext: Context, packagename: String): Boolean {
    var isAppLive = false
    val activityMananger: ActivityManager = mContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val appProcessInfoList = ArrayList<ActivityManager.RunningAppProcessInfo>()
    appProcessInfoList.forEach {
        if (packagename.equals(it)) {
            isAppLive = true
        }
    }
    return isAppLive
}