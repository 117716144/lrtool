package com.base.core.action.idcard;

import com.base.core.BaseAction;

@SuppressWarnings("serial")
public class GenerateIdCardAction extends BaseAction{
	
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

	public String execute(){
		this.getIpInfo();
		IdCardGenerator gen = new IdCardGenerator();
		for(int i=0;i<reqCount;i++){
		  cardInfo +=gen.generate()+"<br/>";
		}
		return SUCCESS;
	}

}
