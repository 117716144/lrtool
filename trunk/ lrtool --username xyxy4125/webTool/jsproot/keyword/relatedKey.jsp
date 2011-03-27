<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><s:if test="keyword!=''"><s:property value='keyword'/></s:if><s:else>相关关键词列表</s:else>-懒人工具- 懒人网站助手</title>
<meta name="keywords" content="关键词，长尾词，收录量">
<meta name="description" content="查询网站某个关键字，长尾关键字在百度、相关收录量.以及用户关注度，媒体关注度。">
</head>
<body>
<div class="main">
	<div class="col">
	<dl class="clist">
		   <dt><strong>搜索引擎相关关键词查询</strong></dt>
		      	<dd>
		      	<form method="post" action="relatedKey.html">
		      	请输入关键字：<input name="keyword" id="key" type="text" size="65" value="<s:property value='keyword'/>" class="inp">&nbsp;<input type="submit" value="开始查询"  class="sec"><br />
                <s:if test="keyword!=''">
				<div class="ct">
					<s:iterator value="keyList" id="key">
					<p><label><s:property value="#key.keyword"/></label>最近搜索量：<s:property value="#key.searchCount"/></p>
					</s:iterator>
				</div>
				</s:if><s:else>
				<font color="#f00">请先输入关键词！</font>
				</s:else>
                </dd>
		</dl>
	</div>
</div>
</body>
</html>
