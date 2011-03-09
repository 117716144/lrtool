package com.base.core.action.idcard;

import java.text.ParseException;

import com.base.core.BaseAction;
import com.base.core.manager.AreasManager;
import com.base.core.model.Areas;
import com.base.core.util.StringUtil;

@SuppressWarnings("serial")
public class GenerateIdCardAction extends BaseAction{
	
    private AreasManager areasManager;
	
	public AreasManager getAreasManager() {
		return areasManager;
	}

	public void setAreasManager(AreasManager areasManager) {
		this.areasManager = areasManager;
	}
	
	private String cardInfo="";
	
	private int reqCount =10;
	
	public int getReqCount() {
		return reqCount;
	}

	public void setReqCount(int reqCount) {
		this.reqCount = reqCount;
	}

	public String getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(String cardInfo) {
		this.cardInfo = cardInfo;
	}
	
	private Long province;

    private Long area;
    
    private Long city;
	
	public Long getProvince() {
		return province;
	}

	public void setProvince(Long province) {
		this.province = province;
	}

	public Long getArea() {
		return area;
	}

	public void setArea(Long area) {
		this.area = area;
	}

	public Long getCity() {
		return city;
	}

	public void setCity(Long city) {
		this.city = city;
	}

	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	private String birthDay;

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String execute(){
		this.getIpInfo();
		IdCardGenerator gen = new IdCardGenerator();
		String selCode ="";
		if(city!=null && city!=-1){
			selCode =String.valueOf(city);
		}else if (area!=null && area!=-1){
			selCode =String.valueOf(area);
		}else selCode = String.valueOf(province);
		if(!StringUtil.isEmpty(selCode)){
			Areas areas =areasManager.loadAreas(Long.valueOf(selCode));
			selCode =String.valueOf(areas.getAreaCode());
		}
		if(selCode.length()==2){
			selCode =selCode+"0000";
		}
		if(selCode.length()==4){
			selCode =selCode+"00";
		}
		this.setBirthDay("1978-10-21");
		try {
			gen.generate(selCode, birthDay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<reqCount;i++){
		  cardInfo +=gen.generate()+"<br/>";
		}
		return SUCCESS;
	}

}
