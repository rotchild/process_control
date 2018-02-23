package com.project.cx.processcontrol_jx;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2018/2/20 0020.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;
    public static Context getContext(){
        return myApplication;
    }
    public static Application getApplication(){
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication=this;
    }
}
