package muhanxi.cviewgroup;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by muhanxi on 17/11/4.
 */

public class TitleView extends LinearLayout {
    public TitleView(Context context) {
        super(context);
    }

    public TitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

       View view = LayoutInflater.from(context).inflate(R.layout.kaoshi_title_layout,null);
        view.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        addView(view);

       Button buttonLeft = (Button) view.findViewById(R.id.left_btn);

        Button buttonRight = (Button) view.findViewById(R.id.right_btn);

        buttonLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.leftClick();
            }
        });
        buttonRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.rightClick();
            }
        });

    }

    public TitleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    private MyCallBack callBack ;
    public void setCallBack(MyCallBack callBack){
        this.callBack = callBack;
    }


    public interface  MyCallBack {
        public void leftClick();
        public void rightClick();

    }


}
