package com.bwei.im.observer;

/**
 * Created by muhanxi on 17/11/2.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 */
public class Observerable {


    public List<Observer> list = new ArrayList<>();


    public void addObserver(Observer observer){
        this.list.add(observer);
    }


    public void removeObserver(Observer observer){
        this.list.remove(observer);
    }

    public void iNotify(){

        System.out.println(" 被观察者 发出通知 " );

        for (Observer list1 : list){
            list1.update();
        }

    }






}
