package com.base.core.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;

import com.base.core.model.NewsCategory;
import com.base.core.util.Page;

public class NewsCategoryManager extends Manager{
	
	@SuppressWarnings("unchecked")
	public List<NewsCategory> getAgentList(String sql,Class newsCategory){
		return dao.getListByStanderdSQL(sql,newsCategory);
	}
	
	@SuppressWarnings("unchecked")
	public List<NewsCategory> getNewsCategoryList(Page page){
		DetachedCriteria criteria = DetachedCriteria.forClass(NewsCategory.class);
		return dao.findPageByCriteria(criteria,page);
	}
	
	public NewsCategory loadNews(Long nid){
		return dao.load(NewsCategory.class, nid);
	}
	
	@Transactional
	public void save(NewsCategory news){
		dao.save(news);
	}
}
