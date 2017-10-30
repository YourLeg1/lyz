package com.bewei.mvps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bewei.mvps.MainActivity;
import com.bewei.mvps.R;
import com.bewei.mvps.model.News;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/10/30 15:26
 */


public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    News news;

    public MyAdapter(Context context, News news) {
        this.context = context;
        this.news = news;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        List<News.DataBean> data = news.getData();
        News.DataBean dataBean = data.get(position);
        String title = dataBean.getTITLE();
        String imageurl = dataBean.getIMAGEURL();
        myViewHolder.tv_title.setText(title);
        Picasso.with(context).load(imageurl).placeholder(R.mipmap.ic_launcher).into(myViewHolder.iv);
    }

    @Override
    public int getItemCount() {
        return news.getData().size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv_title;
        private final ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            iv = itemView.findViewById(R.id.iv);

        }
    }
}
