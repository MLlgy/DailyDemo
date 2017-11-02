package com.utils;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.androidwebviewdemo.mddemo.R;

import java.util.ArrayList;

/**
 * Created by liguoying on 2017/8/16.
 */

public class RecordPathView extends View {
    private Context context;
    private Paint paint, iconPaint;
    private Path dstPath, totalPath;
    private PathMeasure mPathMeasure, mDstPathMeasure;

    private boolean isDrawRecordPath = false;

    private float pathLength;

    private Bitmap startIcon, endIcon, middleIcon;

    private float[] pathStartPoint = new float[2];
    private float[] pathEndPoint = new float[2];
    private float[] dstPathEndPoint = new float[2];

    private float value = 0;

    private long ANIM_DURATION;

    private ArrayList<RecordPathAnimUtil.RecordPathBean> recordPathList;

    private OnAnimEnd onAnimEnd;

    private int animIndex;

    public RecordPathView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public RecordPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public RecordPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.argb(0, 0, 0, 0));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);

        iconPaint = new Paint();
        iconPaint.setAntiAlias(true);

        dstPath = new Path();

        startIcon = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher/*R.drawable.outside_run_record_start_point*/);
        endIcon = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher/*R.drawable.outside_run_record_stop_point*/);
        middleIcon = BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher /*R.drawable.speed_view_point*/);
    }

    public void setPath(RecordPathAnimUtil recordPathAnimUtil) {
        if (recordPathAnimUtil == null)
            return;
        if (!isDrawRecordPath) {
            pathLength = recordPathAnimUtil.getAllPathLength();
            ANIM_DURATION = recordPathAnimUtil.getANIM_DURATION();
            recordPathList = recordPathAnimUtil.getRecordPathList();
            totalPath = recordPathAnimUtil.getTotalPath();
            mPathMeasure = new PathMeasure(totalPath, false);
            mPathMeasure.getPosTan(0, pathStartPoint, null);//轨迹的起点
            mPathMeasure.getPosTan(mPathMeasure.getLength(), pathEndPoint, null);//轨迹的终点
            if (recordPathList == null || recordPathList.size() == 0)
                return;
            startPathAnim();
            isDrawRecordPath = true;
        }
    }

    public void setOnAnimEnd(OnAnimEnd onAnimEnd) {
        this.onAnimEnd = onAnimEnd;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (recordPathList == null || recordPathList.size() == 0)
            return;
        if (animIndex > 0){
            for (int i = 0; i < animIndex; i++) {
                RecordPathAnimUtil.RecordPathBean recordPathBean = recordPathList.get(i);
                paint.setColor(recordPathBean.getEndColor());
                paint.setShader(recordPathBean.getShader());
                paint.setStrokeWidth(10);
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawPath(recordPathBean.getPath(), paint);
                paint.setShader(null);
                paint.setStrokeWidth(1);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                canvas.drawCircle(recordPathBean.getEndPoint().x, recordPathBean.getEndPoint().y, 5, paint);
            }
        }

        paint.setStyle(Paint.Style.STROKE);
        paint.setShader(recordPathList.get(animIndex).getShader());
        paint.setStrokeWidth(10);
        canvas.drawPath(dstPath, paint);
        canvas.drawBitmap(startIcon, pathStartPoint[0] - startIcon.getWidth() / 2, pathStartPoint[1] - startIcon.getHeight() / 2, iconPaint);
        if (value >= 1) {
            canvas.drawBitmap(endIcon, pathEndPoint[0] - endIcon.getWidth() / 2, pathEndPoint[1] - endIcon.getHeight() / 2, iconPaint);
        } else {
            canvas.drawBitmap(middleIcon, dstPathEndPoint[0] - middleIcon.getWidth() / 2, dstPathEndPoint[1] - middleIcon.getHeight() / 2, iconPaint);
        }
    }

    private void caculateAnimPathData(){
        float length = value * pathLength;
        float caculateLength = 0;
        float offsetLength = 0;
        for (int i = 0,count = recordPathList.size();i < count;i++){
            caculateLength += recordPathList.get(i).getPathLength();
            if (caculateLength > length){
                animIndex = i;
                offsetLength = caculateLength - length;
                break;
            }
        }
        dstPath.reset();
        PathMeasure pathMeasure = new PathMeasure(recordPathList.get(animIndex).getPath(),false);
        pathMeasure.getSegment(0, recordPathList.get(animIndex).getPathLength() - offsetLength, dstPath, true);
        mDstPathMeasure = new PathMeasure(dstPath, false);
        mDstPathMeasure.getPosTan(mDstPathMeasure.getLength(), dstPathEndPoint, null);
    }

    private void startPathAnim() {
        ValueAnimator animator = ValueAnimator.ofObject(new DstPathEvaluator(), 0, mPathMeasure.getLength());
        animator.setDuration(ANIM_DURATION);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                value = (float) animation.getAnimatedValue();
                caculateAnimPathData();
                invalidate();
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (onAnimEnd != null)
                    onAnimEnd.animEndCallback();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
    }

    class DstPathEvaluator implements TypeEvaluator {

        @Override
        public Object evaluate(float fraction, Object startValue, Object endValue) {
            return fraction;
        }
    }

    public interface OnAnimEnd {
        void animEndCallback();
    }

    float x, y;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_CANCEL:
                if (Math.abs(event.getX() - x) > 0 || Math.abs(event.getY() - y) > 0) {
                    if (onAnimEnd != null)
                        onAnimEnd.animEndCallback();
                }
                break;
            default:
                break;
        }
        return true;
    }
}
