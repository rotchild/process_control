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

public class DCKViewHolder extends BaseViewHolder<TaskCK>{
    View mView;
    @BindView(R.id.item_dck)
    View item_dck;

    @BindView(R.id.dck_caseTime)
    TextView caseTime;

    @BindView(R.id.dck_hurt_state_icon)
    ImageView hurt_state_icon;

    @BindView(R.id.dck_outNumber)
    TextView dck_outNumber;

    @BindView(R.id.dck_risklevel)
    TextView dck_risklevel;

    @BindView(R.id.dck_riskstate)
    TextView dck_riskstate;
    public DCKViewHolder(View view) {
        super(view);
        mView=view;
    }

    public void bind(TaskCK taskCK){
        caseTime.setText(taskCK.getCaseTime());
        hurt_state_icon.setImageDrawable(ContextCompat.getDrawable(mView.getContext(),R.drawable.red_medical));
        dck_outNumber.setText(taskCK.getOutNumber());
        dck_risklevel.setText(taskCK.getRisklevel());
        dck_riskstate.setText(taskCK.getRiskstate());
    }

    @OnClick(R.id.item_dck)
    public void onClick(View view){
        notifyItemAction(CLICK_TYPE_DCK_CLICKED);
    }
}
