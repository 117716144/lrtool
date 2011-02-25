package com.base.core.action.bo;

import com.base.core.BaseAction;
import com.base.core.manager.NewsManager;
import com.base.core.model.News;
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

	public String input(){
		
		return SUCCESS;
	}
	
	public String addNews(){
		if(!StringUtil.isEmpty(news.getTitle()) && !StringUtil.isEmpty(news.getContent())){
			newsManager.save(news);
		}
		return SUCCESS;
	}

}
