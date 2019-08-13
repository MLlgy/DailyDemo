package com.learn_recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.androidwebviewdemo.mddemo.R
import kotlinx.android.synthetic.main.activity_padding_recycler_view.*

class PaddingRecyclerViewActivity : AppCompatActivity() {


    private val linearManager by lazy {
        LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    private val customAdapter by lazy {
        CustomAdapter(this)
    }

    private val paddingItemDecoration: PaddingItemDecoration by lazy {
        PaddingItemDecoration(this)
    }

    private val wordList by lazy {
        ObtainData.initList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_padding_recycler_view)
        rvPadding.apply {
            layoutManager = linearManager
            adapter = customAdapter
            addItemDecoration(paddingItemDecoration)
            customAdapter.setData(wordList)
        }
    }
}
