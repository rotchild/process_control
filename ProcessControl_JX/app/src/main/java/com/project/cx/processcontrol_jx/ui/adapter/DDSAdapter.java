package com.project.cx.processcontrol_jx.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.project.cx.processcontrol_jx.R;
import com.project.cx.processcontrol_jx.base.BaseAdapter;
import com.project.cx.processcontrol_jx.model.bean.TaskDS;
import com.project.cx.processcontrol_jx.ui.adapter.holder.DDSViewHolder;

/**
 * Created by Administrator on 2018/2/8 0008.
 */

public class DDSAdapter extends BaseAdapter<TaskDS> {
    @Override
    public int getViewLayoutId(int viewType) {
        return R.layout.item_dds;
    }

    @Override
    public RecyclerView.ViewHolder createViewHolder(View view, int viewType) {
        return new DDSViewHolder(view);
    }


    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder, TaskDS taskDS, int position) {
        if(holder instanceof DDSViewHolder){
            ((DDSViewHolder)holder).bind(taskDS);
        }
    }
}
