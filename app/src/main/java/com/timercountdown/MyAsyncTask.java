package com.timercountdown;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.TextView;

/**
 * Created by liguoying on 2017/9/9.
 */

public class MyAsyncTask extends AsyncTask<Integer, Integer, String> {
    private static CharSequence mainText = "00.00.00";
    private static CharSequence strHour = ".00";
    private static CharSequence strSecond = ".00";
    private static CharSequence strMinute = ".00";
    private static CharSequence strMSecond = "00";

    private Handler mHandler;
    private TextView txtView;
    private long number;

    private static final String TAG = "MyAsyncTask";
    private long hour;
    private long minute;
    private long second;
    private long m_second;

    public MyAsyncTask(TextView txtView, long number, Handler mHandler) {
        super();
        this.number = number;
        this.txtView = txtView;
        this.mHandler = mHandler;
    }

    @Override
    protected String doInBackground(Integer... integers) {

        publishProgress(1);
        mHandler.sendEmptyMessageDelayed(1, 20);
        publishProgress(0);

        return "";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        super.onProgressUpdate(values);
        Log.e(TAG, "onProgressUpdate: " + number);
        number += number;
        hour = (((number / 100) / 60) % 60) / 60;
        minute = ((number / 100) / 60) % 60;
        second = (number / 100) % 60;
        m_second = (number % 100);

        if (minute < 10)
            strMinute = "0" + minute;
        else
            strMinute = "" + minute;
        if (second < 10)
            strSecond = "0" + second;
        else
            strSecond = "" + second;
        if (m_second < 10)
            strMSecond = "0" + m_second;
        else
            strMSecond = "" + m_second;
        if (hour < 10) {
            strHour = "0" + hour;
        } else {
            strHour = hour + "";
        }

        mainText = hour + "." + strMinute + "." + strSecond + "." + strMSecond;

        while (values.equals(1)) {
            number = 0;
        }
    }


    @Override
    protected void onPostExecute(String result) {

        super.onPostExecute(result)
        ;
        txtView.setText(mainText);
    }

}