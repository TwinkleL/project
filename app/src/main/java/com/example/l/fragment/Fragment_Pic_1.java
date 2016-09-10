package com.example.l.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.l.adapter.MyPic1Fadapter;
import com.example.l.been.Pic1;
import com.example.l.mediumproject.MyWebViewActivity;
import com.example.l.mediumproject.R;
import com.example.l.utils.HandlerUtils;
import com.example.l.utils.JsonUtils;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L on 2016/9/3.
 */
public class Fragment_Pic_1 extends Fragment {
    PullToRefreshGridView gridView;
    List<Pic1.ListBean> list;
    MyPic1Fadapter adapter;
    int num=1;
    HandlerUtils handlerUtils;
    private static final String URL="http://api.fengniao.com/app_ipad/pic_bbs_list_v2.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&fid=101&page=";
    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:

                    String jsonString = (String) msg.obj;
                    Log.d("ll", "jsonString======="+jsonString);
                    Gson js = new Gson();
                    Pic1 jsonE = js.fromJson(jsonString, Pic1.class);
                    list.addAll(jsonE.getList());

                    adapter=new MyPic1Fadapter(getActivity(),handlerUtils,list);
                    adapter.notifyDataSetChanged();
                    gridView.setAdapter(adapter);

                    gridView.onRefreshComplete();
                    break;
                case 2:
                    Bitmap bitmap=(Bitmap) msg.obj;
                    Log.d("zsp", "handleMessage"+bitmap);
                    String urlString=msg.getData().getString("url");
                    ImageView imageView=(ImageView) gridView.
                            findViewWithTag(urlString);
                    if (bitmap!=null&& imageView!=null) {
                        imageView.setImageBitmap(bitmap);
                    }
                    break;
                default:
                    break;
            }
        };
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pic_1,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView= (PullToRefreshGridView) view.findViewById(R.id.L_picId);
        handlerUtils=new HandlerUtils(handler);
        initdata();
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getContext(), MyWebViewActivity.class);
                String url=  list.get(position).getWeb_url();
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
        gridView.setMode(PullToRefreshBase.Mode.BOTH);
        gridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
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

                        Log.d("ll", "num======="+num);
                    }
                }).start();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
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

                        Log.d("ll", "num======="+num);

                    }
                }).start();
            }
        });
    }
    private void initdata() {
        list=new ArrayList<>();
        new JsonUtils(handler).loadJson(URL+num);
        }
    }

