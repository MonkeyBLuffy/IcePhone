package com.icephone.yuhao.repairerecord.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.icephone.yuhao.repairerecord.bean.DeviceBean;

import java.util.List;

public class DeviceAdapter extends BaseQuickAdapter<DeviceBean.DataBean,BaseViewHolder> {

    public DeviceAdapter(int layoutResId, @Nullable List<DeviceBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DeviceBean.DataBean item) {

    }
}
