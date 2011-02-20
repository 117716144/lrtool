package com.base.core.action.shoulu;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.base.core.BaseAction;
import com.base.core.util.StringUtil;

@SuppressWarnings("serial")
public class SiteAlexaInfoAction extends BaseAction{

	private SiteAlexaInfo alexaInfo = new SiteAlexaInfo();
	
	private String domain;
	
	
	public String getDomain() {
		return domain.replace("http://www.", "");
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public SiteAlexaInfo getAlexaInfo() {
		return alexaInfo;
	}
	
	public void setAlexaInfo(SiteAlexaInfo alexaInfo) {
		this.alexaInfo = alexaInfo;
	}

	public String execute(){
		try{
			DocumentBuilderFactory domfac=DocumentBuilderFactory.newInstance(); 
			DocumentBuilder dombuilder=domfac.newDocumentBuilder();
			String urlStr ="http://data.alexa.com/data/?cli=10&dat=snba&ver=7.0&url="+this.getDomain();
			String uri =new SiteAlexaInfoAction().getTargetStr(urlStr,"utf-8");
			Document doc =dombuilder.parse(new ByteArrayInputStream(uri.getBytes("utf-8")));
			NodeList nodeList=doc.getElementsByTagName("SD"); 
			for(int len=0;len<nodeList.getLength();len++){
			Node fatherNode=nodeList.item(len);  
			//把父节点的属性拿出来  
			NamedNodeMap attributes=fatherNode.getAttributes();  
			for(int i=0;i<attributes.getLength();i++){  
			Node attribute=attributes.item(i);  
			if("FLAGS".equalsIgnoreCase(attribute.getNodeName())){}
			if("HOST".equalsIgnoreCase(attribute.getNodeName())){}
			if("TITLE".equalsIgnoreCase(attribute.getNodeName())){}
			}  
			NodeList childNodes = fatherNode.getChildNodes();  
			for(int j=0;j<childNodes.getLength();j++){  
			Node childNode=childNodes.item(j);  
			//如果这个节点属于Element ,再进行取值  
			if(childNode instanceof Element){  
			if("TITLE".equalsIgnoreCase(childNode.getNodeName())){
				NamedNodeMap titleAttrs =childNode.getAttributes();
				for(int i=0;i<titleAttrs.getLength();i++){  
					Node attribute=titleAttrs.item(i);  
					if("TEXT".equalsIgnoreCase(attribute.getNodeName())){}
				}  
			}
			if("ADDR".equalsIgnoreCase(childNode.getNodeName())){
				NamedNodeMap addrAttrs =childNode.getAttributes();
				for(int i=0;i<addrAttrs.getLength();i++){  
					Node attribute=addrAttrs.item(i);  
					if("CITY".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setCITY(attribute.getNodeValue());}
					if("COUNTRY".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setCOUNTRY(attribute.getNodeValue());}
					if("STATE".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setSTATE(attribute.getNodeValue());}
					if("STREET".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setSTREET(attribute.getNodeValue());}
					if("ZIP".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setZIP(attribute.getNodeValue());}
				}  
			}
			if("OWNER".equalsIgnoreCase(childNode.getNodeName())){
				NamedNodeMap ownerAttrs =childNode.getAttributes();
				for(int i=0;i<ownerAttrs.getLength();i++){  
					Node attribute=ownerAttrs.item(i);  
					if("NAME".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setxOwner(attribute.getNodeValue());}
				}  
			}
			if("EMAIL".equalsIgnoreCase(childNode.getNodeName())){
				NamedNodeMap emailAttrs =childNode.getAttributes();
				for(int i=0;i<emailAttrs.getLength();i++){  
					Node attribute=emailAttrs.item(i);  
					if("ADDR".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setxEmail(attribute.getNodeValue());}
				}  
			}
			if("LANG".equalsIgnoreCase(childNode.getNodeName())){
				NamedNodeMap langAttrs =childNode.getAttributes();
				for(int i=0;i<langAttrs.getLength();i++){  
					Node attribute=langAttrs.item(i);  
					if("CODE".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setxCode(attribute.getNodeValue());}
					if("LEX".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setxLex(attribute.getNodeValue());}
				}  
			}
			if("LINKSIN".equalsIgnoreCase(childNode.getNodeName())){
				NamedNodeMap linkAttrs =childNode.getAttributes();
				for(int i=0;i<linkAttrs.getLength();i++){  
					Node attribute=linkAttrs.item(i);  
					if("NUM".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setxLinksin(attribute.getNodeValue());}
				}  
			}
			if("SPEED".equalsIgnoreCase(childNode.getNodeName())){
				NamedNodeMap speedAttrs =childNode.getAttributes();
				for(int i=0;i<speedAttrs.getLength();i++){  
					Node attribute=speedAttrs.item(i);  
					if("PCT".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setxPct(attribute.getNodeValue());}
					if("TEXT".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setxSpeed(attribute.getNodeValue());}
				}  
			}
			if("CHILD".equalsIgnoreCase(childNode.getNodeName())){
				NamedNodeMap childAttrs =childNode.getAttributes();
				for(int i=0;i<childAttrs.getLength();i++){  
					Node attribute=childAttrs.item(i);  
					if("SRATING".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setxChild(attribute.getNodeValue());}
				}  
			}
			if("POPULARITY".equalsIgnoreCase(childNode.getNodeName())){
				NamedNodeMap popularAttrs =childNode.getAttributes();
				for(int i=0;i<popularAttrs.getLength();i++){  
					Node attribute=popularAttrs.item(i);  
					if("TEXT".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setxPopularity(StringUtil.getFormatNumbers(attribute.getNodeValue(), 0, ","));}
					if("URL".equalsIgnoreCase(attribute.getNodeName())){}
				}  
			}
			if("REACH".equalsIgnoreCase(childNode.getNodeName())){
				NamedNodeMap reachAttrs =childNode.getAttributes();
				for(int i=0;i<reachAttrs.getLength();i++){  
					Node attribute=reachAttrs.item(i);  
					if("RANK".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setxReach(attribute.getNodeValue());}
				}  
			}
			if("RANK".equalsIgnoreCase(childNode.getNodeName())){
				NamedNodeMap rankAttrs =childNode.getAttributes();
				for(int i=0;i<rankAttrs.getLength();i++){  
					Node attribute=rankAttrs.item(i);  
					if("DELTA".equalsIgnoreCase(attribute.getNodeName())){
						if(attribute.getNodeName().indexOf("-")==-1){
							alexaInfo.setDimg("<img src=\"/images/up_arrow.gif\" align=absmiddle width=18 height=16 />");
						}else
							alexaInfo.setDimg("<img src=\"/images/down_arrow.gif\" align=absmiddle width=18 height=16 />");
						alexaInfo.setxRank(StringUtil.getFormatNumbers(attribute.getNodeValue().replaceAll("\\-", "").replaceAll("\\+", ""),0,","));
					}
				}  
			}
			}  
			} 
			}
			
			NodeList domzList=doc.getElementsByTagName("DMOZ");
			NodeList childNodes = domzList.item(0).getChildNodes();
			for(int j=0;j<childNodes.getLength();j++){  
				Node childNode=childNodes.item(j);  
				//如果这个节点属于Element ,再进行取值  
				if(childNode instanceof Element){  
				if("SITE".equalsIgnoreCase(childNode.getNodeName())){
					NamedNodeMap titleAttrs =childNode.getAttributes();
					for(int i=0;i<titleAttrs.getLength();i++){  
						Node attribute=titleAttrs.item(i);  
						if("BASE".equalsIgnoreCase(attribute.getNodeName())){}
						if("DESC".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setSiteDesc(attribute.getNodeValue());}
						if("TITLE".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setSiteTitle(attribute.getNodeValue());}
					}
					if("CATS".equalsIgnoreCase(childNode.getChildNodes().item(0).getNodeName())){
						if(childNode.getChildNodes()!=null && childNode.getChildNodes().item(0)!=null && childNode.getChildNodes().item(0).getChildNodes().item(0)!=null && "CAT".equalsIgnoreCase(childNode.getChildNodes().item(0).getChildNodes().item(0).getNodeName())){
							titleAttrs =childNode.getChildNodes().item(0).getChildNodes().item(0).getAttributes();
							for(int i=0;i<titleAttrs.getLength();i++){  
								Node attribute=titleAttrs.item(i);  
								if("CID".equalsIgnoreCase(attribute.getNodeName())){}
								if("ID".equalsIgnoreCase(attribute.getNodeName())){}
								if("TITLE".equalsIgnoreCase(attribute.getNodeName())){alexaInfo.setCat(attribute.getNodeValue());}
							}
						}
					}
				}
				}
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		return SUCCESS;
	}
	
	//异步加载Alexa information
	public String ajax(){
		try{
			//http://cn.alexa.com/siteinfo/ubao.com
			String urlStr ="http://www.alexa.com/siteinfo/"+this.getDomain();
			String result =new SiteAlexaInfoAction().getTargetStr(urlStr,"utf-8");
			Pattern pattern = Pattern.compile("(.*)<img src=\"/images/icons/globe-sm.jpg\" alt=\"Global\" style=\"margin-bottom:-2px;\"/>(.*)</div><div class=\"label\">Alexa Traffic Rank(.*)");
	        Matcher matcher =pattern.matcher(result.toString());
	        if(matcher.find()){
	        	String ranks =matcher.group(2).toString().trim();
	        	System.out.println(ranks);
	        }
	        
	        pattern =Pattern.compile("(.*)<img class=\"dynamic-icon\" src=\"/images/flags/cn.png\"(.*)</div><div class=\"label\">Traffic Rank in(.*)");
	        matcher =pattern.matcher(result.toString());
	        if(matcher.find()){
	        	String ranks =matcher.group(2).toString().trim();
	        	if(ranks.indexOf("alt=\"China Flag\"/>")!=-1){
	        	System.out.println(ranks.replace("alt=\"China Flag\"/>", ""));
	        	}
	        }
	        
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public String trafficRank(){
		try{
		String resultStr="";
		String strUrl ="http://cn.alexa.com/siteinfo/"+this.getDomain();
		String result =new SiteAlexaInfoAction().getTargetStr(strUrl,"utf-8");
	
	    Pattern pattern =Pattern.compile("(.*)<p>"+this.getDomain()+"的 Alexa 网站流量排名：</p>(.*)<p>"+this.getDomain()+"的页面访问量占全球页面访问量的百分比：</p>(.*)");
	    Matcher matcher =pattern.matcher(result.toString());
	    if(matcher.find()){
    	String ranks =matcher.group(2).toString().trim();
    	if(ranks.indexOf("</div><div id=\"pageviews\" c=\"1\" y=\"p\"  class=\"tw-table\">")!=-1){
    		ranks =ranks.replace("</div><div id=\"pageviews\" c=\"1\" y=\"p\"  class=\"tw-table\">", "");
    	}
    	System.out.println(ranks);
    	//"<table><tr class=\"even\"><th>昨日</th><td>53,887</td></tr><tr><th>最近七天平均</th><td>64,982</td></tr><tr class=\"even\"><th>最近一月平均</th><td>65,630</td></tr><tr ><th>最近三月平均</th><td>54,116</td></tr><tr class=\"even\"><th>最近三月改变量</th><td>-8,127 <img src='/images/arrows/up_arrow.gif'/>  </td></tr></table>";    
	    String url =ranks.replaceAll("\\<.*?>", "");
        System.out.println(url);
        if(url.indexOf("昨日")!=-1 && url.indexOf("最近七天平均")!=-1 && url.indexOf("最近一月平均")!=-1 && url.indexOf("最近三月平均")!=-1 && url.indexOf("最近三月改变量")!=-1){
        	int p1 =url.indexOf("昨日");
        	int p2 =url.indexOf("最近七天平均");
        	int p3 =url.indexOf("最近一月平均");
        	int p4 =url.indexOf("最近三月平均");
        	int p5 =url.indexOf("最近三月改变量");
//        	System.out.println(url.substring(p1+2,p2)+"--"+url.substring(p2+6,p3)+"--"+url.substring(p3+6,p4)
//        			+"--"+url.substring(p4+6,p5)+"--"+url.substring(p5+7));
        	resultStr =url.substring(p1+2,p2)+"_split_"+url.substring(p2+6,p3)+"_split_"+url.substring(p3+6,p4)
        			+"_split_"+url.substring(p4+6,p5)+"_split_"+url.substring(p5+7);
        }
        }
	    
	    pattern =Pattern.compile("(.*)<img src=\"/images/icons/globe-sm.jpg\" alt=\"Global\" style=\"margin-bottom:-2px;\"/>(.*)</a></div><div class=\"label\">网站流量排名(.*)");
	    matcher =pattern.matcher(result.toString());
	    if(matcher.find()){
    	 String ranks =matcher.group(2).toString().trim();
    	 resultStr +="_split_"+ranks;
	    }
	    pattern =Pattern.compile("(.*)<div class=\"data\"><img class=\"dynamic-icon\" src=\"/images/flags/cn.png\" alt=\"China Flag\"/>(.*)</div><div class=\"label\"><!--<a href='/topsites/countries/CN' title=\"China\">-->CN<!--</a>-->网站流量排名(.*)");
	    matcher =pattern.matcher(result.toString());
	    if(matcher.find()){
    	 String ranks =matcher.group(2).toString().trim();
    	 resultStr +="_split_"+ranks;
	    }
	    this.getResponse().setCharacterEncoding("utf-8");
	    this.getResponse().setContentType("text/json;charset=utf-8");
	    PrintWriter out =this.getResponse().getWriter();
	    out.write(resultStr);
		}catch(Exception e){
			e.printStackTrace();
		}
	    return null;
	}
	
	public static void main(String[] args){
		Long start =System.currentTimeMillis();
		new SiteAlexaInfoAction().trafficRank();
		//new SiteAlexaInfoAction().ajax();
		Long end =System.currentTimeMillis();
		System.out.println("总共用时："+(end-start));
	}
	public static void testXml(String[] args){
		try{
		DocumentBuilderFactory domfac=DocumentBuilderFactory.newInstance(); 
		DocumentBuilder dombuilder=domfac.newDocumentBuilder();
		String urlStr ="http://data.alexa.com/data/?cli=10&dat=snba&ver=7.0&url=www.ubao.com";
		String uri =new SiteAlexaInfoAction().getTargetStr(urlStr,"utf-8");
		Document doc =dombuilder.parse(new ByteArrayInputStream(uri.getBytes()));
		Element root=doc.getDocumentElement();
		NodeList nodeList=doc.getElementsByTagName("SD"); 
		System.out.println("dbstore节点链的长度:"+nodeList.getLength());  
		for(int len=0;len<nodeList.getLength();len++){
		Node fatherNode=nodeList.item(len);  
		System.out.println("父节点为:"+fatherNode.getNodeName());  
		//把父节点的属性拿出来  
		NamedNodeMap attributes=fatherNode.getAttributes();  
		for(int i=0;i<attributes.getLength();i++){  
		Node attribute=attributes.item(i);  
		System.out.println("dbstore的属性名为:"+attribute.getNodeName()+" 相对应的属性值为:"+attribute.getNodeValue());  
		if("FLAGS".equalsIgnoreCase(attribute.getNodeName())){}
		if("HOST".equalsIgnoreCase(attribute.getNodeName())){}
		if("TITLE".equalsIgnoreCase(attribute.getNodeName())){}
		}  
		NodeList childNodes = fatherNode.getChildNodes();  
		System.out.println(childNodes.getLength());  
		for(int j=0;j<childNodes.getLength();j++){  
		Node childNode=childNodes.item(j);  
		//如果这个节点属于Element ,再进行取值  
		if(childNode instanceof Element){  
		System.out.println("子节点名为:"+childNode.getNodeName());
		if("TITLE".equalsIgnoreCase(childNode.getNodeName())){
			NamedNodeMap titleAttrs =childNode.getAttributes();
			for(int i=0;i<titleAttrs.getLength();i++){  
				Node attribute=titleAttrs.item(i);  
				System.out.println(childNode.getNodeName()+"的属性名为:"+attribute.getNodeName()+" 相对应的属性值为:"+attribute.getNodeValue());  
				if("TEXT".equalsIgnoreCase(attribute.getNodeName())){}
			}  
		}
		if("ADDR".equalsIgnoreCase(childNode.getNodeName())){
			NamedNodeMap addrAttrs =childNode.getAttributes();
			for(int i=0;i<addrAttrs.getLength();i++){  
				Node attribute=addrAttrs.item(i);  
				System.out.println(childNode.getNodeName()+"的属性名为:"+attribute.getNodeName()+" 相对应的属性值为:"+attribute.getNodeValue());  
				if("CITY".equalsIgnoreCase(attribute.getNodeName())){}
				if("COUNTRY".equalsIgnoreCase(attribute.getNodeName())){}
				if("STATE".equalsIgnoreCase(attribute.getNodeName())){}
				if("STREET".equalsIgnoreCase(attribute.getNodeName())){}
				if("ZIP".equalsIgnoreCase(attribute.getNodeName())){}
			}  
		}
		if("OWNER".equalsIgnoreCase(childNode.getNodeName())){
			NamedNodeMap ownerAttrs =childNode.getAttributes();
			for(int i=0;i<ownerAttrs.getLength();i++){  
				Node attribute=ownerAttrs.item(i);  
				System.out.println(childNode.getNodeName()+"的属性名为:"+attribute.getNodeName()+" 相对应的属性值为:"+attribute.getNodeValue());  
				if("NAME".equalsIgnoreCase(attribute.getNodeName())){}
			}  
		}
		if("EMAIL".equalsIgnoreCase(childNode.getNodeName())){
			NamedNodeMap emailAttrs =childNode.getAttributes();
			for(int i=0;i<emailAttrs.getLength();i++){  
				Node attribute=emailAttrs.item(i);  
				System.out.println(childNode.getNodeName()+"的属性名为:"+attribute.getNodeName()+" 相对应的属性值为:"+attribute.getNodeValue());  
				if("ADDR".equalsIgnoreCase(attribute.getNodeName())){}
			}  
		}
		if("LANG".equalsIgnoreCase(childNode.getNodeName())){
			NamedNodeMap langAttrs =childNode.getAttributes();
			for(int i=0;i<langAttrs.getLength();i++){  
				Node attribute=langAttrs.item(i);  
				System.out.println(childNode.getNodeName()+"的属性名为:"+attribute.getNodeName()+" 相对应的属性值为:"+attribute.getNodeValue());  
				if("CODE".equalsIgnoreCase(attribute.getNodeName())){}
				if("LEX".equalsIgnoreCase(attribute.getNodeName())){}
			}  
		}
		if("LINKSIN".equalsIgnoreCase(childNode.getNodeName())){
			NamedNodeMap linkAttrs =childNode.getAttributes();
			for(int i=0;i<linkAttrs.getLength();i++){  
				Node attribute=linkAttrs.item(i);  
				System.out.println(childNode.getNodeName()+"的属性名为:"+attribute.getNodeName()+" 相对应的属性值为:"+attribute.getNodeValue());  
				if("NUM".equalsIgnoreCase(attribute.getNodeName())){}
			}  
		}
		if("SPEED".equalsIgnoreCase(childNode.getNodeName())){
			NamedNodeMap speedAttrs =childNode.getAttributes();
			for(int i=0;i<speedAttrs.getLength();i++){  
				Node attribute=speedAttrs.item(i);  
				System.out.println(childNode.getNodeName()+"的属性名为:"+attribute.getNodeName()+" 相对应的属性值为:"+attribute.getNodeValue());  
				if("PCT".equalsIgnoreCase(attribute.getNodeName())){}
				if("TEXT".equalsIgnoreCase(attribute.getNodeName())){}
			}  
		}
		if("CHILD".equalsIgnoreCase(childNode.getNodeName())){
			NamedNodeMap childAttrs =childNode.getAttributes();
			for(int i=0;i<childAttrs.getLength();i++){  
				Node attribute=childAttrs.item(i);  
				System.out.println(childNode.getNodeName()+"的属性名为:"+attribute.getNodeName()+" 相对应的属性值为:"+attribute.getNodeValue());  
				if("SRATING".equalsIgnoreCase(attribute.getNodeName())){}
			}  
		}
		if("POPULARITY".equalsIgnoreCase(childNode.getNodeName())){
			NamedNodeMap popularAttrs =childNode.getAttributes();
			for(int i=0;i<popularAttrs.getLength();i++){  
				Node attribute=popularAttrs.item(i);  
				System.out.println(childNode.getNodeName()+"的属性名为:"+attribute.getNodeName()+" 相对应的属性值为:"+attribute.getNodeValue());  
				if("TEXT".equalsIgnoreCase(attribute.getNodeName())){}
				if("URL".equalsIgnoreCase(attribute.getNodeName())){}
			}  
		}
		if("REACH".equalsIgnoreCase(childNode.getNodeName())){
			NamedNodeMap reachAttrs =childNode.getAttributes();
			for(int i=0;i<reachAttrs.getLength();i++){  
				Node attribute=reachAttrs.item(i);  
				System.out.println(childNode.getNodeName()+"的属性名为:"+attribute.getNodeName()+" 相对应的属性值为:"+attribute.getNodeValue());  
				if("RANK".equalsIgnoreCase(attribute.getNodeName())){}
			}  
		}
		if("RANK".equalsIgnoreCase(childNode.getNodeName())){
			NamedNodeMap rankAttrs =childNode.getAttributes();
			for(int i=0;i<rankAttrs.getLength();i++){  
				Node attribute=rankAttrs.item(i);  
				System.out.println(childNode.getNodeName()+"的属性名为:"+attribute.getNodeName()+" 相对应的属性值为:"+attribute.getNodeValue());  
				if("DELTA".equalsIgnoreCase(attribute.getNodeName())){}
			}  
		}
		}  
		} 
		}
		
		NodeList domzList=doc.getElementsByTagName("DMOZ");
		NodeList childNodes = domzList.item(0).getChildNodes();
		for(int j=0;j<childNodes.getLength();j++){  
			Node childNode=childNodes.item(j);  
			//如果这个节点属于Element ,再进行取值  
			if(childNode instanceof Element){  
			System.out.println("子节点名为:"+childNode.getNodeName());
			if("SITE".equalsIgnoreCase(childNode.getNodeName())){
				NamedNodeMap titleAttrs =childNode.getAttributes();
				for(int i=0;i<titleAttrs.getLength();i++){  
					Node attribute=titleAttrs.item(i);  
					System.out.println(childNode.getNodeName()+"的属性名为:"+attribute.getNodeName()+" 相对应的属性值为:"+attribute.getNodeValue());  
					if("BASE".equalsIgnoreCase(attribute.getNodeName())){}
					if("DESC".equalsIgnoreCase(attribute.getNodeName())){}
					if("TITLE".equalsIgnoreCase(attribute.getNodeName())){}
				}
				if("CATS".equalsIgnoreCase(childNode.getChildNodes().item(0).getNodeName())){
					if("CAT".equalsIgnoreCase(childNode.getChildNodes().item(0).getChildNodes().item(0).getNodeName())){
						titleAttrs =childNode.getChildNodes().item(0).getChildNodes().item(0).getAttributes();
						for(int i=0;i<titleAttrs.getLength();i++){  
							Node attribute=titleAttrs.item(i);  
							System.out.println(childNode.getNodeName()+"的属性名为:"+attribute.getNodeName()+" 相对应的属性值为:"+attribute.getNodeValue());  
							if("CID".equalsIgnoreCase(attribute.getNodeName())){}
							if("ID".equalsIgnoreCase(attribute.getNodeName())){}
							if("TITLE".equalsIgnoreCase(attribute.getNodeName())){}
						}
					}
				}
			}
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// 取得目标字符串
	protected String getTargetStr(String urlStr,String charset) {
		URL url = null;
		HttpURLConnection httpConn = null;
		InputStream in = null;
		String cookie = "";
		try {
			do {
				url = new URL(urlStr);
				httpConn = (HttpURLConnection) url.openConnection();
				HttpURLConnection.setFollowRedirects(true);
				httpConn.setRequestMethod("GET");
				httpConn.setConnectTimeout(30000);
				httpConn.setRequestProperty("User-Agent",
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows 2000)");
				if (cookie.length() != 0)
					httpConn.setRequestProperty("Cookie", cookie);
				httpConn.setInstanceFollowRedirects(false);
				int code = httpConn.getResponseCode();
				if (code == HttpURLConnection.HTTP_MOVED_TEMP) {
					cookie += httpConn.getHeaderField("Set-Cookie") + ";";
				}
				if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK)
					break;
			} while (true);
			in = httpConn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in,
					StringUtil.isEmpty(charset)?"gb2312":charset));
			String line = "";
			StringBuffer sbf = new StringBuffer();
			while ((line = br.readLine()) != null) {
				sbf.append(line);
			}
			return sbf.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				httpConn.disconnect();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
}



