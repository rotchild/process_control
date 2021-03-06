package com.project.cx.processcontrol_jx.ui.fragment;

import android.util.Log;

import com.project.cx.processcontrol_jx.base.BaseAdapter;
import com.project.cx.processcontrol_jx.model.bean.TaskCK;
import com.project.cx.processcontrol_jx.ui.adapter.YCKAdapter;

/**
 * Created by Administrator on 2018/2/23 0023.
 */

public class YCKFragment extends BaseFragment<TaskCK> {
    @Override
    protected BaseAdapter<TaskCK> getAdapter() {
        return new YCKAdapter();
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
            super.toRefresh();
        }
    }
}
