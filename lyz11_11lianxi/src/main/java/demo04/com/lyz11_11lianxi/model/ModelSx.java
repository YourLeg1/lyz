package demo04.com.lyz11_11lianxi.model;

import java.util.List;

import demo04.com.lyz11_11lianxi.ApiService;
import demo04.com.lyz11_11lianxi.OFLin;
import demo04.com.lyz11_11lianxi.bean.News;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 小可爱 on 2017/11/11.
 */

public class ModelSx implements Modelif{
    String url = "http://result.eolinker.com/";
    @Override
    public void setData(final OFLin lin) {

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
                        lin.getData(newses.get(0));
                    }
                });
    }
}
