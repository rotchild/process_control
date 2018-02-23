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
import java.util.Map;

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
        ButterKnife.bind(this,view);
        initData();
        initializeViews(savedInstanceState);

       /* Map<String,String> params=ParamManager.getInstance().getCKParam("dck","","",
                "","",ParamManager.currentIndex,10);*/
       Map<String,String> params=getQueryParams();
        this.onStartRequest();
        if(params!=null){
            pBaseFragmentImp.fetchData(params);
        }else{
            Log.e("basefragment","params is null");
        }
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
        if(items!=null && !items.isEmpty()){
            //mAdapter.setItems(items);
            ParamManager.currentIndex=ParamManager.currentIndex+items.size();
            mAdapter.addItems(items);
        }else if(items!=null &&items.isEmpty()){
            Toast.makeText(getContext(),"没有更多数据了",Toast.LENGTH_SHORT).show();
        }
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

                Map<String,String> params=ParamManager.getInstance().getCKParam("dck","","",
                        "","",ParamManager.currentIndex,10);
                pBaseFragmentImp.fetchData(params);
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
        pBaseFragmentImp=new PBaseFragmentImp(this);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    protected abstract BaseAdapter<T> getAdapter();
    protected void onItemClick(int actionId, T item){}
    protected abstract Map<String,String> getQueryParams();
}
