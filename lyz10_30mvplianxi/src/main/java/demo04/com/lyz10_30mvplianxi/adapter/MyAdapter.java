package demo04.com.lyz10_30mvplianxi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import demo04.com.lyz10_30mvplianxi.R;
import demo04.com.lyz10_30mvplianxi.bean.Bean;

/**
 * Created by 小可爱 on 2017/10/30.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<Bean.DataBean>list;

    public MyAdapter(Context context, List<Bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = View.inflate(context, R.layout.item, null);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        } else {
            View view = View.inflate(context, R.layout.item2, null);
            MyViewHolder2 myViewHolder2 = new MyViewHolder2(view);
            return myViewHolder2;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof MyViewHolder){
            MyViewHolder holder1 = (MyViewHolder) holder;
            holder1.tv_item.setText(list.get(position).getTITLE());
            Picasso.with(context).load(list.get(position).getIMAGEURL())
                    .placeholder(R.mipmap.ic_launcher).into(holder1.iv_item);
        }else if(holder instanceof MyViewHolder2){
            MyViewHolder2 holder2 = (MyViewHolder2) holder;
            holder2.tv_item2.setText(list.get(position).getTITLE());
            Picasso.with(context).load(list.get(position).getIMAGEURL())
                    .placeholder(R.mipmap.ic_launcher).into(holder2.iv_item2);
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position %2 == 0){
            return 0;
        }else {
            return 1;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv_item;
        private final ImageView iv_item;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_item = itemView.findViewById(R.id.tv_item);
            iv_item = itemView.findViewById(R.id.iv_item);
        }
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder{

        private final TextView tv_item2;
        private final ImageView iv_item2;

        public MyViewHolder2(View itemView) {
            super(itemView);
            tv_item2 = itemView.findViewById(R.id.tv_item2);
            iv_item2 = itemView.findViewById(R.id.iv_item2);
        }
    }
    public void loadMore(List<Bean.DataBean> li){
        for (Bean.DataBean str : li){
            list.add(str);
        }
        //更新界面
        notifyDataSetChanged();

    }
    public void refreshMore(List<Bean.DataBean> li){
        for (Bean.DataBean str : li){
            list.add(0,str);
        }
        //更新界面
        notifyDataSetChanged();

    }
}
