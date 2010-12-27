<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>IP类信息查询 - 站长工具 - 傻人工具 - lrtool.net - 致力SEO简单流程化！</title>
<script language="javascript" type="text/javascript" src="/js/shoulu.js"></script>
</head>
<body>
<div class="w960 center clear">
<div class="conent">

<div class="totop">
     <dl class="tbox">
     <dt>欢迎您使用本站的 域名 WHOIS 信息查询 工具，如果您觉得本站对您有帮助，请收藏或者推荐给您的朋友。</dt>
     <dd class="tc">
     <form method="post" target="_top" action="showWhoisInfo.action" name="ipform" onsubmit="return checkIP();">请输入要查询的域名 :  <input type="text" name="domain" size="60" value="<s:property value='domain'/>" class='inp_t'>&nbsp;<input type="submit" value="点击查询" class="sb_c"></form> <br />
<s:property value="searchResult" escape="false"/>
</dd>
</dl>
</div>

</div>
</div>
</body>
</html>
