package com.icephone.yuhao.repairerecord.adapter;

import android.support.annotation.Nullable;

import com.icephone.yuhao.repairerecord.bean.CenterBean;
import com.icephone.yuhao.repairerecord.bean.PeopleBean;
import com.icephone.yuhao.repairerecord.bean.RepairRecordBean;

import java.util.List;

public class AdapterFacory {

    public static CenterAdapter getCenterAdapter(int layoutResId, @Nullable List<CenterBean> data) {
        return new CenterAdapter(layoutResId, data);
    }

    public static PeopleAdapter getPeopleAdapter(int layoutResId, @Nullable List<PeopleBean> data) {
        return new PeopleAdapter(layoutResId, data);
    }

    public static RepairRecordAdapter getRepairRecordAdater(int layoutResId, @Nullable List<RepairRecordBean> data) {
        return new RepairRecordAdapter(layoutResId, data);
    }

}
