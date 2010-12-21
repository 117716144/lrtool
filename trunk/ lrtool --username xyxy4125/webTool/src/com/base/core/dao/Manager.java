package com.base.core.dao;

import com.base.core.HibernateDao;

public class Manager {
    protected HibernateDao dao;

    public void setDao(HibernateDao dao) {
        this.dao = dao;
    }

    public String createLikeTerm(String term){
        return "%"+term+"%";
    }    
}