package com.demo01.lianxi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo01.lianxi.R;
import com.demo01.lianxi.bean.DataBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by 小可爱 on 2017/10/27.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener{

    private Context context;
    private List<DataBean.SongListBean> list;
    private final DisplayImageOptions options;
    //声明一个这个接口的变量
    private OnItemClickListener mOnItemClickListener = null;

    public MyAdapter(Context context, List<DataBean.SongListBean> list) {
        this.context = context;
        this.list = list;
        //用于ImageLoader的加载图片所设置的方法
        options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .build();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_rlv, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        //将创建的View注册点击事件
        view.setOnClickListener(this);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.introduce.setText(list.get(position).getAuthor()+"-"+list.get(position).getAlbum_title());
        //Picasso加载图片
        //Picasso.with(context).load(list.get(position).getPic_big()).into(holder.image);
        //ImageLoader加载图片 如果不用的话可以打开上面的Picasso方法
        ImageLoader.getInstance().displayImage(list.get(position).getPic_big(),holder.image,options);

        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public void onClick(View view) {
        //将点击事件转移给外面的调用者
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title,introduce;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            introduce = itemView.findViewById(R.id.introduce);
        }
    }
    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
    //暴露给外面的调用者，定义一个设置Listener的方法（）
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
