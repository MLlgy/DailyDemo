package com.CommonActivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

import com.R;
import com.widget.CircleMenu;

public class ClickBtnActivity extends AppCompatActivity {
    private CircleMenu circleMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_btn);
        findView();
        initContent();
        addListener();
    }

    /*
     * 查找布局组件
     */
    private void findView() {
        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
    }

    /*
     * 初始化布局内容
     */
    private void initContent() {
    }

    /*
     * 为布局组件添加监听器
     */
    private void addListener() {
        circleMenu.setOnCircleItemSelectedListener(new CircleMenu.OnCircleItemSelectedListener() {
            @Override
            public void onItemClickedListener(int index) {
                if (index == -2) {
                    circleMenu.closeOrOpen();
                }

            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("jambla", "kasdfjhasdhflasdhflkjahdsfa");
        return true;
    }
}
