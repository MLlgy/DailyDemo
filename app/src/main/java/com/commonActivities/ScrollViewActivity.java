package com.commonActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidwebviewdemo.mddemo.R;
import com.widget.MoveWidgetView;

public class ScrollViewActivity extends AppCompatActivity {

    private TextView mTextView;
    private MoveWidgetView mMoveWidgetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        mTextView = findViewById(R.id.tv_scroll_line);
        mMoveWidgetView = findViewById(R.id.mw_view);
        mMoveWidgetView.setIMoveSpec(new MoveWidgetView.IMoveSpec() {
            @Override
            public void way(int left, int top, int right, int bottom) {
                Log.e("124---", left + " " + top + " " + right + " " + bottom);
                mTextView.setTop(top);
                mTextView.setBottom(bottom);
//                ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(mTextView.getLayoutParams());
//                margin.setMargins(0, top, 0, 0);
//                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(margin);
//                mTextView.setLayoutParams(layoutParams);
            }
        });
    }
}
