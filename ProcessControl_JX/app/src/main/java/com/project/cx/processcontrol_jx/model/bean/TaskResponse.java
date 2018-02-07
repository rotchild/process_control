package com.project.cx.processcontrol_jx.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2018/1/23 0023.
 */

public class TaskResponse<T> {
    @SerializedName("err")
    public Error err;

    @SerializedName("success")
    public String success;

    @SerializedName("data")
    public Data<T> data;

    public class Data<T> {
        @SerializedName("servertime")
        public String servertime;

        @SerializedName("data")
        public List<T> dataList;
    }

    public class Error{
        @SerializedName("message")
        public String message;
    }
}
