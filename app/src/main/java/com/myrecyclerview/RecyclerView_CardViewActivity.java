package com.myrecyclerview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;


import com.androidwebviewdemo.mddemo.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView_CardViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mData = new ArrayList<>();
    private RecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view__card_view);
        recyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mSpinner = (Spinner) findViewById(R.id.sp_layout_type);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerView_CardViewActivity.this));
                        break;
                    case 1:
                        recyclerView.setLayoutManager(new GridLayoutManager(RecyclerView_CardViewActivity.this, 3));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mData.add("Recycler");
        mData.add("Recycler");
        mData.add("Recycler");
        mAdapter = new RecyclerAdapter(mData);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnClickListener(new RecyclerAdapter.OnitemClickListenr() {
            @Override
            public void onItemClickListener(final View v, int i) {
                v.animate()
                        .translationZ(15f)
                        .setDuration(300)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                v.animate().translationZ(1f).setDuration(500).start();
                            }
                        }).start();
            }
        });
    }
    public void addRecycler(View view){
        mData.add("Recycler");
        int position = mData.size();
        if(position>0){
            mAdapter.notifyDataSetChanged();
        }
    }

    public void delRecycler(View view){
        int position = mData.size();
        if(position>0){
            mData.remove(position-1);
            mAdapter.notifyDataSetChanged();
        }
    }
}
