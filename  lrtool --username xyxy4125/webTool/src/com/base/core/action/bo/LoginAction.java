package com.base.core.action.bo;

import com.base.core.BaseAction;
import com.base.core.constant.LrtoolConstant;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction{
	
	private String userName;
	private String userPwd;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String input(){
		return SUCCESS;
	}
	
	public String execute(){
		if("administrator".equalsIgnoreCase(userName) && "admin_alison".equalsIgnoreCase(userPwd)){
			session.put(LrtoolConstant.admin_user_id, "admin");
		}else{
			addActionError("帐号或密码不正确!");
			return this.INPUT;
		}
		return SUCCESS;
	}

}
