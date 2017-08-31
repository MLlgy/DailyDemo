package com.CommonActivities;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.R;
import com.utils.BadgeUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import me.leolin.shortcutbadger.ShortcutBadger;

/**
 * http://www.2cto.com/kf/201604/498329.html
 * Android系统 小米/三星/索尼 应用启动图标未读消息数(BadgeNumber)动态提醒 http://blog.csdn.net/janice0529/article/details/44344169
 */

public class BadgeNumberActivity extends AppCompatActivity {

    private int mCount = 5;
    private Notification mNotification;
    private Notification.Builder mBuilder;
    private NotificationManager mMNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badge_number);
//        initData();
    }

    private void initData() {
        mMNotificationManager = (NotificationManager) this

                .getSystemService(Context.NOTIFICATION_SERVICE);


        mBuilder = new Notification.Builder(this)

                .setContentTitle("title").setContentText("text").setSmallIcon(R.drawable.ic_launcher);

        mNotification = mBuilder.build();

        try {

            Field field = mNotification.getClass().getDeclaredField("extraNotification");

            Object extraNotification = field.get(mNotification);

            Method method = extraNotification.getClass().getDeclaredMethod("setMessageCount", int.class);

            method.invoke(extraNotification, mCount);

        } catch (Exception e) {

            e.printStackTrace();

        }

        mMNotificationManager.notify(0, mNotification);
    }

    public void send(View view) {
        int badgeCount = 1;
        ShortcutBadger.applyCount(this, badgeCount); //for 1.1.4+
//        BadgeUtil.setBadgeCount(mNotification, this, 10);
    }

    public void unsend(View view) {
        ShortcutBadger.removeCount(this); //for 1.1.4+
//        BadgeUtil.resetBadgeCount(mNotification, this);
    }
}
