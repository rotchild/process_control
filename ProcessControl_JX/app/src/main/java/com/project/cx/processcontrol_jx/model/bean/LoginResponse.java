package com.project.cx.processcontrol_jx.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 2018/2/22.
 */

public class LoginResponse {
    @SerializedName("err")
    public Error err;

    @SerializedName("success")
    public String success;

    @SerializedName("data")
    public Data data;

    public class Data{
        @SerializedName("userid")
        public String userid;

        @SerializedName("username")
        public String username;

        @SerializedName("token")
        public String token;

        @SerializedName("frontrole")
        public String frontrole;

        @SerializedName("realname")
        public String realname;

        @SerializedName("mobile")
        public String mobile;

        @SerializedName("jobNo")
        public String jobNo;
    }

    public class Error{
        @SerializedName("message")
        public String message;
    }
}
