package com.bw.movie.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.model.XbannerEntity;
import com.stx.xhb.androidx.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * 引导页
 * */
public class GuidePageActivity extends BaseActivity {

    @BindView(R.id.guide_xbanner)
    XBanner guideXbanner;
    private List<XbannerEntity> list = new ArrayList<>();
    @Override
    protected void initData() {
        SharedPreferences guide = getSharedPreferences("guide", 0);
        boolean key = guide.getBoolean("key", false);
        if (key){
            Intent intent = new Intent(GuidePageActivity.this,MainActivity.class);
            startActivity(intent);
        }else {
            list.add(new XbannerEntity(R.drawable.guide_one));
            list.add(new XbannerEntity(R.drawable.guide_two));
            list.add(new XbannerEntity(R.drawable.guide_three));
            list.add(new XbannerEntity(R.drawable.guide_four));
            guideXbanner.setBannerData(list);
            guideXbanner.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    XbannerEntity xbannerEntity = list.get(position);
                    ImageView imageView = (ImageView) view;
                    imageView.setImageResource(xbannerEntity.getSouce());

                }
            });

            guideXbanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    Toast.makeText(GuidePageActivity.this, ""+list.size(), Toast.LENGTH_SHORT).show();
                    if (list.size()-1==position){
                        Intent intent = new Intent(GuidePageActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }

    }

    @Override
    protected void initView() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    @Override
    protected BasePresenter provitePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_guide_page;
    }

}
