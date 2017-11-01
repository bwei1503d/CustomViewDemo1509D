package com.bwei.im.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by muhanxi on 17/11/1.
 */

public class CustomProgrssView extends View {

    //定义一个画笔
    private Paint paint ;

    private boolean runing = true ;

    private int progress = 0 ;

    public CustomProgrssView(Context context) {
        super(context);
    }

    public CustomProgrssView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //创建一个画笔
        paint = new Paint();
        // 抗锯齿
        paint.setAntiAlias(true);
        //设置画笔的颜色
        paint.setColor(Color.RED);
        //设置画笔 填充是空心的
        paint.setStyle(Paint.Style.STROKE);


        new Thread(new Runnable() {
            @Override
            public void run() {

                while (runing){


                    if(progress >= 360){
                        runing = false;
                        return;
                    }
                    System.out.println("progress = " + progress);
                    progress += 10 ;

                    //子线程刷新 系统调用onDraw（） 方法
                    postInvalidate();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }).start();



    }


    float sweep ;

    public CustomProgrssView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }





    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


//        getWidth（） 获取当前View 的宽度
        int x =  getWidth() / 2 ;
        int y = getHeight() / 2 ;

        int radius =  200 ;


        //设置画笔的粗细
        paint.setStrokeWidth(30);
        //定义一个区域
        RectF rectF = new RectF(x-radius,y-radius,x+radius,y+radius);
        //画弧
//       useCentor  true 从中心点开始画 false 中心点不现实
        canvas.drawArc(rectF,-90,progress,false,paint);


        int text = (int) ((float)progress / 360  * 100 );

//        measureText  测量字符串的宽度
        float textWidth =  paint.measureText(text+"%");
        Rect rextText = new Rect();
//        rextText.height() 获取字符串的高度
        paint.getTextBounds(text+"%",0,(text+"%").length(),rextText);


        paint.setTextSize(30);
        paint.setStrokeWidth(1);
        //画文字
        canvas.drawText(text+"%",x-textWidth/2,y+rextText.height()/2,paint);


    }
}
