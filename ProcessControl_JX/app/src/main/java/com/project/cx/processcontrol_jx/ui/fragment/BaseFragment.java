package com.project.cx.processcontrol_jx.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.project.cx.processcontrol_jx.R;
import com.project.cx.processcontrol_jx.base.BaseAdapter;
import com.project.cx.processcontrol_jx.base.ViewEventListener;
import com.project.cx.processcontrol_jx.presenter.PBaseFragmentImp;
import com.project.cx.processcontrol_jx.util.ParamManager;
import com.project.cx.processcontrol_jx.widget.MultiStateView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/6 0006.
 */

public abstract class BaseFragment<T> extends Fragment implements IBaseFragment<T>{
    @BindView(R.id.multi_state_view)
    MultiStateView multiStateView;
    @BindView(R.id.refreshlayout)
    RefreshLayout mRefreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;
    PBaseFragmentImp pBaseFragmentImp;

    protected BaseAdapter<T> mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_refresh,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.e("BaseFragment","onViewCreated");
        ButterKnife.bind(this,view);
        initData();
        initializeViews(savedInstanceState);
    }

    @Override
    public void onStartRequest() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFinishRequest(List<T> items) {
        progressBar.setVisibility(View.GONE);
        if(mRefreshLayout.isLoading()){
            mRefreshLayout.finishLoadMore();
        }
        //更新当前index
        ParamManager.getInstance().updateCurrentIndex(getTaskType(),items.size());
    }

    @Override
    public void onRequestFail(String errMsg) {
        if(progressBar.getVisibility()==View.VISIBLE){
            progressBar.setVisibility(View.GONE);
        }
        if(mRefreshLayout.isLoading()){
            mRefreshLayout.finishLoadMore();
        }
        Toast.makeText(getContext(),errMsg,Toast.LENGTH_SHORT).show();
    }

    private void initializeViews(Bundle savedInstanceState) {
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {

            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
               pBaseFragmentImp.loadMore(ParamManager.getInstance().getQueryParams(1,getTaskType()));
            }
        });

        mAdapter=getAdapter();
        mAdapter.setViewEventListener(new ViewEventListener<T>() {
            @Override
            public void onViewEvent(int actionId, T item, int position, View view) {
                onItemClick(actionId, item);
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        if(pBaseFragmentImp==null){
            pBaseFragmentImp=new PBaseFragmentImp(this);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(getTaskType().equals("dck")){
            ParamManager.dck_currentIndex=0;
        }else if(getTaskType().equals("yck")){
            ParamManager.yck_currentIndex=0;
        }
    }


    @Override
    public void onRefreshFinish(List<T> items) {
        onFinishRequest(items);
        if(items!=null && !items.isEmpty()){
            mAdapter.setItems(items);
        }else if(items!=null &&items.isEmpty()){
            Toast.makeText(getContext(),"暂无数据",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoadMoreFinish(List<T> items) {
        onFinishRequest(items);
        if(items!=null && !items.isEmpty()){
            mAdapter.addItems(items);
        }else if(items!=null &&items.isEmpty()){
            Toast.makeText(getContext(),"没有更多数据了",Toast.LENGTH_SHORT).show();
        }
    }

    protected abstract BaseAdapter<T> getAdapter();
    protected void onItemClick(int actionId, T item){}
    protected abstract String getTaskType();
    protected void toRefresh(){
        if(pBaseFragmentImp==null){
            pBaseFragmentImp=new PBaseFragmentImp(this);
        }
        pBaseFragmentImp.refresh(ParamManager.getInstance().getQueryParams(0,getTaskType()));
    }
}
