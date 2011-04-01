<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>404页面该怎么做？-懒人工具-懒人网站助手中文关键字分析与挖掘</title>
<meta name="keywords" content="404,seo" />
<meta name="description" content="<strong>404页面</strong>的目的是：告诉浏览者其所请求的页面不存在或链接错误，同时引导用户使用网站其他页面而不是关闭窗口离开。" />
</head>
<body>
<div class="main">
	<div class="news">
		<div class="column">
			<h1>404页面该怎么做？</h1>
			<em class="postInfo"><a title="View all posts by 懒人空间" href="http://www.lrtool.net/">懒人工具</a> 发表于: 2011-04-01 | 发表在: <a rel="category tag" title="查看 懒人空间的全部文章" href="/lrspace.html">懒人网站优化</a>  | Tags: 网站优化，404</em>
			<p><strong>404页面</strong>的目的是：告诉浏览者其所请求的页面不存在或链接错误，同时引导用户使用网站其他页面而不是关闭窗口离开。</p>
			<p>很多开源系统包括CMS系统、Blog系统等不提供404页面或提供的404页面并未达到SEO的要求，这让网站的权威性大打折扣。</p>
			<p>404页面该达到怎么样的效果才符合SEO要求？</p>
			<p>搜索引擎通过HTTP状态码来识别网页的状态。当搜索引擎获得了一个错误链接时，网站应该返回404状态码，告诉搜索引擎放弃对该链接的索引。而如果返回200或302状态码，搜索引擎就会为该链接建立索引，这导致大量不同的链接指向了相同的网页内容。结果是，搜索引擎对该网站的信任度大幅降低。——很多网站存在这个问题：404页面返回的是200或302状态码而不是404状态码。</p>
			<p>正确建立404页面的方法是：（仅适合Apache服务器）</p>
			<p>在.htaccess 文件中加入代码： ErrorDocument 404 /Error.html<br/>
    建立一个简单的html404页面命名 Error.html<br/>
    把 Error.html放置在网站根目录
</p>
			<p>注意：</p>
			<p>不要将404错误直接转向到网站首页，这将导致首页不被收录；<br/>
    /Error.html 前面不要带主域名，否则返回的状态码是302或200状态码。</p>
			<p>对此文章有什么疑问，请提交在<a href="/lrspace.html">懒人空间</a></p>
		</div>
		<!-- <div class="relat">
			<h3>更多相关链接：</h3>
			<ul>
				<li><a href="#" target="_blank"><s:property value="news.title"/></a></li>
			</ul>
		</div> -->
	</div>
</div>
</body>
</html>
