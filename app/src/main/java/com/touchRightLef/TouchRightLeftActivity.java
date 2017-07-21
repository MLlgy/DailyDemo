package com.touchRightLef;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import com.R;


public class TouchRightLeftActivity extends Activity {
    private static final String TAG = "TouchRightLeftActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_right_left);
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.activity_touch_right_left);
        relativeLayout.setLongClickable(true);
        relativeLayout.setOnTouchListener(new MyListener(this));
    }
    private class MyListener extends GestureListener{
        public MyListener(Context context) {
            super(context);
        }

        @Override
        public boolean left() {
            Log.d(TAG, "left: "+"左划");
            return super.left();
        }

        @Override
        public boolean right() {
            Log.d(TAG, "left: "+"右划");
            return super.right();
        }
    }
}
