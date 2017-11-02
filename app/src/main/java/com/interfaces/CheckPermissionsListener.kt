package com.interfaces

/**
 * @author liguoying
 * @date 2017/11/2.
 */
interface CheckPermissionsListener {
    fun onGranted()
    fun onDenied(permissions: ArrayList<String>)
}