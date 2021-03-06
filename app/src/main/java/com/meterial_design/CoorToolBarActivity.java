package com.meterial_design;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.R;
import com.utils.TranslateTitlebarUtils;

import java.util.ArrayList;
import java.util.List;

public class CoorToolBarActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private CommonRecyclerAdapter<String> mAdapter;
    private List<String> mStringList;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coor_tool_bar);
        TranslateTitlebarUtils.translucentStatusBar(this,false);
        initViews();
        initToolBar(mToolbar, false, "");
        initVariables();
    }

    private void initVariables() {
        mStringList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mStringList.add("测试：" + i);
        }
        mAdapter = new CommonRecyclerAdapter<String>(this, mStringList, R.layout.layout_item) {
            @Override
            public void convert(CommonRecyclerHolder holder, String item, int position, boolean isScrolling) {
                holder.setText(R.id.item_text, mStringList.get(position));
            }
        };
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    /**
     * 初始化 Toolbar
     */
    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }
}
