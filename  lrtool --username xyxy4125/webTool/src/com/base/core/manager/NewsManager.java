package com.base.core.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.base.core.model.Agent;
import com.base.core.model.News;
import com.base.core.model.NewsCategory;
import com.base.core.util.Page;

public class NewsManager extends Manager{
	
	@SuppressWarnings("unchecked")
	public List<Agent> getAgentList(String sql,Class agent){
		return dao.getListByStanderdSQL(sql,agent);
	}
	
	@SuppressWarnings("unchecked")
	public List<News> getNewsList(NewsCategory category,Page page){
		DetachedCriteria criteria = DetachedCriteria.forClass(News.class);
		if(category!=null){
		criteria.add(Restrictions.eq("itsCategory", category));
		}
		return dao.findPageByCriteria(criteria,page,Order.desc("createdDate"));
	}
	
	@SuppressWarnings("unchecked")
	public int getNewsCountByCategory(Long category){
		String sql ="select count(*) from news where its_category="+category;
		List rs =dao.getListByStanderdSQL(sql);
		if(rs.size()>0){
			return Integer.parseInt(rs.get(0).toString());
		}else
			return 0;
	}
	
	public News loadNews(Long nid){
		return dao.load(News.class, nid);
	}
	
	@Transactional
	public void save(News news){
		dao.save(news);
	}
}
