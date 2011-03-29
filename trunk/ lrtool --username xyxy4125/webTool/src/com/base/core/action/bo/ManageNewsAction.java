package com.base.core.action.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.base.core.BaseAction;
import com.base.core.manager.NewsCategoryManager;
import com.base.core.manager.NewsManager;
import com.base.core.model.News;
import com.base.core.model.NewsCategory;
import com.base.core.util.Page;
import com.base.core.util.StringUtil;
import com.base.core.util.TaoBaoKeyUtil;

@SuppressWarnings("serial")
public class ManageNewsAction extends BaseAction{
	
	private NewsManager newsManager;
	public void setNewsManager(NewsManager newsManager) {
		this.newsManager = newsManager;
	}
	
	private NewsCategoryManager newsCategoryManager;
	
	public NewsCategoryManager getNewsCategoryManager() {
		return newsCategoryManager;
	}

	public void setNewsCategoryManager(NewsCategoryManager newsCategoryManager) {
		this.newsCategoryManager = newsCategoryManager;
	}

	private News news = new News();

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	
	private List<News> newsList;

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	
	private Long nid;

	public Long getNid() {
		return nid;
	}

	public void setNid(Long nid) {
		this.nid = nid;
	}
	
	private String idStr;
	
	public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	private List<NewsCategory> categorys = new ArrayList<NewsCategory>();

	public List<NewsCategory> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<NewsCategory> categorys) {
		this.categorys = categorys;
	}
	
	private Long itsCategory;

	public Long getItsCategory() {
		return itsCategory;
	}

	public void setItsCategory(Long itsCategory) {
		this.itsCategory = itsCategory;
	}

	public String input(){
		categorys = newsCategoryManager.getNewsCategoryList(new Page(10));
		if(nid!=null){
		news = newsManager.loadNews(nid);
		}
		return SUCCESS;
	}
	
	//添加新闻
	public String addNews(){
		if(!StringUtil.isEmpty(news.getTitle()) && !StringUtil.isEmpty(news.getContent())){
			news.setCreatedDate(new Date());
			news.setIsTop("N");
			news.setSortNum(0);
			if(itsCategory!=null){
				NewsCategory category =newsCategoryManager.loadNewsCategory(itsCategory);
				news.setItsCategory(category);
			}
			if(nid!=null){ 
				News curNews =newsManager.loadNews(nid);
				news.setId(curNews.getId());
			}
			newsManager.save(news);
		}
		return SUCCESS;
	}
	
	//新闻列表
	public String listNews(){
		Page page = new Page(100);
		if(itsCategory==null ){
			newsList = newsManager.getNewsList(null,page);
		}else{
		NewsCategory category =newsCategoryManager.loadNewsCategory(itsCategory);
		page.setCurrentPageIndex(1);
		newsList = newsManager.getNewsList(category,page);
		}
		if(newsList!=null && newsList.size()>0){
			for(News ns:newsList){
				ns.setEncodeIdStr(TaoBaoKeyUtil.encode(ns.getId().toString(), "UTF-8"));
			}
		}
		return SUCCESS;
	}
	
	//详细新闻
	public String showDetail(){
		try{
		if(!StringUtil.isEmpty(idStr)){
		  idStr =TaoBaoKeyUtil.decode(idStr, "UTF-8");
		  nid =Long.valueOf(idStr);
		  news =newsManager.loadNews(nid);
		}
		return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
