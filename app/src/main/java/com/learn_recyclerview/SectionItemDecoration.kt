package com.learn_recyclerview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.View
import com.androidwebviewdemo.mddemo.R

/**
 * @author: GY.LEE
 * @date: 2019-08-13
 * @Des:
 */
class SectionItemDecoration(val context: Context, val callback: ISectionItemCallBack) : RecyclerView.ItemDecoration() {


    private val rectPaint by lazy {
        initRectPaint()
    }

    private val textPaint by lazy {
        initTextPaint()
    }

    private fun initRectPaint(): Paint {
        val paint = Paint()
        paint.color = context.resources.getColor(R.color.bank_bg02)
        return paint
    }

    private fun initTextPaint(): Paint {
        val paint = Paint()
        paint.typeface = Typeface.DEFAULT_BOLD
        paint.isAntiAlias = true
        paint.textSize = 80F
        paint.textAlign = Paint.Align.LEFT
        return paint
    }

    private val padding: Int by lazy {
        context.resources.getDimensionPixelSize(R.dimen.dp_40)
    }


    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        val positiont = parent?.getChildAdapterPosition(view)
        if (callback.isHeader(positiont!!)) {
            outRect?.top = padding
        } else {
            outRect?.top = 0
        }
    }

    override fun onDraw(canvas: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.onDraw(canvas, parent, state)
        val left = parent?.left
        val right = parent?.width?.minus(parent.paddingRight)
        val count = parent?.childCount
        for (index in 0 until count!!) {
            val view = parent.getChildAt(index)
            val position = parent.getChildAdapterPosition(view)
            if (callback.isHeader(position)) {
                val string = callback.getChar(position)
                val top = view.top - padding
                val bottom = view.top
                canvas?.drawRect(left!!.toFloat(), top.toFloat(), right!!.toFloat(), bottom.toFloat(), rectPaint)
                canvas?.drawText(string, left!!.toFloat(), bottom.toFloat(), textPaint)
            }
        }
    }


    interface ISectionItemCallBack {
        fun isHeader(position: Int): Boolean
        fun getChar(position: Int): String
    }

}