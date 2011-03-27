package com.base.core.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.base.core.constant.LrtoolConstant;
import com.base.core.util.StringUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class LoginInterceptor implements Interceptor {
    public void destroy() {
    }

    public void init() {
    }

    @SuppressWarnings("unchecked")
	public String intercept(ActionInvocation actionInvocation) throws Exception {

        Map session = actionInvocation.getInvocationContext().getSession();
        if(StringUtil.isNullString((String)session.get(LrtoolConstant.admin_user_id))){
        	return "toLogin";
        }
        //HttpServletRequest request = ServletActionContext.getRequest();
        return actionInvocation.invoke();
    }
   
}
