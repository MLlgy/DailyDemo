package com.meterial_design;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.R;

/**
 * theme 设置
 * 清单文件中的activity 的theme 的优先级最低
 * 代码中的会覆盖 清单文件中的设置
 */

public class StatusBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
        //自己在代码中设置 statusbar 的颜色
        StatusBarCompat.compat(this, getResources().getColor(R.color.tomato));

        //自己在代码中设置 statusbar 的颜色
//        StatusBarCompat.compat(this, getResources().getColor(R.color.tomato));
//        StatusBarCompat.compat(this);
    }
}
