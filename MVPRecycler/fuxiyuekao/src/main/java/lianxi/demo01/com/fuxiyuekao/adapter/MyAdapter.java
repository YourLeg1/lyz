package lianxi.demo01.com.fuxiyuekao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import lianxi.demo01.com.fuxiyuekao.R;
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
        View view = View.inflate(context, R.layout.item, null);
        MyHodler myHodler = new MyHodler(view);

        return myHodler;
    }

    @Override
    public void onBindViewHolder(MyHodler holder, int position) {
        holder.tv_item.setText(list.get(position).getTitle());
        Picasso.with(context).load(list.get(position).getPic_big()).into(holder.iv_item);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHodler extends RecyclerView.ViewHolder{

        TextView tv_item;
        ImageView iv_item;
        public MyHodler(View itemView) {
            super(itemView);
            tv_item = itemView.findViewById(R.id.tv_item);
            iv_item = itemView.findViewById(R.id.iv_item);
        }
    }
}
