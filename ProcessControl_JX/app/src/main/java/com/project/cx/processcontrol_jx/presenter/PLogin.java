package com.project.cx.processcontrol_jx.presenter;

/**
 * Created by Administrator on 2018/2/19 0019.
 */

public interface PLogin {
    void setProgressBar(int visibility);
    void startRequest();
    void doLogin(String username,String password);
}
