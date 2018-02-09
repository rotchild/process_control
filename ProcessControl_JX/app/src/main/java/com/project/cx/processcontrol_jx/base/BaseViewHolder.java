package com.project.cx.processcontrol_jx.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/8 0008.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements IViewHolder<T>{

    protected ViewEventListener<T> mViewEventListener;
    protected T mItem;
    protected int mPosition;

    public BaseViewHolder(View view) {
        super(view);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setViewEventListener(ViewEventListener<T> viewEventListener) {
        mViewEventListener=viewEventListener;
    }

    @Override
    public void setItem(T item) {
        mItem=item;
    }

    @Override
    public void setPosition(int position) {
        mPosition=position;
    }

    protected void notifyItemAction(int actionId){
        notifyItemAction(actionId,mItem,itemView);
    }

    protected void notifyItemAction(int actionId,T item,View view){
        if(mViewEventListener!=null){
            mViewEventListener.onViewEvent(actionId,item,getAdapterPosition(),view);
        }
    }
}
