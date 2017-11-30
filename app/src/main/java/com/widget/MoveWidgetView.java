package com.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.DemoApplication;
import com.utils.DisplayUtil;

/**
 * @author liguoying
 * @date 2017/11/30.
 */

public class MoveWidgetView extends LinearLayout {

    private int mStartX;
    private int mStartY;
    private int mParentWidth;
    private int mParentHeight;
    private int mWidth;
    private int mHight;
    private IMoveSpec mIMoveSpec;

    public MoveWidgetView(Context context) {
        this(context, null);
    }

    public MoveWidgetView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MoveWidgetView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //测量控件的宽高
//        mWidth = getWidth();
//        mHight = getHeight();
        this.post(new Runnable() {
            @Override
            public void run() {
                mWidth = getWidth();
                mHight = getHeight();
                Log.e("124--0", getWidth() + " " + getHeight());

            }
        });
        //测量父类的宽高
        ViewGroup group = (ViewGroup) getParent();
//        mParentWidth = group.getWidth();
//        mParentHeight = group.getHeight();
        group.post(new Runnable() {
            @Override
            public void run() {

                mParentWidth = group.getWidth();
                mParentHeight = group.getHeight();
                Log.e("124--0", group.getWidth() + " " + group.getHeight());

            }
        });
        Log.e("124-0", mWidth + " " + mHight + " " + mParentWidth + " " + mParentHeight);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int moveX = (int) event.getX();
        int moveY = (int) event.getY();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mStartX = moveX;
                mStartX = moveY;

                Log.e("124", mStartX + "  " + mStartX);

                break;
            case MotionEvent.ACTION_MOVE:
                //每次滑动的 距离
                int xdiff = moveX - mStartX;
                int ydiff = moveY - mStartY;
                int vLeft = getLeft() + xdiff;
                Log.e("124-1", xdiff + "  " + ydiff + " " + vLeft);
                int vRight = 0;
                if (vLeft <= 0) {
                    vLeft = 0;
                    vRight = vLeft + mWidth;
                } else {
                    vRight = getRight() + xdiff;
                }
                int vTop = getTop() + ydiff;
                Log.e("124-1", vTop + " ");
                int vBotton = 0;
                if (vTop <= 0) {
                    vTop = 0;
                    vBotton = vTop + mHight;
                } else {
                    vBotton = getBottom() + ydiff;
                }
                if (vRight > mParentWidth) {
                    vRight = mParentWidth;
                    vLeft = mParentWidth - mWidth;
                }
                if (vBotton > mParentHeight) {
                    vBotton = mParentHeight;
                    vTop = mParentHeight - mHight;
                }
                Log.e("124", vLeft + " " + vTop + " " + vRight + " " + vBotton);
                mIMoveSpec.way(vLeft, vTop + ((mHight - DisplayUtil.dp2px(DemoApplication.getInstance(), 1)) / 2), vRight,
                        vBotton - ((mHight - DisplayUtil.dp2px(DemoApplication.getInstance(), 1)) / 2));
                layout(vLeft, vTop, vRight, vBotton);
                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
                break;

        }
        return true;
    }


    public interface IMoveSpec {
        void way(int left, int top, int right, int bottom);
    }

    public void setIMoveSpec(IMoveSpec IMoveSpec) {
        mIMoveSpec = IMoveSpec;
    }
}
