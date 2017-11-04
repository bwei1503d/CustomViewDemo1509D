package com.bwei.im.moni;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by muhanxi on 17/11/4.
 */

public class CircleView extends View {


    Paint paint ;

    public CircleView(Context context) {
        super(context);
    }
    int progress = 0 ;
    int max = 360;
    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();



        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){


                    if(progress > 360){
                        return;
                    }
                    postInvalidate();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress += 36 ;


                }

            }
        }).start();




    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.BLACK);
        canvas.drawCircle(300,300,100,paint);


        RectF rectF = new RectF(200,200,400,400);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF,-90,progress,false,paint);

        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        int percent = progress;  //中间的进度百分比，先转换成float在进行除法运算，不然都为0
        float textWidth = paint.measureText(percent+"  %   ");
        paint.setTextSize(20);
        canvas.drawText((float)progress/(float) 360 * 100 +"%",300,300,paint);

    }
}
