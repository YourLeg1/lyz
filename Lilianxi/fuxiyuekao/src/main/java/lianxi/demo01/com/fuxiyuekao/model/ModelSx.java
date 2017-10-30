package lianxi.demo01.com.fuxiyuekao.model;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

import lianxi.demo01.com.fuxiyuekao.adapter.MyAdapter;
import lianxi.demo01.com.fuxiyuekao.bean.DataBean;
import lianxi.demo01.com.fuxiyuekao.utils.GsonObjectCallback;
import lianxi.demo01.com.fuxiyuekao.utils.OkHttp3Utils;
import lianxi.demo01.com.fuxiyuekao.view.ViewListen;
import okhttp3.Call;

/**
 * Created by 小可爱 on 2017/10/30.
 */

public class ModelSx implements Modelif {

    //定义接口
    String url = "http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0";

    @Override
    public void Recycler(final Context context, final RecyclerView recyclerView, final ViewListen viewListen) {

        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        OkHttp3Utils.doGet(url, new GsonObjectCallback<DataBean>() {
            @Override
            public void onUi(DataBean dataBean) {
                viewListen.onSer();
                List<DataBean.SongListBean> beanList = dataBean.getSong_list();
                MyAdapter myAdapter = new MyAdapter(context,beanList);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailed(Call call, IOException e) {
                viewListen.enSer();
            }
        });
    }
}
