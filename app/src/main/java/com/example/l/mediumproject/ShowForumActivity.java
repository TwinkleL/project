package com.example.l.mediumproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.l.adapter.MyForumShowAdapter;
import com.example.l.been.Forum;
import com.example.l.utils.HandlerUtils;
import com.example.l.utils.JsonUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ShowForumActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    List<Forum.ListBean> list;
    HandlerUtils handlerUtils;
    MyForumShowAdapter adapter;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:

                    String jsonString = (String) msg.obj;
                    Log.d("ll", "jsonString======="+jsonString);
                    Gson js = new Gson();
                    Forum jsonE = js.fromJson(jsonString, Forum.class);
                    list.addAll(jsonE.getList());

                    adapter=new MyForumShowAdapter(getApplicationContext(),handlerUtils,list);
                    listView.setAdapter(adapter);
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
    MyForumShowAdapter myForumShowAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_forum);

        listView= (ListView) findViewById(R.id.L_showforumId);
        list = new ArrayList<>();
        handlerUtils= new HandlerUtils(handler);
        Intent intent = getIntent();
        String urls = intent.getStringExtra("url");
        new JsonUtils(handler).loadJson(urls);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getApplicationContext(),MyWebViewActivity.class);
        String weburl=list.get(position).getWeb_url();
        intent.putExtra("url",weburl);
        startActivity(intent);
    }
}
