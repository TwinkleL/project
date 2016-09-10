package com.example.l.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.l.adapter.MyNewsFadapter;
import com.example.l.mediumproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L on 2016/9/3.
 */
public class Fragment_News extends Fragment  {
    ViewPager viewPager;
    List<Fragment> list;
    MyNewsFadapter adapter;
    TabLayout tabLayout;
    List<String>  titles;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news,null);

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager= (ViewPager) view.findViewById(R.id.vp_newsId);
        tabLayout= (TabLayout) view.findViewById(R.id.tabId);
        list=new ArrayList<>();
        titles=new ArrayList<>();
        titles.add("精选");
        titles.add("器材");
        titles.add("影像");
        titles.add("学院");


        tabLayout.setTabMode(TabLayout.MODE_FIXED);//设置导航模式
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(3)));



        list.add(new Fragment_News_1());
        list.add(new Fragment_News_2());
        list.add(new Fragment_News_3());
        list.add(new Fragment_News_4());
        adapter=new MyNewsFadapter(getChildFragmentManager(),list,titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);//将tanlayout与viewpager发生联系
    }



}
