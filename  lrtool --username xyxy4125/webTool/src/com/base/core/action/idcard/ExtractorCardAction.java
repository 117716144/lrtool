package com.base.core.action.idcard;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import com.base.core.BaseAction;
import com.base.core.manager.AreasManager;
import com.base.core.model.Areas;
import com.base.core.util.StringUtil;

@SuppressWarnings("serial")
public class ExtractorCardAction extends BaseAction{
	
    private AreasManager areasManager;
	
	public AreasManager getAreasManager() {
		return areasManager;
	}

	public void setAreasManager(AreasManager areasManager) {
		this.areasManager = areasManager;
	}
	
	private String idCodeStr="";
	
	public String getIdCodeStr() {
		return idCodeStr;
	}

	public void setIdCodeStr(String idCodeStr) {
		this.idCodeStr = idCodeStr;
	}

	// 省份
	private String province;
	// 城市
	private String city;
	// 区县
	private String region;
	// 年份
	private int year;
	// 月份
	private int month;
	// 日期
	private int day;
	// 性别
	private String gender;
	// 出生日期
	private Date birthday;
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public void IdcardInfoExtract(String idcard) {
		try {
			IdcardValidator validator = new IdcardValidator();
			if (validator.isValidatedAllIdcard(idcard)) {
				if (idcard.length() == 15) {
					idcard = validator.convertIdcarBy15bit(idcard);
				}
				String code = idcard.substring(0,6);
				Areas area = areasManager.getUniqueAreas(Long.valueOf(code));
				if(area!=null){ this.city = area.getAreaName(); }
				else{
					code =idcard.substring(0,2);
					Set<String> key = IdcardInfoExtractor.cityCodeMap.keySet();
					for (String id : key) {
						if (id.equals(code)) {
							this.city = IdcardInfoExtractor.cityCodeMap.get(id);
							break;
						}
					}
				}
				// 获取性别
				String id17 = idcard.substring(16, 17);
				if (Integer.parseInt(id17) % 2 != 0) {
					this.gender = "男";
				} else {
					this.gender = "女";
				}

				// 获取出生日期
				String birthday = idcard.substring(6, 14);
				Date birthdate = new SimpleDateFormat("yyyyMMdd")
						.parse(birthday);
				this.birthday = birthdate;
				GregorianCalendar currentDay = new GregorianCalendar();
				currentDay.setTime(birthdate);
				this.year = currentDay.get(Calendar.YEAR);
				this.month = currentDay.get(Calendar.MONTH) + 1;
				this.day = currentDay.get(Calendar.DAY_OF_MONTH);
			}else{
				addActionError("请先输入正确的身份证号码!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String execute(){
		if(!StringUtil.isEmpty(idCodeStr)){
			this.IdcardInfoExtract(idCodeStr);
		}
		getIpInfo();
		return SUCCESS;
	}

}
