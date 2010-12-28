package com.base.core.action.shoulu;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.base.core.util.StringUtil;

public class SiteAlexaInfoAction {

	public static void main(String[] args){
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

