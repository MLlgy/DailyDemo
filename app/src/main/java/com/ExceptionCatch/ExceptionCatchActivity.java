package com.ExceptionCatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.R;


public class ExceptionCatchActivity extends AppCompatActivity {

    private CatchExcep application;
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exception_catch);
        button = (Button) findViewById(R.id.exception_btn);
        application = (CatchExcep)getApplication();
        application.init();
        application.addActivity(this);
        textView = (TextView)findViewById(R.id.tv_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opress();
            }
        });
    }

    private void opress() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                textView.setText("在主线程更新子线程");
            }
        }).start();
    }
}