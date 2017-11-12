package demo04.com.lyz11_11lianxi.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import demo04.com.lyz11_11lianxi.R;
import demo04.com.lyz11_11lianxi.bean.News;

/**
 * Created by 小可爱 on 2017/11/11.
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
        Uri uri = Uri.parse(list.get(position).getImg());
        myHolder.tv_item.setText(list.get(position).getTitle());
        myHolder.simp.setImageURI(uri);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView simp;
        private final TextView tv_item;

        public MyHolder(View itemView) {
            super(itemView);
            simp = itemView.findViewById(R.id.simp);
            tv_item = itemView.findViewById(R.id.tv_item);
        }
    }

    public void loadMore(List<News.DataBean> li){
        for (News.DataBean str: li){
            list.add(str);
        }
        notifyDataSetChanged();
    }

    public void refreshMore(List<News.DataBean> li){
        for (News.DataBean str : li){
            list.add(0,str);
        }
        notifyDataSetChanged();
    }
}
