package demo04.com.duoxianchengshipin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import demo04.com.duoxianchengshipin.R;
import demo04.com.duoxianchengshipin.bean.NewsBean;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by 小可爱 on 2017/11/21.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<NewsBean.DataBean> list;

    public MyAdapter(Context context, List<NewsBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        MyR myR = new MyR(view);


        return myR;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyR myR = (MyR) holder;
        myR.tie.setText(list.get(position).getTitle());
        myR.con.setText(list.get(position).getContent());
        String vedio_url = list.get(position).getVedio_url();
        myR.view.setUp(vedio_url+"",myR.view.SCREEN_LAYOUT_NORMAL,list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyR extends RecyclerView.ViewHolder{

        private final JCVideoPlayerStandard view;
        private final TextView con;
        private final TextView tie;
        public MyR(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.video_view);
            con = itemView.findViewById(R.id.con);
            tie = itemView.findViewById(R.id.Tiel);
        }
    }
}
