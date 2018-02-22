package com.project.cx.processcontrol_jx.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.cx.processcontrol_jx.model.bean.ResponseError;

/**
 * Created by Administrator on 2018/2/13 0013.
 */

public abstract class BaseFragment<UC> extends Fragment implements BaseController.Ui<UC> {
    private UC mCallbacks;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getController().attachUi(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        getController().startUi(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getController().detachUi(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



    @Override
    public void setCallbacks(UC callbacks) {
        mCallbacks=callbacks;
    }

    @Override
    public UC getCallbacks() {
        return mCallbacks;
    }

    @Override
    public void onResponseError(ResponseError error) {

    }

    protected abstract BaseController getController();
}
