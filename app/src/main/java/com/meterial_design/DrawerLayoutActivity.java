package com.meterial_design;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.R;
import com.utils.StatusBarUtil;


public class DrawerLayoutActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
//    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        DrawerLayout mDrawerLayout = findViewById(R.id.activity_drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
//        actionBar.setHomeAsUpIndicator();
        actionBar.setDisplayHomeAsUpEnabled(true);
        StatusBarUtil.setTranslucentForDrawerLayout(DrawerLayoutActivity.this, mDrawerLayout, 20);
        toolbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        navigationView = (NavigationView) findViewById(R.id.nav_menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_drawer_layout);
        if(navigationView!=null){
        }
    }
}
