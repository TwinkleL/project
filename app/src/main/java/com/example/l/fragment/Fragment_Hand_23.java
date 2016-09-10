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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.l.been.NHand2;
import com.example.l.mediumproject.MyWebViewActivity;
import com.example.l.mediumproject.R;
import com.example.l.utils.HandlerUtils;
import com.example.l.utils.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L on 2016/9/3.
 */
public class Fragment_Hand_23 extends Fragment {
    //PullToRefreshGridView gridView;
    List<NHand2> list;
    //MyHFadapter1 adapter;

    TextView textView;
    ImageView imageView;
    HandlerUtils handlerUtils;
    private static final String URL="http://api.fengniao.com/app_ipad//focus_pic.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&mid=19929";
    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:

                    String jsonString = (String) msg.obj;
                    Log.d("lllllllllll", "jsonString======="+jsonString);
                    Gson js = new Gson();
                    list= js.fromJson(jsonString,new TypeToken<List<NHand2>>(){}.getType());
                    String text= list.get(2).getTitle();
                    textView.setText(text);
                    String imageurl= list.get(2).getPic_src();
                    handlerUtils.downLoadImage(imageurl);
//                    adapter=new MyHFadapter1(getActivity(),handlerUtils,list);
//                    gridView.setAdapter(adapter);
                    break;
                case 2:
                    Bitmap bitmap=(Bitmap) msg.obj;
                    Log.d("zsp", "handleMessage"+bitmap);
                    String urlString=msg.getData().getString("url");
//                    ImageView imageView=(ImageView)
//                            findViewWithTag(urlString);
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
        return inflater.inflate(R.layout.item_news_2,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        gridView= (PullToRefreshGridView) view.findViewById(R.id.L_picId);
        textView= (TextView) view.findViewById(R.id.news2_textId);
        imageView= (ImageView) view.findViewById(R.id.news2_imageId);
        handlerUtils=new HandlerUtils(handler);
        initdata();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MyWebViewActivity.class);
                String web_url = list.get(2).getWeb_url();
                intent.putExtra("url",web_url);
                startActivity(intent);
            }
        });

    }
    private void initdata() {
        list=new ArrayList<>();
        new JsonUtils(handler).loadJson(URL);
        }
    }

