package com.icephone.yuhao.repairerecord.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.icephone.yuhao.repairerecord.R;
import com.icephone.yuhao.repairerecord.bean.PeopleBean;

import java.util.List;

public class PeopleAdapter extends BaseQuickAdapter<PeopleBean,BaseViewHolder> {

    public PeopleAdapter(int layoutResId, @Nullable List<PeopleBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PeopleBean item) {
        helper.setText(R.id.tv_name, item.getNick_name());
    }
}
