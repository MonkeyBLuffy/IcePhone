package com.icephone.yuhao.repairerecord.view;

import android.Manifest;
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
import com.icephone.yuhao.repairerecord.adapter.RepairRecordAdapter;
import com.icephone.yuhao.repairerecord.bean.CenterBean;
import com.icephone.yuhao.repairerecord.bean.GetResultBean;
import com.icephone.yuhao.repairerecord.bean.RepairRecordBean;
import com.icephone.yuhao.repairerecord.net.ApiBuilder;
import com.icephone.yuhao.repairerecord.net.ApiClient;
import com.icephone.yuhao.repairerecord.net.CallBack;
import com.icephone.yuhao.repairerecord.net.URLConstant;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;

public class ResultActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {

    private final int READ_WRITE_MEMORY = 0;

    @BindView(R.id.rv_record_list)
    RecyclerView rvRecordList;

    @OnClick(R.id.rl_back)
    void back() {
        onBackPressed();
    }

    @OnClick(R.id.tv_output)
    void output() {
        // TODO 导出文件和权限
        ToastUtil.showToastShort(this,"导出文件");
        requestReadFilePermissions();
    }

    private RepairRecordAdapter recordAdapter;
    private List<RepairRecordBean.DataBean> recordBeanList = new ArrayList<>();

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
        recordAdapter = AdapterFacory.getRepairRecordAdater(R.layout.layout_repaire_item, recordBeanList);
        recordAdapter.setEmptyView(emptyView);
        recordAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        recordAdapter.isFirstOnly(false);
        recordAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString(StringConstant.KEY_MODE, StringConstant.KEY_LOOK_MODE); //点击这个维修项，然后查看详细
                bundle.putSerializable(StringConstant.KEY_TRANSFER_RECORD, recordBeanList.get(position));
                openActivity(RecordDetailActivity.class, bundle);
            }
        });
        rvRecordList.setLayoutManager(new LinearLayoutManager(this));
        rvRecordList.setAdapter(recordAdapter);
    }

    @Override
    public void initDate() {
        refreshList();
    }

    /**
     * 申请查看相册权限
     */
    private void requestReadFilePermissions() {
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}; //读写权限
        //判断有没有权限读写权限
        if (EasyPermissions.hasPermissions(this, perms)) {
            // 如果有权限了
            //TODO 打开相册
            Log.i("permission", "打开相册");
            outputFile();
        } else {
            // 如果没有权限, 就去申请权限
            // this: 上下文
            // Dialog显示的正文
            // RC_CAMERA_AND_RECORD_AUDIO 请求码, 用于回调的时候判断是哪次申请
            // perms 就是你要申请的权限
            EasyPermissions.requestPermissions(this, "需要读取相册", READ_WRITE_MEMORY, perms);
        }
    }

    private void outputFile() {
        KProgressHUD dialog = KProgressHUD.create(ResultActivity.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setDetailsLabel("正在导出文件")
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);
        dialog.show();
        String[] title = {"时间", "联社名称", "网点全称", "网点人员", "维修人员","维修项目","更换设备明细","维修详细","是否返厂维修","维修费","返厂返回时间"};
    }

    //查询列表
    private void refreshList() {
        String centerName, startTime, endTime;
        centerName = getIntent().getStringExtra(StringConstant.KEY_SEARCH_CENTER_NAME);
        startTime = getIntent().getStringExtra(StringConstant.KEY_SEARCH_START_TIME);
        endTime = getIntent().getStringExtra(StringConstant.KEY_SEARCH_END_TIME);
//        Log.i("维修查询参数Result", centerName + ":" + startTime + "--" + endTime);

        ApiBuilder builder = new ApiBuilder().Url(URLConstant.REPAIR_GET_LIST)
                .Params("center_name", centerName)
                .Params("start_time", startTime)
                .Params("end_time", endTime);
        ApiClient.getInstance().doGet(builder, new CallBack<RepairRecordBean>() {
            @Override
            public void onResponse(RepairRecordBean data) {
                if (data.getCode() == URLConstant.SUCCUSS_CODE) {
                    if (data.getData() != null) {
                        recordBeanList = data.getData();
                        recordAdapter.setNewData(recordBeanList);
//                        rvSiteList.setAdapter(siteAdapter);
                    }
                } else {
                    ToastUtil.showToastShort(ResultActivity.this, "查询失败请重试");
                }
            }

            @Override
            public void onFail(String msg) {
                ToastUtil.showToastShort(ResultActivity.this, "查询失败请重试");
            }
        }, RepairRecordBean.class);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }
}
