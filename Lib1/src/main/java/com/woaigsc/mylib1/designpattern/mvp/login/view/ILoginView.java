package com.woaigsc.mylib1.designpattern.mvp.login.view;

/**
 * Created by chuiyuan on 16-5-19.
 */
public interface ILoginView {
    public void onClearText();
    public void onLoginResult(boolean result);
    public void onSetProgressBarVisible(int visible);
}
