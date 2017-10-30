package lianxi.demo01.com.fuxiyuekao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import lianxi.demo01.com.fuxiyuekao.bean.DataBean;

/**
 * Created by 小可爱 on 2017/10/30.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHodler>{

    private Context context;
    private List<DataBean.SongListBean> list;

    public MyAdapter(Context context, List<DataBean.SongListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyHodler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHodler extends RecyclerView.ViewHolder{

        public MyHodler(View itemView) {
            super(itemView);
        }
    }
}
