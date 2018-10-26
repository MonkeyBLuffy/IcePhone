package com.icephone.yuhao.repairerecord.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.icephone.yuhao.repairerecord.bean.RequireRecordBean;

import java.util.List;

public class RepaireRecordAdapter extends BaseQuickAdapter<RequireRecordBean,BaseViewHolder> {


    public RepaireRecordAdapter(int layoutResId, @Nullable List<RequireRecordBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RequireRecordBean item) {

    }

}
