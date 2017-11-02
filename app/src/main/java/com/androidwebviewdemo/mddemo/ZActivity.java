package com.androidwebviewdemo.mddemo;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.androidwebviewdemo.mddemo.R;

public class ZActivity extends AppCompatActivity {
    private TextView textView;
    private TextView one, two, three;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z);
        initview();
        textView.animate().translationZ(100f);
    }

    private void initview() {
        textView = (TextView) findViewById(R.id.tv_no_elevation);
        one = findViewById(R.id.tv_one);
        two = findViewById(R.id.tv_one);
        three = findViewById(R.id.tv_three);
    }
}
