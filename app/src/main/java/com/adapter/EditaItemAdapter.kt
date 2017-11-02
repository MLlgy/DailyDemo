package com.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.androidwebviewdemo.mddemo.R
import com.entity.DayEntity
import com.lidroid.xutils.util.LogUtils

/**
 * Created by liguoying on 2017/9/22.
 */

class EditaItemAdapter(val mContext: Context, val mDateBeans: List<DayEntity.ContentBean.DateBean>, val mFirstPosition: Int, val editAble: Boolean) : RecyclerView.Adapter<EditaItemAdapter.EditaItemAdapterViewHolder>() {
    private var mIItemSecondItemClick: IItemSecondItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditaItemAdapterViewHolder {
        return EditaItemAdapterViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_sigle_menu, parent, false))
    }

    override fun onBindViewHolder(holder: EditaItemAdapterViewHolder, position: Int) {
        if (!editAble) {
            holder.mCutOrAdd.visibility = View.INVISIBLE
        } else {
            holder.mCutOrAdd.visibility = View.VISIBLE
        }
        holder.logo.setImageResource(R.mipmap.ic_category_0)
        if (mDateBeans[position].status == 1) {
            holder.mCutOrAdd.setImageResource(R.mipmap.icon_add_menu)
        } else {
            holder.mCutOrAdd.setImageResource(R.mipmap.icon_selected_yes)

        }
        holder.name.text = mDateBeans[position].image
        holder.mRelativeLayout.setOnClickListener {
            if (mDateBeans[position].status == 1) {
                holder.mCutOrAdd.setImageResource(R.mipmap.icon_selected_yes)
                mIItemSecondItemClick!!.secondItemClick(position, mFirstPosition)
            }
            LogUtils.e(position.toString() + "   " + mFirstPosition)
        }
    }

    override fun getItemCount(): Int {
        return mDateBeans.size
    }

    inner class EditaItemAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val logo: ImageView
        val name: TextView
        val mCutOrAdd: ImageView
        val mRelativeLayout: RelativeLayout

        init {
            logo = itemView.findViewById<ImageView>(R.id.iv_image_edite_sigle)
            name = itemView.findViewById<TextView>(R.id.tv_sigle_menu_name)
            mCutOrAdd = itemView.findViewById<ImageView>(R.id.iv_cancler_or_add)
            mRelativeLayout = itemView.findViewById<RelativeLayout>(R.id.ll_item_second)
        }
    }

    interface IItemSecondItemClick {
        fun secondItemClick(position: Int, firstPosition: Int)
    }

    fun setSecondItemClick(mIItemSecondItemClick: IItemSecondItemClick) {
        this.mIItemSecondItemClick = mIItemSecondItemClick
    }
}
