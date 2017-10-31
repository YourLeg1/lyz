package demo04.com.lyz10_30mvplianxi.model;

import java.io.IOException;

import demo04.com.lyz10_30mvplianxi.OnFinishListener;
import demo04.com.lyz10_30mvplianxi.bean.Bean;
import demo04.com.lyz10_30mvplianxi.utils.GsonObjectCallback;
import demo04.com.lyz10_30mvplianxi.utils.OkHttp3Utils;
import okhttp3.Call;

/**
 * Created by 小可爱 on 2017/10/30.
 */

public class ShowModelImpl implements ShowModel {
    @Override
    public void getData(final OnFinishListener listener) {
        String url = "http://www.93.gov.cn/93app/data.do?channelId=0&startNum=0";

        OkHttp3Utils.doGet(url, new GsonObjectCallback<Bean>() {
            @Override
            public void onUi(Bean bean) {
                if(listener != null){
                    listener.onSuccess(bean);
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });

    }
}
