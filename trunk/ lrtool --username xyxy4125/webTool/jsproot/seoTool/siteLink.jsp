<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:if test="searchWord!=''"><s:property value='searchWord'/></s:if><s:else>搜索引擎反向链接</s:else>-懒人工具- 懒人网站助手</title>
<meta name="keywords" content="<s:property value='searchWord'/>,百度关键字排名查询，关键字排名查询，搜索引擎关键字排名查询">
<meta name="description" content="<s:property value='searchWord'/>查询网站某个关键字在百度、排名情况.以及用户关注度，媒体关注度。">
<script language="javascript" type="text/javascript" src="/js/sitelink.js"></script>
</head>
<body>
<div class="main">
	<div class="col">
		<dl class="clist">
			<dt><strong>欢迎您使用本站的搜索引擎反向链接 工具，如果您觉得本站对您有帮助，请收藏或者推荐给您的朋友。</strong></dt>
      <dd><form method="post" target="_top" action="link.html">请输入要查询的网址: <font class="htp">HTTP://</font> <input type="text" name="shoulu_domain" size="60" id="shoulu_domain" value="<s:property value='shoulu_domain'/>" class="inp_t">&nbsp;<input type="submit" value="开始查询" class="sec"><br />
<input name="googlecheck" type="checkbox" class="checkbox" value="checked" <s:if test="googlecheck=='checked'">checked</s:if>/>谷歌
<input name="baiducheck" type="checkbox" class="checkbox" value="checked" <s:if test="baiducheck=='checked'">checked</s:if>/>百度
<input name="yahoocheck" type="checkbox" class="checkbox" value="checked" <s:if test="yahoocheck=='checked'">checked</s:if>> 雅虎
<input name="sosocheck" type="checkbox" class="checkbox" value="checked" <s:if test="sosocheck=='checked'">checked</s:if>/>SOSO
<input name="sogoucheck" type="checkbox" class="checkbox" value="checked" <s:if test="sogoucheck=='checked'">checked</s:if>/>搜狗
<input name="youdaocheck" type="checkbox" class="checkbox" value="checked" <s:if test="youdaocheck=='checked'">checked</s:if>/>有道
<input name="bingcheck" type="checkbox" class="checkbox" value="checked" <s:if test="bingcheck=='checked'">checked</s:if>/>必应
<input name="chkall" type="checkbox" class="checkbox" value=on onclick=checkall(this.form)>全选
</form>
</dd>
		</dl>
	</div>
	<s:if test="shoulu_domain!=''">
	<s:if test="googlecheck==null && baiducheck==null && yahoocheck==null && msncheck==null && sogoucheck==null && zhongsoucheck==null && sosocheck==null && sinacheck==null && tomcheck==null">
选择查询内容项错误，请至少选择其中一项进行查询！
</s:if>
<s:else>
	<div class="col">
		<dl class="clist">
     <dt><strong>网站 <s:property value="shoulu_domain"/> 搜索引擎反向链接情况查询</strong></dt>
      <dd class="clear">
      	<ul>
           <li>&nbsp;</li>           
            <li>查询站点</li>
            <li>链接数量</li>
            <li>查看详细</li>
        </ul>
		<s:if test ="googlecheck=='checked'">
        <ul id="google" >
            <li>谷歌</li>
            <li><s:property value="shoulu_domain"/></li>
            <li id="google_count">数据加载中...</li>
            <li id="google_site">数据加载中...</li>
            </ul></s:if>
        <s:if test="baiducheck=='checked'">
			<ul id="baidu" >
            <li>百度</li>
            <li><s:property value="shoulu_domain"/></li>
            <li id="baidu_count">数据加载中...</li>
            <li id="baidu_site">数据加载中...</li>
            </ul></s:if>
		<s:if test="yahoocheck=='checked'">
			<ul id="yahoo" >
            <li>雅虎中国</li>
            <li><s:property value="shoulu_domain"/></li>
            <li id="yahoo_count">数据加载中...</li>
            <li id="yahoo_site">数据加载中...</li>
            </ul>
			</s:if>
         <s:if test="sosocheck=='checked'">
            <ul id="soso" >
            <li>搜搜</li>
            <li><s:property value="shoulu_domain"/></li>
            <li id="soso_count">数据加载中...</li>
            <li id="soso_site">数据加载中...</li>
            </ul></s:if>
         <s:if test="sogoucheck=='checked'">
              <ul id="sogou" >
            <li>搜狗</li>
            <li><s:property value="shoulu_domain"/></li>
            <li id="sogou_count">数据加载中...</li>
            <li id="sogou_site">数据加载中...</li>
            </ul></s:if>
          <s:if test="youdaocheck=='checked'">  
             <ul id="youdao" >
            <li>有道</li>
            <li><s:property value="shoulu_domain"/></li>
            <li id="youdao_count">数据加载中...</li>
            <li id="youdao_site">数据加载中...</li>
            </ul></s:if>
          <s:if test="bingcheck=='checked'">        
             <ul id="bing" >
            <li>必应</li>
            <li>  </li>
            <li><s:property value="shoulu_domain"/></li>
            <li id="bing_count">数据加载中...</li>
            <li id="bing_site">数据加载中...</li>
            </ul></s:if>
      </dd>
     </dl>
	</div>
</s:else>
</s:if>
</div>

 <s:if test="shoulu_domain!=''">
 <script type="text/javascript">
 <s:if test="googlecheck=='checked'">getGoogle();</s:if>
 <s:if test="baiducheck=='checked'">getBaidu();</s:if>
 <s:if test="yahoocheck=='checked'">getYahoo();</s:if>
 <s:if test="sosocheck=='checked'">getSoso();</s:if>
 <s:if test="sogoucheck=='checked'">getSogou();</s:if>
 <s:if test="youdaocheck=='checked'">getYoudao();</s:if>
 <s:if test="bingcheck=='checked'">getBing();</s:if>
 </script>
 </s:if>
</body>
</html>
