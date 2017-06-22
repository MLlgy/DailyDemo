package com.androidwebviewdemo.mddemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.R;

public class SecondActivity extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void explode(View view){
        intent = new Intent(this,TransitionsActivity.class);
        intent.putExtra("flag",0);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void slide(View view){
        intent = new Intent(this,TransitionsActivity.class);
        intent.putExtra("flag",1);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    public void fade(View view){
        intent = new Intent(this,TransitionsActivity.class);
        intent.putExtra("flag",2);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    public void share(View view){
        View fab = findViewById(R.id.fab_button);

        intent = new Intent(this,TransitionsActivity.class);
        intent.putExtra("flag",3);
//        startActivity(intent);
//        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this,view,"share").toBundle());
        startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this, Pair.create(view,"share"),Pair.create(view,"fab")).toBundle());
    }

}
