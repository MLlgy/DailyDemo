package com.CommonActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.R;
import com.adapter.EditMenuAdapter;
import com.adapter.MyEditMenuAdapter;
import com.entity.DayEntity;
import com.google.gson.Gson;
import com.lidroid.xutils.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class EditMenuActivity extends AppCompatActivity {
    private String content = "{\"code\" : ok ,\"content\" : [{\"name\":\"今天\",\"date\":[{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\" 中间 \",\"image\":\"haha\"},{\"title\":\" 中间 \",\"image\":\"haha\"}]},{\"name\":\"明天\",\"date\":[{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"}]},{\"name\":\"明天\",\"date\":[{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"}]},{\"name\":\"明天\",\"date\":[{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"}]},{\"name\":\"明天\",\"date\":[{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"}]},{\"name\":\"明天\",\"date\":[{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"}]},{\"name\":\"明天\",\"date\":[{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"}]},{\"name\":\"明天\",\"date\":[{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"}]}]\n" +
            "     }";

    private LinearLayout mLinearLayout;
    private DayEntity mDayEntity;
    private int mMllinearWitdh;
    private int perWidth;
    private ImageView mImageView;
    private RecyclerView mRecyclerView;
    private EditMenuAdapter mEditMenuAdapter;
    private RelativeLayout mEditemuTitleBar;
    private TextView editMenu;
    private TextView mEditCancle;
    private TextView mEditOk;
    private RecyclerView mMyApplicationRecyclerView;
    private LinearLayout mMyApplicationShow;
    private List<DayEntity.ContentBean.DateBean> temMenu = new ArrayList();
    private List<DayEntity.ContentBean.DateBean> lastMenu = new ArrayList();
    private MyEditMenuAdapter mMyEditMenuAdapter;
    private boolean editAble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_menu);
        mDayEntity = new Gson().fromJson(content, DayEntity.class);
        initView();
        getLinearlayoutWidth();
        initData();
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            lastMenu.add(mDayEntity.getContent().get(0).getDate().get(i));
        }

        mEditMenuAdapter = new EditMenuAdapter(mDayEntity.getContent(), this, editAble);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mEditMenuAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        mMyEditMenuAdapter = new MyEditMenuAdapter(this, lastMenu);
        mMyApplicationRecyclerView.setLayoutManager(gridLayoutManager);
        mMyApplicationRecyclerView.setAdapter(mMyEditMenuAdapter);
        mMyEditMenuAdapter.setSecondItemClick(new MyEditMenuAdapter.IMyApplicationItemClick() {
            @Override
            public void secondItemClick(int position) {
                findSameItem(lastMenu.get(position));
                lastMenu.remove(position);
                mMyApplicationRecyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        mEditMenuAdapter.setIItemFirstItemClick(new EditMenuAdapter.IItemFirstItemClick() {
            @Override
            public void setIItemFirstItemClick(int secondPosition, int firstPosition) {
                lastMenu.add(mDayEntity.getContent().get(firstPosition).getDate().get(secondPosition));
                mMyApplicationRecyclerView.getAdapter().notifyDataSetChanged();
                Toast.makeText(EditMenuActivity.this, firstPosition + "  二  " + secondPosition, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void findSameItem(DayEntity.ContentBean.DateBean dateBean) {
        LogUtils.e(mDayEntity.toString());
        String key = dateBean.getImage();
        int size = mDayEntity.getContent().size();
        for (int i = 0; i < size; i++) {
            DayEntity.ContentBean mContentBean = mDayEntity.getContent().get(i);
            int mSize = mContentBean.getDate().size();
            for (int j = 0; j < mSize; j++) {
                DayEntity.ContentBean.DateBean mDataBean = mContentBean.getDate().get(j);
                if (key.equals(mDataBean.getImage())) {
                    mDataBean.setImage("3532");
                }
            }

        }
        LogUtils.e(mDayEntity.toString());
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initTitleMenu() {
        List<DayEntity.ContentBean.DateBean> dateBean = mDayEntity.getContent().get(0).getDate();
        int size = dateBean.size();
        for (int i = 0; i < size; i++) {
            mImageView = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(perWidth, LinearLayout.LayoutParams.WRAP_CONTENT);
            mImageView.setLayoutParams(params);
            if (i == 6) {
                mImageView.setImageResource(R.mipmap.icon_more_menu);
                mLinearLayout.addView(mImageView);
                mImageView = null;
                return;
            }
            mImageView.setImageResource(R.mipmap.icon_tem);
            mLinearLayout.addView(mImageView);
            mImageView = null;
        }
    }

    private void getLinearlayoutWidth() {
        mLinearLayout.post(new Runnable() {
            @Override
            public void run() {
                mMllinearWitdh = mLinearLayout.getMeasuredWidth();
                perWidth = mMllinearWitdh / 7;
                initTitleMenu();
            }
        });
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv_edit_menu);
        mLinearLayout = findViewById(R.id.ll_use_application);
        mEditemuTitleBar = findViewById(R.id.rl_edit_menu_titlebar);
        editMenu = findViewById(R.id.tv_edit_application);
        mEditCancle = findViewById(R.id.tv_edit_ok);
        mEditOk = findViewById(R.id.tv_edit_cancle);
        mMyApplicationShow = findViewById(R.id.ll_my_application_show);
        mMyApplicationRecyclerView = findViewById(R.id.rl_my_application_menu);
        editMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editAble = true;
                mEditMenuAdapter.setEditAble(editAble);
                mRecyclerView.getAdapter().notifyDataSetChanged();
                mEditemuTitleBar.setVisibility(View.GONE);
                mMyApplicationShow.setVisibility(View.VISIBLE);
            }
        });

        mEditOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editAble = false;
                mEditMenuAdapter.setEditAble(editAble);
                mRecyclerView.getAdapter().notifyDataSetChanged();
                mEditemuTitleBar.setVisibility(View.VISIBLE);
                mMyApplicationShow.setVisibility(View.GONE);
            }
        });
        mEditCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editAble = false;
                mEditMenuAdapter.setEditAble(editAble);
                mRecyclerView.getAdapter().notifyDataSetChanged();
                mEditemuTitleBar.setVisibility(View.VISIBLE);
                mMyApplicationShow.setVisibility(View.GONE);
            }
        });
    }
}
