package com.bwei.im.moni;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by LYY on 2017/11/4.
 */
public class CustomProgess extends View {


  private Paint paint;

    private int progress = 0 ;

    Context context ;

    public CustomProgess(Context context) {
        super(context);

    }


    public CustomProgess(Context context, AttributeSet attrs) {
        this(context, attrs,0);

    }

    public CustomProgess(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        //创建一个画笔
        paint = new Paint();
        // 抗锯齿
        paint.setAntiAlias(true);
        //设置画笔的颜色
        paint.setColor(Color.RED);
        //设置画笔 填充是空心的
        paint.setStyle(Paint.Style.STROKE);





    }



    public void start(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){


                    if(progress >= 360){

                        return;
                    }

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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
      //  getWidth（） 获取当前View 的宽度
        int x =  getWidth() / 2 ;
        int y = getHeight() / 2 ;

        int radius =  200 ;


        //设置画笔的粗细
        paint.setStrokeWidth(30);
        //定义一个区域
        RectF rectF = new RectF(x-radius,y-radius,x+radius,y+radius);
        //画弧

        canvas.drawArc(rectF,-90,progress,false,paint);


        int text = (int) ((float)progress / 360  * 100 );

        float textWidth =  paint.measureText(text+"%");
        Rect rextText = new Rect();

        paint.getTextBounds(text+"%",0,(text+"%").length(),rextText);


        paint.setTextSize(30);
        paint.setStrokeWidth(1);
        //画文字
        canvas.drawText(text+"%",x-textWidth/2,y+rextText.height()/2,paint);

        if(progress == 100 ){

//            context.startActivity();

        }

    }
}


