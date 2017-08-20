package com.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.R;

/**
 * Created by mk.io on 17-8-21.
 */

public class DragViewOne extends View {
    private static final String TAG = "DragViewOne";
    private int lastX;
    private int lastY;

    public DragViewOne(Context context) {
        super(context);
    }

    public DragViewOne(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DragViewOne(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setBackgroundColor(getResources().getColor(R.color.blue3));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        Log.e(TAG, "onTouchEvent 1: " + x + "  " + y+ "**" + getLeft() + " " + getTop() + "" + getRight() + " " + getBottom());
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                Log.e(TAG, "onTouchEvent:ACTION_DOWN " + "lastX: " + lastX + ",lastY: " + lastY);
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                Log.e(TAG, "onTouchEvent:ACTION_MOVE " + "offsetx: " + offsetX + " offsety: " + offsetY
                        + "**" + getLeft() + " " + getTop() + "" + getRight() + " " + getBottom());
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;//true 代表处理事件
    }
}
