package com.CommonActivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.R;
import com.utils.BarChartView;

import java.util.ArrayList;
import java.util.List;

public class BarChartViewActivity extends AppCompatActivity {
    private BarChartView mBarChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart_view);
        initView();
        initData();
    }

    private void initView() {
        mBarChartView = findViewById(R.id.bcv_show);
    }

    private void initData() {
        List<String> taggings = new ArrayList<>();
        taggings.add("北京");
        taggings.add("上海");
        taggings.add("深圳");
        List<String> xRawDatas = new ArrayList<>();  //横坐标值
        xRawDatas.add("2016-01");
        xRawDatas.add("2016-02");
        xRawDatas.add("2016-03");
        xRawDatas.add("2016-04");
        xRawDatas.add("2016-05");
        xRawDatas.add("2016-06");
        xRawDatas.add("2016-07");
        xRawDatas.add("2016-08");
        xRawDatas.add("2016-09");
        List<Float> yRawDatas1 = new ArrayList<>();
        List<Float> yRawDatas2 = new ArrayList<>();
        List<Float> yRawDatas3 = new ArrayList<>();
        yRawDatas1.add(12.0f);
        yRawDatas1.add(7.0f);
        yRawDatas1.add(-12.0f);
        yRawDatas1.add(6.0f);
        yRawDatas1.add(12.0f);
        yRawDatas1.add(17.0f);
        yRawDatas1.add(-5.0f);
        yRawDatas1.add(9.0f);
        yRawDatas1.add(2.0f);

        yRawDatas2.add(-12.0f);
        yRawDatas2.add(7.0f);
        yRawDatas2.add(6.0f);
        yRawDatas2.add(7.0f);
        yRawDatas2.add(8.0f);
        yRawDatas2.add(-13.0f);
        yRawDatas2.add(5.0f);
        yRawDatas2.add(9.0f);
        yRawDatas2.add(2.8f);

        yRawDatas3.add(3.0f);
        yRawDatas3.add(6.0f);
        yRawDatas3.add(9.0f);
        yRawDatas3.add(6.0f);
        yRawDatas3.add(11.0f);
        yRawDatas3.add(-7.0f);
        yRawDatas3.add(6.66f);
        yRawDatas3.add(116.0f);
        yRawDatas3.add(-6.0f);
        mBarChartView.setData(taggings, xRawDatas, yRawDatas1, yRawDatas2, yRawDatas3);
    }


}
