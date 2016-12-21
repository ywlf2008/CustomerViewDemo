package com.example.yhuan.customerviewdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TabActivity extends AppCompatActivity {

    @Bind(R.id.view1)
    ColorTrackView view1;
    @Bind(R.id.view2)
    ColorTrackView view2;
    @Bind(R.id.view3)
    ColorTrackView view3;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    private List<ColorTrackView> mViews;
    private String[] titles = {"简介", "评价", "相关"};
    private List<Fragment> mFragments;
    private TabPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mViews = new ArrayList<>();
        mFragments = new ArrayList<>();
        mViews.add(view1);
        mViews.add(view2);
        mViews.add(view3);
        for (int i = 0; i < titles.length; i++) {
            mViews.get(i).setText(titles[i]);
            mFragments.add(ContentFragment.newInstance(titles[i]));
        }
        mAdapter = new TabPagerAdapter(getSupportFragmentManager(), mFragments);
        viewpager.setAdapter(mAdapter);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (positionOffset > 0) {
                    ColorTrackView left = mViews.get(position);
                    ColorTrackView right = mViews.get(position + 1);

                    left.setDirection(1);
                    right.setDirection(0);
                    Log.e("TAG", positionOffset + "");
                    left.setProgress(1 - positionOffset);
                    right.setProgress(positionOffset);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
