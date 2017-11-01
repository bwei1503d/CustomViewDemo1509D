package com.bwei.im.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bwei.im.R;
import com.bwei.im.bean.ShopBean;

import java.util.List;

/**
 * Created by muhanxi on 17/11/1.
 */

public class ShopAdapter extends BaseAdapter {


    private List<ShopBean> list ;

    private Context context ;
    public ShopAdapter(Context context,List<ShopBean> list){
        this.context = context;
        this.list = list ;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {

//        list.get(position).getData().get(position).get


       if(position % 2 == 0){
           return 1;
       }else {
           return 0;
       }

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

       int type =  getItemViewType(i);
        SingleImageViewHolder singleImageViewHolder ;
        MultiImageViewHolder multiImageViewHolder ;
       switch (type){
           case 0:

               if(view == null){
                   view = View.inflate(context, R.layout.activity_base,null);
                   singleImageViewHolder = new SingleImageViewHolder();
                   // 执行 findviewById
                   view.setTag(singleImageViewHolder);
               } else {
                   singleImageViewHolder = (SingleImageViewHolder) view.getTag() ;
               }


               //直接赋值

               break;
           case 1:
               if(view == null){
                   view = View.inflate(context, R.layout.activity_base,null);
                   multiImageViewHolder = new MultiImageViewHolder();
                   // 执行 findviewById
                   view.setTag(multiImageViewHolder);
               } else {
                   multiImageViewHolder = (MultiImageViewHolder) view.getTag() ;
               }

               //直接赋值
               break;
       }





        return null;
    }


    static class  SingleImageViewHolder {

    }
    static class  MultiImageViewHolder {

    }
}
