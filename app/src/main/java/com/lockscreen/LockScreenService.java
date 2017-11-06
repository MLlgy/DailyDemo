package com.lockscreen;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class LockScreenService extends Service {
    @Override public void onCreate() {
        super.onCreate();
        IntentFilter mScreenOffFilter = new IntentFilter();
        mScreenOffFilter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(mScreenOffReceiver, mScreenOffFilter);
    }

    @Override public void onDestroy() {
        super.onDestroy();
        unregisterComponent();
    }

    @Override public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_STICKY;
    }

    private BroadcastReceiver mScreenOffReceiver = new BroadcastReceiver() {
        @Override public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF) || intent.getAction()
                    .equals(Intent.ACTION_SCREEN_ON)) {
                Intent intent1 = new Intent(LockScreenService.this, LockMainActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
            }
        }
    };

    public void unregisterComponent() {
        if (mScreenOffReceiver != null) {
            LockScreenService.this.unregisterReceiver(mScreenOffReceiver);
        }
    }
}
