package com.project.cx.processcontrol_jx.ui.fragment;

import java.util.List;

/**
 * Created by Administrator on 2018/2/7 0007.
 */

public interface IBaseFragment<T> {
    void onStartRequest();
    void onFinishRequest(List<T> items);
}
