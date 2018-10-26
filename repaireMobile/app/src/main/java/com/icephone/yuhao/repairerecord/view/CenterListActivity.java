package com.icephone.yuhao.repairerecord.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.icephone.yuhao.repairerecord.R;
import com.icephone.yuhao.repairerecord.Util.ToastUtil;
import com.icephone.yuhao.repairerecord.adapter.CenterAdapter;
import com.icephone.yuhao.repairerecord.bean.CenterBean;

import java.util.ArrayList;
import java.util.List;

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

    private CenterAdapter centerAdapter;
    private List<CenterBean> centerBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_list);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        rvCenterList.setHasFixedSize(true);
        rvCenterList.setLayoutManager(new LinearLayoutManager(this));
        initDate();
        View emptyView = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) rvCenterList.getParent(), false);
        centerAdapter.setEmptyView(emptyView);
        centerAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtil.showToastShort(getApplicationContext(),centerBeanList.get(position).getCenterName());
            }
        });
        rvCenterList.setAdapter(centerAdapter);
    }

    @Override
    public void initDate() {

        centerBeanList.add(new CenterBean("1","清苑联社"));
        centerBeanList.add(new CenterBean("2","满城联社"));

        centerAdapter = new CenterAdapter(R.layout.layout_center_item,centerBeanList);
    }
}
