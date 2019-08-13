package com.learn_recyclerview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import com.androidwebviewdemo.mddemo.R

/**
 * @author: GY.LEE
 * @date: 2019-08-13
 * @Des: 带颜色的分割线
 */
class SeparatorLineItemDecoration(val context: Context) : RecyclerView.ItemDecoration() {

    private val padding: Int by lazy {
        context.resources.getDimensionPixelSize(R.dimen.dp_10)
    }

    private val paint by lazy {
        initPaint()
    }

    private fun initPaint(): Paint {
        val paint = Paint()
        paint.color = context.resources.getColor(R.color.bank_bg02)
        return paint
    }

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect?.bottom = padding
    }

    override fun onDraw(canvas: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.onDraw(canvas, parent, state)
        val count = parent!!.childCount
        val left = parent.left.toFloat()
        val right = parent.width.toFloat() - parent.paddingRight
        for (index in 0 until count) {
            val view = parent.getChildAt(index)
            val top = view.bottom.toFloat()
            val bottom = top + padding
            canvas?.drawRect(left, top, right, bottom, paint)
        }
    }

    /**
     * 同样
     */
//    override fun onDraw(canvas: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
//        super.onDraw(canvas, parent, state)
//        val count = parent!!.childCount
//        val left = parent.left.toFloat()
//        val right = parent.width.toFloat() - parent.paddingRight
//        for (index in 0 until count) {
//            val view = parent.getChildAt(index)
//            val top = view.top.toFloat()
//            val bottom = view.bottom.toFloat() + padding
//            canvas?.drawRect(left, top, right, bottom, paint)
//        }
//    }

//    override fun onDrawOver(canvas: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
//        super.onDrawOver(canvas, parent, state)
//        val count = parent!!.childCount
//        val left = parent.left.toFloat()
//        val right = parent.width.toFloat() - parent.paddingRight
//        for (index in 0 until count) {
//            val view = parent.getChildAt(index)
//            val top = view.bottom.toFloat()
//            val bottom = top + padding
//            canvas?.drawRect(left, top, right, bottom, paint)
//        }
//    }

}