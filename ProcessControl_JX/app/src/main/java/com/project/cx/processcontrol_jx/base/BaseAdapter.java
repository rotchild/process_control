package com.project.cx.processcontrol_jx.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/8 0008.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter implements IAdapter<T> {
    private List<T> mItems;
    private ViewEventListener<T> mViewEventListener;

    public BaseAdapter() {
        mItems=new ArrayList<>();
    }

    @Override
    public void setItems(List<T> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public void addItem(T item) {
        mItems.add(item);
        notifyDataSetChanged();
    }

    @Override
    public void delItem(T item) {
        mItems.remove(item);
        notifyDataSetChanged();
    }

    @Override
    public void addItems(List<T> items) {
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public void clearItems() {
        mItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public T getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public ViewEventListener<T> getViewEventListener() {
        return mViewEventListener;
    }

    @Override
    public void setViewEventListener(ViewEventListener viewEventListener) {
        mViewEventListener=viewEventListener;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mItems!=null? mItems.size():0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {//将数据和viewholder绑定
        if(viewHolder instanceof IViewHolder){
            IViewHolder<T> holder=(IViewHolder) viewHolder;
            holder.setViewEventListener(mViewEventListener);
            holder.setItem(getItem(position));
            holder.setPosition(position);
        }
        bindViewHolder(viewHolder, getItem(position), position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(getViewLayoutId(viewType),parent,false);
        return createViewHolder(view,viewType);
    }

    public abstract int getViewLayoutId(int viewType);

    public abstract RecyclerView.ViewHolder createViewHolder(View view,int viewType);

    public abstract void bindViewHolder(RecyclerView.ViewHolder holder, T item, int position);


}
