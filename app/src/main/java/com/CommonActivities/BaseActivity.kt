package com.CommonActivities

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import com.interfaces.CheckPermissionsListener
import com.umeng.message.PushAgent

open class BaseActivity : AppCompatActivity() {

    companion object {
        private val REQUEST_CODE: Int = 2333
    }

    protected var needPermission: Array<String> = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE)

    private var mListener: CheckPermissionsListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PushAgent.getInstance(this).onAppStart();
    }

    open fun requestPermission(activity: Activity, permissions: Array<String>, listener: CheckPermissionsListener) {
        if (activity == null) return
        mListener = listener
        val deniedPermission = findDeniedPermission(activity, permissions)
        if (!deniedPermission.isEmpty()) {
            ActivityCompat.requestPermissions(activity, permissions, REQUEST_CODE)
        } else {
            mListener!!.onGranted()
        }
    }

    private fun findDeniedPermission(activity: Activity, permissions: Array<String>): ArrayList<String> {
        val deniedPermissions = ArrayList<String>()
        for (permission in permissions) {
            if (ActivityCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED)
                deniedPermissions.add(permission)
        }
        return deniedPermissions
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CODE -> {
                val deneiedPermission = ArrayList<String>()
                val length: Int = permissions?.size
                for (i in 0..length - 1) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        deneiedPermission.add(permissions[i])
                    }
                }
                if (deneiedPermission.size > 0) {
                    mListener!!.onDenied(deneiedPermission)
                }else{
                    mListener!!.onGranted()
                }
            }
            else -> {}
        }
    }
}
