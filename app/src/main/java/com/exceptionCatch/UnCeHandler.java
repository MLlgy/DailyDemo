package com.exceptionCatch;

import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Monkey
 * on 2016/10/25.
 */

public class UnCeHandler implements Thread.UncaughtExceptionHandler {

    private static final String TAG = "UnCeHandler";
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    CatchExcep application;

    public UnCeHandler(CatchExcep application) {
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.application = application;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
//        异常没有处理并且默认的异常处理线程不为空，则交给默认的异常处理器来进行处理
        if (!handleExecption(ex) && mDefaultHandler != null) {
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
//                e.printStackTrace();
                Log.e(TAG, "error:" + e.getMessage());
            }

            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
////            配置重启程序后进入的activity
//            Intent intent = new Intent(application.getApplicationContext(),
//                    ExceptionCatchActivity.class);
//            PendingIntent restartIntent = PendingIntent.getActivity(application.getApplicationContext(),
//                    0, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
////            退出程序
//            AlarmManager mgr = (AlarmManager) application.getSystemService(Context.ALARM_SERVICE);
//            mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 4000, restartIntent);
//            application.finishActivity();
        }
    }

    //    自定义错误处理，收集错误信息 发送错误报告等操作均在此完成
//    true--已处理  、false--未处理
    private boolean handleExecption(Throwable ex) {
        if (ex == null) {
            return false;
        }
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(application.getApplicationContext()
                        , "程序出现了异常", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }.start();
        return true;
    }

}