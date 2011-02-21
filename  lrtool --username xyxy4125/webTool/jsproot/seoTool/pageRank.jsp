<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>谷歌/搜狗PR值查询 - 站长工具 - 懒人工具 - lrtool.net - 致力SEO简单有效！</title>
</head>
<body>
<div class="main">
	<div class="col">
		<dl class="clist">
			<dt><strong>欢迎您使用本站的 PAGE RANK 查询工具，如果您觉得本站对您有帮助，请收藏或者推荐给您的朋友。</strong></dt>
			<dd>
				<form method="post" action="pagerank.html">
网站地址：<input name="prdomain" type="text" size="50" onMouseOver="this.focus()" onBlur="if (value ==''){value='http://www.'}" onFocus="this.select()" value="<s:property value='prdomain'/>" class="inp">&nbsp;<input type="submit" value="点击查询" class="sec"></form>	
				<font color="#ff0000">注："www.abc.com" 和 "abc.com" 的 Page Rank 数值不同</font>
		<div id="rank_index_colum_one_right_top">
		<div id="tool_show_result">您查询的页面地址：<br /><s:property value="prdomain"/><br />页面评定结果：<br/>
		<span class="google"><img alt="Google Rank<s:property value='googlePR'/>" src="/images/pagerank_4_<s:property value='googlePR'/>.gif"></span>
		<span class="sogou"><div class="percent"><span><em style="width: <s:property value='sogouPR'/>%;"><s:property value='sogouPR'/></em></span><s:property value='sogouPR'/></div></span>
	
			</dd>
		</dl>
		</div>
</body>
</html>
