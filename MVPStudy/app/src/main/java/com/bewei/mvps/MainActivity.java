package com.bewei.mvps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.bewei.mvps.adapter.MyAdapter;
import com.bewei.mvps.model.News;
import com.bewei.mvps.presenter.ShowPresenter;
import com.bewei.mvps.presenter.ShowPresenterImpl;
import com.bewei.mvps.view.ShowView;

public class MainActivity extends AppCompatActivity implements ShowView{
 private  String url ="http://www.93.gov.cn/93app/data.do?channelId=0&startNum=0";
    private RecyclerView rlr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        rlr = (RecyclerView) findViewById(R.id.rlv);
        //设置成布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rlr.setLayoutManager(linearLayoutManager);

        //p关联v
        ShowPresenterImpl presenter = new ShowPresenterImpl(this);
        //p关联m 做网络请求
        presenter.relevance();






    }

    @Override
    public void showData(News news) {
        MyAdapter adapter = new MyAdapter(this,news);
        rlr.setAdapter(adapter);
    }
}
