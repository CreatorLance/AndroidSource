package com.example.a15715.caidaojiaprogram.Mine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a15715.caidaojiaprogram.R;

public class MineFragment extends Fragment {

    Toolbar toolbar ;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine,container,false);
        return view;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        //这里说明getSupportActionBar这个方法是AppCompatActivity这个子类的方法，父类没有这个方法
        //在这里需要将getActivity进行强制转换，这样才能调用这个方法
        if (actionBar!=null){
            actionBar.hide();
        }
        toolbar = (Toolbar) ((AppCompatActivity) getActivity()).findViewById(R.id.toolbar_mine);
    }
}
