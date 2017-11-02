package com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidwebviewdemo.mddemo.R;
import com.entity.DayEntity;

import java.util.List;

/**
 * Created by liguoying on 2017/9/25.
 */

public class MyEditMenuAdapter extends RecyclerView.Adapter<MyEditMenuAdapter.MyApplicationAdapterViewHolder> {

    private Context mContext;
    private List<DayEntity.ContentBean.DateBean> mDateBeans;
    private IMyApplicationItemClick myApplicationItemClick;

    public MyEditMenuAdapter(Context context, List<DayEntity.ContentBean.DateBean> dateBeans) {
        mContext = context;
        mDateBeans = dateBeans;
    }

    @Override
    public MyEditMenuAdapter.MyApplicationAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyApplicationAdapterViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_sigle_menu, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyEditMenuAdapter.MyApplicationAdapterViewHolder holder, final int position) {
        holder.logo.setImageResource(R.mipmap.ic_category_0);
        holder.mCutOrAdd.setImageResource(R.mipmap.icon_selected_cancle);
        holder.name.setText(mDateBeans.get(position).getImage());
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myApplicationItemClick.secondItemClick(position);
//                myApplicationItemClick.secondItemClick(position, mFirstPosition);
//                LogUtils.e(position + "   " + mFirstPosition);
//                holder.mCutOrAdd.setImageResource(R.mipmap.icon_selected_yes);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDateBeans.size();
    }

    class MyApplicationAdapterViewHolder extends RecyclerView.ViewHolder {

        private ImageView logo;
        private TextView name;
        private ImageView mCutOrAdd;
        private RelativeLayout mRelativeLayout;

        public MyApplicationAdapterViewHolder(View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.iv_image_edite_sigle);
            name = itemView.findViewById(R.id.tv_sigle_menu_name);
            mCutOrAdd = itemView.findViewById(R.id.iv_cancler_or_add);
            mRelativeLayout = itemView.findViewById(R.id.ll_item_second);
        }
    }

    public interface IMyApplicationItemClick {
        void secondItemClick(int position);
    }

    public void setSecondItemClick(IMyApplicationItemClick myApplicationItemClick) {
        this.myApplicationItemClick = myApplicationItemClick;
    }
}
