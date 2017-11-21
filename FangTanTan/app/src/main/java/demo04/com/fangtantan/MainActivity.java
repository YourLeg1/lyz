package demo04.com.fangtantan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.mcxtzhang.layoutmanager.swipecard.CardConfig;
import com.mcxtzhang.layoutmanager.swipecard.OverLayCardLayoutManager;
import com.mcxtzhang.layoutmanager.swipecard.RenRenCallback;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

//http://api.svipmovie.com/front/columns/getVideoList.do?catalogId=402834815584e463015584e539330016

public class MainActivity extends AppCompatActivity {

    private RecyclerView rlv;
    String url = "http://api.svipmovie.com/front/columns/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlv = (RecyclerView) findViewById(R.id.rlv);
       // rlv.setLayoutManager(new LinearLayoutManager(this));
        getData();

    }

    private void getData(){

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Observable<NewsBean> observable = apiService.getHaParams("402834815584e463015584e539330016");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        List<NewsBean.RetBean.ListBean> list = newsBean.getRet().getList();
                        MyAdapter myAdapter = new MyAdapter(MainActivity.this,list);
                        rlv.setLayoutManager(new OverLayCardLayoutManager());
                        CardConfig.initConfig(MainActivity.this);
                        ItemTouchHelper.Callback callback = new RenRenCallback(rlv, myAdapter, list);
                        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
                        itemTouchHelper.attachToRecyclerView(rlv);
                        rlv.setAdapter(myAdapter);
                    }
                });

    }
}
