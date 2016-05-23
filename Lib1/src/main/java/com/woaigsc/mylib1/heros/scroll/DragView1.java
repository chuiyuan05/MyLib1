package com.woaigsc.mylib1.heros.scroll;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

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
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG,"Before");
                Log.d(TAG,"getX "+event.getX()+ "getY "+event.getY());
                Log.d(TAG,"getRawX "+event.getRawX()+" getRawY "+event.getRawY());
                Log.d(TAG,"getLeft "+getLeft()+" getTop "+getTop());
                /*layout(getLeft()+50,
                        getTop()+100,
                        getRight()+50,
                        getBottom()+100);*/

                /*offsetLeftAndRight(50);
                offsetTopAndBottom(100);*/

                /*ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams)getLayoutParams();
                lp.leftMargin = getLeft()+50;
                lp.topMargin = getTop()+100;
                setLayoutParams(lp);*/

                /*((View)getParent()).scrollBy(-50,-100);*/
                /*AnimatorSet set = new AnimatorSet();
                set.playTogether(
                        ObjectAnimator.ofFloat(this, "translationX", 50),
                        ObjectAnimator.ofFloat(this,"translationY", 100)

                );
                set.start();*/

                TranslateAnimation anim = new TranslateAnimation(0,50,0,100);
                anim.setFillAfter(true);
                startAnimation(anim);

                Log.d(TAG, "After");
                Log.d(TAG,"getX "+event.getX()+ "getY "+event.getY());
                Log.d(TAG,"getRawX "+event.getRawX()+" getRawY "+event.getRawY());
                Log.d(TAG,"getLeft "+getLeft()+" getTop "+getTop());

                break;
        }
        return true ;
    }

}
