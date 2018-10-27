package com.icephone.yuhao.repairerecord.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.icephone.yuhao.repairerecord.bean.RepairRecordBean;

import java.util.List;

public class RepairRecordAdapter extends BaseQuickAdapter<RepairRecordBean,BaseViewHolder> {


    public RepairRecordAdapter(int layoutResId, @Nullable List<RepairRecordBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RepairRecordBean item) {

    }

}
