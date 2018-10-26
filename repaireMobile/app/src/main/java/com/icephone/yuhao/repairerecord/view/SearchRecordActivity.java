package com.icephone.yuhao.repairerecord.view;

import android.os.Bundle;

import com.icephone.yuhao.repairerecord.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchRecordActivity extends BaseActivity {

    @OnClick(R.id.rl_back)
    void back() {
        onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_record);
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
