package com.woaigsc.mylib1.heros.scroll;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import com.orhanobut.logger.Logger;

/**
 * Created by chuiyuan on 16-5-24.
 */
public class DragView3 extends View {
    private String TAG = this.getClass().getSimpleName();
    private int lastX ;
    private int lastY ;

    private Scroller mScroller ;

    public DragView3(Context context, AttributeSet attrs, int defStyleValue){
        super(context, attrs, defStyleValue);
        mScroller = new Scroller(context);
        initView();
    }
    public DragView3(Context context, AttributeSet attrs){
        this(context, attrs,0);
    }
    public DragView3(Context context){
        this(context, null);
    }

    private void initView(){
        setBackgroundColor(Color.BLUE);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        Log.d(TAG,"computeScroll");
        //This is called in draw
        if(mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(
                    mScroller.getCurrX(),//current scroll location
                    mScroller.getCurrY());
            invalidate();//invalidate->draw->computeScroll
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int)event.getRawX();
        int rawY = (int)event.getRawY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG,"Action down");
                lastX = rawX;
                lastY = rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG,"Action move");
                int offsetX = rawX - lastX;
                int offsetY = rawY - lastY;
                ((View)getParent()).scrollBy(-offsetX,-offsetY);
                /*layout(getLeft() + offsetX,
                        getTop() + offsetY,
                        getRight() + offsetX,
                        getBottom() + offsetY);*/
                lastX = (int)event.getRawX();
                lastY = (int)event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG,"Action up");
                //getScrollX():Return the scrolled position of this view
                View viewGroup = (View)getParent();
                mScroller.startScroll(
                        viewGroup.getScrollX(),
                        viewGroup.getScrollY(),
                        -viewGroup.getScrollX(),
                        -viewGroup.getScrollY()
                );
                invalidate();
                break;
        }
        return true;
    }
}
