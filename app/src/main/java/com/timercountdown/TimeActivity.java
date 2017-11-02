package com.timercountdown;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidwebviewdemo.mddemo.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import android.view.WindowManager;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;

public class TimeActivity extends AppCompatActivity implements View.OnClickListener{

    private final static String newClock="00.00.00";
    private final static String start="Start";
    private final static String stop="Stop";

    private static Handler mHandler=null;
    private static long startTime=0;
    private ViewFlipper allFlipper;
    private ObjectAnimator animator;
    private MyAsyncTask asyncTask;

    private ImageView midClock;
    private LinearLayout leftRight;
    private Button mainButton;
    private Button leftButton;
    private Button rightButton;

    private TextView firstText;
    private TextView secondText;
    private TextView thirdText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        allFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                fullScreenChange();
                allFlipper.setDisplayedChild(1);
            }
        }, 3000);

        mHandler = new Handler () {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    startTime++;
                    asyncTask=new MyAsyncTask(firstText,startTime,mHandler);
                    asyncTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
                }
            }
        };

        midClock=(ImageView)findViewById(R.id.mid_hand);
        mainButton=(Button)findViewById(R.id.main_button);
        leftButton=(Button)findViewById(R.id.left_button);
        rightButton=(Button)findViewById(R.id.right_button);
        leftRight=(LinearLayout)findViewById(R.id.id_layout);

        firstText=(TextView)findViewById(R.id.TextOne);
        secondText=(TextView)findViewById(R.id.TextTwo);
        thirdText=(TextView)findViewById(R.id.TextThree);

        animator = ObjectAnimator.ofFloat(midClock, "rotation", 0.0f, 360.0f);
        animator.setDuration(60000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(-1);
        animator.setRepeatMode(ObjectAnimator.RESTART);

        mainButton.setOnClickListener(this);
        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    private void fullScreenChange() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
    }

    public void onClick(View buttonView){
        switch (buttonView.getId()){
            case R.id.main_button:
                mainClick();
                break;
            case R.id.left_button:
                continueClock();
                break;
            case R.id.right_button:
                resetClock();
                break;
        }
    }

    private void mainClick(){
        String buttonText=(String)mainButton.getText();
        switch (buttonText){
            case "Start":
                startClock();
                break;
            case "Stop":
                stopClock();
                break;
        }
    }

    private void startClock(){
        mainButton.setText(stop);
        mHandler.removeMessages(1);
        mHandler.sendEmptyMessage(1);
        animator.start();

    }

    private void stopClock(){
        mainButton.setVisibility(View.INVISIBLE);
        leftRight.setVisibility(View.VISIBLE);
        mHandler.removeMessages(1);
        mHandler.sendEmptyMessage(0);
        animator.pause();

    }

    private void continueClock(){
        mainButton.setVisibility(View.VISIBLE);
        leftRight.setVisibility(View.INVISIBLE);
        mHandler.removeMessages(1);
        mHandler.sendEmptyMessage(1);
        animator.resume();

    }

    private void resetClock(){
        mainButton.setVisibility(View.VISIBLE);
        leftRight.setVisibility(View.INVISIBLE);
        mainButton.setText(start);
        thirdText.setText(secondText.getText());
        secondText.setText(firstText.getText());
        firstText.setText(newClock);
        animator.end();
        startTime=0;
    }

}
