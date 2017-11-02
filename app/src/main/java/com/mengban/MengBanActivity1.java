package com.mengban;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.androidwebviewdemo.mddemo.R;

public class MengBanActivity1 extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mLinearLayout;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meng_ban);
        initView();
        setMask();//设置蒙版，一般在oncreat()里面设置
    }


    private void initView() {
        mLinearLayout = findViewById(R.id.linearLayout_mask);
        mImageView = findViewById(R.id.imageView_mask);
        mLinearLayout.setOnClickListener(this);
        mImageView.setOnClickListener(this);
    }

    private void setMask() {
        SharedPreferences sharedPreferences = this.getSharedPreferences(
                "Setting", Context.MODE_PRIVATE);
        boolean isread = sharedPreferences.getBoolean("read_share", false);
        if (!isread) {
            // 调整顶部背景图片的大小，适应不同分辨率的屏幕
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            int width = dm.widthPixels;
            int height = (int) ((float) width / 48 * 31);
            mImageView.setLayoutParams(new LinearLayout.LayoutParams(width, height));
            mLinearLayout.setVisibility(View.VISIBLE);
        } else {
            mLinearLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linearLayout_mask://分享蒙版监听,截取蒙板下方的点击事件
                break;

            case R.id.imageView_mask://分享蒙版上的按钮
                mLinearLayout.setVisibility(View.GONE);
                this.getSharedPreferences("Setting", Context.MODE_PRIVATE).edit().putBoolean("read_share", true).commit();
                break;

            default:
                break;
        }
    }
}
