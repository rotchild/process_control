package com.project.cx.processcontrol_jx.ui.fragment;

import android.util.Log;

import com.project.cx.processcontrol_jx.base.BaseAdapter;
import com.project.cx.processcontrol_jx.model.bean.TaskDS;
import com.project.cx.processcontrol_jx.ui.adapter.DDSAdapter;

/**
 * Created by Administrator on 2018/2/23 0023.
 */

public class DDSFragment extends BaseFragment<TaskDS> {
    @Override
    protected BaseAdapter<TaskDS> getAdapter() {
        return new DDSAdapter();
    }

    @Override
    protected String getTaskType() {
        return "dds";
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("ddsfragment","setUserVisibleHint\n"+String.valueOf(isVisibleToUser));
        if(isVisibleToUser){
            super.toRefresh();
        }
    }
}
