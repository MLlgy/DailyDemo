package com.lockscreen

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.androidwebviewdemo.mddemo.R
import com.MainActivity
import android.content.Intent
import android.content.Context.KEYGUARD_SERVICE
import android.app.KeyguardManager
import android.content.Context
import android.view.KeyEvent
import android.view.WindowManager
import android.view.KeyEvent.KEYCODE_MENU
import android.view.KeyEvent.KEYCODE_BACK
import com.utils.TranslateTitlebarUtils.setStatusBarColor
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.os.Build
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
import android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION






class LockMainActivity : AppCompatActivity() {
    val MSG_LAUNCH_HOME = 0
//    private val mUnderView: LockUnderView? = null
//    private val mHandler = UnlockHandler(this)
    var keyguardManager: KeyguardManager? = null
    var keyguardLock: KeyguardManager.KeyguardLock? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
//        getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//        )
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            val window = window
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            window.statusBarColor = 0
//        }
//        setContentView(R.layout.activity_lock_main)
//        mUnderView = findViewById<View>(R.id.lock_underview) as LockUnderView
//        mUnderView.setHandler(mHandler)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        val key = event.getKeyCode()
        when (key) {
            KeyEvent.KEYCODE_BACK -> {
                return true
            }
            KeyEvent.KEYCODE_MENU -> {
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }

//    @SuppressLint("MissingPermission")
//    private fun initKeyguardManager() {
//        keyguardManager = applicationContext.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
//        keyguardLock = keyguardManager!!.newKeyguardLock("")
//        (keyguardLock as KeyguardManager.KeyguardLock?).disableKeyguard()//取消系统锁屏
//        startService(Intent(this@LockMainActivity, LockScreenService::class.java))
//    }
}
