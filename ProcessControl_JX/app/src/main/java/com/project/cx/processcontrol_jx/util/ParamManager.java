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
    public Map<String,String> getParam(String tasktype,String lian_state,String riskstate,String risklevel,
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

    public Map<String, String> getQueryParams(int loadtype,String tasktype) {//refresh always 0,10;
        Map<String,String> params=null;
        if(loadtype==0){//refresh
            params= getParam(tasktype,"","",
                    "","",0,10);
        }else if(loadtype==1){//loadmore
            params= getParam(tasktype,"","",
                    "","",getCurrentIndexFromType(tasktype),10);
        }
        return params;
    }

    /**
     * 根据tasktype获得对应index
     * @param tasktype
     * @return
     */
    public int getCurrentIndexFromType(String tasktype){
        int currentIndex=0;
        switch (tasktype){
            case "dck":
                currentIndex=dck_currentIndex;
                break;
            case "yck":
                currentIndex=yck_currentIndex;
                break;
        }
        return currentIndex;
    }
}
