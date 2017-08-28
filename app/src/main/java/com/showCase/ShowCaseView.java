package com.showCase;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liguoying on 2017/8/22.
 */

public class ShowCaseView {
    Queue<View> mQueue;
    View currentView;

    Activity context;

    public ShowCaseView(Activity context) {
        this.context = context;
    }

    public void addViews(ArrayList<View> views) {
        mQueue = new LinkedList<>();
        mQueue.addAll(views);
    }

    /**
     * 将VIEW 添加到屏幕上
     */
    public void show() {
        if (!mQueue.isEmpty()) {
            currentView = mQueue.poll();
            ((ViewGroup) context.getWindow().getDecorView()).addView(currentView);
        }
    }

    //    将VIEW 移除屏幕
    public void dismiss() {
        if (currentView != null) {
            ((ViewGroup) context.getWindow().getDecorView()).removeView(currentView);
        }
        show();
    }

    public void cancel() {
        if (!mQueue.isEmpty()) {
            mQueue.clear();
        }
        if (currentView != null) {
            ((ViewGroup) context.getWindow().getDecorView()).removeView(currentView);
        }
    }
}
