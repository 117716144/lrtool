package com.base.core.manager;

import java.util.List;

import com.base.core.model.Agent;

public class TestManager extends Manager{
	
	@SuppressWarnings("unchecked")
	public List<Agent> getAgentList(String sql,Class agent){
		return dao.getListByStanderdSQL(sql,agent);
	}
	
	public List<Agent> getAgentList(){
		return dao.findByNamedQuery("getList");
	}
}
