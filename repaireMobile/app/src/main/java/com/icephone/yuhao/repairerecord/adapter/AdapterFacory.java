package com.icephone.yuhao.repairerecord.adapter;

import android.support.annotation.Nullable;

import com.icephone.yuhao.repairerecord.bean.CenterBean;
import com.icephone.yuhao.repairerecord.bean.DeviceBean;
import com.icephone.yuhao.repairerecord.bean.InstallRecordBean;
import com.icephone.yuhao.repairerecord.bean.PeopleBean;
import com.icephone.yuhao.repairerecord.bean.ProjectBean;
import com.icephone.yuhao.repairerecord.bean.RepairRecordBean;
import com.icephone.yuhao.repairerecord.bean.SiteBean;

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

    public static DeviceAdapter getDeviceAdapter(int layoutResId, @Nullable List<DeviceBean> data) {
        return new DeviceAdapter(layoutResId, data);
    }

    public static InstallRecordAdapter getInstallRecordAdapter(int layoutResId, @Nullable List<InstallRecordBean> data) {
        return new InstallRecordAdapter(layoutResId, data);
    }

    public static ProjectAdapter getProjectAdapter(int layoutResId, @Nullable List<ProjectBean> data) {
        return new ProjectAdapter(layoutResId, data);
    }

    public static SiteAdapter getSiteAdapter(int layoutResId, @Nullable List<SiteBean> data) {
        return new SiteAdapter(layoutResId, data);
    }

}
