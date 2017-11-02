package com.androidwebviewdemo.mddemo;

import android.animation.AnimatorInflater;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidwebviewdemo.mddemo.R;

public class Change_Animation_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change__animation_);
        AnimatorInflater.loadStateListAnimator(this, R.drawable.statelistanimaiton);
    }
}
