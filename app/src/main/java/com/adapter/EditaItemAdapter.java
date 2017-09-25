package com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.R;
import com.entity.DayEntity;
import com.lidroid.xutils.util.LogUtils;

import java.util.List;

/**
 * Created by liguoying on 2017/9/22.
 */

public class EditaItemAdapter extends RecyclerView.Adapter<EditaItemAdapter.EditaItemAdapterViewHolder> {
    private Context mContext;
    private List<DayEntity.ContentBean.DateBean> mDateBeans;

    private int mFirstPosition;
    private IItemSecondItemClick mIItemSecondItemClick;
    private boolean editAble;

    public EditaItemAdapter(Context context, List<DayEntity.ContentBean.DateBean> dateBeans, int position, boolean editAble) {
        mContext = context;
        mDateBeans = dateBeans;
        this.mFirstPosition = position;
        this.editAble = editAble;
    }

    @Override
    public EditaItemAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EditaItemAdapterViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_sigle_menu, parent, false));
    }

    @Override
    public void onBindViewHolder(final EditaItemAdapterViewHolder holder, final int position) {
        if (!editAble) {
            holder.mCutOrAdd.setVisibility(View.INVISIBLE);
        } else {
            holder.mCutOrAdd.setVisibility(View.VISIBLE);
        }
        holder.logo.setImageResource(R.mipmap.ic_category_0);
        holder.mCutOrAdd.setImageResource(R.mipmap.icon_add_menu);
        holder.name.setText(mDateBeans.get(position).getImage());
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIItemSecondItemClick.secondItemClick(position, mFirstPosition);
                LogUtils.e(position + "   " + mFirstPosition);
                holder.mCutOrAdd.setImageResource(R.mipmap.icon_selected_yes);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDateBeans.size();
    }

    class EditaItemAdapterViewHolder extends RecyclerView.ViewHolder {

        private ImageView logo;
        private TextView name;
        private ImageView mCutOrAdd;
        private RelativeLayout mRelativeLayout;

        public EditaItemAdapterViewHolder(View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.iv_image_edite_sigle);
            name = itemView.findViewById(R.id.tv_sigle_menu_name);
            mCutOrAdd = itemView.findViewById(R.id.iv_cancler_or_add);
            mRelativeLayout = itemView.findViewById(R.id.ll_item_second);
        }
    }

    public interface IItemSecondItemClick {
        void secondItemClick(int position, int firstPosition);
    }

    public void setSecondItemClick(IItemSecondItemClick mIItemSecondItemClick) {
        this.mIItemSecondItemClick = mIItemSecondItemClick;
    }
}
