<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>搜索引擎反向链接 - 站长工具 - 懒人工具 - lrtool.net - 致力SEO简单有效！</title>
<meta name ="keywords" content="便民工具,网站搜索,网址导航，搜一搜,个性化导航,全民搜索,起始页,上网主页,上网首页,收藏夹,网络收藏夹,网址收藏夹,书签,QQ书签,网络书签,上网导航,网址,网址导航,导航,快捷上网,网址之家,实用工具,搜索,社区" />
<meta name="description" content="网站搜一搜，让全民上网更加方便更加快捷，最具个性化的导航搜索平台，让你工作生活无忧!" />
<script language="javascript" type="text/javascript" src="/js/sitelink.js"></script>
</head>
<body>
<div class="main">
	<div class="col">
		<dl class="clist">
			<dt><strong>欢迎您使用本站的搜索引擎反向链接 工具，如果您觉得本站对您有帮助，请收藏或者推荐给您的朋友。</strong></dt>
      <dd><form method="post" target="_top" action="siteLinkAction.action">请输入要查询的网址: <font face="Arial">http://</font> <input type="text" name="shoulu_domain" size="60" id="shoulu_domain" value="<s:property value='shoulu_domain'/>" class="inp_t">&nbsp;<input type="submit" value="开始查询" class="sb_c"><br />
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
	<s:if test="googlecheck==null && baiducheck==null && yahoocheck==null && msncheck==null && sogoucheck==null && zhongsoucheck==null && sosocheck==null && sinacheck==null && tomcheck==null">
选择查询内容项错误，请至少选择其中一项进行查询！
</s:if>
<s:else>
	<div class="col">
		<dl class="clist">
     <dt><strong>网站 <s:property value="shoulu_domain"/> 搜索引擎收录查询结果</strong></dt>
      <dd class="clear">
      	<ul>
           <li></li>           
            <li>查询站点</li>
            <li>收录数量</li>
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
</div>


<s:else>
<div class="totop ri">
     <dl class="tbox">
     <dt>网站 <s:property value="shoulu_domain"/> 搜索引擎反向链接查询结果</dt>
      <dd class="tc"><ul class="d1">
            <li> </li>
            <li>  </li>
            <li>查询站点</li>
            <li>收录数量</li>
            <li>查看详细</li>
            
        </ul>
		<br />
		<s:if test ="googlecheck=='checked'">
        <ul class="d1" id="google" >
            <li>谷歌</li>
            <li>  </li>
            <li><s:property value="shoulu_domain"/></li>
            <li id="google_count">数据加载中...</li>
            <li id="google_site">数据加载中...</li>
            </ul><br /></s:if>
        <s:if test="baiducheck=='checked'">
			<ul class="d1" id="baidu" >
            <li>百度</li>
            <li>  </li>
            <li><s:property value="shoulu_domain"/></li>
            <li id="baidu_count">数据加载中...</li>
            <li id="baidu_site">数据加载中...</li>
            </ul><br /></s:if>
		<s:if test="yahoocheck=='checked'">
			<ul class="d1" id="yahoo" >
            <li>雅虎中国</li>
            <li>  </li>
            <li><s:property value="shoulu_domain"/></li>
            <li id="yahoo_count">数据加载中...</li>
            <li id="yahoo_site">数据加载中...</li>
            </ul><br />
			</s:if>
         <s:if test="sosocheck=='checked'">
            <ul class="d1" id="soso" >
            <li>搜搜</li>
            <li>  </li>
            <li><s:property value="shoulu_domain"/></li>
            <li id="soso_count">数据加载中...</li>
            <li id="soso_site">数据加载中...</li>
            </ul><br /></s:if>
         <s:if test="sogoucheck=='checked'">
              <ul class="d1" id="sogou" >
            <li>搜狗</li>
            <li>  </li>
            <li><s:property value="shoulu_domain"/></li>
            <li id="sogou_count">数据加载中...</li>
            <li id="sogou_site">数据加载中...</li>
            </ul><br /></s:if>
          <s:if test="youdaocheck=='checked'">  
             <ul class="d1" id="youdao" >
            <li>有道</li>
            <li>  </li>
            <li><s:property value="shoulu_domain"/></li>
            <li id="youdao_count">数据加载中...</li>
            <li id="youdao_site">数据加载中...</li>
            </ul><br /></s:if>
            
          <s:if test="bingcheck=='checked'">        
             <ul class="d1" id="bing" >
            <li>必应</li>
            <li>  </li>
            <li><s:property value="shoulu_domain"/></li>
            <li id="bing_count">数据加载中...</li>
            <li id="bing_site">数据加载中...</li>
            </ul><br /></s:if>
        <div class="clear"></div>
      </dd>
     </dl>   </div>
</s:else>


</div>
</div>
 
 <script type="text/javascript">
 <s:if test="googlecheck=='checked'">getGoogle();</s:if>
 <s:if test="baiducheck=='checked'">getBaidu();</s:if>
 <s:if test="yahoocheck=='checked'">getYahoo();</s:if>
 <s:if test="sosocheck=='checked'">getSoso();</s:if>
 <s:if test="sogoucheck=='checked'">getSogou();</s:if>
 <s:if test="youdaocheck=='checked'">getYoudao();</s:if>
 <s:if test="bingcheck=='checked'">getBing();</s:if>
 </script>
 
</body>
</html>
