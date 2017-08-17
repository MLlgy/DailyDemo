package com.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.DemoApplication;

/**
 * Created by liguoying on 2017/8/17.
 */

public class FontsTextView extends TextView {
    public FontsTextView(Context context) {
        super(context);
        setTypeface();
    }

    public FontsTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface();
    }

    public FontsTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setTypeface();
    }

    private void setTypeface() {
        // 如果自定义typeface初始化失败，就用原生的typeface
        if (DemoApplication.mTypeface == null) {
            setTypeface(getTypeface());
        } else {
            setTypeface(DemoApplication.mTypeface);
        }
    }
}
