package cn.icephone.myapplication.net;


import cn.icephone.myapplication.bean.NewsBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dong on 18-3-16.
 */

public interface GetApiService {

    @GET("4/news/before/{date}")
    Call<NewsBean> getBean(
            @Query("q") String q
    );

}
