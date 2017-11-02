package com.tracedraw;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidwebviewdemo.mddemo.R;
import com.utils.RecordPathAnimUtil;

public class TraceDrawActivity extends AppCompatActivity {
    RecordPathAnimUtil mRecordPathAnimUtil = new RecordPathAnimUtil();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trace_draw);
        for (int i = 0; i < 100; i++) {
            Point startPoint = new Point(1*i,2*i);
            Point endPoit = new Point(2*i,3*i);
            mRecordPathAnimUtil.addPath(startPoint,endPoit,R.color.trans_black0,R.color.tomato);
        }
    }
}
