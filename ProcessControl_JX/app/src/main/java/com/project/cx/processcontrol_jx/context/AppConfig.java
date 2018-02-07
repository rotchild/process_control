package com.project.cx.processcontrol_jx.context;

/**
 * Created by Administrator on 2018/2/7 0007.
 */

public class AppConfig {
    /**
     * 连接超时时间
     */
    public static final int CONNECT_TIMEOUT_MILLIS = 15 * 1000; // 15s

    /**
     * 响应超时时间
     */
    public static final int READ_TIMEOUT_MILLIS = 20 * 1000; // 20s

    public static final String SERVER_URL = "http://192.168.1.13:7091/";
}
