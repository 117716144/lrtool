package com.base.core.action;

import com.base.core.BaseAction;

public class TestAction extends BaseAction{
	
	/**
	private TestManager testManager;

	public void setTestManager(TestManager testManager) {
		this.testManager = testManager;
	}
	
	private List<Agent> agents = new ArrayList<Agent>();
	
	****/
	public String execute(){
		System.out.println("Test OK!!!!!!!!!!");
		return SUCCESS;
	}

}
