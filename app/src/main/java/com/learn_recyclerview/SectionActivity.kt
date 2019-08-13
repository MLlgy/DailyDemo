package com.learn_recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.androidwebviewdemo.mddemo.R
import com.learn_recyclerview.SectionItemDecoration.ISectionItemCallBack
import kotlinx.android.synthetic.main.activity_padding_recycler_view.*
import java.util.*

class SectionActivity : AppCompatActivity() {

    private val linearManager by lazy {
        LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    private val customAdapter by lazy {
        CustomAdapter(this)
    }

    private val itemDecoration: SectionItemDecoration by lazy {
        SectionItemDecoration(this, object : ISectionItemCallBack {
            override fun isHeader(position: Int) = wordList[position].isHeader

            override fun getChar(position: Int) = with(wordList[position]) { title.substring(0, 1).toUpperCase(Locale.CHINA) }

        })
    }

    private val wordList by lazy {
        ObtainData.initSectionList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_padding_recycler_view)
        rvPadding.apply {
            layoutManager = linearManager
            adapter = customAdapter
            addItemDecoration(itemDecoration)
            customAdapter.setData(wordList)
        }
    }
}
