package com.woaigsc.mylib1.designpattern.mvp.outeradapter.view;

import android.app.Activity;

import java.util.List;

/**
 * Created by chuiyuan on 16-5-20.
 */
public interface IAdapterView {
    public void onGetDataList(List<String> datas);
    public void onLoadMoreData(String item);
    public void toast(String msg);
    public Activity onGetActivity();
    public void onShowFooterView(boolean isShow);
}
