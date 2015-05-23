package com.curson.viewpagerindicatortab.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.curson.viewpagerindicatortab.fragment.TabFragment;

public class TabAdapter extends FragmentPagerAdapter {

    public static String[] TITLES = {"课程", "问答", "求课", "学习", "计划"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public Fragment getItem(int position) {
        return new TabFragment(position);
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }
}
