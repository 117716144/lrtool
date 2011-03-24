package com.base.core.action.keywords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import com.base.core.BaseAction;
import com.base.core.util.StringUtil;
import com.google.api.adwords.v201008.cm.KeywordMatchType;

@SuppressWarnings("serial")
public class SearchRelatedWordsAction extends BaseAction{

	private String keyword="";
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	private List<KeywordInfo> keyList = new ArrayList<KeywordInfo>();

	public List<KeywordInfo> getKeyList() {
		return keyList;
	}

	public void setKeyList(List<KeywordInfo> keyList) {
		this.keyList = keyList;
	}

	public String execute(){
		getIpInfo();
		if(StringUtil.isEmpty(keyword))  return SUCCESS;
		GetRelatedKeywords grk = new GetRelatedKeywords();
		try {
			keyList =grk.getRelateKeys(keyword, KeywordMatchType.EXACT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
