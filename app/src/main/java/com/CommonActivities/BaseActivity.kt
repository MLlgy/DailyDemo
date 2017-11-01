package com.CommonActivities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.R
import com.umeng.message.PushAgent

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PushAgent.getInstance(this).onAppStart();
    }
}
