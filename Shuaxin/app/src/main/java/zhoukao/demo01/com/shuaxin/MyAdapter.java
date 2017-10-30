package zhoukao.demo01.com.shuaxin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 小可爱 on 2017/10/25.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<DataBean.ResultsBean> list;

    public MyAdapter(Context context, List<DataBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if(position %2== 0){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 0){
            View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
            MyViewHolder2 myViewHolder2 = new MyViewHolder2(view);
            return myViewHolder2;
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        /*ViewGroup.LayoutParams params = holder.iv_recy.getLayoutParams();
        if(position == 0){
            params.height = 200;
        }else{
            params.height = 400;
        }*/
        //holder.iv_recy.setLayoutParams(params);

        if(holder instanceof MyViewHolder){
            MyViewHolder holder1 = (MyViewHolder) holder;
            Picasso.with(holder1.iv_recy.getContext()).load(list.get(position).getUrl()).into(holder1.iv_recy);

            holder1.tv_recy.setText(list.get(position).getType());
        }else if(holder instanceof MyViewHolder2){
            MyViewHolder2 holder2 = (MyViewHolder2) holder;
            Picasso.with(holder2.iv_recy2.getContext()).load(list.get(position).getUrl()).into(holder2.iv_recy2);

            holder2.tv_recy2.setText(list.get(position).getType());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_recy;
        TextView tv_recy;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_recy = (ImageView) itemView.findViewById(R.id.iv_recy);
            tv_recy = (TextView) itemView.findViewById(R.id.tv_recy);

        }
    }
    public class MyViewHolder2 extends RecyclerView.ViewHolder{

        ImageView iv_recy2;
        TextView tv_recy2;

        public MyViewHolder2(View itemView) {
            super(itemView);
            iv_recy2 = (ImageView) itemView.findViewById(R.id.iv_recy2);
            tv_recy2 = (TextView) itemView.findViewById(R.id.tv_recy2);

        }
    }


    public void loadMore(List<DataBean.ResultsBean> li){
        for (DataBean.ResultsBean str : li){
            list.add(str);
        }
        //更新界面
        notifyDataSetChanged();

    }
    public void refreshMore(List<DataBean.ResultsBean> li){
        for (DataBean.ResultsBean str : li){
            list.add(0,str);
        }
        //更新界面
        notifyDataSetChanged();

    }
}
