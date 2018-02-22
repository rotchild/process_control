package com.project.cx.processcontrol_jx;

import android.app.Application;

/**
 * Created by Administrator on 2018/2/20 0020.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;
    public static Application getContext(){
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication=this;
    }
}
