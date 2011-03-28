<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>文章列表</title>
<meta name ="keywords" content="前端开发, web前端,前端开发攻城师,设计, 开发, 前端资源, CSShtml,html5,css3,浏览器兼容, 前端开发工具, CSS整形和优化工具 , JS压缩工具 , JS格式化工具 , CSS参考手册 ,HTML参考手册 , 多重搜索" />
<meta name="description" content="懒人分享前端开发，关注用户体验。偷懒也是一种进步，懒人工具带您进步！" />
</head>
<body>
<div class="main">
	<table>
	<tr style="background-color:pink;"><td width="150px;">标题</td><td width="100px;">所属分类</td><td width="100px;">操作</td></tr>
	<s:iterator value="newsList" id="news">
		<tr><td><s:property value='#news.title'/></td><td><s:property value='#news.itsCategory.categoryName'/></td>
		<td><a href="orderNews.action?nid=<s:property value='#news.id'/>">修改</a></td>
		</tr>
	</s:iterator>
	</table>
</div>
</body>
</html>
