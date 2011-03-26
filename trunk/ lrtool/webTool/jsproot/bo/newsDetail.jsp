<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title> 新闻详细页- 站长工具 - 懒人工具 - lrtool.net - 实用的网站！</title>
</head>
<body>
<div class="main">
	<div class="col">
<table>
<b><s:property value="news.title"/></b><br/><br/>
<s:property value="news.content" escape="false"/><br/>

</table>
	</div>
</div>
</body>
</html>
