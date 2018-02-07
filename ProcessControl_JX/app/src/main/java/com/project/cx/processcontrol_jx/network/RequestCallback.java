package com.project.cx.processcontrol_jx.network;

import rx.Subscriber;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public class RequestCallback<T> extends Subscriber<T> {
    private static final String TAG = "RequestCallback";

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        onFailure(e.getMessage());
    }

    @Override
    public void onNext(T t) {
        onResponse(t);
    }

    public void onResponse(T response) {}

    public void onFailure(String errMsg){}

}
