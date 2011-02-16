<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>谷歌/搜狗PR值查询 - 站长工具 - 懒人工具 - lrtool.net - 致力SEO简单有效！</title>
</head>
<body>
<div class="totop">
     <dl class="tbox">
     <dt>欢迎您使用本站的 PAGE RANK 查询工具，如果您觉得本站对您有帮助，请收藏或者推荐给您的朋友。</dt>

      <dd class="tc">
<form method="post" action="pageRank.action">网站地址：<input name="prdomain" type="text" size="50" onMouseOver="this.focus()" onBlur="if (value ==''){value='http://www.'}" onFocus="this.select()" value="<s:property value='prdomain'/>" class="inp_t">&nbsp;<input type="submit" value="点击查询" class="sb_c"></form><font color="#ff0000">注："www.abc.com" 和 "abc.com" 的 Page Rank 数值不同</font>
<div id="rank_index_colum_one_right_top">
<div id="tool_show_result">您查询的页面地址：<br /><s:property value="prdomain"/><br />页面评定结果：<br/>
<span class="google"><img alt="Google Rank<s:property value='googlePR'/>" src="/images/pagerank_4_<s:property value='googlePR'/>.gif"></span>
<span class="sogou"><div class="percent"><span><em style="width: <s:property value='sogouPR'/>%;"><s:property value='sogouPR'/></em></span><s:property value='sogouPR'/></div></span>
</div>
</div>
<!-- 
<div id="rank_index_colum_one_bottom">
<div class="intro_title">>>GOOGLE PAGE RANK [GOOGLE页面等级评定] 简介<<</div>
<div id="tool_show_intro">PageRank取自Google的创始人LarryPage，它是Google排名运算法则（排名公式）的一部分，用来标识网页的等级/重要性。级别从0到10级，10级为满分。PR值越高说明该网页越受欢迎（越重要）。注意: GOOGLE PR 是和精确完整的网址相关的，不同的网址具有不同的PR。www.abc.com与abc.com的PR值是不同的。</div>
</div>
<div id="rank_index_colum_one_bottom">
<div class="intro_title">>>SOGOU PAGE RANK [搜狗页面等级评定] 简介<<</div>
<div id="tool_show_intro">网页评级依托搜狗40亿中文网页的储备，分析最全的中文互联网链接库，链接覆盖度位居同类产品之首，确保评级的客观公正。评级范围从0到100，同时显示链接情况，提供比Google Rank更精细的优化参考。无需安装任何工具，即可查询到每个页面的评级，首度揭秘搜狗衡量网页重要性的指标。注意: Sogou Rank 是和精确完整的网址相关的，不同的网址具有不同的PR。www.abc.com与abc.com的Sogou Rank值是不同的。</div>
</div>
-->
</div>
</body>
</html>
