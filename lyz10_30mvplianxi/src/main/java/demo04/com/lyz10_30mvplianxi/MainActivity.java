package demo04.com.lyz10_30mvplianxi;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.youth.banner.Banner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import demo04.com.lyz10_30mvplianxi.adapter.MyAdapter;
import demo04.com.lyz10_30mvplianxi.bean.Bean;
import demo04.com.lyz10_30mvplianxi.presenter.ShowPresenterImpl;
import demo04.com.lyz10_30mvplianxi.utils.GsonObjectCallback;
import demo04.com.lyz10_30mvplianxi.utils.OkHttp3Utils;
import demo04.com.lyz10_30mvplianxi.view.ShowView;
import okhttp3.Call;

public class MainActivity extends AppCompatActivity implements ShowView{

    private String url = "http://www.93.gov.cn/93app/data.do?channelId=0&startNum=0";
    private RecyclerView rlv;
    private LinearLayoutManager layoutManager;
    private SwipeRefreshLayout swipe;
    private Handler handler = new Handler();
    private Banner banner;
    private List<String> b = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlv = (RecyclerView) findViewById(R.id.rlv);
        //设置布局管理器
        layoutManager = new LinearLayoutManager(this);
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        banner = (Banner) findViewById(R.id.banner);

        b.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2275951577,3020532777&fm=27&gp=0.jpg");
        b.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=679805784,3150507797&fm=27&gp=0.jpg");
        b.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3920398476,1501488149&fm=27&gp=0.jpg");
        banner.setImageLoader(new MyImage());
        banner.setImages(b);
        banner.setDelayTime(2000);
        banner.start();
        rlv.setLayoutManager(layoutManager);
        ShowPresenterImpl presenter = new ShowPresenterImpl(this);
        presenter.relevance();
    }

    @Override
    public void ShowData(Bean bean) {
        List<Bean.DataBean> list = bean.getData();
        final MyAdapter myAdapter = new MyAdapter(MainActivity.this,list);
        rlv.setAdapter(myAdapter);
        rlv.setOnScrollListener(new RecyclerView.OnScrollListener() {
            private int lastPosition;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(lastPosition+1 == myAdapter.getItemCount()&&newState == RecyclerView.SCROLL_STATE_IDLE){
                    OkHttp3Utils.doGet(url, new GsonObjectCallback<Bean>() {
                        @Override
                        public void onUi(Bean bean) {
                            List<Bean.DataBean> data = bean.getData();
                            myAdapter.loadMore(data);
                            Toast.makeText(MainActivity.this, "加载成功", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailed(Call call, IOException e) {

                        }
                    });
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastPosition = layoutManager.findLastVisibleItemPosition();
            }
        });

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        OkHttp3Utils.doGet(url, new GsonObjectCallback<Bean>() {
                            @Override
                            public void onUi(Bean bean) {
                                List<Bean.DataBean> data = bean.getData();
                                myAdapter.refreshMore(data);
                                swipe.setRefreshing(false);
                                Toast.makeText(MainActivity.this, "刷新成功", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailed(Call call, IOException e) {

                            }
                        });
                    }
                },3000);

            }
        });
    }
}
