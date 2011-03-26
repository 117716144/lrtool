package com.base.core.model;


@SuppressWarnings("serial")
public class NewsCategory extends Entity {
    
	private String categoryName;
	private Long parentCategory;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(Long parentCategory) {
		this.parentCategory = parentCategory;
	}

}