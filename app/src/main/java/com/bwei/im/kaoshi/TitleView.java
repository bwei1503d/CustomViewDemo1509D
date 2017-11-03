package com.bwei.im.kaoshi;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.bwei.im.R;

/**
 * Created by muhanxi on 17/11/3.
 */

public class TitleView extends LinearLayout {
    public TitleView(Context context) {
        this(context,null);
    }

    public TitleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);

    }

    public TitleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        // setContentView
        LayoutInflater.from(context).inflate(R.layout.kaoshi_title_layout, this);

//        View view =  View.inflate(context,R.layout.kaoshi_title_layout,null);
//        view.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        Button left =  (Button) findViewById(R.id.left_btn);
        Button right =  (Button)findViewById(R.id.right_btn);

        left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.leftClick();

            }
        });

        right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.rightClick();
            }
        });
//        addView(view);





    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


    }



    public LeftCallBack callBack ;
    public void setCallBack(LeftCallBack callBack){
        this.callBack  = callBack;
    }



    interface  LeftCallBack {

        public void leftClick();
        public void rightClick();


    }


}
