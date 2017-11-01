package com.CommonActivities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.R;

public class FontActivity extends BaseActivity {

    private Typeface mTypeface;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font);
        initData();
    }

    private void initData() {
        mTextView = findViewById(R.id.tv_font_showcase);
        mTypeface = Typeface.createFromAsset(getAssets(), "fonts/qiaoqiao.ttf");
        mTextView.setTypeface(mTypeface);
    }
}
