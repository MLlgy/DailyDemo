package com.androidwebviewdemo.mddemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.R;

public class SecondActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void explode(View view) {
        intent = new Intent(this, TransitionsActivity.class);
        intent.putExtra("flag", 0);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void slide(View view) {
        intent = new Intent(this, TransitionsActivity.class);
        intent.putExtra("flag", 1);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void fade(View view) {
        intent = new Intent(this, TransitionsActivity.class);
        intent.putExtra("flag", 2);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void share(View view) {
        View fab = findViewById(R.id.fab_button);
        Button button = findViewById(R.id.fab_button);
        intent = new Intent(this, TransitionsActivity.class);
        intent.putExtra("flag", 3);
//        startActivity(intent);/**
        /**
         * this: context
         * view: 共享元素的起始控件
         * string" 共享元素的标示
         */
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, button, "fab").toBundle());
//        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, button, "share").toBundle());
//        startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this, Pair.create(view,"share"),Pair.create(view,"fab")).toBundle());
    }

}
