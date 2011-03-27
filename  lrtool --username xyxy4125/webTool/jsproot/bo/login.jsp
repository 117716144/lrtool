<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title> 后台登陆- 懒人工具 - lrtool.net - 实用的网站！</title>
</head>

<body>
<s:component template="errorNoFieldKey"/>
<div style="padding:10px 0px;margin:0 auto;background-color:pink;text-align:center;">
<form name="loginForm" action="login.action" method="post">
帐号：<input name="userName" type="text"/><br/><br/>
密码：<input name="userPwd" type="password"/><br/><br/>
<button type="sumit" name="smit">确定</button>
</form>

</div>
</body>
</html>
