package com.androidwebviewdemo.mddemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.Window;

import com.R;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.iv_guide1);
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
//                提取色调值
                Palette.Swatch vibrant = palette.getDarkVibrantSwatch();
                Drawable drawable =new ColorDrawable(vibrant.getRgb());
//                if (drawable != null) {
//
//                    getActionBar().setBackgroundDrawable(drawable);
//                }

                Window window = getWindow();
                window.setStatusBarColor(vibrant.getRgb());
                window.setNavigationBarColor(palette.getMutedColor(getResources().getColor(android.R.color.holo_green_light)));
                window.setNavigationBarColor(palette.getDarkMutedColor(getResources().getColor(android.R.color.holo_green_light)));
            }
        });
    }
}
