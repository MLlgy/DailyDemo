package com.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.R;

/**
 * Created by liguoying on 2017/8/21.
 */

public class DialogView extends Dialog implements View.OnClickListener {
    private Context mContext;
    private View registerView;
    private Button cancleGuild;
    private LinearLayout bacGuild;

    public DialogView(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        registerView = View.inflate(mContext, R.layout.layout_register_dialog, null);
        setContentView(registerView);
        // 这句话起全屏的作用
        getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        initView();
        initListener();
    }

    private void initListener() {
        cancleGuild.setOnClickListener(this);
        bacGuild.setOnClickListener(this);
    }

    private void initView() {
        cancleGuild = findViewById(R.id.btn_end_guild);
        bacGuild = findViewById(R.id.ll_newer_guide);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        this.dismiss();
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_end_guild:
                this.dismiss();
                Toast.makeText(mContext, "button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_newer_guide:
                this.dismiss();
                Toast.makeText(mContext, "llinear", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
