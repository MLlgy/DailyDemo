package com;

import android.app.Application;

/**
 * Created by liguoying on 2017/8/16.
 */

public class DemoApplication extends Application {
    private static DemoApplication mDemoApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mDemoApplication = this;
    }

    public static DemoApplication getInstance() {
        return mDemoApplication;
    }
}
