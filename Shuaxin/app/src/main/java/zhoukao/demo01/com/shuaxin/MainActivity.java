package zhoukao.demo01.com.shuaxin;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.io.IOException;
import java.util.List;

import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout;
import okhttp3.Call;
import zhoukao.demo01.com.shuaxin.utils.GsonObjectCallback;
import zhoukao.demo01.com.shuaxin.utils.OkHttp3Utils;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WaveSwipeRefreshLayout mWaveSwipeRefreshLayout;
    private Handler handler = new Handler();
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private LinearLayoutManager layoutManager;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        getData();
//        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        //布局管理器
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mWaveSwipeRefreshLayout = (WaveSwipeRefreshLayout) findViewById(R.id.wave);
        //设置中间小圆从白色到黑色
        mWaveSwipeRefreshLayout.setColorSchemeColors(Color.WHITE, Color.BLACK);
        //设置整体的颜色
        mWaveSwipeRefreshLayout.setWaveColor(Color.argb(255, 255, 0, 0));
        //下拉刷新
        mWaveSwipeRefreshLayout.setOnRefreshListener(new WaveSwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        OkHttp3Utils.doGet("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1", new GsonObjectCallback<DataBean>() {
                            @Override
                            public void onUi(DataBean dataBean) {
                                List<DataBean.ResultsBean> list = dataBean.getResults();
                                myAdapter.refreshMore(list);
                            }

                            @Override
                            public void onFailed(Call call, IOException e) {

                            }
                        });
                        //三秒后停止刷新
                        mWaveSwipeRefreshLayout.setRefreshing(false);
                    }
                },3000);
            }
        });
        //上拉加载
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener(){

            private int lastPosition;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(lastPosition+1==myAdapter.getItemCount()&&newState==RecyclerView.SCROLL_STATE_IDLE){
                    OkHttp3Utils.doGet("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1", new GsonObjectCallback<DataBean>() {
                        @Override
                        public void onUi(DataBean dataBean) {
                            List<DataBean.ResultsBean> list = dataBean.getResults();
                            myAdapter.loadMore(list);
                        }

                        @Override
                        public void onFailed(Call call, IOException e) {

                        }
                    });
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastPosition = layoutManager.findLastVisibleItemPosition();


            }
        });

    }
    private void getData(){
        OkHttp3Utils.doGet("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1", new GsonObjectCallback<DataBean>() {
            @Override
            public void onUi(DataBean dataBean) {
                List<DataBean.ResultsBean> list = dataBean.getResults();
                if(myAdapter==null){
                    myAdapter = new MyAdapter(MainActivity.this,list);
                    recyclerView.setAdapter(myAdapter);
                }else {
                    myAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }

}
