package com.woaigsc.mylib1.heros.scroll;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by chuiyuan on 16-5-25.
 */
public class DragViewGroup extends FrameLayout {
    private String TAG = this.getClass().getSimpleName() ;

    private ViewDragHelper mViewDragHelper ;
    private View mMenuView ;
    private View mMainView ;
    private View mMainBtn;
    private int mWidth ;

    public DragViewGroup(Context context, AttributeSet attrs, int defStyleValue){
        super(context, attrs, defStyleValue);
        initView(context);
    }
    public DragViewGroup(Context context, AttributeSet attrs){
        this(context, attrs,0);
    }
    public DragViewGroup(Context context){
        this(context, null);
    }

    private void initView(Context context){
        mViewDragHelper = ViewDragHelper.create(this,callback);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
        //return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
        //return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll(){
        if(mViewDragHelper.continueSettling(true)){
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenuView = getChildAt(0);
        mMainView = getChildAt(1);
        mMainBtn = getChildAt(2);
    }

    @Override
    protected  void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w,h,oldw,oldh);
        mWidth = mMenuView.getMeasuredWidth();
        Log.d(TAG, "onSizeChanged: measuredWith:"+mMenuView.getMeasuredWidth());// not 0
        Log.d(TAG, "onSizeChanged: With:"+mMenuView.getWidth());//0
    }

    private ViewDragHelper.Callback callback = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return mMainView == child;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return left;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return 0;
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            if(mMainView.getLeft() < 500){
                mViewDragHelper.smoothSlideViewTo(mMainView, 0, 0);//initial position
                ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
            }else {
                mViewDragHelper.smoothSlideViewTo(mMainView, 300, 0);
                ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
            }
        }

    };
}
