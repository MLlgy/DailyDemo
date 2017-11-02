package com.myrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.androidwebviewdemo.mddemo.R;

import java.util.List;

/**
 * Created by Monkey
 * on 2016/10/15.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {
    private List<String> mList;


    private OnitemClickListenr onitemClickListener;

    public void setOnClickListener(OnitemClickListenr onitemClickListener){
        this.onitemClickListener = onitemClickListener;
    }

    public interface OnitemClickListenr{
        void onItemClickListener(View v,int i);
    }




    public RecyclerAdapter (List<String>mList){
        this.mList = mList;

    }
    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_item,parent,false);
        return new myViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
//        holder.textView.setText(mList.get(position)+position);
//        (myViewHolder)holder.itemView.setTe

        holder.textView.setText(mList.get(position)+position);


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textView;
        public myViewHolder(View view){
            super(view);
            textView = (TextView) view;
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onitemClickListener != null) {
                onitemClickListener.onItemClickListener(v,getPosition());
            }
        }
    }
}
