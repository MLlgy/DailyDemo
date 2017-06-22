package com.androidwebviewdemo.mddemo;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.R;

public class ZActivity extends AppCompatActivity {
    private TextView textView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z);
        textView = (TextView)findViewById(R.id.tv_no_elevation);
        textView.animate().translationZ(100f );
    }
}
