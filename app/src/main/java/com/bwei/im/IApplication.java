package com.bwei.im;

import android.app.Application;

import com.bwei.im.exception.CaughtExceptionHandler;

/**
 * Created by muhanxi on 17/11/6.
 */

public class IApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        CaughtExceptionHandler.getInstance().init(this);

    }
}
