package com.bwei.im;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;




public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button button = new Button(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });





    }



    //
    private void enqueue(){

//      创建发送求的client 对象
        OkHttpClient client = new OkHttpClient();

        // 创建一个request 对象 ，request 对象 构造包含 请求方法 （get post put delete），请求接口地址
        Request request = new Request.Builder().url("http://120.27.23.105/product/getProducts?pscid=39&page=1").build();

//        newCall 返回Call（实际上 RealCall ） 对象，实际底层 把网络请求放入了一个请求队列
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//失败回调
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

//                成功回调

//                System.out.println("call = " + Thread.currentThread().getName());
                System.out.println("response = " + response.body().string());

            }
        });




    }


    private void postEnqueue(){

        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .build();

//        FormBody 表单
        RequestBody requestBody = new FormBody.Builder()
                .add("pscid","39")
                .add("page","1")
                .build();

        Request request = new Request.Builder().url("http://120.27.23.105/product/getProducts")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "1111", Toast.LENGTH_SHORT).show();
                    }
                });
                System.out.println("response = " + response.body().string());

            }
        });






    }






    private void execute(){

        //同步方法

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder().url("http://120.27.23.105/product/getProducts?pscid=39&page=1").build();

                    Call call =  client.newCall(request);

                    Response response =  call.execute() ;

                    String result =  response.body().string();

                    System.out.println("result = " + result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
