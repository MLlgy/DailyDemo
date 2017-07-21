package com.myrecyclerview;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.entity.BasicNotificationEvent;
import com.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button basicBtn, zdBtn, piBtn;
    private final static int BASIC_NOTI = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        initView();
    }

    private void initView() {
        basicBtn = (Button) findViewById(R.id.btn_basic_notification);
        zdBtn = (Button) findViewById(R.id.btn_zd_notification);
        zdBtn.setOnClickListener(this);
        basicBtn.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_basic_notification:
                EventBus.getDefault().post(new BasicNotificationEvent("basic", "content", R.mipmap.ic_launcher));
                break;
            case R.id.btn_zd_notification:
                EventBus.getDefault().post(new BasicNotificationEvent("折叠通知栏", "content", R.mipmap.ic_launcher));
                break;
        }
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showBaicNotification(BasicNotificationEvent event) {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = null;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            notification = new Notification.Builder(this)
                    .setSmallIcon(event.getSmallIcon())
                    .setContentTitle(event.getTitle())
                    .setContentText(event.getContent())
                    .build();
        }
        manager.notify(BASIC_NOTI, notification);

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showZheDie(BasicNotificationEvent event) {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.activity_cliping);
        remoteViews.setTextViewText(R.id.tv_notification_zd_show,"i am a collsp");
        Notification notification = null;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            notification = new Notification.Builder(this)
                    .setSmallIcon(event.getSmallIcon())
                    .setContentTitle(event.getTitle())
                    .setContentText(event.getContent())
                    .build();
        }
        notification.contentView = remoteViews;
        manager.notify(BASIC_NOTI, notification);

    }
}
