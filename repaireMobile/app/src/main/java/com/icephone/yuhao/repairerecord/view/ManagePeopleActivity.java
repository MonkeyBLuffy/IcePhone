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

public class ManagePeopleActivity extends BaseActivity {

    @OnClick(R.id.fl_add)
    void add() {
        View view = View.inflate(this, R.layout.layout_dialog_edit, null);
        final EditText editText = view.findViewById(R.id.et_add);

        //TODO 人员管理的页面稍微复杂一些，需要同时设置账号密码

        DialogUtil.showEditTextDialog(this, "添加人员", view, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newCenterName = editText.getText() == null ? "" : editText.getText().toString();
                if (newCenterName.equals("")) {
                    ToastUtil.showToastShort(ManagePeopleActivity.this, "请输入维修人员");
                } else {
                    // TODO 调用网络接口上传
                    ToastUtil.showToastShort(ManagePeopleActivity.this, "添加成功");
                    dialog.dismiss();
                }
            }
        },null);
    }

    @OnClick(R.id.rl_back)
    void back() {
        onBackPressed();
    }

    @BindView(R.id.rv_people_list)
    RecyclerView rvPeopleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_people);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initDate() {

    }
}
