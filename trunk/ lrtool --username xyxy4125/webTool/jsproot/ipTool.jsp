<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>搜索引擎收录查询 - 站长工具 - 网站搜一搜 - 个性化导航WZS1S.com - 致力全民个性化快捷的上网方式！</title>
<meta name ="keywords" content="便民工具,网站搜索,网址导航，搜一搜,个性化导航,全民搜索,起始页,上网主页,上网首页,收藏夹,网络收藏夹,网址收藏夹,书签,QQ书签,网络书签,上网导航,网址,网址导航,导航,快捷上网,网址之家,实用工具,搜索,社区" />
<meta name="description" content="网站搜一搜，让全民上网更加方便更加快捷，最具个性化的导航搜索平台，让你工作生活无忧!" />
<link href="/style/css.css" rel="stylesheet" type="text/css" />
<title>搜索引擎收录查询-站长工具</title>
<Script Language="JavaScript">if(self!=top){top.location=self.location;}</script>
<script language="JavaScript">var Sys_LoadStart=new Date(); </script>
<script language="javascript" type="text/javascript" src="/js/Blank_link.js"></script>
<script language="javascript" type="text/javascript" src="/js/Main.js"></script>
<script language="javascript" type="text/javascript" src="/js/jquery.js"></script>
<script language="javascript" type="text/javascript" src="/js/shoulu.js"></script>
</head>
<body>
<div class="w960 center clear">
  <div class="header">
<h1><a class="logo" title="网站搜一搜 - 个性化导航WZS1S.com" href="javascript:void(0)" onClick="this.style.behavior='url(#default#homepage)';this.setHomePage(location.href);return(false);">网站搜一搜 - 个性化导航WZS1S.com</a></h1>
<p class="nav"> <a  title="网站搜一搜 - 设为首页" href="javascript:void(0)" onClick="this.style.behavior='url(#default#homepage)';this.setHomePage(location.href);return(false);">设为首页</a>  
<a  title="网站搜一搜 - 加入收藏" href="javascript:window.external.AddFavorite('http://www.wzs1s.com','网站搜一搜')">加入收藏</a>  
<a  title="帮助中心" href="/about/help.html">使用帮助</a>  
</p>
<div class="menu">
			<ul>
				<li><a href="http://www.wzs1s.com/">网站首页</a></li>
				<li><a href="http://www.wzs1s.com//bianmin">便民查询</a></li>
				<li class="active"><a href="http://www.wzs1s.com//tool">站长工具

</a></li>
				<li><a href="http://www.wzs1s.com//link">名站导航</a></li>
				<li><a href="http://www.wzs1s.com//web2.0">好站推荐</a></li>
				
			</ul>		
		</div>
        <div class="clear"></div>  
    </div>
    <!--  header -->
</div> 

<div class="w960 center clear">
<div class="conent">
<!--第一栏开始-->
 <div class="totop">
     <dl class="tbox">
     <dt>欢迎您使用本站的 IP类的信息查询 工具，如果您觉得本站对您有帮助，请收藏或者推荐给您的朋友。</dt>
     <dd class="tc">
     + + 您 的 IP : [ <s:property value="myIp"/> ]  来 自 : <s:property value="myPosition"/> + + <br />
<s:property value="getOsInfo(request)"/><br /><br />
<%--
<form method="post" target="_top" action="Index.asp" name="ipform" onsubmit="return checkIP();">请输入要查询的IP或域名:  
<input type="text" name="ip" size="36" value="<s:property value='myIp'>" class='inp_t'>
&nbsp;<input type="submit" value="点击查询" class="sb_c"></form><br />

if request.getMethod().equalsIgnoreCase(post)%>
<font color="#ff0000"><strong>查询结果 : <%=ip%> ==>> <%=ip%> ==>> <%=address(ip)%></strong></font><br /><br />上面四项依次显示的是 : 原始输入内容 <strong>==>></strong> 获取的IP地址 <strong>==>></strong> IP的物理位置<br /><%end if%><br />使用帮助 : 查询框输入IP则显示指定IP的物理位置，输入网站域名则显示网站服务器的IP和服务器所在地。<br /><br /><a>查询代码调用</a> | <a>IpWhois查询</a> | <a>同Ip站点查询</a> | <a>代理Ip公布</a><br />
--%>    
     </dd>
     </dl>
   </div>

</div>
</div>

<div class="close clear center"><a href="/" target="_self" onClick="clickCount(this.href);"><img src="/images/fh.gif" border=0 alt=返回首页></a>　　<a href="javascript:window.opener =null;window.close()" target="_self" onClick="clickCount(this.href);"><img src="/images/close.gif"  border=0 alt=关闭本页></a></div>
 
 <div  class="footer clear">
    <div class="group">
 <a href="http://www.wzs1s.com/about/" target="_blank">关于本站</a> | <a href="http://www.wzs1s.com/about/help.html" target="_blank">帮助中心</a> | <a href="http://www.wzs1s.com/about/ad.html" target="_blank">广告服务</a> | <a href="http://www.wzs1s.com/about/contact.html" target="_blank">在线客服</a> | <a href="http://www.coooltong.com" target="_blank">酷通设计</a> | <script src="http://s73.cnzz.com/stat.php?id=1083816&web_id=1083816" language="JavaScript" charset="gb2312"></script>

    </div>
    <div class="copyright">
 Copyright &copy; 2009 Wzs1s.com.com All Rights Reserved. 网站搜一搜 版权所有<br />
 建议使用1024*768以上的屏幕分辨率和6.0以上版本的IE来访问本站
    </div>
    <div class="miibeian"><a href="http://www.miibeian.gov.cn/">网络警察</a><noscript><a href="http://www.linezing.com"><img src="http://img.tongji.linezing.com/1078870/tongji.gif"/></a></noscript></div>
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
