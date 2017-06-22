package com.androidwebviewdemo.mddemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//import ExceptionCatch.ExceptionCatchActivity;
import com.MVP.view.UserActivity;
import com.MutiThreadsDownloadFile.MutiThreadsDownloadFileActivity;
import com.PermissionRequest_6.PerssionRequestTestActivity;
import com.R;
import com.meterial_design.DrawerLayoutActivity;
import com.TouchRightLef.TouchRightLeftActivity;
import com.designer.DesignerModeActivity;
import com.myrecyclerview.RecyclerView_CardViewActivity;
import com.SigleThreadDownloadFile.DownloaderFileActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @NonNull
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_palette).setOnClickListener(this);
        findViewById(R.id.tv_z_show).setOnClickListener(this);
        findViewById(R.id.tv_tinting).setOnClickListener(this);
        findViewById(R.id.tv_cliping).setOnClickListener(this);
        findViewById(R.id.tv_recyclerview_cardview).setOnClickListener(this);
        findViewById(R.id.tv_activity_animation).setOnClickListener(this);
        findViewById(R.id.tv_ripple).setOnClickListener(this);
        findViewById(R.id.circle_reveal).setOnClickListener(this);
        findViewById(R.id.change_animation).setOnClickListener(this);
        findViewById(R.id.catch_expection).setOnClickListener(this);
        findViewById(R.id.tv_md_design).setOnClickListener(this);
        findViewById(R.id.tv_right_left_scroll).setOnClickListener(this);
        findViewById(R.id.tv_designer_mode).setOnClickListener(this);
        findViewById(R.id.tv_sigle_thread_download).setOnClickListener(this);
        findViewById(R.id.tv_mvp).setOnClickListener(this);
        findViewById(R.id.tv_muti_threads_download).setOnClickListener(this);
        findViewById(R.id.tv_permission_request).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_palette:
                startActivity(new Intent(this, PaletteActivity.class));
                break;
            case R.id.tv_z_show:
                startActivity(new Intent(this, ZActivity.class));
                break;
            case R.id.tv_tinting:
                startActivity(new Intent(this, TintingActivity.class));
                break;
            case R.id.tv_cliping:
                startActivity(new Intent(this,ClipingActivity.class));
                break;
            case R.id.tv_recyclerview_cardview:
                startActivity(new Intent(this, RecyclerView_CardViewActivity.class));
                break;
            case R.id.tv_activity_animation:
                startActivity(new Intent(this,SecondActivity.class));
                break;
            case R.id.tv_ripple:
                startActivity(new Intent(this,RippleAcitvity.class));
                break;
            case R.id.circle_reveal:
                startActivity(new Intent(this,Circle_Reveal_Activity.class));
                break;
            case R.id.change_animation:
                startActivity(new Intent(this,Change_Animation_Activity.class));
                break;
            case R.id.catch_expection:
//                startActivity(new Intent(this, ExceptionCatchActivity.class));
                break;
            case R.id.tv_md_design:
                startActivity(new Intent(this, DrawerLayoutActivity.class));
                break;
            case R.id.tv_mvp:
                startActivity(new Intent(this, UserActivity.class));
                break;
            case R.id.tv_right_left_scroll:
                startActivity(new Intent(this, TouchRightLeftActivity.class));
                break;
            case R.id.tv_designer_mode:
                startActivity(new Intent(this, DesignerModeActivity.class));
                break;
            case R.id.tv_sigle_thread_download:
                startActivity(new Intent(this, DownloaderFileActivity.class));
                break;
            case R.id.tv_muti_threads_download:
                startActivity(new Intent(this, MutiThreadsDownloadFileActivity.class));
                break;
            case R.id.tv_permission_request:
                startActivity(new Intent(this, PerssionRequestTestActivity.class));
                break;

        }
    }
}
