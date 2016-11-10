package com.androidwebviewdemo.mddemo;

import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;

public class ClipingActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliping);
        TextView view1 = (TextView)findViewById(R.id.tv_rect);
        TextView view2 = (TextView)findViewById(R.id.tv_circle);
        final Rect rectF = new Rect(0,0,100,100);
//        获取Outline
        ViewOutlineProvider viewOutlineProvider1 =new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0,0,view.getWidth(),view.getHeight(),30);
            }
        };

        ViewOutlineProvider viewOutlineProvider2 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setOval(0,0,view.getWidth(),view.getHeight());
            }
        };
        ViewOutlineProvider viewOutlineProvider3 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRect(rectF);
            }
        };
        view1.setOutlineProvider(viewOutlineProvider1);
        view2.setOutlineProvider(viewOutlineProvider3);
    }
}
