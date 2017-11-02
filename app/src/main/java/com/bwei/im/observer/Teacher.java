package com.bwei.im.observer;

/**
 * Created by muhanxi on 17/11/2.
 */

public class Teacher {




    public static void main(String [] args){

        Student student = new Student();

//        boolean result =  student.code();
//        student.setCallBack(new Student.CallBack() {
//            @Override
//            public void sleepover(boolean result) {
//
//                System.out.println("student sleep over = " + result );
//
//            }
//
//            @Override
//            public void eat(boolean result) {
//                System.out.println("student eat over = " + result );
//
//            }
//        });
//        student.sleep();
        student.eat(new Student.CallBack() {
            @Override
            public void sleepover(boolean result) {

            }

            @Override
            public void eat(boolean result) {
                System.out.println("student eat over = " + result );


            }
        });


    }





    public void watchTv(){
        System.out.println(" Teacher watchTv  = " );
    }



}
