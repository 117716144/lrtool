package com.base.core.model;

import java.util.Date;

@SuppressWarnings("serial")
public class News extends Entity {

	private Long id;
	private String title;
	private String content;
	private String keyword;
	private Date createdDate;
	private String isTop;
	private NewsCategory itsCategory;
	private int sortNum;
	private String encodeIdStr;
	private String summary;
	private String isShow;
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	
	public String getEncodeIdStr() {
		return encodeIdStr;
	}
	public void setEncodeIdStr(String encodeIdStr) {
		this.encodeIdStr = encodeIdStr;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getIsTop() {
		return isTop;
	}
	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}
	public NewsCategory getItsCategory() {
		return itsCategory;
	}
	public void setItsCategory(NewsCategory itsCategory) {
		this.itsCategory = itsCategory;
	}
	public int getSortNum() {
		return sortNum;
	}
	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	

}