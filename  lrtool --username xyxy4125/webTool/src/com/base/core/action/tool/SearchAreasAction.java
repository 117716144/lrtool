package com.base.core.action.tool;

import java.util.ArrayList;
import java.util.List;

import com.base.core.BaseAction;
import com.base.core.manager.AreasManager;
import com.base.core.model.Areas;

@SuppressWarnings("serial")
public class SearchAreasAction extends BaseAction{
	
	private AreasManager areasManager;
	
	public AreasManager getAreasManager() {
		return areasManager;
	}

	public void setAreasManager(AreasManager areasManager) {
		this.areasManager = areasManager;
	}

	private List<Areas> areas = new ArrayList<Areas>();
	
	public List<Areas> getAreas() {
		return areas;
	}

	public void setAreas(List<Areas> areas) {
		this.areas = areas;
	}
	
	private Long areaCode;

	public Long getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Long areaCode) {
		this.areaCode = areaCode;
	}

	public String execute(){
		areas =areasManager.getAreasByParentAreaCode(0L);
		return SUCCESS;
	}
	
	public String area(){
		if(areaCode==null)    areaCode =0L;  
		areas =areasManager.getAreasByParentAreaCode(areaCode);
		return SUCCESS;
	}
	
	public String city(){
		if(areaCode==null)    areaCode =0L;  
		areas =areasManager.getAreasByParentAreaCode(areaCode);
		return SUCCESS;
	}

}
