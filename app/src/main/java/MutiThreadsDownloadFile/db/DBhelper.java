package MutiThreadsDownloadFile.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库帮助类，记录下载位置
 */

public class DBhelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "download.db";
    private static final int VERSION = 1;
    private static final String SQL_CREAT = "create table threads_info(_id integer primary key autoincrement," +
            "thread_id integer, url text, start integer ,end integer, finished integer )";
    private static final String SQL_DROP = "drop the table if exists threads_info";

    private static DBhelper dBhelper;

    public static synchronized DBhelper INSTANCE(Context context) {
        if (dBhelper == null) {
            synchronized (DBhelper.class) {
                if (dBhelper == null) {

                    dBhelper = new DBhelper(context);
                }
            }
        }
        return dBhelper;
    }


    private DBhelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREAT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP);
        db.execSQL(SQL_CREAT);


    }
}
