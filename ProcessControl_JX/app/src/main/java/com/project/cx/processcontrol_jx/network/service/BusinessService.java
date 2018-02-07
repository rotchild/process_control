package com.project.cx.processcontrol_jx.network.service;

import com.project.cx.processcontrol_jx.model.bean.TaskCK;
import com.project.cx.processcontrol_jx.model.bean.TaskResponse;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Administrator on 2018/2/7 0007.
 */

public interface BusinessService {
    @POST("api/AuthSystem/GetTask_ck")
    Observable<TaskResponse<TaskCK>> getTaskCK(@QueryMap Map<String,String> map);
}
