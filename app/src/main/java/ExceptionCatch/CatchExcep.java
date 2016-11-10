package ExceptionCatch;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;

import ExceptionCatch.UnCeHandler;

/**
 * Created by Monkey
 * on 2016/10/25.
 */

//在全局类中处理异常
public class CatchExcep extends Application {

    ArrayList<Activity> list = new ArrayList<Activity>();

    public void init() {
//        设置该CrashHandler为程序的默认处理器
        UnCeHandler catchExcep = new UnCeHandler(this);
        Thread.setDefaultUncaughtExceptionHandler(catchExcep);
    }

    public void removeActivity(Activity activity) {
        list.remove(activity);
    }

    public void addActivity(Activity activity) {
        list.add(activity);
    }

    public void finishActivity() {
        for (Activity activity : list) {
            if(activity!=null){
                activity.finish();
            }
        }
    }

}
