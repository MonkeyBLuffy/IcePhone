package com.icephone.yuhao.repairerecord.view;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.icephone.yuhao.repairerecord.R;
import com.icephone.yuhao.repairerecord.Util.DialogUtil;
import com.icephone.yuhao.repairerecord.Util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ManageRepairProActivity extends BaseActivity {

    @OnClick(R.id.fl_add)
    void add() {
        View view = View.inflate(this, R.layout.layout_dialog_edit, null);
        final EditText editText = view.findViewById(R.id.et_add);
        DialogUtil.showEditTextDialog(this, "添加维修项目", view, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newCenterName = editText.getText() == null ? "" : editText.getText().toString();
                if (newCenterName.equals("")) {
                    ToastUtil.showToastShort(ManageRepairProActivity.this, "请输入项目名称");
                } else {
                    // TODO 调用网络接口上传
                    ToastUtil.showToastShort(ManageRepairProActivity.this, "添加成功");
                    dialog.dismiss();
                }
            }
        },null);
    }

    @OnClick(R.id.rl_back)
    void back() {
        onBackPressed();
    }

    @BindView(R.id.rv_repair_pro_list)
    RecyclerView rvCenterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_repair_pro);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initDate() {

    }
}
