package com.icephone.yuhao.repairerecord.view;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.icephone.yuhao.repairerecord.R;
import com.icephone.yuhao.repairerecord.Util.DialogUtil;
import com.icephone.yuhao.repairerecord.Util.StringConstant;
import com.icephone.yuhao.repairerecord.Util.TimeUtil;
import com.icephone.yuhao.repairerecord.Util.ToastUtil;
import com.icephone.yuhao.repairerecord.bean.RepairRecordBean;

import java.util.Calendar;

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
    @BindView(R.id.bt_submit)
    Button btSubmit;

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

    @BindView(R.id.ll_time)
    LinearLayout llTime;
    @BindView(R.id.rl_center_name)
    RelativeLayout rvCenterName;

    @OnClick(R.id.ll_time)
    void showTimeDialog() {
        DialogUtil.showDateDialog(this, calendar,new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                timeView.setText(TimeUtil.getShowTime(calendar));
                time = TimeUtil.getUploadTime(calendar);
            }
        });
    }

    @OnClick(R.id.rl_center_name)
    void chooseCenterName() {
        final String[] item = {"清苑联社", "满城联社"};
        DialogUtil.showSingleChooseDialog(this, "选择联社", item,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                },
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        center_name = item[which];
                        centerNameView.setText(item[which]);
                    }
                }
        );
    }

    @OnClick(R.id.iv_delete)
    void deleteRecord() {
        ToastUtil.showToastShort(this,"删除");
    }

    @OnClick(R.id.iv_edit)
    void editRecord() {
        setViewTouchable();
        ToastUtil.showToastShort(this,"编辑模式");
    }

    @OnClick(R.id.bt_submit)
    void submit() {
        if (isTextNull()) {
            //TODO 上传操作
            openActivity(SuccessActivity.class);
            finish();
        }
    }

    @OnClick(R.id.rl_back)
    void back() {
        onBackPressed();
    }


    private Calendar calendar = Calendar.getInstance(); //获取当前时间
    private String time = ""; //选择的时间，默认是当前时间
    private String site_name = "";
    private String repair_pro = "";
    private String repair_person = "";
    private String site_person = "";
    private String center_name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_detail);
        ButterKnife.bind(this);
        initDate();
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
                btSubmit.setVisibility(View.VISIBLE);
                addRecordView();
                break;
            case StringConstant.KEY_FIX_MODE:
                tvTitle.setText("修改记录");
                btSubmit.setVisibility(View.VISIBLE);
                break;
            case StringConstant.KEY_LOOK_MODE:
                tvTitle.setText("记录详情");
                btSubmit.setVisibility(View.GONE);
                putDataToView();
                break;
        }

    }

    @Override
    public void initDate() {

    }

    private boolean isTextNull() {
        if (time.equals("")) {
            ToastUtil.showToastShort(this,"请填写时间");
            return false;
        }
        if (center_name.equals("")) {
            ToastUtil.showToastShort(this,"请选择联社名称");
        }
        site_name = siteNameView.getText() == null ? "" : siteNameView.getText().toString();
        if (site_name.equals("")) {
            ToastUtil.showToastShort(this,"请填写网点全称");
            return false;
        }
        repair_pro = repairProView.getText() == null ? "" : repairProView.getText().toString();
        if (repair_pro.equals("")) {
            ToastUtil.showToastShort(this,"请填写维修项目");
            return false;
        }
        repair_person = repairPersonView.getText() == null ? "" : repairPersonView.getText().toString();
        if (repair_person.equals("")) {
            ToastUtil.showToastShort(this,"请填写维修人员");
            return false;
        }
        site_person = sitePersonView.getText() == null ? "" : sitePersonView.getText().toString();
        if (site_person.equals("")) {
            ToastUtil.showToastShort(this,"请填写网点人员");
            return false;
        }
        return true;
    }

    /**
     * 添加记录，把当前时间更新到对应时间
     */
    public void addRecordView() {
        time = TimeUtil.getUploadTime(calendar);
        timeView.setText(TimeUtil.getShowTime(calendar));
    }

    /**
     * 查看记录，把传过来的数据更新到View
     */
    public void putDataToView() {
        RepairRecordBean bean = (RepairRecordBean) getIntent().getSerializableExtra(StringConstant.KEY_TRANSFER_RECORD);

        time = bean.getTime();
        timeView.setText(TimeUtil.transferTimeToShow(time));

        center_name = bean.getCenter_name();
        centerNameView.setText(center_name);

        site_name = bean.getSite_name();
        siteNameView.setText(site_name);

        repair_person = bean.getRepair_person();
        repairPersonView.setText(repair_person);

        repair_pro = bean.getRepair_pro();
        repairProView.setText(repair_pro);

        site_person = bean.getSite_person();
        sitePersonView.setText(site_person);

        setViewUntouchable();
    }

    /**
     * 设置View不可编辑
     */
    public void setViewUntouchable() {
        llTime.setEnabled(false);
        rvCenterName.setEnabled(false);
        siteNameView.setFocusable(false);
        repairPersonView.setFocusable(false);
        sitePersonView.setFocusable(false);
        repairProView.setFocusable(false);
    }

    /**
     * 设置View可以编辑
     */
    public void setViewTouchable() {
        llTime.setEnabled(true);
        llTime.setEnabled(true);
        rvCenterName.setEnabled(true);
        rvCenterName.setFocusableInTouchMode(true);

        repairPersonView.setFocusable(true);
        repairPersonView.setFocusableInTouchMode(true);

        sitePersonView.setFocusable(true);
        sitePersonView.setFocusableInTouchMode(true);

        repairProView.setFocusable(true);
        repairProView.setFocusableInTouchMode(true);

        btSubmit.setVisibility(View.VISIBLE);
        siteNameView.setFocusable(true);
        siteNameView.setFocusableInTouchMode(true);
        siteNameView.requestFocus();
    }

}
