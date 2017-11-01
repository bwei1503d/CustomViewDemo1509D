package com.bwei.im.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import static android.R.attr.x;

/**
 * Created by muhanxi on 17/11/1.
 */

public class CustomCircleView extends View {

    private Paint mPaint;

    private int cx = 200;
    private int cy = 200;

    public CustomCircleView(Context context) {
        super(context);
    }

    public CustomCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(10);


    }

    public CustomCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

//        MeasureSpec.get

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                System.out.println("event ACTION_DOWN = " + event.getRawX() + "  " + event.getRawY());
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("event ACTION_MOVE = " + event.getRawX() + "  " + event.getRawY());

                cx = (int) event.getX() ;
                 cy =(int) event.getY();
                //刷新
                invalidate();
//                postInvalidate();

                break;
            case MotionEvent.ACTION_UP:
                System.out.println("event ACTION_UP = " + event.getRawX() + "  " + event.getRawY());

                break;
        }



        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


//        int x =  getWidth() / 2 ;
        canvas.drawCircle(cx,cy,200,mPaint);



    }
}
