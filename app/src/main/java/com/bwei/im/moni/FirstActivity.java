package com.bwei.im.moni;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bwei.im.R;

import muhanxi.cviewgroup.TitleView;

public class FirstActivity extends Activity implements TitleView.MyCallBack {

    private CustomProgess progres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        progres = (CustomProgess) findViewById(R.id.custom_path);

       TitleView titleView = (TitleView) findViewById(R.id.titleview_id);
        titleView.setCallBack(this);


        findViewById(R.id.btn_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progres.start();
            }
        });


    }

    @Override
    public void leftClick() {
        Toast.makeText(this, "left", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void rightClick() {
        Toast.makeText(this, "right", Toast.LENGTH_SHORT).show();

    }
}
