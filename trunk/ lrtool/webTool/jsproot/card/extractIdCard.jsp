<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title> 身份证查询工具 - 站长工具 - 懒人工具 - lrtool.net - 实用的网站！</title>
</head>
<body>
<div class="main">
	<div class="col">
		<dl class="clist">
			<dt><strong>欢迎您使用本站的身份证查询工具，如果您觉得本站对您有帮助，请收藏或者推荐给您的朋友。</strong></dt>
<dd><div id="tool_show_intro">
<s:if test="hasErrors()"><font color=red></font><s:component template="errorNoFieldKey"/></font></s:if><s:else>
<s:if test="idCodeStr!=''">
你输入的身份证号：<s:property value='idCodeStr'/></b>的信息如下：<br/>
地区：<b><s:property value="city"/></b>--性别：<b><s:property value="gender"/></b>--出生日期：<b><s:date format="yyyy年MM月dd日" name="birthday"/></b>
</s:if><s:else>请先输入正确的身份证号码！</s:else></s:else>
</dd></dl>
	</div>
</div>
</body>
</html>
