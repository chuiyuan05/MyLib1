package com.woaigsc.mylib1.heros.scroll;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.woaigsc.mylib1.R;

/**
 * Created by chuiyuan on 16-5-23.
 */
public class ScrollTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylib1_scrolltest_activity);
    }

    public void btnDragViewActivity(View view){
        startActivity(new Intent(this, DragViewTestActivity.class));
    }

    public void btnDragViewGroupActivity(View view){
        startActivity(new Intent(this, DragViewGroupTestActivity.class));
    }
}
