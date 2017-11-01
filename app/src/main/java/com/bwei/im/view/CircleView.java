package com.bwei.im.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by muhanxi on 17/10/31.
 */

//http://www.cnblogs.com/goagent/p/5159126.html

public class CircleView extends View {
    public CircleView(Context context) {
        super(context);
    }

    Paint mPaint ;
    int x ;
    int y ;
    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();



    }


    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

//        x = MeasureSpec.getSize(widthMeasureSpec) / 2 ;
//        y = MeasureSpec.getSize(heightMeasureSpec) / 2 ;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        x =  getWidth() / 2 ;
//        y = getHeight() / 2 ;

        mPaint.setColor(Color.RED);
        canvas.drawCircle(x,y,100,mPaint);

    }
}
