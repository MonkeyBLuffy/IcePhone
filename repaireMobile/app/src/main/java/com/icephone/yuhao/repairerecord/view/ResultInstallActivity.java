package com.icephone.yuhao.repairerecord.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.icephone.yuhao.repairerecord.R;
import com.icephone.yuhao.repairerecord.Util.StringConstant;
import com.icephone.yuhao.repairerecord.adapter.RepairRecordAdapter;
import com.icephone.yuhao.repairerecord.bean.RepairRecordBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResultInstallActivity extends BaseActivity {

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
        recordAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        recordAdapter.isFirstOnly(false);
        recordAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString(StringConstant.KEY_MODE, StringConstant.KEY_LOOK_MODE); //点击这个维修项，然后查看详细
                bundle.putSerializable(StringConstant.KEY_TRANSFER_RECORD,recordBeanList.get(position));
                openActivity(RecordDetailActivity.class,bundle);
            }
        });
        rvRecordList.setLayoutManager(new LinearLayoutManager(this));
        rvRecordList.setAdapter(recordAdapter);
    }

    @Override
    public void initDate() {
        String centerName, startTime, endTime;
        centerName = getIntent().getStringExtra(StringConstant.KEY_SEARCH_CENTER_NAME);
        startTime = getIntent().getStringExtra(StringConstant.KEY_SEARCH_START_TIME);
        endTime = getIntent().getStringExtra(StringConstant.KEY_SEARCH_END_TIME);
        Log.i("查询结果Result", centerName + ":" + startTime + "--" + endTime);
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));
        recordBeanList.add(new RepairRecordBean("1", "20180910", "南王庄分社", "维修电视", "小王", "小张", "清苑联社", "差不多修好了", "一个扳手"));


        recordAdapter = new RepairRecordAdapter(R.layout.layout_repaire_item, recordBeanList);
    }
}
