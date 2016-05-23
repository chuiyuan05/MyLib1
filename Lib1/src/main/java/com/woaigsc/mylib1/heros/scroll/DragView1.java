package com.woaigsc.mylib1.heros.scroll;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.orhanobut.logger.Logger;

/**
 * Created by chuiyuan on 16-5-17.
 */
public class DragView1 extends View {
    private String TAG = this.getClass().getSimpleName() ;
    private int lastX ;
    private int lastY ;

    public DragView1(Context context){
        this(context, null);
    }

    public DragView1(Context context, AttributeSet attrs){
        this(context, attrs, 0);
    }

    public DragView1(Context context, AttributeSet attrs,
                     int defStyleValue){
        super(context, attrs, defStyleValue);
        initView();
    }

    private void initView(){
        setBackgroundColor(Color.BLUE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int x = (int)event.getX() ;
        int y = (int)event.getY() ;
        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:
                lastX = x ;
                lastY = y ;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX ;
                int offsetY = y - lastY ;
                /*layout(getLeft()+offsetX,
                        getTop()+ offsetY,
                        getRight()+ offsetX,
                        getBottom()+ offsetY);*/
                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);
                break;
        }
        return true ;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Logger.d("getX:"+event.getX()+",getY:"+event.getY());
            Logger.d("getRawX:"+event.getRawX()+",getRawY:"+event.getRawY());
        }

        return super.dispatchTouchEvent(event);
    }
}
