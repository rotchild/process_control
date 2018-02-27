package com.project.cx.processcontrol_jx.ui.adapter.holder;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.cx.processcontrol_jx.R;
import com.project.cx.processcontrol_jx.base.BaseViewHolder;
import com.project.cx.processcontrol_jx.model.bean.TaskDS;

import butterknife.BindView;
import butterknife.OnClick;

import static com.project.cx.processcontrol_jx.util.Constants.ClickType.CLICK_TYPE_DCK_CLICKED;

/**
 * Created by Administrator on 2018/2/8 0008.
 */

public class DDSViewHolder extends BaseViewHolder<TaskDS>{
    View mView;

    @BindView(R.id.item_dds)
    View item_dds;

    @BindView(R.id.dds_caseNo)
    TextView caseNo;

    @BindView(R.id.dds_licenseno)
    TextView licenseno;

    @BindView(R.id.dds_caseTime)
    TextView caseTime;

    @BindView(R.id.dds_hurt_state_icon)
    ImageView hurt_state_icon;

    @BindView(R.id.dds_risklevel)
    TextView risklevel;

    @BindView(R.id.dds_riskstate)
    TextView riskstate;
    public DDSViewHolder(View view) {
        super(view);
        mView=view;
    }

    public void bind(TaskDS taskDS){
        caseNo.setText(taskDS.getCaseNo());
        licenseno.setText(taskDS.getLicenseno());
        caseTime.setText(taskDS.getCaseTime());
        hurt_state_icon.setImageDrawable(ContextCompat.getDrawable(mView.getContext(),R.drawable.red_medical));
        risklevel.setText(taskDS.getRisklevel());
        riskstate.setText(taskDS.getRiskstate());
    }

    @OnClick(R.id.item_dds)
    public void onClick(View view){
        notifyItemAction(CLICK_TYPE_DCK_CLICKED);
    }
}
