package com.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by mk.io on 17-8-21.
 * 手指点击该 View，会触发该 View 的 一次 onTouchEvent() 方法，触发了 ACTION_DOWN 事件
 * 手指松开该 View，会触发该 View 的 一次 onTouchEvent() 方法，触发了 ACTION_UP 事件
 * 注意： 以上的次数为一次
 * 手指在该 view 上滑动或者一直按在该 view 上，会一直触发（像个几毫秒） onTouchEvent() ，同时也会一直触发 ACITON_MOVE 事件，执行相关代码
 */

public class DragViewOne extends View {
    private static final String TAG = "DragViewOne";
    private int lastX;
    private int lastY;

    public DragViewOne(Context context) {
        super(context);
        initView();
    }

    public DragViewOne(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DragViewOne(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setBackgroundColor(Color.RED);
        Log.e(TAG, "onTouchEvent 0: " + getLeft() + " " + getTop() + " " + getRight() + " " + getBottom());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {//长时间按住不移动也会触发该方法
        int action = event.getAction();
//        int x = (int) event.getRawX();
//        int y = (int) event.getRawY();
        int x = (int) event.getX();
        int y = (int) event.getY();
        Log.e(TAG + "li", "onTouchEvent 1: " + x + "  " + y + "**" + getLeft() + " " + getTop() + " " + getRight() + " " + getBottom());
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                Log.e(TAG + "ACTION_DOWN", "onTouchEvent:ACTION_DOWN " + "lastX: " + lastX + ",lastY: " + lastY);
                break;
            case MotionEvent.ACTION_MOVE://长时间按住不移动也会触发该方法
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
//                lastX = x;
//                lastY = y;
                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);
                Log.e(TAG + "ACTION_MOVE", "onTouchEvent: " + "offsetx: " + offsetX + " offsety: " + offsetY
                        + " l: " + getLeft() + " t: " + getTop() + " r:" + getRight() + " b:" + getBottom() + " " + lastY + " " + lastX);

                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG + "ACTION_UP", "onTouchEvent: " + " l:" + getLeft() + " t: " + getTop() + " r:" + getRight() + " b:" + getBottom());
                break;
        }
        return true;//true 代表处理事件
    }
}
