package com.project.cx.processcontrol_jx.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.project.cx.processcontrol_jx.R;
import com.project.cx.processcontrol_jx.base.BaseAdapter;
import com.project.cx.processcontrol_jx.model.bean.TaskCK;
import com.project.cx.processcontrol_jx.ui.adapter.holder.DCKViewHolder;

/**
 * Created by Administrator on 2018/2/8 0008.
 */

public class DCKAdapter extends BaseAdapter<TaskCK> {
    @Override
    public int getViewLayoutId(int viewType) {
        return R.layout.item_dck;
    }

    @Override
    public RecyclerView.ViewHolder createViewHolder(View view, int viewType) {
        return new DCKViewHolder(view);
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder, TaskCK taskCK, int position) {
        if(holder instanceof DCKViewHolder){
            ((DCKViewHolder)holder).bind(taskCK);
        }
    }
}
