package com.icephone.yuhao.repairerecord.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.icephone.yuhao.repairerecord.R;
import com.icephone.yuhao.repairerecord.Util.StringConstant;
import com.icephone.yuhao.repairerecord.Util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecordDetailActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_delete)
    ImageView ivDelete;
    @BindView(R.id.iv_edit)
    ImageView ivEdit;

    @BindView(R.id.tv_time)
    TextView timeView;
    @BindView(R.id.et_site_name)
    EditText siteNameView;
    @BindView(R.id.et_repair_pro)
    EditText repairProView;
    @BindView(R.id.et_repair_person)
    EditText repairPersonView;
    @BindView(R.id.et_site_person)
    EditText sitePersonView;
    @BindView(R.id.tv_center_name)
    TextView centerNameView;

    @OnClick(R.id.ll_time)
    void showTimeDialog() {
        ToastUtil.showToastShort(this,"展示时间选择控件");
    }

    @OnClick(R.id.rl_center_name)
    void chooseCenterName() {
        ToastUtil.showToastShort(this,"展示右边栏，选择联社");
    }

    @OnClick(R.id.iv_delete)
    void deleteRecord() {
        ToastUtil.showToastShort(this,"删除");
    }

    @OnClick(R.id.iv_edit)
    void editRecord() {
        ToastUtil.showToastShort(this,"编辑");
    }

    @OnClick(R.id.bt_submit)
    void submit() {
        ToastUtil.showToastShort(this,"提交");
    }

    @OnClick(R.id.rl_back)
    void back() {
        onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_detail);
        ButterKnife.bind(this);
        initView();
    }


    @Override
    public void initView() {

        String keyMode = getIntent().getStringExtra(StringConstant.KEY_MODE);
        switch (keyMode){
            case StringConstant.KEY_ADD_MODE:
                tvTitle.setText("添加记录");
                ivDelete.setVisibility(View.GONE);
                ivEdit.setVisibility(View.GONE);
                break;
            case StringConstant.KEY_FIX_MODE:
                tvTitle.setText("修改记录");
                break;
            case StringConstant.KEY_LOOK_MODE:
                tvTitle.setText("记录详情");
                break;
        }

    }

    @Override
    public void initDate() {

    }

}
