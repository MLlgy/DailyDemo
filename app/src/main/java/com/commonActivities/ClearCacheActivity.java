package com.commonActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidwebviewdemo.mddemo.R;
import com.utils.DataCleanManager;
import com.widget.DialogView;

public class ClearCacheActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_cache_size;
    private Button btn_clear_cache;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear_cache);
        initView();
        initSizeData();
    }

    private void initSizeData() {
        try {
            tv_cache_size.setText(DataCleanManager.getTotalCacheSize(ClearCacheActivity.this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        tv_cache_size = (TextView) findViewById(R.id.tv_cache_size);
        btn_clear_cache = (Button) findViewById(R.id.btn_clear_cache);
        btn_clear_cache.setOnClickListener(this);
        new DialogView(this).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_clear_cache:
                DataCleanManager.clearAllCache(ClearCacheActivity.this);
                DataCleanManager.cleanDatabases(ClearCacheActivity.this);
                initSizeData();
                break;
        }
    }
}
