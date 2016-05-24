package com.woaigsc.mylib1.heros.scroll;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.orhanobut.logger.Logger;

/**
 * Created by chuiyuan on 16-5-23.
 */
public class DragView2 extends View{
    private int lastX;
    private int lastY;

    public DragView2(Context context, AttributeSet attrs, int defStyleValue){
        super(context, attrs, defStyleValue);
        initView();
    }
    public DragView2(Context context, AttributeSet attrs){
        this(context, attrs,0);
    }
    public DragView2(Context context){
        this(context, null);
    }

    private void initView(){
        setBackgroundColor(Color.BLUE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Logger.d("Action down");
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.d("Action move");
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                layout(getLeft()+offsetX,
                        getTop()+ offsetY,
                        getRight() + offsetX,
                        getBottom()+ offsetY);
                break;
            case MotionEvent.ACTION_UP:
                Logger.d("Action up");
                break;
        }
        return true;
    }
}
