package com.demo01.lianxi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.demo01.lianxi.presenter.PresenterIf;
import com.demo01.lianxi.presenter.PresenterImpl;
import com.demo01.lianxi.view.ViewIf;
//V层
public class MainActivity extends AppCompatActivity implements ViewIf{

    private RecyclerView rlv;
    private PresenterIf presenterIf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隐藏头部
        getSupportActionBar().hide();
        //找组件
        rlv = (RecyclerView) findViewById(R.id.rlv);
        presenterIf = new PresenterImpl(this);
        presenterIf.validatepass(MainActivity.this,rlv);

    }

    @Override
    public void isSeccess() {
        Toast.makeText(this, "请求成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void isUnSeccess() {
        Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
    }
}
