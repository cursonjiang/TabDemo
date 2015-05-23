package com.curson.fragmenttab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.curson.fragmenttab.fragment.AddressFragment;
import com.curson.fragmenttab.fragment.FriendFragment;
import com.curson.fragmenttab.fragment.SettingFragment;
import com.curson.fragmenttab.fragment.WeiXinFragment;


public class MainActivity extends FragmentActivity implements View.OnClickListener {

    //Tabs
    private LinearLayout mTabWeiXin;
    private LinearLayout mTabFriend;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    //ImageButton
    private ImageButton mImageWeiXin;
    private ImageButton mImageFriend;
    private ImageButton mImageAddress;
    private ImageButton mImageSetting;

    //Fragment
    private Fragment mFragment1;
    private Fragment mFragment2;
    private Fragment mFragment3;
    private Fragment mFragment4;

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
    }

    private void setSelect(int i) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        //隐藏所有Fragment
        hideFragment(transaction);

        switch (i) {
            case 0:
                if (mFragment1 == null) {
                    mFragment1 = new WeiXinFragment();
                    transaction.add(R.id.id_content, mFragment1);
                } else {
                    transaction.show(mFragment1);
                }
                mImageWeiXin.setImageResource(R.mipmap.tab_weixin_pressed);
                break;
            case 1:
                if (mFragment2 == null) {
                    mFragment2 = new FriendFragment();
                    transaction.add(R.id.id_content, mFragment2);
                } else {
                    transaction.show(mFragment2);
                }
                mImageFriend.setImageResource(R.mipmap.tab_find_frd_pressed);
                break;
            case 2:
                if (mFragment3 == null) {
                    mFragment3 = new AddressFragment();
                    transaction.add(R.id.id_content, mFragment3);
                } else {
                    transaction.show(mFragment3);
                }
                mImageAddress.setImageResource(R.mipmap.tab_address_pressed);
                break;
            case 3:
                if (mFragment4 == null) {
                    mFragment4 = new SettingFragment();
                    transaction.add(R.id.id_content, mFragment4);
                }
                transaction.show(mFragment4);
                mImageSetting.setImageResource(R.mipmap.tab_settings_pressed);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    /**
     * 隐藏所有Fragment
     *
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (mFragment1 != null) {
            transaction.hide(mFragment1);
        }
        if (mFragment2 != null) {
            transaction.hide(mFragment2);
        }
        if (mFragment3 != null) {
            transaction.hide(mFragment3);
        }
        if (mFragment4 != null) {
            transaction.hide(mFragment4);
        }
    }

    @Override
    public void onClick(View v) {
        resetImgs();
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
