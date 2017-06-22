package com.SigleThreadDownloadFile.services;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.SigleThreadDownloadFile.db.ThreadDao;
import com.SigleThreadDownloadFile.db.ThreadDaoImpl;
import com.SigleThreadDownloadFile.entities.FileInfo;
import com.SigleThreadDownloadFile.entities.ThreadInfo;

/**
 * 下载任务类
 * Created by Monkey
 * on 2016/11/3.
 */

public class DownloadTask {
    private static final String TAG = "DownloadTask";
    private FileInfo mFileInfo = null;
    private Context mContext = null;
    private ThreadDao mDao = null;
    private long mFinished = 0;
    public boolean isPause = false;

    public DownloadTask(FileInfo mFileInfo, Context mContext) {
        this.mFileInfo = mFileInfo;
        this.mContext = mContext;
        /**
         * 创建数据库实现类
         */
        mDao = new ThreadDaoImpl(mContext);
    }

    public void download() {
        //从数据库读取当前线程信息
        List<ThreadInfo> list = mDao.getThread(mFileInfo.getUrl());
        ThreadInfo threadInfo = null;
        if (list.size() == 0) {
            //初始化线程信息对象--附上各变量初值
            threadInfo = new ThreadInfo(0, mFileInfo.getUrl(), 0, mFileInfo.getLength(), 0);
        } else {
            threadInfo = list.get(0);//获取唯一的线程
        }
        //此操作之前，程序运行在主线程中
        //创建子线程进行下载
        /**
         * 参数 threadInfo 线程信息类
         */
        new DownloadThread(threadInfo).start();

    }

    /**
     * 下载文件的线程
     */
    class DownloadThread extends Thread {
        private ThreadInfo mThreadInfo = null;

        public DownloadThread(ThreadInfo mThreadInfo) {
            this.mThreadInfo = mThreadInfo;
        }

        public void run() {

            if (!mDao.isExists(mThreadInfo.getUrl(), mThreadInfo.getId())) {//线程是否存在于数据库中
                //向数据库插入线程信息
                mDao.insertThread(mThreadInfo);
            }
            HttpURLConnection conn = null;
            RandomAccessFile raf = null;
            InputStream input = null;
            try {
                URL url = new URL(mThreadInfo.getUrl());
                conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(3000);
                conn.setRequestMethod("GET");
                //设置下载位置
//                Log.e(TAG, "run:222 " + mThreadInfo.getStart() + "===" + mThreadInfo.getFinished());
                long start = mThreadInfo.getStart() + mThreadInfo.getFinished();
                //该方法可从指定位置写入数据
                conn.setRequestProperty("Range", "bytes=" + start + "-" + mThreadInfo.getEnd());
//                Log.e(TAG, "run: " + start + "\n" + mThreadInfo.getEnd() + "--" + mFileInfo.getLength());
                //设置文件写入位置
                File file = new File(DownLoadService.DOWNLOAD_PATH, mFileInfo.getFileName());
                raf = new RandomAccessFile(file, "rwd");
                raf.seek(start);
                Intent intent = new Intent(DownLoadService.ACTION_UPDATA);
                mFinished += mThreadInfo.getFinished();
                //开始下载
                if (conn.getResponseCode() == 206) {
                    //读取数据
                    input = conn.getInputStream();
                    byte[] buffer = new byte[1024 * 4];
                    int len = -1;
                    long time = System.currentTimeMillis();
                    while ((len = input.read(buffer)) != -1) {
                        //写入文件
                        raf.write(buffer, 0, len);
                        //下载进度发送广播给Activity
                        mFinished += len;
                        if (System.currentTimeMillis() - time > 500) {
                            time = System.currentTimeMillis();
                            long go = mFinished*100;
                            Log.e(TAG, "run: "+go );
                            intent.putExtra("finished", (int)(go / mFileInfo.getLength()));
                            mContext.sendBroadcast(intent);
                        }
                        //下载暂停时，保存下载进度到数据库
                        if (isPause) {
                            mDao.updataThread(mThreadInfo.getUrl(), mThreadInfo.getId(), mFinished);
                            return;//结束该方法，停止下载
                        }
                    }
                    //下载完毕，删除线程信息
                    mDao.deleteThread(mThreadInfo.getUrl(), mThreadInfo.getId());
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    raf.close();
                    input.close();
                    conn.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
