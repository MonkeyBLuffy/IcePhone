package com.icephone.yuhao.repairerecord.view;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
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
import com.icephone.yuhao.repairerecord.adapter.PeopleAdapter;
import com.icephone.yuhao.repairerecord.bean.PeopleBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ManagePeopleActivity extends BaseActivity {

    private List<PeopleBean> peopleBeanList = new ArrayList<>();
    private PeopleAdapter peopleAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_people);
        ButterKnife.bind(this);
        initDate();
        initView();
    }

    @OnClick(R.id.fl_add)
    void add() {
        //TODO 人员管理的页面稍微复杂一些，需要同时设置账号密码
    }

    @OnClick(R.id.rl_back)
    void back() {
        onBackPressed();
    }

    @BindView(R.id.rv_people_list)
    RecyclerView rvPeopleList;

    @Override
    public void initView() {
        rvPeopleList.setLayoutManager(new LinearLayoutManager(this));
        View emptyView = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) rvPeopleList.getParent(), false);
        peopleAdapter.setEmptyView(emptyView);
        peopleAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                // 需要传递各种数据
                openActivity(PeopleDetailActivity.class);
            }
        });
        rvPeopleList.setAdapter(peopleAdapter);
    }

    @Override
    public void initDate() {
        peopleBeanList.add(new PeopleBean("1","小张","123","123","管理员","清苑联社"));
        peopleBeanList.add(new PeopleBean("2","小王","123","123","管理员","清苑联社"));
        peopleBeanList.add(new PeopleBean("3","小王","123","123","管理员","清苑联社"));
        peopleAdapter = new PeopleAdapter(R.layout.layout_simple_item,peopleBeanList);
    }
}
