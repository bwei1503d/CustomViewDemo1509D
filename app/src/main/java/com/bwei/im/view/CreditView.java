package com.bwei.im.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by muhanxi on 17/11/6.
 *http://blog.csdn.net/as7210636/article/details/52634769
 * @author muhanxi
 */
public class CreditView extends View {


    /**
     * 绘制外层圆
     */
    private Paint mPaint ;

    /**
     * 绘制内层圆
     */
    private Paint innerPaint;
    /**
     * 内存圆和外层圆的间距
     */
    private int distaince = 20 ;


    /**
     * 内环小刻度画笔
     */
    private Paint nsPaint;
    /**
     * 内环大刻度画笔
     */
    private Paint nbPaint;


    public CreditView(Context context) {
        super(context);
    }

    public CreditView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();

        defaultSize = dp2Px(defaultSize);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setAlpha(50);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);


        innerPaint = new Paint();
        distaince = dp2Px(distaince);
        innerPaint = new Paint();
        innerPaint.setAntiAlias(true);
        innerPaint.setColor(Color.WHITE);
        innerPaint.setAlpha(50);
        innerPaint.setStyle(Paint.Style.STROKE);
        innerPaint.setStrokeWidth(30);



        nsPaint = new Paint();
        nsPaint.setAntiAlias(true);
        nsPaint.setColor(Color.WHITE);
        nsPaint.setAlpha(80);

        nbPaint = new Paint();
        nbPaint.setAntiAlias(true);
        nbPaint.setColor(Color.WHITE);
        nbPaint.setAlpha(100);
        nbPaint.setStrokeWidth(2);







    }


    private int radio = 140 ;
    private int defaultSize = 200;

    private int width;
    private int height;

    public CreditView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    http://blog.csdn.net/as7210636/article/details/52634769

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthMode =  MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);


        if(widthMode != MeasureSpec.EXACTLY){
            width = defaultSize ;
        }
        if(heightMode != MeasureSpec.EXACTLY){
            height = defaultSize ;
        }
        System.out.println("width = " + width + "  " + height) ;
        setMeasuredDimension(width,height);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制最外层的弧
        RectF rectF = new RectF(getPaddingLeft(),getPaddingTop(),getWidth()-getPaddingRight(),getHeight()-getPaddingBottom());
        canvas.drawArc(rectF,-195,210,false,mPaint);



        // 绘制内层外圆
        RectF rectFInner = new RectF(getPaddingLeft()+distaince,getPaddingTop()+distaince,(getWidth()-(getPaddingRight()+distaince)),(getHeight()-(distaince+getPaddingBottom())));
        canvas.drawArc(rectFInner,-195,210,false,innerPaint);


//        绘制刻度
        canvas.save();
        canvas.rotate(-105,radio,radio);
        //计算刻度线的起点结束点
        int startDist = (int)( getPaddingLeft() + distaince - mPaint.getStrokeWidth() / 2 );




    }

    private int dp2Px(int values){

        float density = getResources().getDisplayMetrics().density;
        return (int) (values * density + 0.5f);
    }

}
