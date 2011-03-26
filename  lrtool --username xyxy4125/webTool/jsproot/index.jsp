<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head> 
<title>网站工具 –懒人工具</title>
<meta name ="keywords" content="网站工具，站长工具,站长查询工具,懒人工具，alexa,seo,关键词" />
<meta name="description" content="提供记录各大搜索引擎每天的收录和反向链接，记录google pagerank 和 alexa 排名，记录每天关键字排位，关键词的深度分析和挖掘数据服务。" />
<script language="javascript" type="text/javascript" src="/datepicker/WdatePicker.js"></script>
</head>

<body>
<div class="main">
	<div class="col">
		<dl>
		   <dt><strong>搜索引擎收录情况查询</strong><p><a href="collect.html" target="_blank"><img src="/images/right.gif" /></a></p></dt>
		      	<dd><form method="post" target="_blank" onsubmit="return checkUrl(document.getElementById('sholuinpt').value);" action="collect.html"><font class="htp">HTTP://</font> <input name="shoulu_domain" id="sholuinpt" type="text" size="35" value="" class="inp">&nbsp;<input type="submit" value="开始查询"  class="sec"><br />
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
    <div class="col">
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
		   <dt><strong>搜索引擎相关关键词查询</strong><p><a href="relatedKey.html" target="_blank"><img src="/images/right.gif" /></a></p></dt>
		      	<dd><form method="post" target="_blank" action="relatedKey.html"><input name="keyword" id="key" type="text" size="45" value="" class="inp">&nbsp;<input type="submit" value="开始查询"  class="sec"></form><br />
                </dd>
		</dl>
    </div>
    
     <div class="col crig">
    	<dl>
        <dt><strong>百度指数查询</strong><p><a href="bdIndex.html"><img src="/images/right.gif"/></a></p></dt>
        <dd><form action="bdIndex.html" method="get"  target="_blank">
        	<input name="searchWord" id="sword" type="text" size="45" value="" class="inp">&nbsp;<input type="submit" value="开始查询"  class="sec"><br />
        	</form>
        </dd>
        
      </dd>
     </dl>
    </div>
    
    <div class="col cmid">
    	<dl>
        <dt><strong>身份证查询工具</strong><p><a href="extractCard.html"><img src="/images/right.gif"/></a></p></dt>
        <dd><form action="extractCard.html" method="get"  target="_blank">
        	<input class="inp" type="text" size="45" name="idCodeStr">
        <input type="submit" value="查询" class="sec"></form>
      </dd>
     </dl>
    </div>
</div>
</body>
</html>