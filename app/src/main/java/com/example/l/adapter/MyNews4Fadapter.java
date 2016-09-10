package com.example.l.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.l.been.News4;
import com.example.l.mediumproject.MyWebViewActivity;
import com.example.l.mediumproject.R;
import com.example.l.utils.HandlerUtils;

import java.util.List;

/**
 * Created by L on 2016/9/4.
 */
public class MyNews4Fadapter extends BaseAdapter {
    List<News4.ListBean> list;
    Context context;
    HandlerUtils handlerUtils;

    public MyNews4Fadapter(Context context, HandlerUtils handlerUtils, List<News4.ListBean> list) {
        this.context = context;
        this.handlerUtils = handlerUtils;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size()/2;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position*2);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_news_12,null);
            viewHolder=new ViewHolder();
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.news12_imageId);
            viewHolder.textView= (TextView) convertView.findViewById(R.id.news12_textId);
            viewHolder.imageView2= (ImageView) convertView.findViewById(R.id.news12_image2Id);
            viewHolder.textView2= (TextView) convertView.findViewById(R.id.news12_text2Id);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(list.get(position*2).getTitle());
        viewHolder.textView2.setText(list.get(position*2+1).getTitle());
        final String url1=list.get(position*2).getPic_url();
        final String url2=list.get(position*2+1).getPic_url();
        Log.d("lzb","url1"+list);
        Log.d("lzb","url2"+url2);
        viewHolder.imageView.setTag(url1);
        viewHolder.imageView2.setTag(url2);
        handlerUtils.downLoadImage(url1);
        int  i=999;

        handlerUtils.downLoadImage(url2);
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MyWebViewActivity.class);
                String web_url = list.get(position*2).getWeb_url();
                intent.putExtra("url",web_url);
                context.startActivity(intent);
            }
        });
        viewHolder.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MyWebViewActivity.class);
                String web_url2 = list.get(position*2+1).getWeb_url();
                intent.putExtra("url",web_url2);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
    class ViewHolder {
        ImageView imageView,imageView2;
        TextView textView ,textView2;
    }
}
