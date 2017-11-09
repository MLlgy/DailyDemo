package com.commonActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.androidwebviewdemo.mddemo.R;
import com.lidroid.xutils.util.LogUtils;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.citywheel.CityPickerView;

public class CityPickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_picker);

    }

    /**
     * 弹出选择器
     */
    private void wheel() {

//        mTitle = mTitleEt.getText().toString();
//        titleBackgroundColorStr = mTitleBgEt.getText().toString();
//        textSize = Integer.parseInt(mItemTextSizeEt.getText().toString());
//        titleTextColorStr = mTitleColorEt.getText().toString();
//        textColor = mItemTextColorEt.getText().toString();
//
//        defaultProvinceName = mProEt.getText().toString();
//        defaultCityName = mCityEt.getText().toString();
//        defaultDistrict = mAreaEt.getText().toString();
//
//        confirmTextColorStr = mConfirmTextColorEt.getText().toString();
//        cancelTextColorStr = mCancelTextColorEt.getText().toString();
//        visibleItems = (Integer.parseInt(mProVisibleCountEt.getText().toString()));
//        padding = (Integer.parseInt(mItemPaddingEt.getText().toString()));

        CityConfig cityConfig = new CityConfig.Builder(CityPickerActivity.this)
                .title("选择地区")
                .titleBackgroundColor("#E9E9E9")
                .textSize(18)
                .titleTextColor("#585858")
                .textColor("0xFF585858")
                .confirTextColor("#0000FF")
                .cancelTextColor("#000000")
                .province("江苏")
                .city("常州")
                .district("新北区")
                .visibleItemsCount(5)
                .provinceCyclic(false)
                .cityCyclic(false)
                .districtCyclic(false)
                .itemPadding(5)
                .setCityInfoType(CityConfig.CityInfoType.BASE)
                .setCityWheelType(CityConfig.WheelType.PRO_CITY_DIS)
                .build();

        CityPickerView cityPicker = new CityPickerView(cityConfig);
        cityPicker.show();
        cityPicker.setOnCityItemClickListener(new CityPickerView.OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {

                if (district != null) {
                    //返回结果
                    LogUtils.e(
                            "所选城市：\n" + province.toString() + "\n" + city.toString() + "\n" + district.toString());
                } else {
                    //返回结果
                    LogUtils.e("所选城市：\n" + province.toString() + "\n" + city.toString());
                }

            }

            @Override
            public void onCancel() {

            }
        });
    }

    public void citypicker(View view) {
        wheel();
    }
}
