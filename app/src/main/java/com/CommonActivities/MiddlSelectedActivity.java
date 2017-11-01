package com.CommonActivities;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.R;
import com.widget.MiddleHorizal;

import java.util.ArrayList;

public class MiddlSelectedActivity extends BaseActivity implements MiddleHorizal.onMiddleItemChangedListener {
    LinearLayout contentLinear;
    MiddleHorizal horizontalScrollView;
    private ArrayList<String> items = new ArrayList<>();
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middl_selected);
        contentLinear = findViewById(R.id.content);
        textView = findViewById(R.id.currentItem);
        horizontalScrollView = findViewById(R.id.horizontalScrollView);
        horizontalScrollView.setMiddleItemChangedListener(this);
        contentLinear.removeAllViews();
        for (int i = 0; i < 50; i++) {
            TextView child = new TextView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(80, ViewGroup.LayoutParams.MATCH_PARENT);
            params.gravity = Gravity.CENTER;
            child.setTextSize(20);
            child.setTextColor(Color.RED);
            child.setGravity(Gravity.CENTER);
            child.setText("" + i);
            items.add("" + i);
            child.setTag(i);//将postion设为tag，设置位置
            child.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    horizontalScrollView.setMiddleItem(v);
                }
            });
            contentLinear.addView(child, params);
        }
    }


    @Override
    public void middleItemChanged(int current) {
        TextView currentTxt = (TextView) contentLinear.getChildAt(current);
        currentTxt.setTextSize(24);
        currentTxt.setTextColor(Color.GREEN);
        String s = items.get(current);
        textView.setText("位于中间位置的是" + s);
    }
}
