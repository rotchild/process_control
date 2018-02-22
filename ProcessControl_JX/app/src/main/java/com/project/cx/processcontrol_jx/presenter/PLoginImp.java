package com.project.cx.processcontrol_jx.presenter;

import android.text.TextUtils;

import com.project.cx.processcontrol_jx.model.bean.LoginResponse;
import com.project.cx.processcontrol_jx.network.RequestCallback;
import com.project.cx.processcontrol_jx.network.RestApiClient;
import com.project.cx.processcontrol_jx.ui.activity.ILogin;

import java.util.HashMap;
import java.util.Map;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
        RestApiClient restApiClient=RestApiClient.getInstance();
        Map<String,String> params=new HashMap<>();
        params.put("username",username);
        params.put("password",password);
        restApiClient.accountService().login(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestCallback<LoginResponse>(){
                    @Override
                    public void onResponse(LoginResponse response) {
                        if(response.success.equals("true")){
                            mLogin.onLoginSuccess();
                        }else{
                            if(response.err!=null){
                                String errMsg=response.err.message;
                                if(!TextUtils.isEmpty(errMsg)){
                                    mLogin.onLoginFail(errMsg);
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(String errMsg) {
                        super.onFailure(errMsg);
                    }
                });

    }
}
