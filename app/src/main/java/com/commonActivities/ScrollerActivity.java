package com.commonActivities;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.androidwebviewdemo.mddemo.R;

public class ScrollerActivity extends BaseActivity {

    private Button showDialog;
    private Dialog mDialog;
    private WindowManager.LayoutParams mLayoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller);
        initView();

    }

    private void initView() {
        showDialog = findViewById(R.id.btn_show_dialog);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMyDialog();
            }
        });
    }

    private void showMyDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_with_animation, null);
        if (null == mDialog) {
            mDialog = new Dialog(this/*,R.style.AppTheme*/);
            mDialog.setContentView(dialogView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            dialogView.findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDialog.dismiss();
                    Toast.makeText(ScrollerActivity.this, "start", Toast.LENGTH_SHORT).show();
                }
            });
            dialogView.findViewById(R.id.middle).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDialog.dismiss();
                    Toast.makeText(ScrollerActivity.this, "middle", Toast.LENGTH_SHORT).show();
                }
            });
            dialogView.findViewById(R.id.end).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDialog.dismiss();
                    Toast.makeText(ScrollerActivity.this, "end", Toast.LENGTH_SHORT).show();
                }
            });

            Window window = mDialog.getWindow();
            window.setWindowAnimations(R.style.main_menu_animstyle);
            mLayoutParams = window.getAttributes();
            mLayoutParams.x = 0;
            mLayoutParams.gravity = Gravity.BOTTOM;
            mLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            mLayoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            // 设置显示位置
            mDialog.onWindowAttributesChanged(mLayoutParams);
            // 设置点击外围解散
            mDialog.setCanceledOnTouchOutside(true);
        }
        mDialog.show();
    }
}
