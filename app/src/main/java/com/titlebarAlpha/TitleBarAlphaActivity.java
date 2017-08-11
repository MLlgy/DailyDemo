package com.titlebarAlpha;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.R;

public class TitleBarAlphaActivity extends AppCompatActivity implements ScrollViewListener {


    private static final String TAG = "vivi";
    private ObservableScrollView mScrollView;
    private ImageView mIvTitleBg;
    private RelativeLayout mRlTitleContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//取消 TitleBar 进行自定义
        setContentView(R.layout.activity_title_bar_alpha);
        initView();
        initListener();
    }


    private void initView() {

        mScrollView = (ObservableScrollView) findViewById(R.id.scrollView);
        mIvTitleBg = (ImageView) findViewById(R.id.ivTitleBg);
        mRlTitleContainer = (RelativeLayout) findViewById(R.id.rlTitleContainer);
    }


    private void initListener() {
        mScrollView.setScrollViewListener(this);
    }

    @Override
    public void onScrollChanged(ObservableScrollView observableScrollView, int x, int y, int oldx, int oldy) {

        Log.d(TAG, "onScrollChanged: " + x
                + "    " + y
                + "     " + oldx
                + "       " + oldy);

        if (y <= 0) {
            mRlTitleContainer.setBackgroundColor(Color.argb((int) 0, 255, 119, 8));//AGB由相关工具获得，或者美工提供
        } else if (y > 0 && y <= mIvTitleBg.getHeight() - mRlTitleContainer.getHeight()) {
            float scale = (float) y / (mIvTitleBg.getHeight() - mRlTitleContainer.getHeight());
            float alpha = (255 * scale);
            // title背景透明
            mRlTitleContainer.setBackgroundColor(Color.argb((int) alpha, 0, 119, 8));
        } else {
            mRlTitleContainer.setBackgroundColor(Color.argb((int) 255, 0, 119, 8));
        }
    }
}
