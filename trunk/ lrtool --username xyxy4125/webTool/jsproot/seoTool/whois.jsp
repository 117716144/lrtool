<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>IP类信息查询 - 站长工具 - 懒人工具 - lrtool.net - 致力SEO简单有效！</title>
</head>
<body>
<div class="main">
	<div class="col">
		<dl class="clist">
			<dt><strong>欢迎您使用本站的 域名 WHOIS 信息查询 工具，如果您觉得本站对您有帮助，请收藏或者推荐给您的朋友。</strong></dt>
		     <dd class="cline">
		     <s:component template="errorNoFieldKey"/>
		     <form method="post" target="_top" action="whois.html" name="ipform" onsubmit="return checkIP();">请输入要查询的域名 :  <input type="text" name="domain" size="60" value="<s:property value='domain'/>" class='inp'>&nbsp;<input type="submit" value="点击查询" class="sec"></form>
			<div class="ct">
			<s:property value="searchResult" escape="false"/>
			</div>
		</dd>
		</dl>
	</div>
</div>
</body>
</html>
