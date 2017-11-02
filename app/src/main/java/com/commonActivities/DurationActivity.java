package com.commonActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidwebviewdemo.mddemo.R;

public class DurationActivity extends BaseActivity implements View.OnClickListener {

    private TextView mTextView;
    private Button mStart, mStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duration);
        initView();
    }

    private void initView() {
        mTextView = findViewById(R.id.tv_time);
        mStart = findViewById(R.id.btn_start_time);
        mStop = findViewById(R.id.btn_stop_time);
        mStart.setOnClickListener(this);
        mStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_time:



                break;
            case R.id.btn_stop_time:

                break;
        }
    }
}
