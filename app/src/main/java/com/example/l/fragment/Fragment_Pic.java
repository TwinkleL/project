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
import android.widget.TableLayout;

import com.example.l.adapter.MyNewsFadapter;
import com.example.l.adapter.MyPicFadapter;
import com.example.l.mediumproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L on 2016/9/3.
 */
public class Fragment_Pic extends Fragment {
    ViewPager viewPager;
    List<Fragment> list;
    MyPicFadapter adapter;
    TabLayout tabLayout;
    List<String> titles;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pic,null);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager= (ViewPager) view.findViewById(R.id.vp_picId);
        tabLayout = (TabLayout) view.findViewById(R.id.tab2Id);
        list=new ArrayList<>();
        titles=new ArrayList<>();
        titles.add("人像");
        titles.add("风光");
        titles.add("生态");
        titles.add("数码");


        tabLayout.setTabMode(TabLayout.MODE_FIXED);//设置导航模式
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(3)));



        list.add(new Fragment_Pic_1());
        list.add(new Fragment_Pic_2());
        list.add(new Fragment_Pic_3());
        list.add(new Fragment_Pic_4());
        adapter= new MyPicFadapter(getChildFragmentManager(),list,titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);//将tanlayout与viewpager发生联系

    }
}
