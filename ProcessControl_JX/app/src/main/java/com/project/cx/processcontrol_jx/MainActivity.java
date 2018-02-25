package com.project.cx.processcontrol_jx;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.project.cx.processcontrol_jx.base.BaseActivity;
import com.project.cx.processcontrol_jx.ui.fragment.DCKFragment;
import com.project.cx.processcontrol_jx.ui.fragment.YCKFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener{
    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.viewpager_tab)
    SmartTabLayout mViewpagerTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void initView() {
        ButterKnife.bind(this);
        final LayoutInflater inflater=LayoutInflater.from(this);
        final int[] tabicons={R.drawable.tab_ic_dck,R.drawable.tab_ic_yck};
        final int[] tabTitles={R.string.tab_dck,R.string.tab_yck};
        FragmentPagerItems pages=FragmentPagerItems.with(this)
                .add("dck",DCKFragment.class)
                .add("yck",YCKFragment.class)
                .create();
        FragmentPagerItemAdapter adapter=new FragmentPagerItemAdapter(
                getSupportFragmentManager(),pages);
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(this);
        mViewpagerTab.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                View view=inflater.inflate(R.layout.navigation_item,container,false);
                ImageView iconView=view.findViewById(R.id.img_icon);
                iconView.setBackgroundResource(tabicons[position%tabicons.length]);
                TextView titleView=view.findViewById(R.id.txt_title);
                titleView.setText(tabTitles[position%tabTitles.length]);
                return view;
            }
        });
        mViewpagerTab.setViewPager(mViewPager);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
/*        Log.e("mainact","onPageScrolled\n"+"position:"+position+"/positionOffset"+positionOffset
                +"/positionOffsetPixels"+positionOffsetPixels);*/
    }

    @Override
    public void onPageSelected(int position) {
//        Log.e("mainactP","onPageSelected\n"+"position:"+position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
//        Log.e("mainact","onPageScrollStateChanged\n"+"state:"+state);
    }
}
