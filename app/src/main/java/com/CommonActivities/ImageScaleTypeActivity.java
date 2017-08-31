package com.CommonActivities;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.R;
import com.utils.DrawText;

public class ImageScaleTypeActivity extends AppCompatActivity {
private ImageView mImageView;
private DrawText mDrawText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_scale_type);
        initView();
    }

    private void initView() {
        mDrawText = new DrawText(this);
        mImageView = findViewById(R.id.iv_draw_text);
        mImageView.setImageBitmap(mDrawText
                .drawTextToBitmap(BitmapFactory
                        .decodeResource(getResources(),R.mipmap.service_with_zxing),
                        BitmapFactory
                                .decodeResource(getResources(),R.mipmap.ic_launcher),
                        "12344",R.color.black,50,400,600,200));
    }
}
