package com.TouchRightLef;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * Created by Monkey
 * on 2016/10/31.
 */

public class GestureListener extends SimpleOnGestureListener implements
        OnTouchListener {
    private static final String TAG = "GestureListener";
    private final int distance = 100;
    private final int v = 20;

    private GestureDetector gestureDetector;

    public GestureListener(Context context) {
        super();
        // TODO: 2016/10/31 ???
        gestureDetector = new GestureDetector(context, this);
    }


    public boolean left() {
        return false;
    }

    public boolean right() {
        return false;
    }

    /**
     * @param e1        第1个ACTION_DOWN MotionEvent
     * @param e2        最后一个ACTION_MOVE MotionEvent
     * @param velocityX X轴上的移动速度（像素/秒）
     * @param velocityY Y轴上的移动速度（像素/秒）
     * @return
     */
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d(TAG, "onFling: " + e1.getX() + "--->" + e2.getX());
        if ((e1.getX() - e2.getX()) > distance && Math.abs(velocityX) > v) {
            left();
        }

        if ((e1.getX() - e2.getX()) < distance && Math.abs(velocityX) > v) {
            right();
        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        //此返回值必须为true
        return true;
    }

    public int getDistance() {
        return distance;
    }

    public int getV() {
        return v;
    }

    public GestureDetector getGestureDetector() {
        return gestureDetector;
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.gestureDetector = gestureDetector;
    }
}
