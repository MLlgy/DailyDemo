package com.CommonActivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.androidwebviewdemo.mddemo.R;
import com.bumptech.glide.Glide;

public class HeaderZoomActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_zoom);
        ImageView iv = (ImageView) findViewById(R.id.iv);
        Glide.with(this).load("http://seopic.699pic.com/photo/50008/2836.jpg_wh1200.jpg").into(iv);
    }
}
