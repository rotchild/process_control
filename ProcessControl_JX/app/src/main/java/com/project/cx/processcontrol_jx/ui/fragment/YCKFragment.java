package com.project.cx.processcontrol_jx.ui.fragment;

import android.util.Log;

import com.project.cx.processcontrol_jx.base.BaseAdapter;
import com.project.cx.processcontrol_jx.model.bean.TaskCK;
import com.project.cx.processcontrol_jx.ui.adapter.YCKAdapter;
import com.project.cx.processcontrol_jx.util.ParamManager;

import java.util.Map;

/**
 * Created by Administrator on 2018/2/23 0023.
 */

public class YCKFragment extends BaseFragment<TaskCK> {
    @Override
    protected BaseAdapter<TaskCK> getAdapter() {
        return new YCKAdapter();
    }

    @Override
    protected Map<String, String> getQueryParams(int type) {
        Map<String,String> params=null;
        if(type==0){//refresh
            params= ParamManager.getInstance().getCKParam("yck","","",
                    "","",0,10);
        }else if(type==1){//loadmore
            params= ParamManager.getInstance().getCKParam("yck","","",
                    "","",ParamManager.yck_currentIndex,10);
        }
        return params;
    }

    @Override
    protected String getTaskType() {
        return "yck";
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("yckfragment","setUserVisibleHint\n"+String.valueOf(isVisibleToUser));
        if(isVisibleToUser){
            super.onRefresh();
        }
    }
}
