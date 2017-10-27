package com.demo01.lianxi.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.demo01.lianxi.SecondActivity;
import com.demo01.lianxi.adapter.MyAdapter;
import com.demo01.lianxi.bean.DataBean;
import com.demo01.lianxi.utils.GsonObjectCallback;
import com.demo01.lianxi.utils.OkHttp3Utils;
import com.demo01.lianxi.view.ViewListener;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;

/**
 * Created by 小可爱 on 2017/10/27.
 */
//M层
public class ModelImpl implements ModelIf{
    //设置接口
    String Url = "http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0";
    private MyAdapter adapter;

    @Override
    public void modelIf(final Context context, final RecyclerView recyclerView, final ViewListener listener) {
        //设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        //OKHttp网络请求数据
        OkHttp3Utils.doGet(Url, new GsonObjectCallback<DataBean>() {

            @Override
            public void onUi(DataBean dataBean) {
                listener.onSuccess();
                Toast.makeText(context, dataBean.getSong_list().toString(), Toast.LENGTH_SHORT).show();
                List<DataBean.SongListBean> song_list = dataBean.getSong_list();
                adapter = new MyAdapter(context,song_list);
                recyclerView.setAdapter(adapter);
                //获取adapter的点击事件
                adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(context, "点击", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, SecondActivity.class);
                        context.startActivity(intent);
                    }
                });

            }

            @Override
            public void onFailed(Call call, IOException e) {
                listener.unSuccessful();
            }
        });
    }
}
