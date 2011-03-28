package com.base.core.action.bo;

import com.base.core.BaseAction;

@SuppressWarnings("serial")
public class LoginOutAction extends BaseAction{

	public String execute() throws Exception {
        for (Object key : session.keySet()){
            if("siteTracking".equals((String)key) || "searchTracking".equals((String)key)
                    || "alliance_id".equals((String)key)){
                continue;
            }
            session.remove((String) key);
        }
        return SUCCESS;
    }
	
}
