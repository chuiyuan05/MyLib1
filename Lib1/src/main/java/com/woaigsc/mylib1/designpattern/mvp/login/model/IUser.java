package com.woaigsc.mylib1.designpattern.mvp.login.model;

/**
 * Created by chuiyuan on 16-5-19.
 */
public interface IUser {
    String getName ();
    String getPasswd();
    boolean checkUserValidity(String name, String passed);
}
