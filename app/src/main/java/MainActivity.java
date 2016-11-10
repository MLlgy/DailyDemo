import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.androidwebviewdemo.mddemo.Change_Animation_Activity;
import com.androidwebviewdemo.mddemo.Circle_Reveal_Activity;
import com.androidwebviewdemo.mddemo.ClipingActivity;
import com.androidwebviewdemo.mddemo.PaletteActivity;
import com.androidwebviewdemo.mddemo.R;
import com.androidwebviewdemo.mddemo.RippleAcitvity;
import com.androidwebviewdemo.mddemo.SecondActivity;
import com.androidwebviewdemo.mddemo.TintingActivity;
import com.androidwebviewdemo.mddemo.ZActivity;

import ExceptionCatch.ExceptionCatchActivity;
import MVP.view.UserActivity;
import MutiThreadsDownloadFile.MutiThreadsDownloadFileActivity;
import meterial_design.DrawerLayoutActivity;
import TouchRightLef.TouchRightLeftActivity;
import designer.DesignerModeActivity;
import myrecyclerview.RecyclerView_CardViewActivity;
import SigleThreadDownloadFile.DownloaderFileActivity;

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
                startActivity(new Intent(this, ExceptionCatchActivity.class));
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

        }
    }
}
