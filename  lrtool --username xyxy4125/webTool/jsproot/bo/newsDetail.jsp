<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><s:property value="news.title"/>-懒人工具-懒人网站助手中文关键字分析与挖掘</title>
</head>
<body>
<div class="main">
	<div class="news">
		<div class="column">
			<h1><s:property value="news.title"/></h1>
			<em class="postInfo"><a title="View all posts by 懒人工具" href="http://www.lrtool.net/">懒人工具</a> 发表于: <s:date format="yyyy-MM-dd" name="createdDate"/> | 发表在: <a rel="category tag" title="查看 懒人分享的全部文章" href="#">懒人分享</a>  | Tags: <a rel="tag" href="#">前端开发</a></em>
			<p><s:property value="news.content" escape="false"/></p>
		</div>
		<div class="relat">
			<h3>更多相关链接：</h3>
			<ul>
				<li><a href="#" target="_blank"><s:property value="news.title"/></a></li>
			</ul>
		</div>
	</div>
	<s:include value="/includes/newsright.jsp"/>
</div>
</body>
</html>
