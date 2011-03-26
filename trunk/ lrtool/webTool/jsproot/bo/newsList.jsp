<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title> 新闻列表- 站长工具 - 懒人工具 - lrtool.net - 实用的网站！</title>
</head>
<body>
<div class="main">
	<div class="col">
	<dl class="clist">
		   <dt><strong>最近分享</strong></dt>
		      	<dd><form method="post" target="_blank" action="relatedKey.html"><input name="keyword" id="key" type="text" size="65" value="<s:property value='keyword'/>" class="inp">&nbsp;<input type="submit" value="开始查询"  class="sec"><br />
                </dd>
		</dl>
	</div>
</div>
<div class="main">
	<div class="col">
<table>
<tr><td>标题</td><td>创建时间</td><td>操作</td></tr>
<s:iterator value="newsList" id="news">
<tr><td width="150px;"><s:property value="#news.title"/></td><td width="100px;"><s:date format="yyyy-MM-dd" name="createdDate"/></td><td width="100px;"><a href="showDetail.action?nid=<s:property value='id'/>" target="_blank">查看详细</a></td></li>
</s:iterator>
</table>
	</div>
</div>
</body>
</html>
