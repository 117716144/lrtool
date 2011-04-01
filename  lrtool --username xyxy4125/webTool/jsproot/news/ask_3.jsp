<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>如何查看网站被百度抓取的情况？-懒人工具-懒人网站助手中文关键字分析与挖掘</title>
<meta name="keywords" content="百度,seo" />
<meta name="description" content="我们查看网站被百度抓取的情况主要是分析，网站日志里百度蜘蛛Baiduspider的活跃性：抓取频率，返回的HTTP状态码。" />
</head>
<body>
<div class="main">
	<div class="news">
		<div class="column">
			<h1>如何查看网站被百度抓取的情况？</h1>
			<em class="postInfo"><a title="View all posts by 懒人空间" href="http://www.lrtool.net/">懒人工具</a> 发表于: 2011-04-01 | 发表在: <a rel="category tag" title="查看 懒人空间的全部文章" href="/lrspace.html">懒人网站优化</a>  | Tags: 网站优化，百度蜘蛛</em>
			<p>百度用于抓取网页的程序叫做<a href="/ask_4.html">Baiduspider - 百度蜘蛛</a>，我们查看网站被百度抓取的情况主要是分析，网站日志里百度蜘蛛Baiduspider的活跃性：抓取频率，返回的HTTP状态码。</p>
			<p>查看日志的方式：</p>
			<p>通过FTP，在网站根目录找到一个日志文件，文件名一般包含log，下载解压里面的记事本，这即是网站的日志，记录了网站被访问和操作的情况。</p>
			<p>因为各个服务器和主机的情况不同，不同的主机日志功能记录的内容不同，有的甚至没有日志功能。</p>
			<p>日志内容如下：</p>
			<p>61.135.168.22 - - [11/Jan/2009:04:02:45 +0800] "GET /bbs/thread-7303-1-1.html HTTP/1.1" 200 8450 "-" "Baiduspider+(+<a href="http://www.baidu.com/search/spider.htm">http://www.baidu.com/search/spider.htm</a>)"   </p>
			<p>分析：</p>
			<p>GET /bbs/thread-7303-1-1.html   代表，抓取/bbs/thread-7303-1-1.html 这个页面。</p>
			<p>200  代表成功抓取。</p>
			<p>8450  代表抓取了8450个字节。</p>
			<p>如果你的日志里格式不是如此，则代表日志格式设置不同。</p>
			<p>很多日志里可以看到 200 0 0和200 0  64 则都代表正常抓取。</p>
			<p>抓取频率是通过查看每日的日志里百度蜘蛛抓取次数来获知。抓取频率并没有一个规范的时间表或频率数字，我们一般通过多日的日志对比来判断。当然，我们希望百度蜘蛛每日抓取的次数越多越好。</p>
			<p>在网站出现问题的情况下，通过查看网站日志，查看网站的HTTP返回值是否正常。</p>
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
