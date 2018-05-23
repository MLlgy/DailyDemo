package com

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast

import com.BRAVHAdapter.BRAVHAdapterActivity
import com.commonActivities.*
import com.androidwebviewdemo.mddemo.*
import com.designer.DesignerModeActivity
import com.interfaces.CheckPermissionsListener
import com.lidroid.xutils.util.LogUtils
import com.mengban.MengBanActivity
import com.meterial_design.SumMDActivity
import com.mutiThreadsDownloadFile.MutiThreadsDownloadFileActivity
import com.mvp.view.UserActivity
import com.myrecyclerview.NotificationActivity
import com.myrecyclerview.RecyclerView_CardViewActivity
import com.numberRunner.NumberRunnerMainActivity
import com.permissionRequest_6.PerssionRequestTestActivity
import com.showCase.ShowCaseActivity
import com.sigleThreadDownloadFile.DownloaderFileActivity
import com.takePhotoWithPerssion.TakePhotoWithPerssionActivity
import com.takePhotoWithPerssion.ToastUtils
import com.timercountdown.TimeActivity
import com.titlebarAlpha.TitleBarAlphaActivity
import com.touchRightLef.TouchRightLeftActivity
import com.tracedraw.TraceDrawActivity
import com.widget.drag_recyclerview.DragRecyclerViewActivity

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

//import ExceptionCatch.ExceptionCatchActivity;

