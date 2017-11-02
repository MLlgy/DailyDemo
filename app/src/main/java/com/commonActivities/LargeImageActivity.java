package com.commonActivities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.androidwebviewdemo.mddemo.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.util.ArrayList;
import java.util.List;

public class LargeImageActivity extends BaseActivity {
    private Bitmap bitmap;
    SubsamplingScaleImageView imageView;
    private LinearLayout mLinearLayout;
    private float mWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_image);
//        imageView = (SubsamplingScaleImageView) findViewById(R.id.imageView);
//        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CUSTOM);
//        DisplayMetrics metric = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(metric);
//        imageView.setMinimumWidth(metric.widthPixels);
//        imageView.setMinScale(1.0F);//最小显示比例
//        imageView.setMaxScale(10.0F);//最大显示比例（太大了图片显示会失真，因为一般微博长图的宽度不会太宽）
//        imageView.setImage(ImageSource.asset("score_detail_assets.png"));
//        imageView.setImage(ImageSource.asset(getAssets()+"score_detail_assets.png"));
//        imageView.setBackgroundResource(R.mipmap.score_detail);

        initLargeImage();
    }

    private void initLargeImage() {
        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        WindowManager windowManager = this.getWindowManager();
        mWidth = windowManager.getDefaultDisplay().getWidth();
        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.score_detail);
        if (bitmap != null) {
            //将图片拆成 index 份
            int index = bitmap.getHeight() / 2000 + 1;
            //每一份图片的高度
            int bitHeight = bitmap.getHeight() / index;
            List<Bitmap> bitmapList = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                /**
                 Bitmap source：要从中截图的原始位图
                 int x:起始x坐标
                 int y：起始y坐标
                 int width：要截的图的宽度
                 int height：要截的图的宽度
                 * */
                Bitmap bitmaps = Bitmap.createBitmap(bitmap, 0, bitHeight * i, bitmap.getWidth(), bitHeight);
                bitmapList.add(bitmaps);
            }

            bitmap.recycle();
            bitmap = null;
            Bitmap bitmapFast = bitmapList.get(0);//获得第一份图片
            //计算狂宽高比例
            double whProportion = (double) bitmapFast.getHeight() / (double) bitmapFast.getWidth();

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (mWidth * whProportion));
            for (Bitmap bit : bitmapList) {
                ImageView imageView = new ImageView(this);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(params);
                imageView.setImageBitmap(bit);
                mLinearLayout.addView(imageView);
            }
        }
    }
}
