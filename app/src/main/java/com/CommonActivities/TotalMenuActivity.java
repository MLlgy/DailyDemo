package com.CommonActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.R;
import com.adapter.EditMenuAdapter;
import com.adapter.MyEditMenuAdapter;
import com.entity.DayEntity;
import com.google.gson.Gson;
import com.widget.FullyLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class TotalMenuActivity extends BaseActivity {
    private String content2 = "{\n" +
            "    \"code\":\"ok\",\n" +
            "    \"content\":[\n" +
            "        {\n" +
            "            \"name\":\"今天\",\n" +
            "            \"date\":[\n" +
            "                {   \"id\":0,\n" +
            "                    \"status\":2,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {  \"id\":1,\n" +
            "                    \"status\":2,\n" +
            "                    \"title\":\" 中间 \",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {   \"id\":2,\n" +
            "                    \"status\":2,\n" +
            "                    \"title\":\" 中间 \",\n" +
            "                    \"image\":\"haha\"\n" +
            "                }\n" +
            "                ,\n" +
            "                {   \"id\":21,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\" 中间 \",\n" +
            "                    \"image\":\"haha\"\n" +
            "                }\n" +
            "                ,\n" +
            "                {   \"id\":22,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\" 中间 \",\n" +
            "                    \"image\":\"haha\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"明天\",\n" +
            "            \"date\":[\n" +
            "                {   \"id\":3,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {   \"id\":4,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {   \"id\":5,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"明天\",\n" +
            "            \"date\":[\n" +
            "                {   \"id\":6,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {   \"id\":0,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {    \"id\":7,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                }\n" +
            "                ,\n" +
            "                {   \"id\":23,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\" 中间 \",\n" +
            "                    \"image\":\"haha\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "        {\n" +
            "            \"name\":\"明天\",\n" +
            "            \"date\":[\n" +
            "                {   \"id\":8,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {   \"id\":9,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {    \"id\":11,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {   \"id\":24,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\" 中间 \",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {   \"id\":25,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\" 中间 \",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {   \"id\":26,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\" 中间 \",\n" +
            "                    \"image\":\"haha\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"明天\",\n" +
            "            \"date\":[\n" +
            "                {   \"id\":12,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {   \"id\":13,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {    \"id\":14,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\":\"明天\",\n" +
            "            \"date\":[\n" +
            "                {   \"id\":15,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {   \"id\":16,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {    \"id\":17,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },{\"name\":\"今天\",\"date\":[{\"id\":0,\"status\":1,\"title\":\"中间\",\"image\":\"haha\"},{\"id\":1,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"},{\"id\":2,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"},{\"id\":21,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"},{\"id\":22,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"}]},{\"name\":\"今天\",\"date\":[{\"id\":0,\"status\":1,\"title\":\"中间\",\"image\":\"haha\"},{\"id\":1,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"},{\"id\":2,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"},{\"id\":21,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"},{\"id\":22,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"}]},{\"name\":\"今天\",\"date\":[{\"id\":0,\"status\":1,\"title\":\"中间\",\"image\":\"haha\"},{\"id\":1,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"},{\"id\":2,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"},{\"id\":21,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"},{\"id\":22,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"}]},{\"name\":\"今天\",\"date\":[{\"id\":0,\"status\":1,\"title\":\"中间\",\"image\":\"haha\"},{\"id\":1,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"},{\"id\":2,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"},{\"id\":21,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"},{\"id\":22,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"}]},{\"name\":\"今天\",\"date\":[{\"id\":0,\"status\":1,\"title\":\"中间\",\"image\":\"haha\"},{\"id\":1,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"},{\"id\":2,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"},{\"id\":21,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"},{\"id\":22,\"status\":1,\"title\":\" 中间 \",\"image\":\"haha\"}]},        " +
            "" +
            "" +
            "\n" +
            "        {\n" +
            "            \"name\":\"明天\",\n" +
            "            \"date\":[\n" +
            "                {   \"id\":18,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {   \"id\":19,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                },\n" +
            "                {    \"id\":20,\n" +
            "                    \"status\":1,\n" +
            "                    \"title\":\"中间\",\n" +
            "                    \"image\":\"haha\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}\n" +
            "\n";

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
        setContentView(R.layout.activity_total_menu);
        mDayEntity = new Gson().fromJson(content2, DayEntity.class);
        initView();
        getLinearlayoutWidth();
        initData();
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

    private void initData() {
        mEditMenuAdapter = new EditMenuAdapter(mDayEntity.getContent(), this, editAble);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mEditMenuAdapter);
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv_edit_menu_total);
        mLinearLayout = findViewById(R.id.ll_use_application_total);
        editMenu = findViewById(R.id.tv_edit_applicationa_total);
        editMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TotalMenuActivity.this, EditMenuActivity.class));
            }
        });
    }
}
