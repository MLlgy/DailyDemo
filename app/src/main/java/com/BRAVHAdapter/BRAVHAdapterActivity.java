package com.BRAVHAdapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.numberRunner.NumberRunnerMainActivity;
import com.takePhotoWithPerssion.TakePhotoWithPerssionActivity;
import com.takePhotoWithPerssion.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class BRAVHAdapterActivity extends AppCompatActivity implements View.OnClickListener {
    @ViewInject(R.id.recy_bravh_adapter)
    private RecyclerView mRecyclerView;
    private List<DataEntity> mList = new ArrayList<>();
    private static final Class<?>[] ACTIVITY = {TakePhotoWithPerssionActivity.class, NumberRunnerMainActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bravhadapter);
        ViewUtils.inject(this);
        initData();
        initRecyclerview();
        initAadpter();
    }

    private void initAadpter() {
        BaseQuickAdapter homeAdapter = new BRAVHAdapter(R.layout.item_bravh_adapter_view, mList);
        homeAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);//设置 item 加载动画
        View top = getLayoutInflater().inflate(R.layout.top_view, (ViewGroup) mRecyclerView.getParent(), false);
        homeAdapter.addHeaderView(top);
        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.show(BRAVHAdapterActivity.this, "item" + position, Toast.LENGTH_LONG);
            }
        });
        homeAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                adapter.notifyItemRemoved(position);
                return false;
            }
        });
        mRecyclerView.setAdapter(homeAdapter);
    }

    private void initRecyclerview() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            DataEntity dataEntity = new DataEntity();
            dataEntity.setName("item:" + i);
            mList.add(dataEntity);
        }
    }

    @OnClick({R.id.recy_bravh_adapter})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.recy_bravh_adapter:

        }
    }
}
