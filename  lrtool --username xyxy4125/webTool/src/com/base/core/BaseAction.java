package com.base.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware{
	
    private String ipAddr;
	
	private String ipLocation;
	
	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getIpLocation() {
		return ipLocation;
	}
	
	public void setIpLocation(String ipLocation) {
		this.ipLocation = ipLocation;
	}

	private static final long serialVersionUID = 3120454583851872498L;
	@SuppressWarnings("unchecked")
	protected Map session;

	@SuppressWarnings("unchecked")
	public void setSession(Map session) {
		this.session = session;
	}
	
	public HttpServletRequest getRequest(){
		HttpServletRequest request =(HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	    return request;
	}

	public HttpServletResponse getResponse(){
		HttpServletResponse response =(HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
	    return response;
	}
	
	public PrintWriter getOut(){
	 try {
	  this.getResponse().setCharacterEncoding("utf-8");
      this.getResponse().setContentType("text/json;charset=utf-8");
		return this.getResponse().getWriter();
	 } catch (IOException e) {
		e.printStackTrace();
	 }
	 return null;
	}
}
