package com.project.cx.processcontrol_jx.presenter;

import android.util.Log;

import com.project.cx.processcontrol_jx.model.bean.TaskResponse;
import com.project.cx.processcontrol_jx.network.RequestCallback;
import com.project.cx.processcontrol_jx.network.RestApiClient;
import com.project.cx.processcontrol_jx.ui.fragment.IBaseFragment;

import java.util.Map;

/**
 * Created by Administrator on 2018/2/7 0007.
 */

public class PBaseFragmentImp<T> implements PBaseFragment<T> {
    IBaseFragment mBaseFragment;
    RestApiClient mRestApiClient;

    public PBaseFragmentImp(IBaseFragment baseFragment) {
        mBaseFragment=baseFragment;
        initData();
    }

    private void initData() {
        mRestApiClient=RestApiClient.getInstance();
    }

    @Override
    public void fetchData(Map<String,String> params,RequestCallback<TaskResponse<T>> callback) {
        /*mRestApiClient.businessService().getTaskCK(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);*/
    }

    @Override
    public void loadMore(Map<String,String> params) {
        fetchData(params,new RequestCallback<TaskResponse<T>>(){
            @Override
            public void onResponse(TaskResponse<T> response) {
                super.onResponse(response);
                if(response.success.equals("true")){
                    mBaseFragment.onLoadMoreFinish(response.data.dataList);
                }else if(response.success.equals("false")){
                    if(response.err!=null){
                        if(response.err.message!=null && response.err.message.length()>0){
                            mBaseFragment.onRequestFail(response.err.message);
                        }else{
                            Log.d("pbasefragment","message is null or size0");
                        }
                    }else{
                        Log.d("pbasefragment","response.err is null or size0");
                    }
                }
            }

            @Override
            public void onFailure(String errMsg) {
                super.onFailure(errMsg);
            }
        });
    }

    @Override
    public void refresh(Map<String,String> params) {
        fetchData(params,new RequestCallback<TaskResponse<T>>(){
            @Override
            public void onResponse(TaskResponse<T> response) {
                super.onResponse(response);
                if(response.success.equals("true")){
                    mBaseFragment.onRefreshFinish(response.data.dataList);
                }else if(response.success.equals("false")){
                    if(response.err!=null){
                        if(response.err.message!=null && response.err.message.length()>0){
                            mBaseFragment.onRequestFail(response.err.message);
                        }else{
                            Log.d("pbasefragment","message is null or size0");
                        }
                    }else{
                        Log.d("pbasefragment","response.err is null or size0");
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
