package com.example.administrator.myhappysky.widget;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

/**
 * Created by admin on 2017/12/15.
 */

public class TabFragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    public final int FRAGMENT_COUNT = 7;
    private String tabTitles[] = new String[]{"tab1","tab2","tab3","tab4","tab5","tab6","tab7"};
    public TabFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return RankFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        /*
        switch (position) {
            case 0:
                Log.d("liang.chen", "getPageTitle 排列");
                return "排列";
            case 1:
                Log.d("liang.chen", "getPageTitle dof");
                return "dof";
            case 2:
                Log.d("liang.chen", "getPageTitle supernight");
                return "supernight";
        }
        */
        return tabTitles[position];
    }
}
