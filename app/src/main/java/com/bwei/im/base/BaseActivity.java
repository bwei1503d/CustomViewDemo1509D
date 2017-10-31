package com.bwei.im.base;

import android.os.Bundle;
import android.app.Activity;

import com.bwei.im.R;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
//         基类






    }


    private void initView(){

    }

}
