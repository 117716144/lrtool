<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><s:property value='selCode'/>身份证生成工具-懒人工具- 懒人网站助手</title>
<meta name="keywords" content="<s:property value='selCode'/>身份证生成工具">
<meta name="description" content="<s:property value='selCode'/>身份证生成工具。">
</head>
<body>
<div class="main">
	<div class="col">
		<dl class="clist">
			<dt><strong>欢迎您使用本站的身份证生成工具，如果您觉得本站对您有帮助，请收藏或者推荐给您的朋友。</strong></dt>
<dd><div id="tool_show_intro">
日期为<b><s:property value='birthDay'/></b>，地区为<b><s:property value='selCode'/></b>的身份证号码如下：<br/>
<s:property value="cardInfo" escape="false"/></dd>
		</dl>
	</div>
</div>
</body>
</html>
