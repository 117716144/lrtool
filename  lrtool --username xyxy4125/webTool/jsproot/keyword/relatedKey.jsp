<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title> 相关关键词列表- 站长工具 - 懒人工具 - lrtool.net - 实用的网站！</title>
</head>
<body>
<div class="main">
	<div class="col">
	<dl class="clist">
		   <dt><strong>搜索引擎相关关键词查询</strong></dt>
		      	<dd><form method="post" target="_blank" action="relatedKey.html"><input name="keyword" id="key" type="text" size="65" value="<s:property value='keyword'/>" class="inp">&nbsp;<input type="submit" value="开始查询"  class="sec"><br />
                </dd>
		</dl>
<s:if test="keyword!=''">
<table>
<s:iterator value="keyList" id="key">
<tr><td width="150px;"><s:property value="#key.keyword"/></td><td width="300px;">最近搜索量：<s:property value="#key.searchCount"/></td></li>
</s:iterator>
</table>
</s:if><s:else>
请先输入关键词！
</s:else>
	</div>
</div>
</body>
</html>
