package com.project.cx.processcontrol_jx.ui.activity;

/**
 * Created by Administrator on 2018/2/19 0019.
 */

public interface ILogin {
    void onLoginSuccess();
    void onLoginFail(String errMsg);
    void onInvalidInput();
    void onStartRequest();
    void setProgressBar(int visibility);
}
