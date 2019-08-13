package com.learn_recyclerview

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import com.androidwebviewdemo.mddemo.R

/**
 * @author: GY.LEE
 * @date: 2019-08-13
 * @Des:
 */
class PaddingItemDecoration(val context: Context) : RecyclerView.ItemDecoration() {

    private val padding: Int by lazy {
        context.resources.getDimensionPixelSize(R.dimen.dp_10)
    }

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect?.bottom = padding
    }
}