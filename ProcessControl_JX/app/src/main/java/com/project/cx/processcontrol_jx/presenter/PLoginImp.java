package com.project.cx.processcontrol_jx.presenter;

import com.project.cx.processcontrol_jx.ui.activity.ILogin;

/**
 * Created by Administrator on 2018/2/19 0019.
 */

public class PLoginImp implements PLogin {
    private ILogin mLogin;
    public PLoginImp(ILogin loginView) {
        mLogin=loginView;
    }

    @Override
    public void setProgressBar(int visibility) {
        mLogin.setProgressBar(visibility);
    }

    @Override
    public void startRequest() {
        mLogin.onStartRequest();
    }

    @Override
    public void doLogin(String username, String password) {
        mLogin.onLoginSuccess();
    }
}
