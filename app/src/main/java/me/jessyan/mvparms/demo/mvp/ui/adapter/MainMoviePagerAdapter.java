package me.jessyan.mvparms.demo.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import me.jessyan.mvparms.demo.mvp.model.entity.MainViewPagerTitleBean;

public class MainMoviePagerAdapter extends FragmentStatePagerAdapter {
    private List<MainViewPagerTitleBean> mTitles;
    private List<Fragment> mFragments;


    public MainMoviePagerAdapter(FragmentManager fm, List<MainViewPagerTitleBean> titles,
                                 List<Fragment> fragments) {
        super(fm);
        this.mTitles = titles;
        this.mFragments = fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles == null) {
            return null;
        }
        if (position >= 0 && position < mTitles.size()) {
            return mTitles.get(position).name;
        }
        return null;
    }

}
