package com.base.core.manager;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.base.core.model.Agent;
import com.base.core.model.News;

public class NewsManager extends Manager{
	
	@SuppressWarnings("unchecked")
	public List<Agent> getAgentList(String sql,Class agent){
		return dao.getListByStanderdSQL(sql,agent);
	}
	
	public List<Agent> getAgentList(){
		return dao.findByNamedQuery("getList");
	}
	
	@Transactional
	public void save(News news){
		dao.save(news);
	}
}
