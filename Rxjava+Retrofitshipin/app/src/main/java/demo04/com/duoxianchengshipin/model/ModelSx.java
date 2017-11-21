package demo04.com.duoxianchengshipin.model;

import demo04.com.duoxianchengshipin.OFLin;
import demo04.com.duoxianchengshipin.bean.NewsBean;
import demo04.com.duoxianchengshipin.info.ApiService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 小可爱 on 2017/11/21.
 */

//http://result.eolinker.com/iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=vedio

public class ModelSx implements Modelif{
    String url = "http://result.eolinker.com/";
    @Override
    public void M(final OFLin lin) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Observable<NewsBean> observable = apiService.getNoParams("vedio");

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
                    public void onNext(NewsBean bean) {
                        lin.setData(bean);
                    }
                });
    }
}
