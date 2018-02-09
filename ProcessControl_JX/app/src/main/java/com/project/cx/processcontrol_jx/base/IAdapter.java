package com.project.cx.processcontrol_jx.base;

import java.util.List;

/**
 * Created by Administrator on 2018/2/8 0008.
 */

public interface IAdapter<T> {//def the adapter manner
    void setItems(List<T> items);
    void addItem(T item);
    void delItem(T item);
    void addItems(List<T> items);
    void clearItems();
    T getItem(int position);
    ViewEventListener<T> getViewEventListener();
    void setViewEventListener(ViewEventListener<T> viewEventListener);
}
