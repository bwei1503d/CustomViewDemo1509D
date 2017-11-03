package com.bwei.im.kaoshi;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.bwei.im.R;

public class SubActivity extends KaoshiActivity implements TitleView.LeftCallBack{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        titleView = (TitleView)  findViewById(R.id.titleview_id);
        titleView.setCallBack(this);













    }


    @Override
    public void leftClick() {
        super.leftClick();
    }

    @Override
    public void rightClick() {
        super.rightClick();
    }
}
