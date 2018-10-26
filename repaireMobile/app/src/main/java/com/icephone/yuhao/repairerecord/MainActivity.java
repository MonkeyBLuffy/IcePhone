package com.icephone.yuhao.repairerecord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.icephone.yuhao.repairerecord.Util.StringConstant;
import com.icephone.yuhao.repairerecord.view.BaseActivity;
import com.icephone.yuhao.repairerecord.view.CenterListActivity;
import com.icephone.yuhao.repairerecord.view.RecordDetailActivity;
import com.icephone.yuhao.repairerecord.view.SearchRecordActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @OnClick(R.id.cv_search_record)
    void searchRecord() {
        toOtherActivity(SearchRecordActivity.class);
    }

    @OnClick(R.id.cv_add_record)
    void addRecord() {
        Bundle bundle = new Bundle();
        bundle.putString(StringConstant.KEY_MODE,StringConstant.KEY_ADD_MODE);
        toOtherActivity(RecordDetailActivity.class,bundle);
    }

    @OnClick(R.id.cv_manage_center)
    void manageCenter() {
        toOtherActivity(CenterListActivity.class);
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
