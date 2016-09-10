package com.example.l.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.l.been.Pic1;
import com.example.l.mediumproject.R;
import com.example.l.utils.HandlerUtils;

import java.util.List;

/**
 * Created by L on 2016/9/4.
 */
public class MyPic1Fadapter extends BaseAdapter {
    List<Pic1.ListBean> list;
    Context context;
    HandlerUtils handlerUtils;

    public MyPic1Fadapter(Context context, HandlerUtils handlerUtils, List<Pic1.ListBean> list) {
        this.context = context;
        this.handlerUtils = handlerUtils;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_news_2,null);
            viewHolder=new ViewHolder();
            viewHolder.textView= (TextView) convertView.findViewById(R.id.news2_textId);
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.news2_imageId);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(list.get(position).getTitle());
        String image = list.get(position).getPic_url();
        viewHolder.imageView.setTag(image);
        handlerUtils.downLoadImage(image);
        return convertView;
    }
    class ViewHolder{
        TextView textView;
        ImageView imageView;
    }
}
