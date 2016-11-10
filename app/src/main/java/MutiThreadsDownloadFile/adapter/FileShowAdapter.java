package MutiThreadsDownloadFile.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.androidwebviewdemo.mddemo.R;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.Inflater;

import MutiThreadsDownloadFile.MutiThreadsDownloadFileActivity;
import MutiThreadsDownloadFile.entities.FileInfo;
import MutiThreadsDownloadFile.services.MutThreadsDownLoadService;

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
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.muti_threads_download_item_list, null);
            holder = new ViewHolder();
            holder.fileName = (TextView) convertView.findViewById(R.id.tv_muti_show);
            holder.mStart = (TextView) convertView.findViewById(R.id.tv_muti_down_start);
            holder.mStop = (TextView) convertView.findViewById(R.id.tv_muti_down_stop);
            holder.pb = (ProgressBar) convertView.findViewById(R.id.muti_pb_show);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final FileInfo info = fileInfoList.get(position);
        holder.fileName.setText(info.getFileName());
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
        return convertView;
    }

     static class ViewHolder {
        TextView fileName;
        TextView mStart;
        TextView mStop;
        ProgressBar pb;
    }
}
