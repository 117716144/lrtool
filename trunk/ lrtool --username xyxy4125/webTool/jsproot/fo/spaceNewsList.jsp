<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>懒人空间-懒人工具-懒人网站助手中文关键字分析与挖掘</title>
<meta name ="keywords" content="前端开发, web前端,前端开发攻城师,设计, 开发, 前端资源, CSShtml,html5,css3,浏览器兼容, 前端开发工具, CSS整形和优化工具 , JS压缩工具 , JS格式化工具 , CSS参考手册 ,HTML参考手册 , 多重搜索" />
<meta name="description" content="懒人分享前端开发，关注用户体验。偷懒也是一种进步，懒人工具带您进步！" />
</head>
<body>
<div class="main">
	<div class="news">
	<s:iterator value="newsList" id="news">
		<div class="column">
			<h1><a href="/view/<s:property value='#news.encodeIdStr'/>.html" target="_blank"><s:property value="#news.title"/></a></h1>
			<em class="postInfo"><a title="View all posts by 懒人空间" href="http://www.lrtool.net/">懒人工具</a> 发表于: <s:date format="yyyy-MM-dd" name="#news.createdDate"/> | 发表在: <a rel="category tag" title="查看 懒人空间的全部文章" href="/lrspace.html">懒人空间</a>  | Tags: <a rel="tag" href="#"><s:property value="#news.keyword"/></a></em>
			<p><s:property value="#news.summary" escape="false"/></p>
			<p><a href="/view/<s:property value='#news.encodeIdStr'/>.html" target="_blank">查看详细</a></p>
		</div>
	</s:iterator>
	</div>
	<s:include value="/includes/newsright.jsp"/>
</div>
</body>
</html>
