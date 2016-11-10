package MutiThreadsDownloadFile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.androidwebviewdemo.mddemo.R;

import java.util.ArrayList;
import java.util.List;

import MutiThreadsDownloadFile.adapter.FileShowAdapter;
import MutiThreadsDownloadFile.entities.FileInfo;
import MutiThreadsDownloadFile.services.MutThreadsDownLoadService;

public class MutiThreadsDownloadFileActivity extends AppCompatActivity {


    private ListView listView;

    private String URL_PATH1 = "http://sw.bos.baidu.com/sw-search-sp/software/7acc86d58f15a/kugou_8.1.0.19303_setup.exe";
    private String URL_PATH2 = "http://sw.bos.baidu.com/sw-search-sp/software/7acc86d58f15a/kugou_8.1.0.19303_setup.exe";
    private String URL_PATH3 = "http://sw.bos.baidu.com/sw-search-sp/software/7acc86d58f15a/kugou_8.1.0.19303_setup.exe";
    private String URL_PATH4 = "http://sw.bos.baidu.com/sw-search-sp/software/7acc86d58f15a/kugou_8.1.0.19303_setup.exe";
    private List<FileInfo> list ;
    private FileShowAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muti_threads_download);
        //初始化组件
        listView = (ListView) findViewById(R.id.lvFile);
        list = new ArrayList<FileInfo>();

        //创建文件信息对象
        final FileInfo fileInfo1 = new FileInfo(0, URL_PATH1, "kugou_8.1.0.19303_setup.exe", 0, 0);
        final FileInfo fileInfo2 = new FileInfo(0, URL_PATH2, "kugou_8.1.0.19303_setup.exe", 0, 0);
        final FileInfo fileInfo3 = new FileInfo(0, URL_PATH3, "kugou_8.1.0.19303_setup.exe", 0, 0);
        final FileInfo fileInfo4 = new FileInfo(0, URL_PATH4, "kugou_8.1.0.19303_setup.exe", 0, 0);
        list.add(fileInfo1);
        list.add(fileInfo2);
        list.add(fileInfo3);
        list.add(fileInfo4);
        adapter = new FileShowAdapter(this,list);
        listView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
        //注册广播接收器
        IntentFilter mFilter = new IntentFilter();
        //为广播接收器添加action，则此广播接收器可以接收该类别的广播
        mFilter.addAction(MutThreadsDownLoadService.ACTION_UPDATA);
        registerReceiver(mReceiver, mFilter);
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

            if (MutThreadsDownLoadService.ACTION_UPDATA.equals(intent.getAction())) {
                int finished = intent.getIntExtra("finished", 0);
//                Log.e("progress:","p--->"+finished);
//                mProgressBar.setProgress(finished);
            }
        }
    };
}
