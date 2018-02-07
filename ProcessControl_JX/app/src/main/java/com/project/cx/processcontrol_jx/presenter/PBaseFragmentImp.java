package com.project.cx.processcontrol_jx.presenter;

import com.project.cx.processcontrol_jx.model.bean.TaskCK;
import com.project.cx.processcontrol_jx.model.bean.TaskResponse;
import com.project.cx.processcontrol_jx.network.RequestCallback;
import com.project.cx.processcontrol_jx.network.RestApiClient;
import com.project.cx.processcontrol_jx.ui.fragment.IBaseFragment;

import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/2/7 0007.
 */

public class PBaseFragmentImp implements PBaseFragment {
    IBaseFragment mBaseFragment;
    RestApiClient mRestApiClient;

    public PBaseFragmentImp(IBaseFragment baseFragment) {
        mBaseFragment=baseFragment;
        initData();
    }

    private void initData() {
        mRestApiClient=new RestApiClient();
    }

    @Override
    public void fetchData(Map<String,String> params) {
        mRestApiClient.businessService().getTaskCK(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestCallback<TaskResponse<TaskCK>>(){
                    @Override
                    public void onResponse(TaskResponse<TaskCK> response) {
                        super.onResponse(response);
                        if(response.success.equals("success")){
                            mBaseFragment.onFinishRequest();
                        }else if(response.success.equals("false")){

                        }
                    }

                    @Override
                    public void onFailure(String errMsg) {
                        super.onFailure(errMsg);
                    }
                });
    }
}
