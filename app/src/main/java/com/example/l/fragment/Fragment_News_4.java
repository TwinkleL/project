package com.example.l.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.l.adapter.MyHFadapter;
import com.example.l.adapter.MyNews3Fadapter;
import com.example.l.adapter.MyNews4Fadapter;
import com.example.l.been.News4;
import com.example.l.mediumproject.R;
import com.example.l.utils.HandlerUtils;
import com.example.l.utils.JsonUtils;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L on 2016/9/3.
 */
public class Fragment_News_4 extends Fragment {
    PullToRefreshListView listView;
    List<News4.ListBean> list;
    MyNews4Fadapter adapter;
    HandlerUtils handlerUtils;
    List<Fragment> handFragment;
    MyHFadapter handeradapter;
    int num=1;
    int i=0;
    private static final String URL="http://api.fengniao.com/app_ipad/news_list.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&cid=190&page=";
    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:

                    String jsonString = (String) msg.obj;
                    Log.d("lzb", "jsonString======="+jsonString);
                    Gson js = new Gson();
                    News4 jsonE = js.fromJson(jsonString, News4.class);
                    list.addAll(jsonE.getList());
                    adapter=new MyNews4Fadapter(getActivity(),handlerUtils,list);
                    adapter.notifyDataSetChanged();
                    listView.setAdapter(adapter);
                    listView.onRefreshComplete();
                    break;
                case 2:
                    Bitmap bitmap=(Bitmap) msg.obj;
                    Log.d("zsp", "handleMessage"+bitmap);
                    String urlString=msg.getData().getString("url");
                    ImageView imageView=(ImageView) listView.
                            findViewWithTag(urlString);
                    if (bitmap!=null&& imageView!=null) {
                        imageView.setImageBitmap(bitmap);
                    }
                    break;
                default:
                    break;
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_2,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView= (PullToRefreshListView) view.findViewById(R.id.L_news2Id);
        handlerUtils=new HandlerUtils(handler);
        list=new ArrayList<>();
        handFragment=new ArrayList<>();

        View view1= (View) LayoutInflater.from(getActivity()).inflate(R.layout.headerview4,null);
        final ViewPager viewPager= (ViewPager) view1.findViewById(R.id.vp_handId4);
        handFragment.add(new Fragment_Hand_41());
        handFragment.add(new Fragment_Hand_42());
        handFragment.add(new Fragment_Hand_43());
        handeradapter=new MyHFadapter(getFragmentManager(),handFragment);
        viewPager.setAdapter(handeradapter);
        listView.getRefreshableView().addHeaderView(view1);
        initdata();


        listView.setMode(PullToRefreshBase.Mode.BOTH);
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        num++;
                        new JsonUtils(handler).loadJson(URL+num);

                    }
                }).start();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        num++;
                        new JsonUtils(handler).loadJson(URL+num);

                    }
                }).start();
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {


                while (true){
                    if(i<3){
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                viewPager.setCurrentItem(i);
                                handeradapter.notifyDataSetChanged();
                            }
                        });

                        i++;
                    }
                    else {
                        i=0;
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                viewPager.setCurrentItem(i);
                                handeradapter.notifyDataSetChanged();
                            }
                        });
                    }

                }
            }
        }).start();
    }

    private void initdata() {
        new JsonUtils(handler).loadJson(URL+num);

    }
}
