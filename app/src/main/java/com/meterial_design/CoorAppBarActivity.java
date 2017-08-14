package com.meterial_design;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.R;

import java.util.ArrayList;
import java.util.List;

public class CoorAppBarActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private CommonRecyclerAdapter<String> mAdapter;
    private List<String> mStringList;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coor_app_bar);
        initView();
        initVariable();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mToolBar.setLogo(getResources().getDrawable(R.mipmap.ic_launcher));
        mToolBar.setTitle("这是标题");
        mToolBar.inflateMenu(R.menu.menu);

    }

    private void initVariable() {
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
}
