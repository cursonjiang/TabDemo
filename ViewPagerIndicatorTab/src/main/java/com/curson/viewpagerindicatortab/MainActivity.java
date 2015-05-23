package com.curson.viewpagerindicatortab;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.curson.viewpagerindicatortab.adapter.TabAdapter;
import com.viewpagerindicator.TabPageIndicator;

import static com.curson.viewpagerindicatortab.R.id.id_viewpager;


public class MainActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private TabPageIndicator mTabPageIndicator;
    private TabAdapter mTabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(id_viewpager);
        mTabPageIndicator = (TabPageIndicator) findViewById(R.id.id_indicator);
        mTabAdapter = new TabAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mTabAdapter);
        mTabPageIndicator.setViewPager(mViewPager, 0);
    }

}
