package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.util.EncryptUtil;
/*
* 功能：主页
* 作者：王黎杨
* */
public class MainActivity extends BaseActivity {


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        SharedPreferences.Editor guide = getSharedPreferences("guide", 0).edit();
        guide.putBoolean("key",true);
        guide.commit();


    }

    @Override
    protected BasePresenter provitePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
