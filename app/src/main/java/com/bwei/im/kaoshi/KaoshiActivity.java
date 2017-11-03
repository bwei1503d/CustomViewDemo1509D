package com.bwei.im.kaoshi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.bwei.im.R;

public class KaoshiActivity extends Activity implements TitleView.LeftCallBack {

    public TitleView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaoshi);












    }

    @Override
    public void leftClick() {
        finish();
        Toast.makeText(this, "leftClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void rightClick() {
        Toast.makeText(this, "rightClick", Toast.LENGTH_SHORT).show();
    }
}
