package com.commonActivities;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidwebviewdemo.mddemo.R;
import com.utils.UIUtils;
import com.widget.CircleMenu;

public class ClickBtnActivity extends BaseActivity implements View.OnClickListener {
    private CircleMenu circleMenu;
    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
    private boolean isShow = true;

    private Button start;
    private Button pause;
    private Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_btn);
        UIUtils.initDip2px(this);
        isShow = true;
        initView();
        findView();
        initContent();
        addListener();
    }

    private void initView() {
        start = findViewById(R.id.btn_start);
        pause = findViewById(R.id.btn_pause);
        stop = findViewById(R.id.btn_stop);
        start.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
        imageView1 = (ImageView) findViewById(R.id.imageview1);
        imageView2 = (ImageView) findViewById(R.id.imageview2);
        imageView3 = (ImageView) findViewById(R.id.imageview3);
        imageView4 = (ImageView) findViewById(R.id.imageview4);
        imageView5 = (ImageView) findViewById(R.id.imageview5);

        imageView3.setOnClickListener(listener);
    }

    /*
     * 查找布局组件
     */
    private void findView() {
        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
    }

    /*
     * 初始化布局内容
     */
    private void initContent() {
    }

    /*
     * 为布局组件添加监听器
     */
    private void addListener() {
        circleMenu.setOnCircleItemSelectedListener(new CircleMenu.OnCircleItemSelectedListener() {
            @Override
            public void onItemClickedListener(int index) {
                if (index == -2) {
                    circleMenu.closeOrOpen();
                }

            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("jambla", "kasdfjhasdhflasdhflkjahdsfa");
        return true;
    }


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            isShow = !isShow;
            if (isShow)
                showBottomLeftToRight();
            else
                showBottomRightToLeft();
        }
    };

    private void showBottomRightToLeft() {
        int widht = UIUtils.getScreenWidth() - UIUtils.dip2px(this, 60);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorTranslateX1 = ObjectAnimator.ofFloat(imageView1
                , "translationX", 0.0f, widht * 0.4f);
        animatorTranslateX1.setDuration(300);
        animatorTranslateX1.setRepeatCount(0);

        ObjectAnimator animatorAlpha1 = ObjectAnimator.ofFloat(imageView1
                , "alpha", 1.0f, 0.2f);
        animatorAlpha1.setDuration(300);
        animatorAlpha1.setRepeatCount(0);

        ObjectAnimator animatorTranslateX2 = ObjectAnimator.ofFloat(imageView2
                , "translationX", 0.0f, widht * 0.2f);
        animatorTranslateX2.setDuration(300);
        animatorTranslateX2.setRepeatCount(0);

        ObjectAnimator animatorAlpha2 = ObjectAnimator.ofFloat(imageView2
                , "alpha", 1.0f, 0.2f);
        animatorAlpha2.setDuration(300);
        animatorAlpha2.setRepeatCount(0);

        animatorTranslateX2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (isShow) {
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
                } else {
                    imageView1.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        ObjectAnimator animatorTranslateX3 = ObjectAnimator.ofFloat(imageView3
                , "translationX", 0.0f, -widht * 0.4f);
        animatorTranslateX3.setDuration(500);
        animatorTranslateX3.setRepeatCount(0);


        ObjectAnimator animatorTranslateX4 = ObjectAnimator.ofFloat(imageView4
                , "translationX", 0.0f, -widht * 0.2667f);
        animatorTranslateX4.setDuration(500);
        animatorTranslateX4.setRepeatCount(0);

        ObjectAnimator animatorTranslateX5 = ObjectAnimator.ofFloat(imageView5
                , "translationX", 0.0f, -widht * 0.1333f);
        animatorTranslateX5.setDuration(500);
        animatorTranslateX5.setRepeatCount(0);

        animatorSet.play(animatorTranslateX1).with(animatorTranslateX2).with(animatorAlpha1)
                .with(animatorAlpha2)
                .before(animatorTranslateX3)
                .before(animatorTranslateX4).before(animatorTranslateX5);
        animatorSet.start();
    }

    private void showBottomLeftToRight() {
        int widht = UIUtils.getScreenWidth() - UIUtils.dip2px(this, 60);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorTranslateX1 = ObjectAnimator.ofFloat(imageView1
                , "translationX", widht * 0.4f, 0.0f);
        animatorTranslateX1.setDuration(300);
        animatorTranslateX1.setRepeatCount(0);
        ObjectAnimator animatorAlpha1 = ObjectAnimator.ofFloat(imageView1
                , "alpha", 0.2f, 1.0f);
        animatorAlpha1.setDuration(300);
        animatorAlpha1.setRepeatCount(0);

        ObjectAnimator animatorTranslateX2 = ObjectAnimator.ofFloat(imageView2
                , "translationX", widht * 0.2f, 0.0f);
        animatorTranslateX2.setDuration(300);
        animatorTranslateX2.setRepeatCount(0);
        ObjectAnimator animatorAlpha2 = ObjectAnimator.ofFloat(imageView2
                , "alpha", 0.2f, 1.0f);
        animatorAlpha1.setDuration(300);
        animatorAlpha1.setRepeatCount(0);


        ObjectAnimator animatorTranslateX3 = ObjectAnimator.ofFloat(imageView3
                , "translationX", -widht * 0.4f, 0.0f);
        animatorTranslateX3.setDuration(500);
        animatorTranslateX3.setRepeatCount(0);


        ObjectAnimator animatorTranslateX4 = ObjectAnimator.ofFloat(imageView4
                , "translationX", -widht * 0.2667f, 0.0f);
        animatorTranslateX4.setDuration(500);
        animatorTranslateX4.setRepeatCount(0);

        ObjectAnimator animatorTranslateX5 = ObjectAnimator.ofFloat(imageView5
                , "translationX", -widht * 0.1333f, 0.0f);
        animatorTranslateX5.setDuration(500);
        animatorTranslateX5.setRepeatCount(0);

        animatorTranslateX5.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (isShow) {
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
                } else {
                    imageView1.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        animatorSet.play(animatorTranslateX3).with(animatorTranslateX4).with(animatorTranslateX5)
                .with(animatorAlpha1).with(animatorAlpha2)
                .before(animatorTranslateX1).before(animatorTranslateX2);
        animatorSet.start();
    }

    /**
     * 此处的属性动画的变化值的基点为 view的原本的位置， 即：移动后再次属性动画的基点还是原来view的位置，
     * 所以有点击start时的 0 -> ObjectAnimator mObjectAnimatorA = ObjectAnimator.ofFloat(start, "translationX", 0);

     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                ObjectAnimator mObjectAnimatorA = ObjectAnimator.ofFloat(start, "translationX", 0);
                mObjectAnimatorA.setDuration(500);
                ObjectAnimator mObjectAnimatorB = ObjectAnimator.ofFloat(stop, "translationX", 0);
                mObjectAnimatorB.setDuration(500);
                ObjectAnimator mObjectAnimatorC = ObjectAnimator.ofFloat(pause, "alpha", 0f, 1f);
                mObjectAnimatorC.setDuration(500);
                mObjectAnimatorA.start();
                mObjectAnimatorB.start();
                mObjectAnimatorC.start();

                break;
            case R.id.btn_stop:

                Toast.makeText(ClickBtnActivity.this, "stop", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_pause:

                break;
        }
    }
}
