package demo04.com.fangtantan;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 小可爱 on 2017/11/21.
 */

//http://api.svipmovie.com/front/columns/getVideoList.do?catalogId=402834815584e463015584e539330016
public interface ApiService {

    @GET("getVideoList.do")
    Observable<NewsBean> getHaParams(@Query("catalogId") String catalogId);

}
