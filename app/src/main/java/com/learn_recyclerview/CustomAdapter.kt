package com.learn_recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidwebviewdemo.mddemo.R
import kotlinx.android.synthetic.main.item_rv_padding.view.*

/**
 * @author: GY.LEE
 * @date: 2019-08-13
 * @Des:
 */
class CustomAdapter(val context: Context) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private val list = mutableListOf<Word>()
    fun setData(wordsList: List<Word>) {
        if (list.isNotEmpty()) {
            list.clear()
        }
        list.addAll(wordsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_rv_padding, parent, false))


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titile.text = list[position].title
        holder.content.text = list[position].content
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titile = itemView.tvTitle
        val content = itemView.tvContent
    }
}