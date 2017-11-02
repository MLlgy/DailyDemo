package com.sigleThreadDownloadFile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.androidwebviewdemo.mddemo.R;
import com.sigleThreadDownloadFile.entities.FileInfo;
import com.sigleThreadDownloadFile.services.DownLoadService;

public class DownloaderFileActivity extends AppCompatActivity {

    private TextView mStart, mStop, mFileNameShow;
    private ProgressBar mProgressBar;
    private TextView checker,delete,show;

    private String PATH="http://sw.bos.baidu.com/sw-search-sp/software/7acc86d58f15a/kugou_8.1.0.19303_setup.exe";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化组件
        checker = (TextView) findViewById(R.id.tv_checker);
        show =  (TextView) findViewById(R.id.tv_show);
        delete = (TextView) findViewById(R.id.tv_delete);
        setContentView(R.layout.downloader_file_activiey);
        mFileNameShow = (TextView) findViewById(R.id.tv_show);
        mStart = (TextView)findViewById(R.id.tv_down_start);
        mStop = (TextView) findViewById(R.id.tv_down_stop);
        mProgressBar = (ProgressBar) findViewById(R.id.pb_show);
        mProgressBar.setMax(100);
        //创建文件信息对象
        final FileInfo fileInfo = new FileInfo(0,PATH,"kugou_8.1.0.19303_setup.exe",0,0);
        mFileNameShow.setText(fileInfo.getFileName());
        //添加事件监听
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过intent1传递参数给Service
                Intent intent = new Intent(DownloaderFileActivity.this, DownLoadService.class);
                intent.setAction(DownLoadService.ACTION_START);
                intent.putExtra("fileInfo", fileInfo);
                startService(intent);
            }
        });
        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DownloaderFileActivity.this, DownLoadService.class);
                intent.setAction(DownLoadService.ACTION_STOP);
                intent.putExtra("fileInfo", fileInfo);
                startService(intent);
            }
        });
        //注册广播接收器
        IntentFilter mFilter = new IntentFilter();
        //为广播接收器添加action，则此广播接收器可以接收该类别的广播
        mFilter.addAction(DownLoadService.ACTION_UPDATA);
        registerReceiver(mReceiver,mFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 解注册广播接收器
         */
        unregisterReceiver(mReceiver);
    }

    /**
     * 广播接收器接收进度，更新UI
     */
    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if(DownLoadService.ACTION_UPDATA.equals(intent.getAction())){
                int finished = intent.getIntExtra("finished",0);
//                Log.e("progress:","p--->"+finished);
                mProgressBar.setProgress(finished);
            }
        }
    };
}
