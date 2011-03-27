<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><s:if test="skey!=''"><s:property value='skey'/></s:if><s:else>关键词密度 查询工具</s:else>-懒人工具- 懒人网站助手</title>
<meta name="keywords" content="<s:property value='skey'/>,百度关关键词密度 ，关键字排名查询，搜索引擎关键字排名查询">
<meta name="description" content="<s:property value='skey'/>关键词密度 查询工具、排名情况.以及用户关注度，媒体关注度。">
</head>
<body>
<div class="main">
	<div class="col">
		<dl class="clist">
			<dt><strong>欢迎您使用本站的 关键词密度 查询工具，如果您觉得本站对您有帮助，请收藏或者推荐给您的朋友。</strong></dt>
			<dd class="tc">
      <form method="post" action="frequency.html">查询页面：<input name="surl" type="text" size="40" value="<s:property value='surl'/>" class="inp">&nbsp;&nbsp;关键词：<input name="skey" type="text" size="20" value="<s:property value='skey'/>" class="inp_t">&nbsp;<input type="submit" value="点击查询" class="sec"><br /><br />
<font color="#ff0000">注：字符长度按字节算，每个中文、半角符号占两字节，每个英文、全角符号占一字节。</font>
</form>
<s:if test="surl!='' && skey!=''">
<div id="key_density_index_colum_one_right_top" class="ct" style="text-align:left;">
<div id="tool_show_result"><div id="key_density">页面代码总长度：<s:property value="stotal"/>字节<br />关键字符串长度：<s:property value="keytotal"/>字节<br />关键字出现频率：<s:property value="frequency"/><br />关键字词密度：<s:property value="percent"/>(即关键字词占总长度的比重)<br />密度建议值：2%≦密度≦8%</div></div>

<div id="key_density_index_colum_one_bottom">
<div class="intro_title">>>PAGE KEYWORDS DENSITY [页面 关键字、关键词 密度 查询工具] 简介<<</div>
<div id="tool_show_intro">输入网站的详细的页面地址和关键词，可快速计算该页面的代码总长度、关键字长度，关键词出现频率、关键词总长度、关键词在总的代码中出现的密度等相关页面属性，使您更好的了解自己的页面结构，以防止被搜索引擎认为您在进行堆砌关键字等作弊行为，是您进行网站页面优化的得力助手。</div>
</div>
</div>
</s:if>
</div>
      </dd>
		</dl>
	</div>
</div>

</body>
</html>
