package com.icephone.yuhao.repairerecord.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.icephone.yuhao.repairerecord.R;
import com.icephone.yuhao.repairerecord.bean.CenterBean;

import java.util.List;

public class CenterAdapter extends BaseQuickAdapter<CenterBean,BaseViewHolder> {

    public CenterAdapter(int layoutResId, @Nullable List<CenterBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CenterBean item) {
        helper.setText(R.id.tv_center_name, item.getCenterName());
    }

}
