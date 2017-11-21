package demo04.com.duoxianchengshipin.info;

import demo04.com.duoxianchengshipin.bean.NewsBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 小可爱 on 2017/11/21.
 */

public interface ApiService {

    //http://result.eolinker.com/iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=vedio

    @GET("iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9")
    Observable<NewsBean> getNoParams(@Query("uri") String uri);
}
