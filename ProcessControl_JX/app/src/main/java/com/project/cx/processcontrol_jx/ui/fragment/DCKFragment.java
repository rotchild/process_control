package com.project.cx.processcontrol_jx.ui.fragment;

import android.util.Log;

import com.project.cx.processcontrol_jx.base.BaseAdapter;
import com.project.cx.processcontrol_jx.model.bean.TaskCK;
import com.project.cx.processcontrol_jx.ui.adapter.DCKAdapter;
import com.project.cx.processcontrol_jx.util.ParamManager;

import java.util.Map;

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
    protected Map<String, String> getQueryParams(int type) {//refresh always 0,10;
        Map<String,String> params=null;
        if(type==0){//refresh
            params= ParamManager.getInstance().getCKParam("dck","","",
                    "","",0,10);
        }else if(type==1){//loadmore
            params= ParamManager.getInstance().getCKParam("dck","","",
                    "","",ParamManager.dck_currentIndex,10);
        }
        return params;
    }

    @Override
    protected String getTaskType() {
        return "dck";
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("dckfragment","setUserVisibleHint\n"+String.valueOf(isVisibleToUser));
        if(isVisibleToUser){
            super.onRefresh();
        }
    }

}
