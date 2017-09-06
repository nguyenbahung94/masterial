package com.example.tablayoutswipescrolltabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by nbhung on 9/5/2017.
 */

public class MypagerAdapter extends FragmentStatePagerAdapter {
    public MypagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        FragmentViewPager fraPager = new FragmentViewPager().newInstance(position);
        return fraPager;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return "Tab" + position;
    }
}
