package com.example.l.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.l.been.Forum;
import com.example.l.mediumproject.R;
import com.example.l.utils.HandlerUtils;

import java.util.List;

/**
 * Created by L on 2016/9/9.
 */
public class MyForumShowAdapter extends BaseAdapter {
    List<Forum.ListBean> list;
    Context context;
    HandlerUtils handlerUtils;

    public MyForumShowAdapter(Context context, HandlerUtils handlerUtils, List<Forum.ListBean> list) {
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
            convertView= LayoutInflater.from(context).inflate(R.layout.item_showforum,null);
            viewHolder= new ViewHolder();
            viewHolder.textView= (TextView) convertView.findViewById(R.id.text_showfroumId);
            viewHolder.textView2= (TextView) convertView.findViewById(R.id.text_showfroum2Id);
            viewHolder.textView3= (TextView) convertView.findViewById(R.id.text_showfroum3Id);
            viewHolder.textView4= (TextView) convertView.findViewById(R.id.text_showfroum4Id);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();

        }
        viewHolder.textView.setText(list.get(position).getTitle());
        viewHolder.textView2.setText(list.get(position).getAuthor());
        viewHolder.textView3.setText(list.get(position).getViews());
        viewHolder.textView4.setText(list.get(position).getReply());
        return convertView;
    }
    class ViewHolder{
        TextView textView,textView2,textView3,textView4;
    }
}
