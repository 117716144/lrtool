<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head> 
<title>首页 - 站长工具 - 懒人工具 - lrtool.net - 致力SEO简单流程化！</title>
<meta name ="keywords" content="便民工具,网站搜索,网址导航，搜一搜,个性化导航,全民搜索,起始页,上网主页,上网首页,收藏夹,网络收藏夹,网址收藏夹,书签,QQ书签,网络书签,上网导航,网址,网址导航,导航,快捷上网,网址之家,实用工具,搜索,社区" />
<meta name="description" content="网站搜一搜，让全民上网更加方便更加快捷，最具个性化的导航搜索平台，让你工作生活无忧!" />
<script language="javascript" type="text/javascript" src="/datepicker/WdatePicker.js"></script>
</head>

<body>
<div class="main">
	<div class="col">
		<dl>
		   <dt><strong>搜索引擎收录情况查询</strong><p><a href="collect.html" target="_blank"><img src="/images/right.gif" /></a></p></dt>
		      	<dd><form method="post" target="_blank" onsubmit="return checkUrl(document.getElementById('sholuinpt').value);" action="collect.html"><font class="htp">HTTP://</font> <input name="shoulu_domain" id="sholuinpt" type="text" size="65" value="" class="inp">&nbsp;<input type="submit" value="开始查询"  class="sec"><br />
				<input name="googlecheck" type="checkbox" class="checkbox" value="checked" > 谷歌
				<input name="baiducheck" type="checkbox" class="checkbox" value="checked" > 百度
				<input name="yahoocheck" type="checkbox" class="checkbox" value="checked" > 雅虎
				<input name="sosocheck" type="checkbox" class="checkbox" value="checked" > SOSO
				<input name="sogoucheck" type="checkbox" class="checkbox" value="checked" > 搜狗
				<input name="youdaocheck" type="checkbox" class="checkbox" value="checked" > 有道
				<input name="bingcheck" type="checkbox" class="checkbox" value="checked" > 必应
				<input name="chkall" type="checkbox" class="checkbox" value=on onclick=checkall(this.form)> 全选</form>可查询各大搜索引擎对指定网站的收录数量和对比情况。
				 </dd>
		</dl>
	</div>
	<div class="col">
    	<dl>
        <dt><strong>关键词排名查询</strong><p><a href="position.html" target="_blank"><img src="/images/right.gif" /></a></p></dt>
        <dd><form action="position.html" method="post" target="_blank">网站域名：<input name="siteurl" type="text" size="30"  class="inp">&nbsp;关键词：<input name="keyword" type="text" value="" size="6"  class="inp">&nbsp;<input type="submit" value="开始查询" class="sec"></form>可查询指定站点在baidu中搜索指定关键词时的排名位置。
      </dd>
    </div>
   	<div class="col cmid">
   		<dl>
        <dt><strong>IP/服务器物理定位查询</strong><p><a href="ipsearch.html" target="_blank"><img src="/images/right.gif" /></a></p></dt>
        <dd><form method="post" target="_blank" onsubmit="return checkUrl(document.getElementById('ipinpt').value);" action="ipsearch.html">IP / 域名：<input name="myIp" id="ipinpt" type="text" size="30" value="<%=request.getRemoteAddr()%>" class="inp">&nbsp;<input type="submit" value="开始查询" class="sec"></form>直接输入IP则可查询该IP的物理位置；
      </dd>
   	</div>
    <div class="col crig">
    	<dl>
        <dt><strong>域名 WHOIS 信息查询</strong><p><a href="whois.html" target="_blank"><img src="/images/right.gif" /></a></p></dt>
        <dd><form method="post" target="_blank" name="ipform" action="whois.html" onsubmit="return checkIP();">网站域名：www.<input name="domain" type="text" size="30" value="" class="inp">&nbsp;<input type="submit"value="开始查询" class="sec"></form>输入域名则可检测服务器的IP及其 WHOIS 信息。
      </dd>
    </div>
    <div class="col cmid">
    	<dl>
        <dt><strong>ALEXA 详细排名查询</strong><p><a href="alexa.html"><img src="/images/right.gif" /></a></p></dt>
        <dd><form action="alexa.html" method="post" target="_blank">
网站地址：<input name="domain"  type="text" size="30" value="http://www." class="inp">&nbsp;<input type="submit" value="开始查询" class="sec"></form>可查询网站的世界排名、流量、访问量、联系方式等综合信息。
      </dd>
     </dl>
    </div>
    
    <div class="col crig">
    	<dl>
        <dt><strong>GG PR & SOGOU RANK 查询</strong><p><a href="pagerank.html" target="_blank"><img src="/images/right.gif" /></a></p></dt>
        <dd><form method="post" target="_blank" name="get_rank" action="pagerank.html">网站地址：<input name="prdomain" type="text" size="20" value="http://www." class="inp">&nbsp;<input type="submit" value="开始查询" class="sec"></form>可查询网页在GG和搜狗上的页面等级（影响搜索引擎排名）信息。</dd>
     </dl>
    </div>
    <div class="col cmid">
    	<dl>
        <dt><strong>页面关键词密度查询</strong><p><a href="frequency.html"><img src="/images/right.gif" /></a></p></dt>
        <dd><form method="post" target="_blank" action="frequency.html">网站页面：<input name="surl" type="text" size="14" value="http://www." class="inp">&nbsp;关键词：<input name="skey" type="text" size="7" value="" class="inp">&nbsp;<input type="submit" value="开始查询" class="sec"></form>可查询指定页面中某一关键词的出现频率和密度。
      </dd>
     </dl>
    </div>
    <div class="col crig">
    	<dl>
        <dt><strong>身份证生成工具</strong><p><a href="generatecard.html"><img src="/images/right.gif"/></a></p></dt>
        <dd><form action="generatecard.html" method="get"  target="_blank">
        	<s:include value="/common/areas/areas.jsp"/>
        	<input class="Wdate" type="text" name="birthDay" value="1987-07-05" onClick="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d',startDate:'1985-07-05'})">
        	请点击生成按钮将身份证号直接生成！<br/>
        <input type="submit" value="生成" class="sec"></form>
      </dd>
     </dl>
    </div>
    <div class="col cmid">
    	<dl>
		   <dt><strong>搜索引擎相关关键词查询</strong><p><a href="relatedKey.action" target="_blank"><img src="/images/right.gif" /></a></p></dt>
		      	<dd><form method="post" target="_blank" action="relatedKey.action"><input name="keyword" id="key" type="text" size="65" value="" class="inp">&nbsp;<input type="submit" value="开始查询"  class="sec"></form><br />
                </dd>
		</dl>
    </div>
    
     <div class="col crig">
    	<dl>
        <dt><strong>百度指数查询</strong><p><a href="bdIndex.action"><img src="/images/right.gif"/></a></p></dt>
        <dd><form action="bdIndex.action" method="get"  target="_blank">
        	<input name="searchWord" id="sword" type="text" size="65" value="" class="inp">&nbsp;<input type="submit" value="开始查询"  class="sec"><br />
        	</form>
        </dd>
        
      </dd>
     </dl>
    </div>
    
    <div class="col cmid">
    	<dl>
        <dt><strong>身份证查询工具</strong><p><a href="extractCard.action"><img src="/images/right.gif"/></a></p></dt>
        <dd><form action="extractCard.action" method="get"  target="_blank">
        	<input class="inp" type="text" size="65" name="idCodeStr">
        <input type="submit" value="查询" class="sec"></form>
      </dd>
     </dl>
    </div>
</div>
</body>
</html>