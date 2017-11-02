package com.BRAVHAdapter;

import com.androidwebviewdemo.mddemo.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by ${liguoying} on 2017/7/24.
 */

public class BRAVHAdapter extends BaseQuickAdapter<DataEntity,BaseViewHolder>{

    public BRAVHAdapter(int item_bravh_adapter_view, List<DataEntity> list) {
        super(item_bravh_adapter_view,list);
    }

    @Override
    protected void convert(BaseViewHolder helper, DataEntity item) {
        helper.setText(R.id.tv_bravh_item_text, item.getName());
    }
}
