package demo04.com.lyz11_04lianxi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import demo04.com.lyz11_04lianxi.adapter.MyFAdapter;
import demo04.com.lyz11_04lianxi.fragment.Fragment1;
import demo04.com.lyz11_04lianxi.fragment.Fragment2;
import demo04.com.lyz11_04lianxi.fragment.Fragment3;
import demo04.com.lyz11_04lianxi.fragment.Fragment4;
import demo04.com.lyz11_04lianxi.fragment.Fragment5;
import demo04.com.lyz11_04lianxi.fragment.Fragment6;
import demo04.com.lyz11_04lianxi.fragment.Fragment7;
import demo04.com.lyz11_04lianxi.fragment.Fragment8;
import demo04.com.lyz11_04lianxi.presenter.PresenterSx;

/**
 * Created by 小可爱 on 2017/11/4.
 */

public class Four extends Fragment{

    private ViewPager viewPager;
    private String[] title = new String[]{"日报","专栏","热门","主题","指数","国外","商品","时尚"};
    private TabLayout tabLayout;
    private PresenterSx presenterSx;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment04, container, false);
        viewPager = (ViewPager)view.findViewById(R.id.viewpager);
        tabLayout = (TabLayout)view.findViewById(R.id.tablayout);

        for (String str :title){
            tabLayout.addTab(tabLayout.newTab().setText(str));
        }
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());
        fragments.add(new Fragment5());
        fragments.add(new Fragment6());
        fragments.add(new Fragment7());
        fragments.add(new Fragment8());

        MyFAdapter adapter = new MyFAdapter(getChildFragmentManager(),title,fragments);
        //把集合放入适配器
        adapter.setFragments(fragments);
        //给ViewPager设置适配器
        viewPager.setAdapter(adapter);
        for (int i = 0; i <fragments.size();i++){
            tabLayout.addTab(tabLayout.newTab());
        }
        //使tablayout和viewPager关联
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

}
