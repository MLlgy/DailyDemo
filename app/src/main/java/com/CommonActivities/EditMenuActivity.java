package com.CommonActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.R;
import com.entity.DayEntity;
import com.google.gson.Gson;

import java.util.List;

public class EditMenuActivity extends AppCompatActivity {
    private String content = "{\"code\" : ok ,\"content\" : [{\"name\":\"今天\",\"date\":[{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\" 中间 \",\"image\":\"haha\"},{\"title\":\" 中间 \",\"image\":\"haha\"}]},{\"name\":\"明天\",\"date\":[{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"}]},{\"name\":\"明天\",\"date\":[{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"},{\"title\":\"中间\",\"image\":\"haha\"}]}]\n" +
            "     }";

    private LinearLayout mLinearLayout;
    private DayEntity mDayEntity;
    private int mMllinearWitdh;
    private int perWidth;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_menu);
        mDayEntity = new Gson().fromJson(content, DayEntity.class);
        initView();
        getLinearlayoutWidth();
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
        mLinearLayout = findViewById(R.id.ll_use_application);
    }
}
