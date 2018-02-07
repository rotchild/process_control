package com.project.cx.processcontrol_jx.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.project.cx.processcontrol_jx.R;
import com.project.cx.processcontrol_jx.presenter.PBaseFragmentImp;
import com.project.cx.processcontrol_jx.widget.MultiStateView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/6 0006.
 */

public abstract class BaseFragment extends Fragment implements IBaseFragment{
    @BindView(R.id.multi_state_view)
    MultiStateView multiStateView;
    @BindView(R.id.refreshlayout)
    RefreshLayout mRefreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;
    PBaseFragmentImp pBaseFragmentImp;

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
    public void onFinishRequest() {
        progressBar.setVisibility(View.GONE);
    }

    private void initializeViews(Bundle savedInstanceState) {
    }

    private void initData() {
        pBaseFragmentImp=new PBaseFragmentImp(this);
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
