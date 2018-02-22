package com.project.cx.processcontrol_jx.base;

import com.project.cx.processcontrol_jx.model.bean.ResponseError;

/**
 * Created by Administrator on 2018/2/13 0013.
 */

public abstract class BaseController<U extends BaseController.Ui<UC>,UC> {
    public synchronized void attachUi(U ui){}
    public synchronized void startUi(U ui){}
    public synchronized void detachUi(U ui){}
    public interface Ui<UC>{
        void setCallbacks(UC callbacks);
        UC getCallbacks();
        void onResponseError(ResponseError error);
    }
}
