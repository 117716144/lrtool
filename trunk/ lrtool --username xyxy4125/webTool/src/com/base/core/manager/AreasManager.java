package com.base.core.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.base.core.model.Areas;

public class AreasManager extends Manager {
	
	@SuppressWarnings("unchecked")
	public List<Areas> getParentAreas(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Areas.class);
		criteria.add(Restrictions.eq("parentCode", 0));
		return dao.findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	public List<Areas> getAreasByParentAreaCode(Long parentCode){
		DetachedCriteria criteria = DetachedCriteria.forClass(Areas.class);
		criteria.add(Restrictions.eq("parentCode", parentCode));
		criteria.addOrder(Order.asc("id"));
		return dao.findByCriteria(criteria);
	}
	
	public Areas loadAreas(Long code){
		return dao.load(Areas.class, code);
	}

}
