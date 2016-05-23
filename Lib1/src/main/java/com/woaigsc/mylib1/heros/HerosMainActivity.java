package com.woaigsc.mylib1.heros;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.woaigsc.mylib1.R;
import com.woaigsc.mylib1.heros.listview.ChatListViewActivity;
import com.woaigsc.mylib1.heros.listview.FlexibleActivity;
import com.woaigsc.mylib1.heros.listview.FocusListViewActivity;
import com.woaigsc.mylib1.heros.listview.NotifyTest;
import com.woaigsc.mylib1.heros.listview.ScrollHideListView;
import com.woaigsc.mylib1.heros.scroll.ScrollTestActivity;

/**
 * Created by chuiyuan on 16-5-15.
 */
public class HerosMainActivity  extends AppCompatActivity{
    private static String TAG ="HerosMainActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceSate){
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.mylib_main_activity);
    }

    public void btnNotify(View view){
        startActivity(new Intent(this, NotifyTest.class));
    }

    public void btnScrollHideListView(View view){
        startActivity(new Intent(this, ScrollHideListView.class));
    }

    public void btnChatActivity(View view) {
        startActivity(new Intent(this, ChatListViewActivity.class));
    }

    public void btnFocusListViewActivity(View view) {
        startActivity(new Intent(this, FocusListViewActivity.class));
    }

    public void btnFlexibleActivity(View view){
        startActivity(new Intent(this, FlexibleActivity.class));
    }
    public void btnScrollActivity(View view){
        startActivity(new Intent(this, ScrollTestActivity.class));
    }


}
