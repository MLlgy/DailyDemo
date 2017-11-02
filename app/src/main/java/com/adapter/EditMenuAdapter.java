package com.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidwebviewdemo.mddemo.R;
import com.entity.DayEntity;

import java.util.List;

/**
 * Created by liguoying on 2017/9/22.
 */

public class EditMenuAdapter extends RecyclerView.Adapter<EditMenuAdapter.EditMenuViewHolder> {
    private List<DayEntity.ContentBean> mList;
    private Context mContext;
    private RecyclerView mEditRecyclerview;
    private EditaItemAdapter mAdapter;
    private IItemFirstItemClick mIItemSecondItemClick;
    private boolean editAble;

    public boolean isEditAble() {
        return editAble;
    }

    public void setEditAble(boolean editAble) {
        this.editAble = editAble;
    }

    public EditMenuAdapter(List<DayEntity.ContentBean> list, Context context, boolean editAble) {
        mList = list;
        mContext = context;
        this.editAble = editAble;
    }

    @Override
    public EditMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EditMenuViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_edit_menu, parent, false));
    }

    @Override
    public void onBindViewHolder(EditMenuViewHolder holder, final int position) {
        mEditRecyclerview = holder.mRecyclerView;
        holder.mTitle.setText(mList.get(position).getName());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 4);
        mAdapter = new EditaItemAdapter(mContext, mList.get(position).getDate(), position,editAble);
        mEditRecyclerview.setLayoutManager(gridLayoutManager);
        mEditRecyclerview.setAdapter(mAdapter);
        mAdapter.setSecondItemClick(new EditaItemAdapter.IItemSecondItemClick() {
            @Override
            public void secondItemClick(int position, int firstPosition) {
                mIItemSecondItemClick.setIItemFirstItemClick(position, firstPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class EditMenuViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView mRecyclerView;
        private TextView mTitle;
        private LinearLayout mLinearLayout;

        public EditMenuViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_menu_name);
            mRecyclerView = itemView.findViewById(R.id.rl_item_menu);
            mLinearLayout = itemView.findViewById(R.id.ll_item_first);
        }
    }

    public interface IItemFirstItemClick {
        void setIItemFirstItemClick(int position, int seconPosition);
    }

    public void setIItemFirstItemClick(IItemFirstItemClick iItemFirstItemClick) {
        mIItemSecondItemClick = iItemFirstItemClick;
    }
}
