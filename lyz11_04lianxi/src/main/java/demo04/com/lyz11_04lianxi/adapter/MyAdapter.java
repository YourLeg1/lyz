package demo04.com.lyz11_04lianxi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import demo04.com.lyz11_04lianxi.R;
import demo04.com.lyz11_04lianxi.bean.News;

/**
 * Created by 小可爱 on 2017/11/4.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<News.DataBean> list;

    public MyAdapter(Context context, List<News.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        myHolder.tv_item.setText(list.get(position).getTitle());
        //Picasso.with(context).load(list.get(position).getImg()).placeholder(R.mipmap.ic_launcher).into(myHolder.iv_item);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private final ImageView iv_item;
        private final TextView tv_item;

        public MyHolder(View itemView) {
            super(itemView);
            iv_item = itemView.findViewById(R.id.iv_item);
            tv_item = itemView.findViewById(R.id.tv_item);
        }
    }
}
