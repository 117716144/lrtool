package com.base.core.model;


@SuppressWarnings("serial")
public class Areas extends Entity {

	private Long areaCode;
	private String areaName;
	private Long parentCode;
	public Long getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(Long areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Long getParentCode() {
		return parentCode;
	}
	public void setParentCode(Long parentCode) {
		this.parentCode = parentCode;
	}
	
	
	
}