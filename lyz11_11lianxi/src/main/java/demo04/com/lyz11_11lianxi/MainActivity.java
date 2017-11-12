package demo04.com.lyz11_11lianxi;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.List;

import demo04.com.lyz11_11lianxi.adapter.MyAdapter;
import demo04.com.lyz11_11lianxi.bean.News;
import demo04.com.lyz11_11lianxi.presenter.PresenterSx;
import demo04.com.lyz11_11lianxi.view.ViewShow;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements ViewShow{

    private RecyclerView rlv;
    private SwipeRefreshLayout swipe;
    String url = "http://result.eolinker.com/";
    private MyAdapter myAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fresco.initialize(this);
        rlv = (RecyclerView) findViewById(R.id.recyclerview);
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);

        layoutManager = new LinearLayoutManager(this);
        rlv.setLayoutManager(layoutManager);
        PresenterSx presenterSx = new PresenterSx(this);
        presenterSx.r();
    }

    @Override
    public void ShowView(News news) {
        List<News.DataBean> list = news.getData();
        myAdapter = new MyAdapter(MainActivity.this,list);
        rlv.setAdapter(myAdapter);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();

                ApiService apiService = retrofit.create(ApiService.class);

                Observable<List<News>> observable = apiService.getHaParams("info");
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<List<News>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(List<News> newses) {
                                News news1 = newses.get(0);
                                List<News.DataBean> data = news1.getData();
                                myAdapter.refreshMore(data);
                                Toast.makeText(MainActivity.this, "刷新成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                if(swipe.isRefreshing()){
                    swipe.setRefreshing(false);
                }
            }
        });
        rlv.setOnScrollListener(new RecyclerView.OnScrollListener() {
            private int lastPosition;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(lastPosition+1==myAdapter.getItemCount()&&newState==RecyclerView.SCROLL_STATE_IDLE){
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .build();

                    ApiService apiService = retrofit.create(ApiService.class);

                    Observable<List<News>> observable = apiService.getHaParams("info");
                    observable.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Subscriber<List<News>>() {
                                @Override
                                public void onCompleted() {

                                }

                                @Override
                                public void onError(Throwable e) {

                                }

                                @Override
                                public void onNext(List<News> newses) {
                                    News news1 = newses.get(0);
                                    List<News.DataBean> data = news1.getData();
                                    myAdapter.loadMore(data);
                                    Toast.makeText(MainActivity.this, "加载成功", Toast.LENGTH_SHORT).show();
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
    }
}
