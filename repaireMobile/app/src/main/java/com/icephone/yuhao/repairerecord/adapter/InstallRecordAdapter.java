package com.icephone.yuhao.repairerecord.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.icephone.yuhao.repairerecord.bean.InstallRecordBean;

import java.util.List;

public class InstallRecordAdapter extends BaseQuickAdapter<InstallRecordBean.DataBean,BaseViewHolder> {

    public InstallRecordAdapter(int layoutResId, @Nullable List<InstallRecordBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, InstallRecordBean.DataBean item) {

    }
}
