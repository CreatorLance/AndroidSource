package com.example.a15715.caidaojiaprogram;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a15715.caidaojiaprogram.Attention.AttentionFragment;
import com.example.a15715.caidaojiaprogram.CaiLan.CaiLanFragment;
import com.example.a15715.caidaojiaprogram.Home.HomeFragment;
import com.example.a15715.caidaojiaprogram.Login.LoginActivity;
import com.example.a15715.caidaojiaprogram.Mine.MineFragment;
import com.example.a15715.caidaojiaprogram.Study.StudyFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView home_picture ;
    ImageView study_picture;
    ImageView attention_picture;
    ImageView caiLan_picture;
    ImageView mine_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();   //将自带的标题栏隐藏
        if (actionBar!=null){
            actionBar.hide();
        }

        View home =(View) findViewById(R.id.home_page);
        home.setOnClickListener(this);
        View study = (View)findViewById(R.id.study_page);
        study.setOnClickListener(this);
        View attention = (View) findViewById(R.id.attention_page);
        attention.setOnClickListener(this);
        View caiLan = (View)findViewById(R.id.CaiLan_page);
        caiLan.setOnClickListener(this);
        View mine = (View)findViewById(R.id.mine_page);
        mine.setOnClickListener(this);

        home_picture = (ImageView)findViewById(R.id.home_picture);
        study_picture = (ImageView)findViewById(R.id.study_picture);
        attention_picture = (ImageView)findViewById(R.id.attention_picture);
        caiLan_picture = (ImageView)findViewById(R.id.CaiLan_picture);
        mine_picture = (ImageView)findViewById(R.id.mine_picture);
        setTableSelection(1);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_page:
                setTableSelection(1);
                break;
            case R.id.study_page:
                setTableSelection(2);
                break;
            case R.id.attention_page:
                setTableSelection(3);
                break;
            case R.id.CaiLan_page:
                setTableSelection(4);
                break;
            case R.id.mine_page:
                setTableSelection(5);
                break;
        }
    }

    public void setTableSelection(int index){              //记录用户对菜单的选项
        switch (index){
            case 1:clearSelection();
                home_picture.setImageResource(R.drawable.home1);
                replaceFragment(new HomeFragment());
                break;
            case 2:clearSelection();
                study_picture.setImageResource(R.drawable.study1);
                replaceFragment(new StudyFragment());
                break;
            case 3:clearSelection();
                attention_picture.setImageResource(R.drawable.attention1);
                replaceFragment(new AttentionFragment());
                break;
            case 4:clearSelection();
                caiLan_picture.setImageResource(R.drawable.cailan1);
                replaceFragment(new CaiLanFragment());
                break;
            case 5:clearSelection();
                mine_picture.setImageResource(R.drawable.mine1);
                replaceFragment(new MineFragment());
                break;
        }
    }


   public void clearSelection(){                           //对app开始的菜单选项进行初始化
       home_picture.setImageResource(R.drawable.home);
       study_picture.setImageResource(R.drawable.study);
       attention_picture.setImageResource(R.drawable.attention);
       caiLan_picture.setImageResource(R.drawable.cailan);
       mine_picture.setImageResource(R.drawable.mine);
   }

   private void replaceFragment(Fragment fragment){
       FragmentManager fragmentManager = getSupportFragmentManager();
       FragmentTransaction transaction = fragmentManager.beginTransaction();
       transaction.replace(R.id.content,fragment);
       transaction.commit();
   }

}
