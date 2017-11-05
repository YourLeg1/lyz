package demo04.com.lyz11_04lianxi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import demo04.com.lyz11_04lianxi.R;
import demo04.com.lyz11_04lianxi.adapter.MyAdapter;
import demo04.com.lyz11_04lianxi.bean.News;
import demo04.com.lyz11_04lianxi.presenter.PresenterSx;
import demo04.com.lyz11_04lianxi.view.ViewShow;

/**
 * Created by 小可爱 on 2017/11/4.
 */

public class Fragment1 extends Fragment implements ViewShow{

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_fragment1, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        PresenterSx presenterSx = new PresenterSx(this);
        presenterSx.getData();
        return view;
    }

    @Override
    public void ShowData(News news) {
        List<News.DataBean> list = news.getData();
        Log.i("qwe",news.getData().toString());
        MyAdapter adapter = new MyAdapter(getActivity(),list);
        recyclerView.setAdapter(adapter);
    }
}
