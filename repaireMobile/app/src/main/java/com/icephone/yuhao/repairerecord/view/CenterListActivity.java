package com.icephone.yuhao.repairerecord.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.icephone.yuhao.repairerecord.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CenterListActivity extends BaseActivity {

    @OnClick(R.id.rl_back)
    void back() {
        onBackPressed();
    }

    @BindView(R.id.rv_center_list)
    RecyclerView rvCenterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_list);
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
