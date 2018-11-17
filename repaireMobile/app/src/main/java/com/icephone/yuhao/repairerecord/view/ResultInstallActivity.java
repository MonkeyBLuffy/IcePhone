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
import com.icephone.yuhao.repairerecord.Util.ToastUtil;
import com.icephone.yuhao.repairerecord.adapter.AdapterFacory;
import com.icephone.yuhao.repairerecord.adapter.InstallRecordAdapter;
import com.icephone.yuhao.repairerecord.adapter.RepairRecordAdapter;
import com.icephone.yuhao.repairerecord.bean.InstallRecordBean;
import com.icephone.yuhao.repairerecord.bean.RepairRecordBean;
import com.icephone.yuhao.repairerecord.net.ApiBuilder;
import com.icephone.yuhao.repairerecord.net.ApiClient;
import com.icephone.yuhao.repairerecord.net.CallBack;
import com.icephone.yuhao.repairerecord.net.URLConstant;

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

    @OnClick(R.id.tv_output)
    void outputFile() {
        ToastUtil.showToastShort(this,"导出文件");
    }

    private InstallRecordAdapter recordAdapter;
    private List<InstallRecordBean.DataBean> recordBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_install);
        ButterKnife.bind(this);
        initDate();
        initView();
    }

    @Override
    public void initView() {
        View emptyView = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) rvRecordList.getParent(), false);
        recordAdapter = AdapterFacory.getInstallRecordAdapter(R.layout.layout_repaire_item,recordBeanList);
        recordAdapter.setEmptyView(emptyView);
        recordAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        recordAdapter.isFirstOnly(false);
        recordAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString(StringConstant.KEY_MODE, StringConstant.KEY_LOOK_MODE); //点击这个维修项，然后查看详细
                bundle.putSerializable(StringConstant.KEY_TRANSFER_RECORD,recordBeanList.get(position));
                openActivity(InstallRecordDetailActivity.class,bundle);
            }
        });
        rvRecordList.setLayoutManager(new LinearLayoutManager(this));
        rvRecordList.setAdapter(recordAdapter);
    }

    @Override
    public void initDate() {
        refreshList();
    }

    private void refreshList() {
        String centerName, startTime, endTime;
        centerName = getIntent().getStringExtra(StringConstant.KEY_SEARCH_CENTER_NAME);
        startTime = getIntent().getStringExtra(StringConstant.KEY_SEARCH_START_TIME);
        endTime = getIntent().getStringExtra(StringConstant.KEY_SEARCH_END_TIME);
        Log.i("查询参数Result", centerName + ":" + startTime + "--" + endTime);

        ApiBuilder builder = new ApiBuilder().Url(URLConstant.INSTALL_GET_LIST)
                .Params("center_name", centerName)
                .Params("start_time", startTime)
                .Params("end_time", endTime);
        ApiClient.getInstance().doGet(builder, new CallBack<InstallRecordBean>() {
            @Override
            public void onResponse(InstallRecordBean data) {
                if (data.getCode() == URLConstant.SUCCUSS_CODE) {
                    if (data.getData() != null) {
                        recordBeanList = data.getData();
                        recordAdapter.setNewData(recordBeanList);
//                        rvSiteList.setAdapter(siteAdapter);
                    }
                } else {
                    ToastUtil.showToastShort(ResultInstallActivity.this, "查询失败请重试");
                }
            }

            @Override
            public void onFail(String msg) {
                ToastUtil.showToastShort(ResultInstallActivity.this, "查询失败请重试");
            }
        }, InstallRecordBean.class);
    }
}
