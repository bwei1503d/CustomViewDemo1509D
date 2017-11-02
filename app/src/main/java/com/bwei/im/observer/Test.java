package com.bwei.im.observer;

/**
 * Created by muhanxi on 17/11/2.
 */

public class Test {

    public static void main(String [] args){




//        Rxjava RxAndroid
        Observerable observerable = new Observerable();

        Observer observer1 = new Observer();

        observerable.addObserver(observer1);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        observerable.iNotify();



    }

}
