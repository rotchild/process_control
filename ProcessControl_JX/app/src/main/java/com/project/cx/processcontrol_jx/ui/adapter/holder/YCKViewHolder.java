package com.project.cx.processcontrol_jx.ui.adapter.holder;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.cx.processcontrol_jx.R;
import com.project.cx.processcontrol_jx.base.BaseViewHolder;
import com.project.cx.processcontrol_jx.model.bean.TaskCK;

import butterknife.BindView;
import butterknife.OnClick;

import static com.project.cx.processcontrol_jx.util.Constants.ClickType.CLICK_TYPE_DCK_CLICKED;

/**
 * Created by Administrator on 2018/2/8 0008.
 */

public class YCKViewHolder extends BaseViewHolder<TaskCK>{
    View mView;

    @BindView(R.id.item_yck)
    View item_yck;

    @BindView(R.id.yck_caseNo)
    TextView yck_caseNo;

    @BindView(R.id.yck_licenseno)
    TextView licenseno;

    @BindView(R.id.yck_caseTime)
    TextView caseTime;

    @BindView(R.id.yck_hurt_state_icon)
    ImageView hurt_state_icon;

    @BindView(R.id.yck_lian_state)
    TextView yck_lian_state;

    @BindView(R.id.yck_risklevel)
    TextView yck_risklevel;

    @BindView(R.id.yck_riskstate)
    TextView yck_riskstate;
    public YCKViewHolder(View view) {
        super(view);
        mView=view;
    }

    public void bind(TaskCK taskCK){
        yck_caseNo.setText(taskCK.getCaseNo());
        licenseno.setText(taskCK.getLicenseno());
        caseTime.setText(taskCK.getCaseTime());
        hurt_state_icon.setImageDrawable(ContextCompat.getDrawable(mView.getContext(),R.drawable.red_medical));
        yck_lian_state.setText(taskCK.getLian_state());
        yck_risklevel.setText(taskCK.getRisklevel());
        yck_riskstate.setText(taskCK.getRiskstate());
    }

    @OnClick(R.id.item_yck)
    public void onClick(View view){
        notifyItemAction(CLICK_TYPE_DCK_CLICKED);
    }
}
