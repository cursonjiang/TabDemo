package com.curson.viewpager_fragment_tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.curson.viewpager_fragment_tab.fragment.AddressFragment;
import com.curson.viewpager_fragment_tab.fragment.FriendFragment;
import com.curson.viewpager_fragment_tab.fragment.SettingFragment;
import com.curson.viewpager_fragment_tab.fragment.WeiXinFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private FragmentPagerAdapter mFragmentPagerAdapter;
    private List<Fragment> mFragmentList;
    //Tab
    private LinearLayout mTabWeiXin;
    private LinearLayout mTabFriend;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;
    //ImageButton
    private ImageButton mImageWeiXin;
    private ImageButton mImageFriend;
    private ImageButton mImageAddress;
    private ImageButton mImageSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        setSelect(0);
    }

    private void initEvent() {
        mTabWeiXin.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        //Tabs
        mTabWeiXin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFriend = (LinearLayout) findViewById(R.id.id_tab_friend);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_setting);

        //ImageButton
        mImageWeiXin = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mImageFriend = (ImageButton) findViewById(R.id.id_tab_friend_img);
        mImageAddress = (ImageButton) findViewById(R.id.id_tab_address_img);
        mImageSetting = (ImageButton) findViewById(R.id.id_tab_setting_img);

        mFragmentList = new ArrayList<>();

        Fragment mFragmentTab1 = new WeiXinFragment();
        Fragment mFragmentTab2 = new FriendFragment();
        Fragment mFragmentTab3 = new AddressFragment();
        Fragment mFragmentTab4 = new SettingFragment();

        mFragmentList.add(mFragmentTab1);
        mFragmentList.add(mFragmentTab2);
        mFragmentList.add(mFragmentTab3);
        mFragmentList.add(mFragmentTab4);

        mFragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mFragmentList.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }
        };

        mViewPager.setAdapter(mFragmentPagerAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = mViewPager.getCurrentItem();
                setTab(currentItem);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setSelect(int i) {
        setTab(i);
        mViewPager.setCurrentItem(i);
    }

    private void setTab(int i) {
        resetImgs();
        switch (i) {
            case 0:
                mImageWeiXin.setImageResource(R.mipmap.tab_weixin_pressed);
                break;
            case 1:
                mImageFriend.setImageResource(R.mipmap.tab_find_frd_pressed);
                break;
            case 2:
                mImageAddress.setImageResource(R.mipmap.tab_address_pressed);
                break;
            case 3:
                mImageSetting.setImageResource(R.mipmap.tab_settings_pressed);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_tab_weixin:
                setSelect(0);
                break;
            case R.id.id_tab_friend:
                setSelect(1);
                break;
            case R.id.id_tab_address:
                setSelect(2);
                break;
            case R.id.id_tab_setting:
                setSelect(3);
                break;
            default:
                break;
        }
    }

    /**
     * 把所有图片重置为暗色
     */
    private void resetImgs() {
        mImageWeiXin.setImageResource(R.mipmap.tab_weixin_normal);
        mImageFriend.setImageResource(R.mipmap.tab_find_frd_normal);
        mImageAddress.setImageResource(R.mipmap.tab_address_normal);
        mImageSetting.setImageResource(R.mipmap.tab_settings_normal);
    }
}
