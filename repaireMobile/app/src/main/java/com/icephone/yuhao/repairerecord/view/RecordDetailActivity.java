package com.icephone.yuhao.repairerecord.view;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import com.icephone.yuhao.repairerecord.Util.StringFormatUtil;
import com.icephone.yuhao.repairerecord.Util.TimeUtil;
import com.icephone.yuhao.repairerecord.Util.ToastUtil;
import com.icephone.yuhao.repairerecord.bean.RepairRecordBean;
import com.icephone.yuhao.repairerecord.net.ApiBuilder;
import com.icephone.yuhao.repairerecord.net.URLConstant;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringJoiner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RecordDetailActivity extends BaseActivity {

    private Calendar calendar = Calendar.getInstance(); //获取当前时间
    private String _id = "";
    private String time = ""; //选择的时间，默认是当前时间
    private String site_name = "";
    private String repair_pro = "";
    private String repair_person = "";
    private String site_person = "";
    private String center_name = "";
    private String fix_details = "";
    private String fitting = "";
    private String returnFix = "";
    private String returnTime = "";


    private String[] item = {"监控", "报警", "其他"};
    private boolean[] itemIsChecked = {false, false, false};
    final List<String> chooseResult = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_detail);
        ButterKnife.bind(this);
        initDate();
        initView();
    }

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_delete)
    ImageView ivDelete;
    @BindView(R.id.iv_edit)
    ImageView ivEdit;
    @BindView(R.id.bt_submit)
    Button btSubmit;

    @BindView(R.id.tv_time) //时间（选择）
    TextView timeView;
    @BindView(R.id.tv_site_name) //网点名称（单选）
    TextView siteNameView;
    @BindView(R.id.tv_repair_pro) //维修项目（多选）
    TextView repairProView;
    @BindView(R.id.tv_repair_person) //维修人员（多选）
    TextView repairPersonView;
    @BindView(R.id.tv_center_name) //联社名称（单选）
    TextView centerNameView;
    @BindView(R.id.et_fix_details) //维修详情（填写）
    TextView fixDetailsView;
    @BindView(R.id.tv_fitting) //设备明细（多选）
    TextView fittingView;
    @BindView(R.id.et_site_person) //网点人员（填写）
    EditText sitePersonView;
    @BindView(R.id.tv_return_time) //返厂时间（选择）
    TextView returnTimeView;
    @BindView(R.id.tv_return_fix) //是否返厂维修（选择）
    TextView returnFixView;
    @BindView(R.id.et_cost) //花费（管理员填写）
    EditText costView;

    @BindView(R.id.ll_time)
    LinearLayout llTime;
    @BindView(R.id.rl_center_name)
    RelativeLayout rlCenterName;
    @BindView(R.id.rl_site_name)
    RelativeLayout rlSiteName;
    @BindView(R.id.rl_repair_pro)
    RelativeLayout rlRepairPro;
    @BindView(R.id.rl_repair_person)
    RelativeLayout rlRepairPerson;
    @BindView(R.id.rl_return_time)
    RelativeLayout rlReturnTime;
    @BindView(R.id.rl_return_fix)
    RelativeLayout rlReturnFix;
    @BindView(R.id.rl_fitting)
    RelativeLayout rlFitting;

    @OnClick(R.id.ll_time)
    void showTimeDialog() {
        DialogUtil.showDateDialog(this, calendar, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
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

    @OnClick(R.id.rl_site_name)
    void chooseSiteName() {
        final String[] item = {"营业部", "南王庄分社", "A分社", "B分社"};
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
                        site_name = item[which];
                        siteNameView.setText(item[which]);
                    }
                }
        );
    }

    @OnClick(R.id.rl_repair_pro)
    void chooseRepairPro() {
        // TODO 多选
        DialogUtil.showMultiChooseDialog(this, "选择维修项目", item, itemIsChecked,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        repair_pro = StringFormatUtil.ListToString(chooseResult);
                        repairProView.setText(repair_pro.equals("") ? "请选择维修人员" : repair_pro);
                        dialog.dismiss();
                    }
                }, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        itemIsChecked[which] = isChecked;
                        if (isChecked) {
                            chooseResult.add(item[which]);
                        } else {
                            chooseResult.remove(item[which]);
                        }
                    }
                });
    }

    @OnClick(R.id.rl_repair_person)
    void chooseRepairPerson() {
        final String[] item = {"小王", "小李", "小张", "小孙"};
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
                        repair_person = item[which];
                        repairPersonView.setText(item[which]);
                    }
                }
        );
    }

    @OnClick(R.id.rl_return_time)
    void chooseReturnTime() {
        DialogUtil.showDateDialog(this, calendar, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                returnTimeView.setText(TimeUtil.getShowTime(calendar));
                //TODO 添加变量
//                time = TimeUtil.getUploadTime(calendar);
            }
        });
    }

    @OnClick(R.id.rl_return_fix)
    void chooseReturnFix() {
        final String[] item = {"未返厂维修","返厂维修"};
        DialogUtil.showSingleChooseDialog(this, "选择是否返厂", item,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                },
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO 添加变量哦
                        returnFixView.setText(item[which]);
                    }
                }
        );
    }

    @OnClick(R.id.rl_fitting)
    void chooseFitting() {
        // TODO 选择配件，多选
    }

    @OnClick(R.id.iv_delete)
    void deleteRecord() {
        ToastUtil.showToastShort(this, "删除");
    }

    @OnClick(R.id.iv_edit)
    void editRecord() {
        setViewTouchable();
        ToastUtil.showToastShort(this, "编辑模式");
    }

    // 上传
    @OnClick(R.id.bt_submit)
    void submit() {
        if (isTextNull()) {
            //TODO 上传操作
            JSONObject jsonObject = new JSONObject();
            try {
                if (!_id.equals("")) {
                    jsonObject.put("_id", _id);
                }
                jsonObject.put("time", time);
                jsonObject.put("center_name", center_name);
                jsonObject.put("site_name", site_name);
                jsonObject.put("site_person", site_person);
                jsonObject.put("repair_pro", repair_pro);
                jsonObject.put("repair_person", repair_person);
                jsonObject.put("fix_details", fix_details);
                jsonObject.put("fitting", fitting);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
            ApiBuilder builder = new ApiBuilder()
                    .Url(URLConstant.UPLOAD_REPAIR_RECORD)
                    .Body(requestBody);

            openActivity(SuccessActivity.class);
            finish();
        }
    }

    @OnClick(R.id.rl_back)
    void back() {
        onBackPressed();
    }

    @Override
    public void initView() {

        String keyMode = getIntent().getStringExtra(StringConstant.KEY_MODE);
        switch (keyMode) {
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
            ToastUtil.showToastShort(this, "请填写时间");
            return false;
        }
        if (center_name.equals("")) {
            ToastUtil.showToastShort(this, "请选择联社名称");
        }
        if (site_name.equals("")) {
            ToastUtil.showToastShort(this, "请选择网点名称");
            return false;
        }
        site_person = sitePersonView.getText() == null ? "" : sitePersonView.getText().toString();
        if (site_person.equals("")) {
            ToastUtil.showToastShort(this, "请填写网点人员");
            return false;
        }
        if (repair_person.equals("")) {
            ToastUtil.showToastShort(this, "请选择维修人员");
            return false;
        }
        if (repair_pro.equals("")) {
            ToastUtil.showToastShort(this, "请选择维修项目");
            return false;
        }
        fix_details = fixDetailsView.getText() == null ? "" : fixDetailsView.getText().toString();
        if (fix_details.equals("")) {
            ToastUtil.showToastShort(this, "请填写维修详情");
            return false;
        }
        fitting = fittingView.getText() == null ? "" : fittingView.getText().toString();
        if (fitting.equals("")) {
            ToastUtil.showToastShort(this, "请填写配件清单");
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

        _id = bean.get_id();

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

        fix_details = bean.getFix_details();
        fixDetailsView.setText(fix_details);

        fitting = bean.getFittings();
        fittingView.setText(fitting);

        setViewUntouchable();
    }

    /**
     * 设置View不可编辑
     */
    public void setViewUntouchable() {
        llTime.setEnabled(false);
        rlCenterName.setEnabled(false);
        rlSiteName.setFocusable(false);
        rlRepairPro.setFocusable(false);
        rlRepairPerson.setFocusable(false);

        fittingView.setFocusable(false);
        sitePersonView.setFocusable(false);
        fixDetailsView.setFocusable(false);
    }

    /**
     * 设置View可以编辑
     */
    public void setViewTouchable() {

        llTime.setEnabled(true);
        rlCenterName.setEnabled(true);
        rlSiteName.setFocusable(true);
        rlRepairPro.setFocusable(true);
        rlRepairPerson.setFocusable(true);

        fittingView.setFocusable(true);
        fittingView.setFocusableInTouchMode(true);
        sitePersonView.setFocusable(true);
        sitePersonView.setFocusableInTouchMode(true);
        fixDetailsView.setFocusable(true);
        fixDetailsView.setFocusableInTouchMode(true);

        btSubmit.setVisibility(View.VISIBLE);
    }

}
