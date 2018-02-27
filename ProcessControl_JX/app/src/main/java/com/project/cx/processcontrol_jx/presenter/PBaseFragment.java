package com.project.cx.processcontrol_jx.presenter;

import com.project.cx.processcontrol_jx.model.bean.TaskResponse;
import com.project.cx.processcontrol_jx.network.RequestCallback;

import java.util.Map;

/**
 * Created by Administrator on 2018/2/7 0007.
 */

public interface PBaseFragment<T> {
    void fetchData(Map<String,String> params, RequestCallback<TaskResponse<T>> callback);
    void loadMore(Map<String,String> params);
    void refresh(Map<String,String> params);
}
