package com.bw.movie.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
/*
 * 功能：启动页
 * 作者：王黎杨
 * */
public class StartActivity extends BaseActivity {

    @BindView(R.id.mv_tv_time)
    TextView mvTvTime;
    private int i = 3;
    private Handler handler = new Handler() {
        int time = 1;

        @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (time == 3) {
                    Intent intent = new Intent(StartActivity.this,GuidePageActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    time++;
                    i--;
                    mvTvTime.setText(i+"S");

                    handler.sendEmptyMessageDelayed(0, 1000);
                }
            }
        }
    };

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //沉浸式布局
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        handler.sendEmptyMessageDelayed(0, 1000);
    }

    @Override
    protected BasePresenter provitePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_start;
    }

}
