package com.project.cx.processcontrol_jx.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/23 0023.
 */

public class ParamManager {
    private static ParamManager mParamManager;
    public static int dck_currentIndex=0;
    public static int yck_currentIndex=0;
    private ParamManager(){}
    public static ParamManager getInstance(){
        if(mParamManager==null){
            mParamManager=new ParamManager();
        }
        return mParamManager;
    }

    //更新当前index
    public void updateCurrentIndex(String tasktype,int itemSize){
        if(tasktype.equals("dck")){
            ParamManager.dck_currentIndex=ParamManager.dck_currentIndex+itemSize;
        }else if(tasktype.equals("yck")){
            ParamManager.yck_currentIndex=ParamManager.yck_currentIndex+itemSize;
        }
    }

    /**
     * 获取查勘参数
     * @param tasktype
     * @param lian_state
     * @param riskstate
     * @param risklevel
     * @param keyword
     * @param startIndex
     * @param limit
     * @return
     */
    public Map<String,String> getCKParam(String tasktype,String lian_state,String riskstate,String risklevel,
                                            String keyword,int startIndex,int limit){
        Map<String,String> params=new HashMap<>();
        params.put("token", UserManager.getInstance().getUserToken());
        params.put("frontrole",UserManager.getInstance().getFrontRole());
        params.put("type",tasktype);
        params.put("lian_state",lian_state);
        params.put("riskstate",riskstate);
        params.put("risklevel",risklevel);
        params.put("keyword",keyword);
        params.put("start",String.valueOf(startIndex));
        params.put("limit",String.valueOf(limit));
        return params;
    }
}
