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
import android.widget.TextView;

import com.icephone.yuhao.repairerecord.R;
import com.icephone.yuhao.repairerecord.Util.DialogUtil;
import com.icephone.yuhao.repairerecord.Util.StringConstant;
import com.icephone.yuhao.repairerecord.Util.TimeUtil;
import com.icephone.yuhao.repairerecord.Util.ToastUtil;

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


    @OnClick(R.id.ll_time)
    void showTimeDialog() {
        DialogUtil.showDateDialog(this, calendar,new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                timeView.setText(TimeUtil.getShowTime(calendar));
                timeStr = TimeUtil.getUploadTime(calendar);
            }
        });
    }

    @OnClick(R.id.rl_center_name)
    void chooseCenterName() {
        final String[] item = {"清苑联社", "满城联社"};
        DialogUtil.showSingalChooseDialog(this, "选择联社", item,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                },
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
        btSubmit.setVisibility(View.VISIBLE);
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


    private Calendar calendar = Calendar.getInstance(); //获取当前时间
    private String timeStr; //选择的时间，默认是当前时间

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

    /**
     * 添加记录View
     */
    public void addRecordView() {
        timeView.setText(TimeUtil.getShowTime(calendar));
    }

    /**
     * 查看记录
     */
    public void putDataToView() {

    }

    public void showDateDialog() {

    }

}
