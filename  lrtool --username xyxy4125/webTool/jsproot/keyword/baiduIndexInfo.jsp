<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><s:if test="searchWord!=''"><s:property value='searchWord'/></s:if><s:else>百度指数查询</s:else>-关键字用户媒体关注度-懒人工具- 懒人网站助手</title>
<meta name="keywords" content="<s:property value='searchWord'/>,百度关键字排名查询，关键字排名查询，搜索引擎关键字排名查询">
<meta name="description" content="<s:property value='searchWord'/>查询网站某个关键字在百度、排名情况.以及用户关注度，媒体关注度。">
</head>
<body>
<div class="main">
	<div class="col">
		<dl class="clist">
		   <dt><strong>关键词百度指数查询(","隔开可查询多个关键词)</strong></dt>
		      	<dd>
		      	<form method="post" action="bdIndex.html">
		      	请输入关键字：<input name="searchWord" id="key" type="text" size="65" value="<s:property value='searchWord'/>" class="inp">&nbsp;<input type="submit" value="开始查询"  class="sec"><br />
                <s:if test="searchWord!=''">
<s:iterator value="infoList" id="info" status="u">
<div class="ct">
<object height="396" width="580" align="middle" id="trendAnalyser" 
codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" 
classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000<s:property value='#u.index'/>">
<param value="transparent" name="wmode"><param value="http://index.baidu.com/fla/TrendAnalyser.swf" name="movie">
<param value="keys=<s:property value='#info.encodeKey'/>&amp;areas=0&amp;periods=<s:property value='#info.startDate'/>%7C<s:property value='#info.endDate'/>&amp;periodNames=null&amp;dv=1&amp;gateway=http%3A%2F%2Findex.baidu.com%2Fgateway.php&amp;snapshot=http%3A%2F%2Findex.baidu.com%2Fmain%2Fshow.php&amp;key=<s:property value='#info.bdKey'/>" name="flashvars">
<embed height="396" width="580" align="middle" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" name="trendAnalyser" src="http://index.baidu.com/fla/TrendAnalyser.swf" flashvars="keys=<s:property value='#info.encodeKey'/>&amp;areas=0&amp;periods=<s:property value='#info.startDate'/>%7C<s:property value='#info.endDate'/>&amp;periodNames=null&amp;dv=1&amp;gateway=http%3A%2F%2Findex.baidu.com%2Fgateway.php&amp;snapshot=http%3A%2F%2Findex.baidu.com%2Fmain%2Fshow.php&amp;key=<s:property value='#info.bdKey'/>" wmode="transparent" bgcolor="#FFFFFF" errormessage="Please download the newest flash player." ver="9.0.0">
</object>
</div>
</s:iterator>
</s:if>
                </dd>
		</dl>
	<div>
</div>
</div>
</body>
</html>
