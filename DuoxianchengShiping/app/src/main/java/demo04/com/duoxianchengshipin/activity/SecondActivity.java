package demo04.com.duoxianchengshipin.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import demo04.com.duoxianchengshipin.R;
import demo04.com.duoxianchengshipin.adapter.MyAdapter;
import demo04.com.duoxianchengshipin.bean.NewsBean;
import demo04.com.duoxianchengshipin.presenter.PresenterSx;
import demo04.com.duoxianchengshipin.view.ViewShow;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class SecondActivity extends AppCompatActivity implements ViewShow{

    private RecyclerView rlv;
    private Banner ban;
    private List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        rlv = (RecyclerView) findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(this));
        ban = (Banner) findViewById(R.id.ban);

        PresenterSx presenterSx = new PresenterSx(this);
        presenterSx.r();
    }
    @Override
    public void show(NewsBean bean) {
        List<NewsBean.DataBean> list = bean.getData();
        MyAdapter myAdapter = new MyAdapter(SecondActivity.this,list);
        rlv.setAdapter(myAdapter);
        for (int i = 0; i < list.size(); i++) {
            data.add(list.get(i).getImage_url()+"");
        }
        ban.setImageLoader(new Glider());
        ban.setDelayTime(2000);
        ban.setImages(data);
        ban.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        ban.start();
    }
    public class Glider extends ImageLoader{

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into((ImageView) imageView);
        }
    }
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
