package com.example.l.mediumproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;

import com.example.l.adapter.MyMainFadapter;
import com.example.l.fragment.Fragment_Forum;
import com.example.l.fragment.Fragment_News;
import com.example.l.fragment.Fragment_Pic;
import com.example.l.fragment.Fragment_Set;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnTouchListener {

    Context mcontext;
    RadioGroup radioGroup;
    Intent intent;
    List<Fragment> list;
    ViewPager viewPager;
    MyMainFadapter adapter;
    Fragment_Forum fragment_forum;
    Fragment_Set fragment_set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcontext=this;
        intent = new Intent(mcontext,Activity_StartPage.class);
        startActivity(intent);
        initView();
        radioGroup.setOnCheckedChangeListener(this);
        list= new ArrayList<>();

        fragment_set= new Fragment_Set();
        list.add(new Fragment_News());
        list.add(new Fragment_Pic());
        fragment_forum = new Fragment_Forum();
        list.add(fragment_forum);
        list.add(fragment_set);
        adapter=new MyMainFadapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        viewPager.setOnTouchListener(this);

    }

    private void initView() {
        viewPager= (ViewPager) findViewById(R.id.vp_mainId);
        radioGroup= (RadioGroup) findViewById(R.id.radioGroupId);


    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.buttonmainId:
                viewPager.setCurrentItem(0);
                break;
            case R.id.buttonmain2Id:
                viewPager.setCurrentItem(1);
                break;
            case R.id.buttonmain3Id:
                viewPager.setCurrentItem(2);
                break;
            case R.id.buttonmain4Id:
                viewPager.setCurrentItem(3);
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;

    }
}
