package com.learn_recyclerview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.androidwebviewdemo.mddemo.R

class RecyclerViewLearnActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_learn)
    }

    fun padding(view: View) {
        startActivity(Intent(this@RecyclerViewLearnActivity,PaddingRecyclerViewActivity::class.java))
    }
    fun separatorLine(view: View) {
        startActivity(Intent(this@RecyclerViewLearnActivity,SeparatorLineActivity::class.java))
    }

    fun section(view: View) {
        startActivity(Intent(this@RecyclerViewLearnActivity,SectionActivity::class.java))
    }
}
