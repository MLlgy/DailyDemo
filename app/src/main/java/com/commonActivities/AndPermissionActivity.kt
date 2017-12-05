package com.commonActivities

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.androidwebviewdemo.mddemo.R
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.Permission
import com.yanzhenjie.permission.PermissionListener

class AndPermissionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_and_permission)
        findViewById<TextView>(R.id.tv_permission_request_listener_callback).setOnClickListener { v ->
            Toast.makeText(this@AndPermissionActivity, "头56edop", Toast.LENGTH_SHORT).show()
            getPermission()
        }
    }

    fun getPermission() {
        val listener = object : PermissionListener {
            override fun onSucceed(requestCode: Int, grantedPermissions: List<String>) {
                // 权限申请成功回调。
                // 这里的requestCode就是申请时设置的requestCode。
                // 和onActivityResult()的requestCode一样，用来区分多个不同的请求。
                if (requestCode == 200) {
                    // TODO ...
                }
            }

            override fun onFailed(requestCode: Int, deniedPermissions: List<String>) {
                // 权限申请失败回调。
                if (requestCode == 200) {
                    // TODO ...
                }
            }
        }

        var permissionListener = object : PermissionListener {

            var str: String? = null

            override fun onSucceed(requestCode: Int, grantPermissions: MutableList<String>) {
                if (requestCode == 200) {
                    grantPermissions.forEach {
                        str += it
                    }
                    Toast.makeText(this@AndPermissionActivity, str, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailed(requestCode: Int, deniedPermissions: MutableList<String>) {
                if (requestCode == 200) {
                    deniedPermissions.forEach {
                        str += it
                    }
                    Toast.makeText(this@AndPermissionActivity, str, Toast.LENGTH_SHORT).show()
                }
            }
        }
        AndPermission.with(this).requestCode(200).permission(Manifest.permission.ACCESS_COARSE_LOCATION).callback(permissionListener)
    }

    fun getPermissionByAnnotion(){
        AndPermission.with(this).permission(Permission.CAMERA).callback(this).start()
    }

    fun getPermissionYes(){

    }
}
