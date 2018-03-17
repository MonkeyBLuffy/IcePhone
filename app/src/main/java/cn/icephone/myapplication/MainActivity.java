package cn.icephone.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import cn.icephone.myapplication.bean.NewsBean;
import cn.icephone.myapplication.net.GetApiService;
import cn.icephone.myapplication.net.RetrofitManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private NewsBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitManager.getInstance().create(GetApiService.class)
                .getBean("20131119")
                .enqueue(new Callback<NewsBean>() {
                    @Override
                    public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                        Log.d("test", response.body().getStories().get(0).getTitle());
                    }

                    @Override
                    public void onFailure(Call<NewsBean> call, Throwable t) {

                    }
                });
    }

}
