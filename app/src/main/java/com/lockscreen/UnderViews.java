package com.lockscreen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import static android.animation.ObjectAnimator.ofFloat;

/**
 * @author liguoying
 * @date 2017/11/6.
 */

public class UnderViews extends View {
    public UnderViews(Context context) {
        super(context);
    }

    public UnderViews(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public UnderViews(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private static final String TAG = "LockUnderView";
    private float mStartX;
    private LockMoveView mMoveView;
    private int mWidth = 1080;
    private Handler mainHandler = new Handler();


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        final float nx = event.getX();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mStartX = nx;
                onAnimationEnd();
            case MotionEvent.ACTION_MOVE:
                handleMoveView(nx);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                doTriggerEvent(nx);
                break;
        }
        return true;

    }

    private void doTriggerEvent(float nx) {
        float movex = nx - mStartX;
        if (movex > (mWidth * 0.4)) {
            moveMoveView(mWidth - mMoveView.getLeft(), true);//自动移动到屏幕右边界之外，并finish掉
        } else {
            moveMoveView(-mMoveView.getLeft(), false);//自动移动回初始位置，重新覆盖
        }
    }

    private void handleMoveView(float nx) {
        float movex = nx - mStartX;
        if (movex < 0) {
            movex = 0;
        }
        mMoveView.setTranslationX(movex);
        float mWidthFloat = (float) 1080;//屏幕显示宽度
        if (getBackground() != null) {
            getBackground().setAlpha((int) ((mWidthFloat - mMoveView.getTranslationX()) / mWidthFloat * 200));//初始透明度的值为200
        }
    }

    private void moveMoveView(float to, boolean exit) {
        ObjectAnimator animator = ofFloat(mMoveView, "translationX", to);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if (getBackground() != null) {
                    getBackground().setAlpha((int) (((float) mWidth - mMoveView.getTranslationX()) / (float) mWidth * 200));
                }
            }
        });
        //随移动动画更新背景透明度
        animator.setDuration(250).start();

        if (exit) {
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mainHandler.obtainMessage(LockscreenActivity.MSG_LAUNCH_HOME).sendToTarget();
                    super.onAnimationEnd(animation);
                }
            });
        }
        //监听动画结束，利用Handler通知Activity退出
    }

    public void setHandler(Handler handler){
        mainHandler = handler;
    }

    public void setMoveView(LockMoveView lockMoveView) {
        Log.d(TAG,"lockMoveView : " + lockMoveView);
        mMoveView = lockMoveView;
    }
}