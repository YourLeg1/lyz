package demo04.com.lyz11_04lianxi.model;

import java.util.List;

import demo04.com.lyz11_04lianxi.API;
import demo04.com.lyz11_04lianxi.ApiService;
import demo04.com.lyz11_04lianxi.OFLin;
import demo04.com.lyz11_04lianxi.bean.News;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 小可爱 on 2017/11/4.
 */

public class ModelSx implements Modelif{

    @Override
    public void setData(final OFLin lin) {
        //String url = "http://result.eolinker.com/6rdnXgZ20130cc07fd3b192ce2715f6df4113e76fe201df?uri=info";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_PATH)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RxJava
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
                    public void onNext(List<News> newsBeen) {
                        lin.Show(newsBeen.get(0));
                        //String id = newsBeen.get(0).getData().get(0).getId();
                        //newsBeen.get(0)
                    }
                });

    }
}
