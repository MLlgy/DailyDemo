package com;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by liguoying on 2017/8/16.
 */

public class DemoApplication extends Application {
    private static DemoApplication mDemoApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mDemoApplication = this;
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/qiaoqiao.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    public static DemoApplication getInstance() {
        return mDemoApplication;
    }
}