class MainActivity : BaseActivity(), View.OnClickListener, CheckPermissionsListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.tv_custom_edit).setOnClickListener(this)
        findViewById<View>(R.id.tv_palette).setOnClickListener(this)
        findViewById<View>(R.id.tv_z_show).setOnClickListener(this)
        findViewById<View>(R.id.tv_tinting).setOnClickListener(this)
        findViewById<View>(R.id.tv_cliping).setOnClickListener(this)
        findViewById<View>(R.id.tv_recyclerview_cardview).setOnClickListener(this)
        findViewById<View>(R.id.tv_activity_animation).setOnClickListener(this)
        findViewById<View>(R.id.tv_ripple).setOnClickListener(this)
        findViewById<View>(R.id.circle_reveal).setOnClickListener(this)
        findViewById<View>(R.id.change_animation).setOnClickListener(this)
        findViewById<View>(R.id.catch_expection).setOnClickListener(this)
        findViewById<View>(R.id.tv_md_design).setOnClickListener(this)
        findViewById<View>(R.id.tv_right_left_scroll).setOnClickListener(this)
        findViewById<View>(R.id.tv_designer_mode).setOnClickListener(this)
        findViewById<View>(R.id.tv_sigle_thread_download).setOnClickListener(this)
        findViewById<View>(R.id.tv_mvp).setOnClickListener(this)
        findViewById<View>(R.id.tv_muti_threads_download).setOnClickListener(this)
        findViewById<View>(R.id.tv_permission_request).setOnClickListener(this)
        findViewById<View>(R.id.tv_nmrunner).setOnClickListener(this)
        findViewById<View>(R.id.tv_notification).setOnClickListener(this)
        findViewById<View>(R.id.tv_take_photo_with_perssion).setOnClickListener(this)
        findViewById<View>(R.id.tv_recycler_user_adapter).setOnClickListener(this)
        findViewById<View>(R.id.tv_mengBan).setOnClickListener(this)
        findViewById<View>(R.id.tv_clear_cache).setOnClickListener(this)
        findViewById<View>(R.id.tv_titlebar_alpha).setOnClickListener(this)
        findViewById<View>(R.id.tv_head_zoom_scrollview).setOnClickListener(this)
        findViewById<View>(R.id.tv_trace_draw).setOnClickListener(this)
        findViewById<View>(R.id.tv_bar_chart_draw).setOnClickListener(this)
        findViewById<View>(R.id.tv_font).setOnClickListener(this)
        findViewById<View>(R.id.tv_btn_animation).setOnClickListener(this)
        findViewById<View>(R.id.tv_image_scale_type).setOnClickListener(this)
        findViewById<View>(R.id.tv_long_image).setOnClickListener(this)
        findViewById<View>(R.id.tv_scoroller).setOnClickListener(this)
        findViewById<View>(R.id.tv_showCase).setOnClickListener(this)
        findViewById<View>(R.id.tv_select_middle).setOnClickListener(this)
        findViewById<View>(R.id.tv_badge_num).setOnClickListener(this)
        findViewById<View>(R.id.tv_time_upper).setOnClickListener(this)
        findViewById<View>(R.id.ed_super_edit).setOnClickListener(this)
        findViewById<View>(R.id.tv_drag_recyclerview).setOnClickListener(this)
        findViewById<View>(R.id.tv_edit_menu).setOnClickListener(this)
        findViewById<View>(R.id.tv_get_permission).setOnClickListener(this)
        findViewById<View>(R.id.tv_city_picker).setOnClickListener(this)
        findViewById<View>(R.id.tv_open_app).setOnClickListener(this)
        findViewById<View>(R.id.tv_image_scroll).setOnClickListener(this)
        findViewById<View>(R.id.tv_add_permission).setOnClickListener(this)
        findViewById<View>(R.id.tv_icon_bang).setOnClickListener(this)
    }

    override fun attachBaseContext(newBase: Context) {
        //// TODO: 2017/6/26 在activity中的attachBaseContext方法中引用Calligraphy
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_custom_edit -> startActivity(Intent(this,CustomEditActivity::class.java))
            R.id.tv_palette -> startActivity(Intent(this, PaletteActivity::class.java))
            R.id.tv_z_show -> startActivity(Intent(this, ZActivity::class.java))
            R.id.tv_tinting -> startActivity(Intent(this, TintingActivity::class.java))
            R.id.tv_cliping -> startActivity(Intent(this, ClipingActivity::class.java))
            R.id.tv_recyclerview_cardview -> startActivity(Intent(this, RecyclerView_CardViewActivity::class.java))
            R.id.tv_activity_animation -> startActivity(Intent(this, SecondActivity::class.java))
            R.id.tv_ripple -> startActivity(Intent(this, RippleAcitvity::class.java))
            R.id.circle_reveal -> startActivity(Intent(this, Circle_Reveal_Activity::class.java))
            R.id.change_animation -> startActivity(Intent(this, Change_Animation_Activity::class.java))
            R.id.catch_expection -> {
            }
            R.id.tv_md_design ->
                //                startActivity(new Intent(this, DrawerLayoutActivity.class));
                //                startActivity(new Intent(this, ScrollingActivity.class));
                startActivity(Intent(this, SumMDActivity::class.java))
            R.id.tv_mvp -> startActivity(Intent(this, UserActivity::class.java))
            R.id.tv_right_left_scroll -> startActivity(Intent(this, TouchRightLeftActivity::class.java))
            R.id.tv_designer_mode -> startActivity(Intent(this, DesignerModeActivity::class.java))
            R.id.tv_sigle_thread_download -> startActivity(Intent(this, DownloaderFileActivity::class.java))
            R.id.tv_muti_threads_download -> startActivity(Intent(this, MutiThreadsDownloadFileActivity::class.java))
            R.id.tv_permission_request -> startActivity(Intent(this, PerssionRequestTestActivity::class.java))
            R.id.tv_nmrunner -> startActivity(Intent(this, NumberRunnerMainActivity::class.java))
            R.id.tv_notification -> startActivity(Intent(this, NotificationActivity::class.java))
            R.id.tv_take_photo_with_perssion -> startActivity(Intent(this, TakePhotoWithPerssionActivity::class.java))
            R.id.tv_recycler_user_adapter -> startActivity(Intent(this, BRAVHAdapterActivity::class.java))
            R.id.tv_mengBan -> startActivity(Intent(this, MengBanActivity::class.java))
            R.id.tv_clear_cache -> startActivity(Intent(this, ClearCacheActivity::class.java))
            R.id.tv_titlebar_alpha -> startActivity(Intent(this, TitleBarAlphaActivity::class.java))
            R.id.tv_head_zoom_scrollview -> startActivity(Intent(this, HeaderZoomActivity::class.java))
            R.id.tv_trace_draw -> startActivity(Intent(this, TraceDrawActivity::class.java))
            R.id.tv_bar_chart_draw -> startActivity(Intent(this, BarChartViewActivity::class.java))
            R.id.tv_font -> startActivity(Intent(this, FontActivity::class.java))
            R.id.tv_btn_animation -> startActivity(Intent(this, ClickBtnActivity::class.java))
            R.id.tv_image_scale_type -> startActivity(Intent(this, ImageScaleTypeActivity::class.java))
            R.id.tv_long_image -> startActivity(Intent(this, LargeImageActivity::class.java))
            R.id.tv_scoroller -> startActivity(Intent(this, ScrollerActivity::class.java))
            R.id.tv_showCase -> startActivity(Intent(this, ShowCaseActivity::class.java))
            R.id.tv_select_middle -> startActivity(Intent(this, MiddlSelectedActivity::class.java))
            R.id.tv_badge_num -> startActivity(Intent(this, BadgeNumberActivity::class.java))
            R.id.tv_time_duration -> startActivity(Intent(this, DurationActivity::class.java))
            R.id.tv_time_upper -> startActivity(Intent(this, TimeActivity::class.java))
            R.id.ed_super_edit -> startActivity(Intent(this, SuperEditTextActivity::class.java))
            R.id.tv_drag_recyclerview -> startActivity(Intent(this, DragRecyclerViewActivity::class.java))
            R.id.tv_edit_menu -> startActivity(Intent(this, TotalMenuActivity::class.java))
            R.id.tv_get_permission -> requestPermission(this, needPermission, this)
            R.id.tv_city_picker -> startActivity(Intent(this, CityPickerActivity::class.java))
            R.id.tv_image_scroll -> startActivity(Intent(this, ScrollViewActivity::class.java))
            R.id.tv_add_permission -> startActivity(Intent(this, AdActivity::class.java))
            R.id.tv_icon_bang -> startActivity(Intent(this, IconBangActivity::class.java))
            R.id.tv_open_app -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("muheda://muheda"))
                startActivity(intent)
            }
            else -> {
            }
        }//                startActivity(new Intent(this, ExceptionCatchActivity.class));
        //                startActivity(new Intent(this, EditMenuActivity.class));
    }

    override fun onGranted() {
        LogUtils.d("success push") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDenied(permissions: ArrayList<String>) {
        val length = permissions?.size
        var deniedStr = StringBuffer()
        for (i in 0..length - 1) {
            deniedStr.append(permissions[i] + "  ")
        }
        LogUtils.e(deniedStr.toString())
        ToastUtils.show(this, deniedStr, Toast.LENGTH_SHORT)
    }
}
