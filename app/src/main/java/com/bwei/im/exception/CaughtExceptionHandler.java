package com.bwei.im.exception;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

import com.bwei.im.ReportActivity;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by muhanxi on 17/11/6.
 */

public class CaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private  static   CaughtExceptionHandler instance = null;
    // 表示系统默认处理异常
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    private CaughtExceptionHandler(){


    }

    /**
     * 存储设备硬件相关信息
     */
    private Map<String, String> infos = new HashMap<String, String>();


    public static CaughtExceptionHandler getInstance(){
        if(instance == null){
            instance = new CaughtExceptionHandler();
        }
        return instance;
    }




    private Context context ;

    public void init(Context context){

        this.context = context ;
        // 获取系统线程 处理异常对象
        uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

        //  设置系统异处理对象
        Thread.setDefaultUncaughtExceptionHandler(this);

    }


    /**
     * 全局异常  来到这里
     * @param t  表示线程
     * @param e   表示异常
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {

        if (!handleException(e) && uncaughtExceptionHandler != null) {
            //如果用户没有处理则让系统默认的异常处理器来处理
            uncaughtExceptionHandler.uncaughtException(t, e);
        }
//
//        System.out.println("t = " + t);
//        System.out.println("e = " + e.getMessage());
//
//        collectDeviceInfo(context);


    }


    /**
     *  false 表示自己没有做异常处理
     *  trur  该异常自己处理
     * @param throwable
     * @return
     */
    private boolean handleException(Throwable throwable){


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                Looper.prepare();
//                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
//                Looper.loop();
//            }
//        }).start();


			Intent intent = new Intent(context, ReportActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(intent);

        android.os.Process.killProcess(Process.myPid());

        if(throwable != null){

            saveException(throwable);
            collectDeviceInfo(context);

            return true;
        }





        return false;

    }

    /**
     * 异常信息保存到sd卡
     * @param throwable
     */
    private void saveException(Throwable throwable){
        String exception = throwable.getMessage() ;
        //异常保存到sd卡  info 保存   时间



    }

    /**
     * 手机设备信息
     * @param ctx
     */
    public void collectDeviceInfo(Context ctx) {
        try {
//            4 2 1
            PackageManager pm = ctx.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(), PackageManager.GET_ACTIVITIES);
            if (pi != null) {
                String versionName = pi.versionName == null ? "null" : pi.versionName;
                String versionCode = pi.versionCode + "";
                infos.put("versionName", versionName);
                infos.put("versionCode", versionCode);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("tag", "an error occured when collect package info", e);
        }
        //通过反射 获取 Build 字段  Build 表示设备硬件相关信息
        Field[] fields = Build.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                infos.put(field.getName(), field.get(null).toString());
                Log.d("tag", field.getName() + " : " + field.get(null));
            } catch (Exception e) {
                Log.e("tag", "an error occured when collect crash info", e);
            }
        }
    }
}
