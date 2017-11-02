package com.bwei.im.observer;

/**
 * Created by muhanxi on 17/11/2.
 */

public class Student {




    public boolean code(){
        System.out.println(" student code " );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;

    }


    public void sleep(){
        System.out.println(" student sleep " );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        callBack.sleepover(true);


    }


    public void eat(CallBack callBack){
        System.out.println(" student eat " );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callBack.eat(true);

    }


//
//    public CallBack callBack ;
//
//    public void setCallBack(CallBack callBack){
//        this.callBack = callBack;
//    }

    interface CallBack {
        public void sleepover(boolean result);
        public void eat(boolean result);
    }


}
