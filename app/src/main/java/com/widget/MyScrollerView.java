package com.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

import com.lidroid.xutils.util.LogUtils;

/**
 * Created by liguoying on 2017/9/25.
 * 实现的功能： 只有在手指滑动时，Scrollerview 才会拦截事件 ，在惯性的滑动时滑动事件交给了子控件(此例子中的 Recyclerview)
 */

public class MyScrollerView extends ScrollView {
    private int downX;
    private int downY;
    private int mTouchSlop;

    public MyScrollerView(Context context) {
        super(context);
        init(context);
    }

    public MyScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyScrollerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        int action = e.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) e.getRawX();
                downY = (int) e.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) e.getRawY();
                if (Math.abs(moveY - downY) > mTouchSlop) {
                    LogUtils.e("true");
                    return true;
                }
        }
        LogUtils.e(super.onInterceptTouchEvent(e) + "");
        return super.onInterceptTouchEvent(e);//默认返回 false
    }
}
