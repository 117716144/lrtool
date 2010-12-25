<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>搜索引擎收录查询-站长工具</title>
<script language="javascript" type="text/javascript" src="/js/shoulu.js"></script>
</head>
<body>
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
</body>
</html>
