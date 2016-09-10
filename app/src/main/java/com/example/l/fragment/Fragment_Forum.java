package com.example.l.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.example.l.adapter.MyForumFadapter;
import com.example.l.mediumproject.R;
import com.example.l.mediumproject.ShowForumActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L on 2016/9/3.
 */
public class Fragment_Forum extends Fragment {
    ListView listView;
    List<String> list;
    RadioGroup radioGroup;
    MyForumFadapter adapter;
    int j=1;
    private static final String URL="http://api.fengniao.com/app_ipad/bbs_all_hot.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&page=";
    String[] Allforum= {"热帖","精华帖","最新帖子","最新回复"};
    String[] works={"人像","风光","纪实","人体","儿童","建筑","生态","宠物"};
    String[] photography = {"商业","女性视觉","新手","数码","黑白","实验","生活摄影","高校","手机","葡萄酒"};
    String[] trading={"交易警示","二手交易","器材维修"};
    String[] substation = {"北京","上海","武汉"};
    String[] equipment={"单反和镜头","大中画幅","便携数码"};
    String[] service = {"活动区","网友服务","蜂鸟茶馆"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_forum,null);

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list=new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.L_forumId);
        radioGroup= (RadioGroup) view.findViewById(R.id.radioGroup4Id);
        for (int i=0;i<Allforum.length;i++){
            list.add(Allforum[i]);

        }
        adapter=new MyForumFadapter(getActivity(),list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getContext(), ShowForumActivity.class);
                String url=URL+(j+position)  ;
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                list.clear();
                switch (checkedId){
                    case R.id.buttonforumId:
                        j=1;
                        for (int i=0;i<Allforum.length;i++){
                            list.add(Allforum[i]);

                        }
                        adapter.notifyDataSetChanged();
                    break;
                    case R.id.buttonforum2Id:
                        j=5;
                        for (int i=0;i<works.length;i++){
                            list.add(works[i]);
                        }
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.buttonforum3Id:
                        j=14;
                        for (int i=0;i<photography.length;i++){
                            list.add(photography[i]);
                        }
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.buttonforum4Id:
                        j=24;
                        for (int i=0;i<trading.length;i++){
                            list.add(trading[i]);
                        }
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.buttonforum5Id:
                        j=27;
                        for (int i=0;i<substation.length;i++){
                            list.add(substation[i]);
                        }
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.buttonforum6Id:
                        j=30;
                        for (int i=0;i<equipment.length;i++){
                            list.add(equipment[i]);
                        }
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.buttonforum7Id:
                        j=33;
                        for (int i=0;i<service.length;i++){
                            list.add(service[i]);
                        }
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        });



    }

}
