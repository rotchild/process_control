package com.project.cx.processcontrol_jx.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.cx.processcontrol_jx.R;
import com.project.cx.processcontrol_jx.widget.MultiStateView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/6 0006.
 */

public abstract class BaseFragment extends Fragment {
    @BindView(R.id.multi_state_view)
    MultiStateView multiStateView;
    @BindView(R.id.refreshlayout)
    RefreshLayout mRefreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_refresh,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this,view);
        initializeViews(savedInstanceState);
    }

    private void initializeViews(Bundle savedInstanceState) {

    }
}
