package com.bewei.retrofit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bewei.retrofit.R;
import com.bewei.retrofit.api.Api;
import com.bewei.retrofit.bean.News;
import com.bewei.retrofit.bean.Party;
import com.bewei.retrofit.bean.User;
import com.bewei.retrofit.inter.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // getNoParams();
      //  getHasParams();
       // getHasParams2();
        register();
    }
  //post请求
    private void register() {
        //创建Retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.baseUrl4).addConverterFactory(GsonConverterFactory.create()).build();
        ////通过动态代理的方式得到网络接口对象
        ApiService apiService = retrofit.create(ApiService.class);
        Call<User> call = apiService.register("13511237846", "123456");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }

    //有参get请求
    private void getHasParams2() {
        //创建Retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.baseUrl3).addConverterFactory(GsonConverterFactory.create()).build();
        ////通过动态代理的方式得到网络接口对象
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Party> call = apiService.getHasParams2(0, 0);
        call.enqueue(new Callback<Party>() {
            @Override
            public void onResponse(Call<Party> call, Response<Party> response) {
                Party party = response.body();
                String result = party.getResult();
                Log.i("xxx",result);
            }

            @Override
            public void onFailure(Call<Party> call, Throwable t) {

            }
        });

    }

    //有参get请求
    private void getHasParams() {
        //创建Retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.baseUrl2).addConverterFactory(GsonConverterFactory.create()).build();
        ////通过动态代理的方式得到网络接口对象
        ApiService apiService = retrofit.create(ApiService.class);
        Call<User> call = apiService.getHasParams("forever");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                String avatar_url = user.getAvatar_url();
                Log.i("xxx",avatar_url);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }

    //无参get请求
    private void getNoParams() {
        //创建Retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.baseUrl1).addConverterFactory(GsonConverterFactory.create()).build();
        //通过动态代理的方式得到网络接口对象
        ApiService apiService = retrofit.create(ApiService.class);
        //得到Call对象
        Call<News> call = apiService.getNoParams();
        //执行异步请求 回调在主线程
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                News news = response.body();
                List<News.AdsBean> ads = news.getAds();
                for (int i = 0; i < ads.size(); i++) {
                    News.AdsBean adsBean = ads.get(i);
                    Log.i("xxx",adsBean.getGonggaoren());
                }

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });

    }
}
