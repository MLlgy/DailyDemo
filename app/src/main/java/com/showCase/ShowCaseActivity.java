package com.showCase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidwebviewdemo.mddemo.R;

import java.util.ArrayList;

public class ShowCaseActivity extends AppCompatActivity {
    Button btn_showcase;
    Button btn1_showcase;

    ShowCaseView showCaseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_case);

        showCaseView = new ShowCaseView(ShowCaseActivity.this);

        btn_showcase = (Button) findViewById(R.id.btn_showcase);
        btn1_showcase = (Button) findViewById(R.id.btn1_showcase);
        btn_showcase.post(new Runnable() {
            @Override
            public void run() {
                ArrayList<View> views = new ArrayList<>();
                views.add(a());
//                views.add(b());
                showCaseView.addViews(views);
                showCaseView.show();
            }
        });

    }

    public View a() {
        ArrayList<CalculatorBean> beanArrayList = new ArrayList<>();

        int[] location = new int[2];
        btn_showcase.getLocationOnScreen(location);
        CalculatorBean bean = new CalculatorBean();
        bean.setmCircleCenterX(location[0] + btn_showcase.getMeasuredWidth() / 2);
        bean.setmCircleCenterY(location[1] + btn_showcase.getMeasuredHeight() / 2);
        bean.setmCircleRadius(150);
        bean.setmFocusShape(FocusShape.CIRCLE);
        beanArrayList.add(bean);

        View view = LayoutInflater.from(ShowCaseActivity.this).inflate(R.layout.view1, null, false);
        ShowCaseImageView image_showcase = view.findViewById(R.id.image_showcase);
        ImageView imageView = view.findViewById(R.id.iv1);
        image_showcase.setmAnimationEnabled(false);
        image_showcase.setmCalculatorBeen(beanArrayList);
        image_showcase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShowCaseActivity.this, "446", Toast.LENGTH_SHORT).show();
                showCaseView.dismiss();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShowCaseActivity.this, "4111146", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    public View b() {
        ArrayList<CalculatorBean> beanArrayList = new ArrayList<>();

        int[] location1 = new int[2];
        btn1_showcase.getLocationOnScreen(location1);
        CalculatorBean bean1 = new CalculatorBean();
        bean1.setmCircleCenterX(location1[0] + btn1_showcase.getMeasuredWidth() / 2);
        bean1.setmCircleCenterY(location1[1] + btn1_showcase.getMeasuredHeight() / 2);
        bean1.setmCircleRadius(20);
        bean1.setmFocusHeight(btn1_showcase.getMeasuredHeight());
        bean1.setmFocusWidth(btn1_showcase.getMeasuredWidth());
        bean1.setmFocusShape(FocusShape.ROUNDED_RECTANGLE);
        beanArrayList.add(bean1);

        View view = LayoutInflater.from(ShowCaseActivity.this).inflate(R.layout.view1, null, false);
        ShowCaseImageView image_showcase = view.findViewById(R.id.image_showcase);
        image_showcase.setmAnimationEnabled(false);
        image_showcase.setmCalculatorBeen(beanArrayList);
        image_showcase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCaseView.dismiss();
            }
        });

        return view;
    }
}
