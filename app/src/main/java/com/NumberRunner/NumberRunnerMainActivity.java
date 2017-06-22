package com.NumberRunner;

import java.util.Random;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.R;

public class NumberRunnerMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_number_runner);
		TOOLS.init(this);
		View rootView = findViewById(R.id.container);
		NumberWheel.NumberBean nBean=new NumberWheel.NumberBean();
		RelativeLayout.LayoutParams rl=new RelativeLayout.LayoutParams(TOOLS.getCurrentPxForWidth(212),TOOLS.getCurrentPxForHeight(54));
		final NumberWheel nw=new NumberWheel(this,nBean,rl,500);
		((FrameLayout)rootView).addView(nw);
		nw.setCallBackListener(new NumberWheel.CallBackListener() {
			
			@Override
			public void start() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void end() {
				// TODO Auto-generated method stub
				nw.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						float f=new Random().nextFloat()*1000f;
						nw.restart(f);
					}
				},2000);
			}
		});
	}
}
