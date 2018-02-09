package com.project.cx.processcontrol_jx.base;

/**
 * Created by Administrator on 2018/2/8 0008.
 */

public interface IViewHolder<T> {
    void setViewEventListener(ViewEventListener<T> viewEventListener);
    void setItem(T item);
    void setPosition(int position);
}
