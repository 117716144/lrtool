<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>搜索引擎收录查询 - 站长工具 - 懒人工具 - lrtool.net - 致力SEO简单流程化！</title>
<meta name ="keywords" content="便民工具,网站搜索,网址导航，搜一搜,个性化导航,全民搜索,起始页,上网主页,上网首页,收藏夹,网络收藏夹,网址收藏夹,书签,QQ书签,网络书签,上网导航,网址,网址导航,导航,快捷上网,网址之家,实用工具,搜索,社区" />
<meta name="description" content="网站搜一搜，让全民上网更加方便更加快捷，最具个性化的导航搜索平台，让你工作生活无忧!" />
</head>

<body>
<div class="w960 center clear">
<div class="conent">
   <div class="totop">
     <dl class="tbox">
     <dt><strong>搜索引擎收录情况查询</strong><p><a href="Shoulu/" target="_blank"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
      <dd class="tc"><form method="post" target="_blank" action="shouLuAction.action">请输入要查询的网址: <font face="Arial">http://</font> <input name="shoulu_domain" type="text" size="65" value="" class="inp_t">&nbsp;<input type="submit" value="开始查询"  class="sb_c"><br />
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
   
   
    <div class="totop w50 left">
     <dl class="tbox">
        <dt><strong>IP/服务器物理定位查询</strong><p><a href="showIpTool.action" target="_blank"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd><form method="post" target="_blank" action="showIpTool.action">IP / 域名：<input name="Ip" type="text" size="30" value="<%=request.getRemoteAddr()%>" class="inp_t">&nbsp;<input type="submit" value="开始查询" class="sb_c"></form>直接输入IP则可查询该IP的物理位置；
      </dd>
     </dl>
    </div>
    
    
     <div class="totop w50 right">
     <dl class="tbox">
        <dt><strong>域名 WHOIS 信息查询</strong><p><a href="showWhoisInfo.action" target="_blank"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd><form method="post" target="_blank" name="ipform" action="showWhoisInfo.action" onsubmit="return checkIP();">网站域名：www.<input name="domain" type="text" size="30" value="" class="inp_t">&nbsp;<input type="submit"value="开始查询" class="sb_c"></form>输入域名则可检测服务器的IP及其 WHOIS 信息。
      </dd>
     </dl>
    </div>
    
    <div class="clear"></div><br />
    <div class="totop">
     <dl class="tbox">
     <dt><strong>搜索引擎反向链接情况查询</strong><p><a href="siteLinkAction.action" target="_blank"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
      <dd class="tc"><form method="post" target="_blank" action="siteLinkAction.action">网站地址：http://<input name="shoulu_domain" type="text" size="65" value="" class="inp_t">&nbsp;<input type="submit" value="开始查询" class="sb_c" /><br />
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
     <div class="clear"></div>
    <div class="totop w50 left">
     <dl class="tbox">
        <dt><strong>ALEXA 详细排名查询</strong><p><a href="siteAlexa.action"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd><form action="siteAlexa.action" method="get" target="_blank">
网站地址：<input name="domain"  type="text" size="30" value="http://www." class="inp_t">&nbsp;<input type="submit" value="开始查询" class="sb_c"></form>可查询网站的世界排名、流量、访问量、联系方式等综合信息。
      </dd>
     </dl>
    </div>
    
    
     <div class="totop w50 right">
     <dl class="tbox">
        <dt><strong>GG PR & SOGOU RANK 查询</strong><p><a href="pageRank.action" target="_blank"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd><form method="post" target="_blank" name="get_rank" action="pageRank.action">网站地址：<input name="prdomain" type="text" size="20" value="http://www." class="inp_t">&nbsp;<input type="submit" value="开始查询" class="sb_c"></form>可查询网页在GG和搜狗上的页面等级（影响搜索引擎排名）信息。</dd>
     </dl>
    </div>
    
    <div class="clear"></div>
    
    <div class="totop w50 left">
     <dl class="tbox">
        <dt><strong>关键词排名查询</strong><p><a href="keywordPosition.action"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd><form action="keywordPosition.action" method="post" target="_blank">网站域名：<input name="siteurl" type="text" size="12"  class="inp_t">&nbsp;关键词：<input name="keyword" type="text" value="" size="6"  class="inp_t">&nbsp;<input type="submit" value="开始查询" class="sb_c"></form>可查询指定站点在baidu中搜索指定关键词时的排名位置。
      </dd>
     </dl>
    </div>
    
    
     <div class="totop w50 right">
     <dl class="tbox">
        <dt><strong>页面关键词密度查询</strong><p><a href="wordFrequency.action"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd><form method="post" target="_blank" action="wordFrequency.action">网站页面：<input name="surl" type="text" size="14" value="http://www." class="inp_t">&nbsp;关键词：<input name="skey" type="text" size="7" value="" class="inp_t">&nbsp;<input type="submit" value="开始查询" class="sb_c"></form>可查询指定页面中某一关键词的出现频率和密度。
      </dd>
     </dl>
    </div>
    <div class="clear"></div>
    
    <div class="totop w50 left">
     <dl class="tbox">
        <dt><strong>身份证生成工具</strong><p><a href="generateIdCard.action"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd><form action="generateIdCard.action" method="get"  target="_blank">
        <input type="submit" value="生成" class="sb_c"></form>
      </dd>
     </dl>
    </div>
    
    <div class="clear"></div>
</div>
</div>

</body>
</html>