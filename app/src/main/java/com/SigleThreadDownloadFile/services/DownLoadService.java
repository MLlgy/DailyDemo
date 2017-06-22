package com.SigleThreadDownloadFile.services;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import com.SigleThreadDownloadFile.entities.FileInfo;

/**
 * Created by Monkey
 * on 2016/11/2.
 */

public class DownLoadService extends Service {

    private static final String TAG = "MutThreadsDownLoadService";
    public static final String DOWNLOAD_PATH =
            Environment.getExternalStorageDirectory().getAbsolutePath() + "/downloads/";
    public static final String ACTION_START = "ACTION_START";
    public static final String ACTION_STOP = "ACTION_STOP";
    public static final String ACTION_UPDATA = "ACTION_UPDATA";
    private static final int MSG_IINIT = 1;
    //下载任务
    private DownloadTask mTask;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent.getAction().equals(ACTION_START)) {
            FileInfo fileInfo = (FileInfo) intent.getSerializableExtra("fileInfo");
            Log.e(TAG, "onStartCommand: start:" + fileInfo.toString());
            // 启动初始化线程----得到下载文件的大小，用以在本地创建相同大小的文件
            /**
             * fileInfo 要下载的文件信息对象
             */
            new InitThread(fileInfo).start();
        } else if (intent.getAction().equals(ACTION_STOP)) {
            FileInfo fileInfo = (FileInfo) intent.getSerializableExtra("fileInfo");
            if(mTask !=null){
                //暂停标志位
                mTask.isPause = true;
            }
            Log.e(TAG, "onStartCommand: stop:" + fileInfo.toString());
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_IINIT:
                    FileInfo fileInfo = (FileInfo) msg.obj;
                    Log.e(TAG, "handleMessage: fileInfo:" + fileInfo.toString());
                    //启动下载任务
                    mTask = new DownloadTask(fileInfo,DownLoadService.this);
                    mTask.download();
                    break;
            }
        }
    };

    /**
     * 初始化子线程进行下载
     */

    class InitThread extends Thread {

        private FileInfo fileInfo = null;

        public InitThread(FileInfo fileInfo) {
            this.fileInfo = fileInfo;
        }

        @Override
        public void run() {
            HttpURLConnection conn = null;
            RandomAccessFile raf = null;
            try {
                //连接网络文件
                URL url = new URL(fileInfo.getUrl());
                conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(3000);
                conn.setRequestMethod("GET");
                int length = -1;
                if (conn.getResponseCode() == 200) {
                    //获得文件长度
                    length = conn.getContentLength();
                }
                if (length <= 0) {
                    return;
                }
                /**
                 * 获得本地文件夹，创建文件目录
                 */
                File dir = new File(DOWNLOAD_PATH);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                //在本地创建文件
                File file = new File(dir, fileInfo.getFileName());
                raf = new RandomAccessFile(file, "rwd");//创建随机写入的文件
                raf.setLength(length);
                //设置文件长度
                fileInfo.setLength(length);
                Log.e(TAG, "run2: " + fileInfo.toString());
                //将信息发到主线程
                mHandler.obtainMessage(MSG_IINIT, fileInfo).sendToTarget();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.disconnect();
                    raf.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
