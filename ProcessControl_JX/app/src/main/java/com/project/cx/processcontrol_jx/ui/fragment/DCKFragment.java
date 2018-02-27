package com.project.cx.processcontrol_jx.ui.fragment;

import android.util.Log;

import com.project.cx.processcontrol_jx.base.BaseAdapter;
import com.project.cx.processcontrol_jx.model.bean.TaskCK;
import com.project.cx.processcontrol_jx.ui.adapter.DCKAdapter;

import static com.project.cx.processcontrol_jx.util.Constants.ClickType.CLICK_TYPE_DCK_CLICKED;

/**
 * Created by Administrator on 2018/2/6 0006.
 */

public class DCKFragment extends BaseFragment<TaskCK> {

    @Override
    protected BaseAdapter getAdapter() {
        return new DCKAdapter();
    }

    @Override
    protected void onItemClick(int actionId, TaskCK taskCK) {
        switch(actionId){
            case CLICK_TYPE_DCK_CLICKED:
                break;
        }
    }

    @Override
    protected String getTaskType() {
        return "dck";
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {//setVisible在baseFragment中切换一直是true
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("dckfragment","setUserVisibleHint\n"+String.valueOf(isVisibleToUser));
        if(isVisibleToUser){
            super.toRefresh();
        }
    }
}
