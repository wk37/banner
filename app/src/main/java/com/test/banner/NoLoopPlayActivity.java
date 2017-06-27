package com.test.banner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.test.banner.loader.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;


public class NoLoopPlayActivity extends AppCompatActivity {

    Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banner = (Banner) findViewById(R.id.banner);
         final List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.b1);
        images.add(R.mipmap.b2);
        images.add(R.mipmap.b3);

        banner.isLoopPlay(false);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);

        final List<String> titles = new ArrayList<>();
        titles.add("第1个标题");
        titles.add("第2个标题");
        titles.add("第3个标题");
        banner.setBannerTitles(titles);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                if (position == images.size() - 1 ){
                    // TODO: 2017/6/27 最后一页，点击任何区域 跳转
                }
            }
        });
        banner.setImages(images)
                .setImageLoader(new GlideImageLoader())
                .start();

    }




}
