package com;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.BRAVHAdapter.BRAVHAdapterActivity;
import com.CommonActivities.BarChartViewActivity;
import com.CommonActivities.ClearCacheActivity;
import com.CommonActivities.FontActivity;
import com.CommonActivities.HeaderZoomActivity;
import com.androidwebviewdemo.mddemo.Change_Animation_Activity;
import com.androidwebviewdemo.mddemo.Circle_Reveal_Activity;
import com.androidwebviewdemo.mddemo.ClipingActivity;
import com.androidwebviewdemo.mddemo.PaletteActivity;
import com.androidwebviewdemo.mddemo.RippleAcitvity;
import com.androidwebviewdemo.mddemo.SecondActivity;
import com.androidwebviewdemo.mddemo.TintingActivity;
import com.androidwebviewdemo.mddemo.ZActivity;
import com.designer.DesignerModeActivity;
import com.mengban.MengBanActivity;
import com.meterial_design.SumMDActivity;
import com.mutiThreadsDownloadFile.MutiThreadsDownloadFileActivity;
import com.mvp.view.UserActivity;
import com.myrecyclerview.NotificationActivity;
import com.myrecyclerview.RecyclerView_CardViewActivity;
import com.numberRunner.NumberRunnerMainActivity;
import com.permissionRequest_6.PerssionRequestTestActivity;
import com.sigleThreadDownloadFile.DownloaderFileActivity;
import com.takePhotoWithPerssion.TakePhotoWithPerssionActivity;
import com.titlebarAlpha.TitleBarAlphaActivity;
import com.touchRightLef.TouchRightLeftActivity;
import com.tracedraw.TraceDrawActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

//import ExceptionCatch.ExceptionCatchActivity;

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
        findViewById(R.id.tv_nmrunner).setOnClickListener(this);
        findViewById(R.id.tv_notification).setOnClickListener(this);
        findViewById(R.id.tv_take_photo_with_perssion).setOnClickListener(this);
        findViewById(R.id.tv_recycler_user_adapter).setOnClickListener(this);
        findViewById(R.id.tv_mengBan).setOnClickListener(this);
        findViewById(R.id.tv_clear_cache).setOnClickListener(this);
        findViewById(R.id.tv_titlebar_alpha).setOnClickListener(this);
        findViewById(R.id.tv_head_zoom_scrollview).setOnClickListener(this);
        findViewById(R.id.tv_trace_draw).setOnClickListener(this);
        findViewById(R.id.tv_bar_chart_draw).setOnClickListener(this);
        findViewById(R.id.tv_font).setOnClickListener(this);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        //// TODO: 2017/6/26 在activity中的attachBaseContext方法中引用Calligraphy
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
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
                startActivity(new Intent(this, ClipingActivity.class));
                break;
            case R.id.tv_recyclerview_cardview:
                startActivity(new Intent(this, RecyclerView_CardViewActivity.class));
                break;
            case R.id.tv_activity_animation:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.tv_ripple:
                startActivity(new Intent(this, RippleAcitvity.class));
                break;
            case R.id.circle_reveal:
                startActivity(new Intent(this, Circle_Reveal_Activity.class));
                break;
            case R.id.change_animation:
                startActivity(new Intent(this, Change_Animation_Activity.class));
                break;
            case R.id.catch_expection:
//                startActivity(new Intent(this, ExceptionCatchActivity.class));
                break;
            case R.id.tv_md_design:
//                startActivity(new Intent(this, DrawerLayoutActivity.class));
//                startActivity(new Intent(this, ScrollingActivity.class));
                startActivity(new Intent(this, SumMDActivity.class));
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
            case R.id.tv_nmrunner:
                startActivity(new Intent(this, NumberRunnerMainActivity.class));
                break;
            case R.id.tv_notification:
                startActivity(new Intent(this, NotificationActivity.class));
                break;
            case R.id.tv_take_photo_with_perssion:
                startActivity(new Intent(this, TakePhotoWithPerssionActivity.class));
                break;
            case R.id.tv_recycler_user_adapter:
                startActivity(new Intent(this, BRAVHAdapterActivity.class));
                break;
            case R.id.tv_mengBan:
                startActivity(new Intent(this, MengBanActivity.class));
            case R.id.tv_clear_cache:
                startActivity(new Intent(this, ClearCacheActivity.class));
                break;
            case R.id.tv_titlebar_alpha:
                startActivity(new Intent(this, TitleBarAlphaActivity.class));
                break;
            case R.id.tv_head_zoom_scrollview:
                startActivity(new Intent(this, HeaderZoomActivity.class));
                break;
            case R.id.tv_trace_draw:
                startActivity(new Intent(this, TraceDrawActivity.class));
                break;
            case R.id.tv_bar_chart_draw:
                startActivity(new Intent(this, BarChartViewActivity.class));
                break;
                case R.id.tv_font:
                startActivity(new Intent(this, FontActivity.class));
                break;
        }
    }
}
