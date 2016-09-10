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

import com.example.l.been.News1;
import com.example.l.mediumproject.MyWebViewActivity;
import com.example.l.mediumproject.R;
import com.example.l.utils.HandlerUtils;

import java.util.List;

/**
 * Created by L on 2016/9/4.
 */
public class MyNews1Fadapter extends BaseAdapter {
    List<News1.SpecificBean> specificBeanList;
    List<News1.EspeciallyBean> especiallyBeanlist;
    Context context;
    final int type1=0;
    final int type2=1;
    HandlerUtils handlerUtils;

    public MyNews1Fadapter(Context context, List<News1.EspeciallyBean> especiallyBeanlist, HandlerUtils handlerUtils, List<News1.SpecificBean> specificBeanList) {
        this.context = context;
        this.especiallyBeanlist = especiallyBeanlist;
        this.handlerUtils = handlerUtils;
        this.specificBeanList = specificBeanList;
    }

    @Override
    public int getCount() {
        return specificBeanList.size()+especiallyBeanlist.size()/2;

    }

    @Override
    public Object getItem(int position) {
        if (position%5==0){
            return especiallyBeanlist.get((position/5)*2);
        }else {
            return specificBeanList.get(position-(position/5+1));
        }

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (position%5==0){
            return type1;
        }else {
            return type2;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder1 viewHolder1=null;
        ViewHolder2 viewHolder2=null;
        int type = getItemViewType(position);
        switch (type){
            case 0:
                if (convertView==null){
                    convertView=LayoutInflater.from(context).inflate(R.layout.item_news_12,null);
                    viewHolder2 = new ViewHolder2();
                    viewHolder2.imageView= (ImageView) convertView.findViewById(R.id.news12_imageId);
                    viewHolder2.textView= (TextView) convertView.findViewById(R.id.news12_textId);
                    viewHolder2.imageView2= (ImageView) convertView.findViewById(R.id.news12_image2Id);
                    viewHolder2.textView2= (TextView) convertView.findViewById(R.id.news12_text2Id);
                    convertView.setTag(viewHolder2);
                }else {
                    viewHolder2= (ViewHolder2) convertView.getTag();
                }
                viewHolder2.textView.setText(especiallyBeanlist.get((position/5)*2).getTitle());
                viewHolder2.textView2.setText(especiallyBeanlist.get((position/5)*2+1).getTitle());
                final String url1=especiallyBeanlist.get((position/5)*2).getPic_url();
                final String url2=especiallyBeanlist.get((position/5)*2+1).getPic_url();
                Log.d("lzb","url1"+especiallyBeanlist);
                Log.d("lzb","url2"+url2);
                viewHolder2.imageView.setTag(url1);
                viewHolder2.imageView2.setTag(url2);
                handlerUtils.downLoadImage(url1);

                handlerUtils.downLoadImage(url2);
                viewHolder2.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context, MyWebViewActivity.class);
                        String web_url = especiallyBeanlist.get((position/5)*2).getWeb_url();
                        intent.putExtra("url",web_url);
                        context.startActivity(intent);
                    }
                });
                viewHolder2.imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context, MyWebViewActivity.class);
                        String web_url2 = especiallyBeanlist.get((position/5)*2+1).getWeb_url();
                        intent.putExtra("url",web_url2);
                        context.startActivity(intent);
                    }
                });
                break;
            case 1:
                if (convertView==null){
                    convertView= LayoutInflater.from(context).inflate(R.layout.item_news_1,null);
                    viewHolder1=new ViewHolder1();
                    viewHolder1.imageView= (ImageView) convertView.findViewById(R.id.news1_imageId);
                    viewHolder1.textView= (TextView) convertView.findViewById(R.id.news1_textId);
                    viewHolder1.textView2= (TextView) convertView.findViewById(R.id.news1_text2Id);
                    convertView.setTag(viewHolder1);
                }
                else {
                    viewHolder1= (ViewHolder1) convertView.getTag();
                }
                viewHolder1.textView.setText(specificBeanList.get(position-(position/5+1)).getTitle());
                viewHolder1.textView2.setText(specificBeanList.get(position-(position/5+1)).getDate());
                final String imageurl= specificBeanList.get(position-(position/5+1)).getPic_url();
                Log.d("lzb","url2"+specificBeanList);
                viewHolder1.imageView.setTag(imageurl);
                handlerUtils.downLoadImage(imageurl);
                viewHolder1.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context, MyWebViewActivity.class);
                        String web_url3 = specificBeanList.get(position-(position/5+1)).getWeb_url();
                        intent.putExtra("url",web_url3);
                        context.startActivity(intent);
                    }
                });
                break;
        }

        return convertView;
    }
    class ViewHolder1{
        ImageView imageView;
        TextView textView ,textView2;
    }
    class ViewHolder2 {
        ImageView imageView,imageView2;
        TextView textView ,textView2;
    }
}
