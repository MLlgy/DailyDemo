package MutiThreadsDownloadFile.services;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import MutiThreadsDownloadFile.db.ThreadDaoImpl;
import MutiThreadsDownloadFile.entities.ThreadInfo;
import MutiThreadsDownloadFile.db.ThreadDao;
import MutiThreadsDownloadFile.entities.FileInfo;

/**
 * 下载任务类
 * Created by Monkey
 * on 2016/11/3.
 *
 * 尽量避免在数据库中访问数据库
 */

public class DownloadTask {
    private static final String TAG = "DownloadTask";
    private FileInfo mFileInfo = null;
    private Context mContext = null;
    private ThreadDao mDao = null;
    private long mFinished = 0;
    public boolean isPause = false;

    private List<DownloadThread> mThreadList = null;

    private int threadCount = 1;//线程数量

    public DownloadTask(FileInfo mFileInfo, Context mContext, int threadCount) {
        this.mFileInfo = mFileInfo;
        this.mContext = mContext;
        this.threadCount = threadCount;
        /**
         * 创建数据库实现类
         */
        mDao = new ThreadDaoImpl(mContext);
    }

    public void download() {
        //从数据库读取当前线程信息
        List<ThreadInfo> threads = mDao.getThread(mFileInfo.getUrl());
        if (threads.size() == 0) {
            //获得每个线程的下载长度
            long length = mFileInfo.getLength() / threadCount;
            for (int i = 0; i < threadCount; i++) {
                //创建每个线程信息对象，设置每个线程的下载开始、结束位置
                ThreadInfo threadInfo = new ThreadInfo(i, mFileInfo.getUrl(), length * i, (i + 1) * length - 1, 0);
                //最后线程的结束位置
                if (i == threadCount - 1) {
                    threadInfo.setEnd(mFileInfo.getLength());
                }
                //添加到线程信息集合中
                threads.add(threadInfo);
                //向数据库插入线程信息
                mDao.insertThread(threadInfo);
            }
        }
        mThreadList = new ArrayList<>();
        //启动多个线程进行下载
        for (ThreadInfo info : threads) {
            DownloadThread thread = new DownloadThread(info);
            thread.start();
            mThreadList.add(thread);
        }
    }

    //判断所有线程是否执行完毕---使用同步线程，保证只有一个线程运行此方法
    private synchronized void checkAllThreadFinished() {
        boolean allFinished = true;
        //遍历集合，判断线程是否执行完毕
        for (DownloadThread thread : mThreadList) {
            //当前线程没有执行完毕，则结束此方法
            if (!thread.isFinished) {
                allFinished = false;
                break;
            }
        }
        if (allFinished) {
            //下载完毕，删除当前线程信息
            mDao.deleteThread(mFileInfo.getUrl());
            //发送广播通知ui下载任务结束
            Intent intent = new Intent(MutThreadsDownLoadService.ACTION_FINISH);
            intent.putExtra("fileInfo", mFileInfo);//携带正在下载的文件
            mContext.sendBroadcast(intent);
        }
    }

    /**
     * 开启新线程，下载文件
     */
    class DownloadThread extends Thread {

        public boolean isFinished = false;//标示线程是否执行完毕
        private ThreadInfo mThreadInfo = null;
        public DownloadThread(ThreadInfo mThreadInfo) {
            this.mThreadInfo = mThreadInfo;
        }

        /**
         * run()方法是一个无限循环，直到任务执行完毕
         */
        public void run() {
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
                File file = new File(MutThreadsDownLoadService.DOWNLOAD_PATH, mFileInfo.getFileName());
                raf = new RandomAccessFile(file, "rwd");
                raf.seek(start);
                Intent intent = new Intent(MutThreadsDownLoadService.ACTION_UPDATA);
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
                        mFinished += len;//整个文件的下载进度
                        //累加每个线程的下载进度
                        mThreadInfo.setFinished(mThreadInfo.getFinished() + len);
                        if (System.currentTimeMillis() - time > 1000) {
                            time = System.currentTimeMillis();
                            long go = mFinished * 100;
                            Log.e(TAG, "run: " + go+",start:"+mThreadInfo.getStart()+",end:"+mThreadInfo.getEnd()+",threadId："+Thread.currentThread().getId());
                            intent.putExtra("finished", (int) (go / mFileInfo.getLength()));
                            intent.putExtra("id", mFileInfo.getId());
                            mContext.sendBroadcast(intent);
                        }
                        /**
                         *由于run()方法会一直运行，直到任务结束，所以此处会将所有的下载线程停止
                         *下载暂停时，保存当前线程的下载进度到数据库
                         */
                        if (isPause) {
                            mDao.updataThread(mThreadInfo.getUrl(), mThreadInfo.getId(), mThreadInfo.getFinished());
                            return;//结束该方法，停止下载
                        }
                    }
                    //标示当前线程执行完毕
                    isFinished = true;

                    //检查下载任务是否完成
                    checkAllThreadFinished();
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
