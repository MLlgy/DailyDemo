package com.SigleThreadDownloadFile.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import com.SigleThreadDownloadFile.entities.ThreadInfo;

/**
 * 数据访问接口实现
 * 数据库中存储的为线程信息对象
 */

public class ThreadDaoImpl implements ThreadDao {

    private DBhelper mHelper;

    public ThreadDaoImpl(Context context) {
        mHelper = new DBhelper(context);
    }

    @Override
    public void insertThread(ThreadInfo threadInfo) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        db.execSQL("insert into thread_info(thread_id, url, start, end, finished) values (?,?,?,?,?)",
                new Object[]{threadInfo.getId(), threadInfo.getUrl(), threadInfo.getStart(), threadInfo.getEnd(), threadInfo.getFinished()});
        db.close();
    }

    @Override
    public void deleteThread(String url, int thread_id) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        db.execSQL("delete from thread_info where url = ? and thread_id = ? ", new Object[]{url, thread_id});
        db.close();
    }

    @Override
    public void updataThread(String url, int thread_id, long finished) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        db.execSQL("update thread_info set finished = ? , url = ? where thread_id = ?",
                new Object[]{finished, url, thread_id});
        db.close();
    }

    @Override
    public List<ThreadInfo> getThread(String url) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from thread_info where url = ?", new String[]{url});
        List<ThreadInfo> list = new ArrayList<ThreadInfo>();
        while (cursor.moveToNext()) {
            ThreadInfo thread = new ThreadInfo();
            thread.setEnd(cursor.getInt(cursor.getColumnIndex("end")));
            thread.setFinished(cursor.getInt(cursor.getColumnIndex("finished")));
            thread.setId(cursor.getInt(cursor.getColumnIndex("thread_id")));
            thread.setStart(cursor.getInt(cursor.getColumnIndex("start")));
            thread.setUrl(cursor.getString(cursor.getColumnIndex("url")));
            list.add(thread);
        }
        cursor.close();
        db.close();
        return list;
    }

    @Override
    public boolean isExists(String url, int thread_id) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from thread_info where url = ? and thread_id = ?", new String[]{url, thread_id + ""});
        boolean exists = cursor.moveToNext();
        cursor.close();
        db.close();
        return exists;
    }
}
