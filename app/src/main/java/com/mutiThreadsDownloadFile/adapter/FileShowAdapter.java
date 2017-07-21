package com.mutiThreadsDownloadFile.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import com.mutiThreadsDownloadFile.entities.FileInfo;
import com.mutiThreadsDownloadFile.services.MutThreadsDownLoadService;
import com.R;

/**
 * Created by Monkey
 * on 2016/11/8.
 */

public class FileShowAdapter extends BaseAdapter {

    private Context mContext;
    private List<FileInfo> fileInfoList = new ArrayList<FileInfo>();

    public FileShowAdapter(Context mContext, List<FileInfo> fileInfoList) {
        this.mContext = mContext;
        this.fileInfoList = fileInfoList;
    }

    @Override
    public int getCount() {
        return fileInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return fileInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final FileInfo info = fileInfoList.get(position);
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.muti_threads_download_item_list, null);
            holder = new ViewHolder();
            holder.fileName = (TextView) convertView.findViewById(R.id.tv_muti_show);
            holder.mStart = (TextView) convertView.findViewById(R.id.tv_muti_down_start);
            holder.mStop = (TextView) convertView.findViewById(R.id.tv_muti_down_stop);
            holder.pb = (ProgressBar) convertView.findViewById(R.id.muti_pb_show);
            /**
             * 只需创建一次的变量，放到这里面来
             */
            holder.fileName.setText(info.getFileName());
            holder.pb.setMax(100);
            holder.mStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, MutThreadsDownLoadService.class);
                    intent.setAction(MutThreadsDownLoadService.ACTION_START);
                    intent.putExtra("fileInfo", info);
                    mContext.startService(intent);
                }
            });
            holder.mStop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, MutThreadsDownLoadService.class);
                    intent.setAction(MutThreadsDownLoadService.ACTION_STOP);
                    intent.putExtra("fileInfo", info);
                    mContext.startService(intent);
                }
            });
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.pb.setProgress((int) info.getFinished());

        return convertView;
    }

    /**
     * 更新列表项的进度条
     */
    public void updataProgress(int id, int progress) {
        FileInfo fileInfo = fileInfoList.get(id);
        fileInfo.setFinished(progress);
        notifyDataSetChanged();//getView()会重新调用
    }

    static class ViewHolder {
        TextView fileName;
        TextView mStart;
        TextView mStop;
        ProgressBar pb;
    }
}
