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
	
	private List<NewsCategory> categorys = new ArrayList<NewsCategory>();

	public List<NewsCategory> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<NewsCategory> categorys) {
		this.categorys = categorys;
	}
	
	private Long itsCategory=10000L;

	public Long getItsCategory() {
		return itsCategory;
	}

	public void setItsCategory(Long itsCategory) {
		this.itsCategory = itsCategory;
	}

	public String input(){
		categorys = newsCategoryManager.getNewsCategoryList(new Page(10));
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
			newsManager.save(news);
		}
		return SUCCESS;
	}
	
	//新闻列表
	public String listNews(){
		NewsCategory category =newsCategoryManager.loadNewsCategory(itsCategory);
		Page page = new Page(100);
		page.setCurrentPageIndex(1);
		newsList = newsManager.getNewsList(category,page);
		return SUCCESS;
	}
	
	//详细新闻
	public String showDetail(){
		try{
		news =newsManager.loadNews(nid);
		return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
