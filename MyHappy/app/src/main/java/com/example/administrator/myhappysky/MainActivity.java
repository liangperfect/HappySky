package com.example.administrator.myhappysky;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;

import com.example.administrator.myhappysky.widget.TabFragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.draw_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.tab_layout)
    TabLayout mLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    TabFragmentPagerAdapter mFragmentPagerAdapter;
    final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        initListener();
    }

    private void init() {
        mFragmentPagerAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), MainActivity.this);
        mViewPager.setAdapter(mFragmentPagerAdapter);

        mLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    private void initListener() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_main:
                        Log.d(TAG, "R.id.nav_main");
                        break;

                    case R.id.nav_search:
                        Log.d(TAG, "R.id.nav_search");
                        break;

                    case R.id.nav_banner:
                        Log.d(TAG, "R.id.nav_banner");
                        break;

                    case R.id.nav_user:
                        Log.d(TAG, "R.id.nav_user");
                        break;

                    case R.id.nav_setting:
                        Log.d(TAG, "R.id.nav_setting");
                        break;

                    case R.id.nav_rate:
                        Log.d(TAG, "R.id.nav_rate");
                        break;

                    case R.id.nav_send:
                        Log.d(TAG, "R.id.nav_send");
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        exit();

    }

    private long exitTime;

    public void exit() {
        //boolean hasRated = JUtils.getSharedPreference().getBoolean("hasRated", false);
        //int count = JUtils.getSharedPreference().getInt("app_exit_count", 1);
        //if (!hasRated && (count == 5 || count % 10 == 0)) {
        //  count++;
        //JUtils.getSharedPreference().edit().putInt("app_exit_count", count).commit();
        //showRatingDialog();
        // return;
        //}
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            //JUtils.Toast("再按一次退出");
            exitTime = System.currentTimeMillis();
        } else {
            //count++;
            //JUtils.getSharedPreference().edit().putInt("app_exit_count", count).commit();
            finish();
            //System.exit(0);
        }
    }
}
