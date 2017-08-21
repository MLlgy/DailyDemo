package com.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by mk.io on 17-8-21.
 * 疑惑依旧存在
 */

public class DragViewTwo extends View {
    private static final String TAG = "DragViewOne";
    private int lastX;
    private int lastY;

    public DragViewTwo(Context context) {
        super(context);
        initView();
    }

    public DragViewTwo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DragViewTwo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {//长时间按住不移动也会触发该方法
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE://长时间按住不移动也会触发该方法
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                LinearLayout.LayoutParams mLayoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                mLayoutParams.leftMargin = getLeft() + offsetX;
                mLayoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(mLayoutParams);
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG + "ACTION_UP", "onTouchEvent: " + " l:" + getLeft() + " t: " + getTop() + " r:" + getRight() + " b:" + getBottom());
                break;
        }
        return true;//true 代表处理事件
    }
}
