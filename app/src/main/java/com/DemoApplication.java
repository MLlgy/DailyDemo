package com;

import android.app.Application;
import android.graphics.Typeface;
import android.util.Log;

import com.androidwebviewdemo.mddemo.R;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by liguoying on 2017/8/16.
 */

public class DemoApplication extends Application {
    private static DemoApplication mDemoApplication;
    public static Typeface mTypeface;

    @Override
    public void onCreate() {
        super.onCreate();
        mDemoApplication = this;
        mTypeface = Typeface.createFromAsset(getAssets(), "fonts/qiaoqiao.ttf");
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/qiaoqiao.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.e("push", deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.e("push failure", s + "   " + s1);
            }
        });
    }

    public static DemoApplication getInstance() {
        return mDemoApplication;
    }
}
