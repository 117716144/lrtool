package com.base.core.action.bo;

import java.util.Date;
import java.util.List;

import com.base.core.BaseAction;
import com.base.core.manager.NewsManager;
import com.base.core.model.News;
import com.base.core.util.Page;
import com.base.core.util.StringUtil;

@SuppressWarnings("serial")
public class ManageNewsAction extends BaseAction{
	
	private NewsManager newsManager;
	public void setNewsManager(NewsManager newsManager) {
		this.newsManager = newsManager;
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

	public String input(){
		
		return SUCCESS;
	}
	
	//添加新闻
	public String addNews(){
		if(!StringUtil.isEmpty(news.getTitle()) && !StringUtil.isEmpty(news.getContent())){
			news.setCreatedDate(new Date());
			news.setIsTop("N");
			news.setSortNum(0);
			newsManager.save(news);
		}
		return SUCCESS;
	}
	
	//新闻列表
	public String listNews(){
		Page page = new Page(10);
		page.setCurrentPageIndex(1);
		newsList = newsManager.getNewsList(page);
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
