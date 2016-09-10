package com.example.l.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.l.adapter.MyNewsFadapter;
import com.example.l.adapter.MySetFadapter;
import com.example.l.mediumproject.AboutActivity;
import com.example.l.mediumproject.LoginActivity;
import com.example.l.mediumproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L on 2016/9/3.
 */
public class Fragment_Set extends Fragment implements RadioGroup.OnCheckedChangeListener {
    RadioGroup radioGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_set,null);

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        radioGroup= (RadioGroup) view.findViewById(R.id.radioGroup5Id);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.buttonsetId:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonset2Id:
                break;
            case R.id.buttonset3Id:
                break;
            case R.id.buttonset4Id:
                break;
            case R.id.buttonset5Id:
                break;
            case R.id.buttonset6Id:
                break;
            case R.id.buttonset7Id:
                break;
            case R.id.buttonset8Id:
                Intent intent8 = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent8);
                break;
        }
    }
}
