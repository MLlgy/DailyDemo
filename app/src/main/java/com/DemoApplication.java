package com;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.androidwebviewdemo.mddemo.R;
import com.lidroid.xutils.util.LogUtils;
//import com.umeng.message.IUmengRegisterCallback;
//import com.umeng.message.PushAgent;
//import com.umeng.message.UmengMessageHandler;
//import com.umeng.message.UmengNotificationClickHandler;
//import com.umeng.message.entity.UMessage;

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

//        PushAgent mPushAgent = PushAgent.getInstance(this);
//
//
//        UmengNotificationClickHandler notificationClickHandler = new UmengNotificationClickHandler() {
//            @Override
//            public void dealWithCustomAction(Context context, UMessage msg) {
//                LogUtils.e("---》"+ msg.custom + msg.text);
//                Toast.makeText(context, msg.custom, Toast.LENGTH_LONG).show();
//            }
//        };
//        mPushAgent.setNotificationClickHandler(notificationClickHandler);
//
//
//        /**
//         * 自定义通知样式
//         */
//        UmengMessageHandler messageHandler = new UmengMessageHandler() {
//            @Override
//            public Notification getNotification(Context context, UMessage msg) {
//                switch (msg.builder_id) {
//                    case 0:
//                        Notification.Builder builder = new Notification.Builder(context);
//                        RemoteViews myNotificationView = new RemoteViews(context.getPackageName(),
//                                R.layout.notification_view);
//                        myNotificationView.setTextViewText(R.id.notification_title, msg.title);
//                        myNotificationView.setTextViewText(R.id.notification_text, msg.text);
//                        myNotificationView.setImageViewBitmap(R.id.notification_large_icon,
//                                getLargeIcon(context, msg));
//                        myNotificationView.setImageViewResource(R.id.notification_small_icon,
//                                getSmallIconId(context, msg));
//                        builder.setContent(myNotificationView)
//                                .setSmallIcon(getSmallIconId(context, msg))
//                                .setTicker(msg.ticker)
//                                .setAutoCancel(true);
//
//                        return builder.getNotification();
//                    default:
//                        //默认为0，若填写的builder_id并不存在，也使用默认。
//                        return super.getNotification(context, msg);
//                }
//            }
//        };
//        mPushAgent.setMessageHandler(messageHandler);
//
//        //注册推送服务，每次调用register方法都会回调该接口
//        mPushAgent.register(new IUmengRegisterCallback() {
//
//            @Override
//            public void onSuccess(String deviceToken) {
//                //注册成功会返回device token
//                Log.e("push", deviceToken);
//            }
//
//            @Override
//            public void onFailure(String s, String s1) {
//                Log.e("push failure", s + "   " + s1);
//            }
//        });
    }

    public static DemoApplication getInstance() {
        return mDemoApplication;
    }
}
