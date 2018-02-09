package com.project.cx.processcontrol_jx.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.project.cx.processcontrol_jx.R;
import com.project.cx.processcontrol_jx.base.BaseAdapter;
import com.project.cx.processcontrol_jx.base.ViewEventListener;
import com.project.cx.processcontrol_jx.presenter.PBaseFragmentImp;
import com.project.cx.processcontrol_jx.widget.MultiStateView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.HashMap;
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
        Map<String,String> params=new HashMap<String, String>();
        params.put("token","02174f799411ace08b36776f2b579aaf");
        params.put("frontrole","12");
        params.put("type","dck");
        params.put("lian_state","");
        params.put("riskstate","");
        params.put("risklevel","");
        params.put("keyword","");
        params.put("start","0");
        params.put("limit","10");
        this.onStartRequest();
        pBaseFragmentImp.fetchData(params);
    }

    @Override
    public void onStartRequest() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFinishRequest(List<T> items) {
        progressBar.setVisibility(View.GONE);
        if(items!=null && !items.isEmpty()){
            mAdapter.setItems(items);
        }
    }

    private void initializeViews(Bundle savedInstanceState) {
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
    protected void onItemClick(int actionId, T item){};
}
