package com.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by mk.io on 17-8-26.
 */

public class DragViewFour extends View {
    private static final String TAG = "DragViewFour";
    private Scroller mScroller;
    private int lastX;
    private int lastY;

    public DragViewFour(Context context) {
        super(context);
        initView(context);
    }

    public DragViewFour(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DragViewFour(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        setBackgroundColor(Color.BLACK);
        mScroller = new Scroller(context);
    }

    /**
     * compute : 计算 推断
     */
    @Override
    public void computeScroll() {
        super.computeScroll();
//        computeScrollOffset() 判断Scroller是否执行完毕
        if (mScroller.computeScrollOffset()) {
            Log.e(TAG, mScroller.getCurrX() + " " + mScroller.getCurrY());
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                lastX = (int) event.getX();
                lastY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;

                break;
        }
        return true;
    }
}
