package com.lockscreen

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * @author liguoying
 * @date 2017/11/6.
 * http://dev.qq.com/topic/57875330c9da73584b025873
 */
class UnderView : View {
    private var mStartx: Int? = 0

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
        val action = event!!.action
        val nx: Float = event.x
        when (action) {
            MotionEvent.ACTION_DOWN -> {
                mStartx = nx.toInt()
                onAnimationEnd()
            }
            MotionEvent.ACTION_MOVE -> {
                handToMoveView(nx)
            }
            else -> {
            }
        }

    }

    private fun handToMoveView(nx: Float) {
        var moveX: Float = nx - mStartx!!.toInt()
        if (moveX < 0) moveX = 0F
    }
}