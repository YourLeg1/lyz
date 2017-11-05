package demo04.com.lyz11_04lianxi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 小可爱 on 2017/11/4.
 */

public class MyFAdapter extends FragmentPagerAdapter{
    private String[] title;
    private List<Fragment> fragments;

    public MyFAdapter(FragmentManager fm, String[] title, List<Fragment> fragments) {
        super(fm);
        this.title = title;
        this.fragments = fragments;
    }
    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
