package com.meterial_design;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.R;
import com.utils.TranslateTitlebarUtils;

public class SumMDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_md);
        TranslateTitlebarUtils.setStatusBarLightMode(this,R.color.tomato);
    }
    public void btnClick1(View view) {
        startActivity(new Intent(this,CoordinatorActivity.class));
    }

    public void btnClick2(View view) {
        startActivity(new Intent(this,CoorAppBarActivity.class));
    }

    public void btnClick3(View view) {
        startActivity(new Intent(this,CoorToolBarActivity.class));
    }
}
