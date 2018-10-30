package com.icephone.yuhao.repairerecord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.icephone.yuhao.repairerecord.Util.StringConstant;
import com.icephone.yuhao.repairerecord.view.BaseActivity;
import com.icephone.yuhao.repairerecord.view.CenterListActivity;
import com.icephone.yuhao.repairerecord.view.InstallRecordDetailActivity;
import com.icephone.yuhao.repairerecord.view.ManageFittingAvtivity;
import com.icephone.yuhao.repairerecord.view.ManagePeopleActivity;
import com.icephone.yuhao.repairerecord.view.ManageRepairProActivity;
import com.icephone.yuhao.repairerecord.view.ManageSiteActivity;
import com.icephone.yuhao.repairerecord.view.RecordDetailActivity;
import com.icephone.yuhao.repairerecord.view.SearchRecordActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @OnClick(R.id.cv_search_record)
    void searchRecord() {
        openActivity(SearchRecordActivity.class);
    }

    @OnClick(R.id.cv_add_record)
    void addRecord() {
        Bundle bundle = new Bundle();
        bundle.putString(StringConstant.KEY_MODE,StringConstant.KEY_ADD_MODE);
        openActivity(RecordDetailActivity.class,bundle);
    }

    @OnClick(R.id.cv_manage_center)
    void manageCenter() {
        openActivity(CenterListActivity.class);
    }

    @OnClick(R.id.cv_repair_pro)
    void repairProject() {
        openActivity(ManageRepairProActivity.class);
    }

    @OnClick(R.id.cv_manage_people)
    void managePeople() {
        openActivity(ManagePeopleActivity.class);
    }

    @OnClick(R.id.cv_site_manage)
    void manageSite() {
        openActivity(ManageSiteActivity.class);
    }

    @OnClick(R.id.cv_install)
    void manageRepairPro() {
        openActivity(InstallRecordDetailActivity.class);
    }

    @OnClick(R.id.cv_manage_fitting)
    void manageFitting() {
        openActivity(ManageFittingAvtivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }


    @Override
    public void initView() {

    }

    @Override
    public void initDate() {

    }
}
