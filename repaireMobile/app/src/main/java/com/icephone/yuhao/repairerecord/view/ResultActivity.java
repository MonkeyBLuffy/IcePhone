package com.icephone.yuhao.repairerecord.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.icephone.yuhao.repairerecord.R;
import com.icephone.yuhao.repairerecord.adapter.RepairRecordAdapter;
import com.icephone.yuhao.repairerecord.bean.RepairRecordBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResultActivity extends BaseActivity {

    @BindView(R.id.rv_record_list)
    RecyclerView rvRecordList;

    @OnClick(R.id.rl_back)
    void back() {
        onBackPressed();
    }

    private RepairRecordAdapter recordAdapter;
    private List<RepairRecordBean> recordBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        initDate();
        initView();

    }

    @Override
    public void initView() {
        View emptyView = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) rvRecordList.getParent(), false);
        recordAdapter.setEmptyView(emptyView);
        recordAdapter.openLoadAnimation();
    }

    @Override
    public void initDate() {
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社"));
        recordBeanList.add(new RepairRecordBean("1", "20180909", "营业部", "维修监控", "李四", "小二", "清苑联社"));
        recordBeanList.add(new RepairRecordBean("1", "20180908", "营业部", "维修对讲", "李四", "小李", "清苑联社"));
        recordAdapter = new RepairRecordAdapter(R.layout.layout_repaire_item, recordBeanList);

    }
}
