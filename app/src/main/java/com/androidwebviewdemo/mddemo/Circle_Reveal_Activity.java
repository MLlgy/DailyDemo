package com.androidwebviewdemo.mddemo;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;

public class Circle_Reveal_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle__reveal_);
        final View recf = this.findViewById(R.id.recf);
        final View oval = this.findViewById(R.id.oval);

        recf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Animator animator = ViewAnimationUtils.createCircularReveal(
                        recf,
                        recf.getWidth() / 2,
                        recf.getHeight() / 2,
                        recf.getWidth(),
                        0);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.setDuration(2000 );
                animator.start();
            }
        });


        oval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator animator = ViewAnimationUtils.createCircularReveal(
                        oval,
                        0,
                        0,
                        0,
                        (float)Math.hypot(oval.getWidth(),oval.getHeight()));
                animator.setInterpolator(new AccelerateInterpolator());
                animator.setDuration(2000);
                animator.start();
            }
        });
    }
}
