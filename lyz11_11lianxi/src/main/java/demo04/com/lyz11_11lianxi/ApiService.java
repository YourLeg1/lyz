package demo04.com.lyz11_11lianxi;

import java.util.List;

import demo04.com.lyz11_11lianxi.bean.News;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 小可爱 on 2017/11/11.
 */

public interface ApiService {
    @GET("6rdnXgZ20130cc07fd3b192ce2715f6df4113e76fe201df")
    rx.Observable<List<News>> getHaParams(@Query("uri") String user);
}
