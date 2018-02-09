package com.project.cx.processcontrol_jx.base;

import android.view.View;

/**
 * Created by Administrator on 2018/2/8 0008.
 */

public interface ViewEventListener<T> {
    void onViewEvent(int actionId,T item,int position,View view);
}
