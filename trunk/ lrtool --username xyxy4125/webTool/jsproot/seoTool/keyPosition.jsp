<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><s:if test="keyword!=''"><s:property value='keyword'/>-baidu关键字收录</s:if><s:else>关键字收录查询</s:else>-懒人工具- 懒人网站助手</title>
<meta name="keywords" content="<s:property value='siteurl'/>,<s:property value='keyword'/>关键词，长尾词，收录量">
<meta name="description" content="<s:property value='siteurl'/>,<s:property value='keyword'/>,长尾关键字在百度、相关收录量.以及用户关注度，媒体关注度。">
</head>
<body>
<div class="main">
	<div class="col">
		<dl class="clist">
			<dt><strong>Baidu关键字收录情况</strong></dt>
			<dd>
				请输入你要查询的地址：
	   <form action="position.html" method="post">
				            网站域名：<input name="siteurl" type="text" size="40" value="<s:property value='siteurl'/>"  class="inp_t"/> 关键词：<input name="keyword" type="text" value="<s:property value='keyword'/>" size="20" class="inp_t" />
				            收索引擎：<select >
	             <option selected="selected" value="0">Baidu</option>
                      </select>
	<input  class="sec" type="submit" value="点击查询" />
			             </form>
			              <div class="ct">
<s:if test="siteurl!='' && keyword!=''">
			             百度关键字排名查询查询结果：<br/>
			             <div id="key">
 <s:if test="keyPosition!=null && keyPosition!=''">
 搜索 <font color=red>"<s:property value='keyword'/>"</font> 第<strong> <font color=red>"<s:property value='keyPosition'/>"</font> </strong>个出现 "<s:property value='siteurl'/>"
 </s:if><s:else>关键字 "<s:property value='keyword'/>" 在网站 "<s:property value='siteurl'/>" 的 Baidu 收录结果前 100 名中有 0 条记录</s:else>
 </s:if><br/>
<font color="#f00">工具简介：Baidu关键字收录情况,百度关键字排名查询！ </font></div>	   
			</dd>
		</dl>
	</div>
</div>
</body>
</html>
