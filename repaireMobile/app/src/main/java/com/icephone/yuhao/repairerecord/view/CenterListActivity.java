package com.icephone.yuhao.repairerecord.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.icephone.yuhao.repairerecord.R;
import com.icephone.yuhao.repairerecord.Util.DialogUtil;
import com.icephone.yuhao.repairerecord.Util.StringConstant;
import com.icephone.yuhao.repairerecord.Util.ToastUtil;
import com.icephone.yuhao.repairerecord.adapter.CenterAdapter;
import com.icephone.yuhao.repairerecord.bean.CenterBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CenterListActivity extends BaseActivity {

    @OnClick(R.id.fl_add_center)
    void addCenter() {
        View view = View.inflate(this, R.layout.layout_dialog_edit, null);
        final EditText editText = view.findViewById(R.id.et_add);
        DialogUtil.showEditTextDialog(this, "修改联社", view, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newCenterName = editText.getText() == null ? "" : editText.getText().toString();
                if (newCenterName.equals("")) {
                    ToastUtil.showToastShort(CenterListActivity.this, "请输入名称");
                } else {
                    // TODO 调用网络接口上传
                    ToastUtil.showToastShort(CenterListActivity.this, "添加成功");
                    dialog.dismiss();
                }
            }
        },null);
    }

    @OnClick(R.id.rl_back)
    void back() {
        onBackPressed();
    }

    @BindView(R.id.rv_center_list)
    RecyclerView rvCenterList;

    private CenterAdapter centerAdapter;
    private List<CenterBean.DataBean> centerBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_list);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        rvCenterList.setHasFixedSize(true);
        rvCenterList.setLayoutManager(new LinearLayoutManager(this));
        initDate();
        View emptyView = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) rvCenterList.getParent(), false);
        centerAdapter.setEmptyView(emptyView);
        centerAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString(StringConstant.KEY_SEARCH_CENTER_NAME,centerBeanList.get(position).getCenter_name());
                bundle.putString(StringConstant.KEY_SEARCH_START_TIME, "");
                bundle.putString(StringConstant.KEY_SEARCH_END_TIME, "");
                openActivity(ResultActivity.class, bundle);
            }
        });

        centerAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                DialogUtil.showAlertDialog(CenterListActivity.this, "确定删除吗", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO 删除操作。
                    }
                }, null);
                return true;
            }
        });
        rvCenterList.setAdapter(centerAdapter);
    }

    @Override
    public void initDate() {

        // TODO 全部改成网络获取的数据

//        centerBeanList.add(new CenterBean("1","清苑联社"));
//        centerBeanList.add(new CenterBean("2","满城联社"));

        centerAdapter = new CenterAdapter(R.layout.layout_simple_item,centerBeanList);
    }

}
