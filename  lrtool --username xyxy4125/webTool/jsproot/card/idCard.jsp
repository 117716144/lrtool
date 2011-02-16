<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title> 身份证生成工具 - 站长工具 - 懒人工具 - lrtool.net - 实用的网站！</title>
</head>
<body>
<div class="w960 center clear">
<div class="conent">
<div class="totop">
     <dl class="tbox">
     <dt>欢迎您使用本站的身份证生成工具，如果您觉得本站对您有帮助，请收藏或者推荐给您的朋友。</dt>
<div id="tool_show_intro">
生成的身份证号码如下：<br/>
<s:property value="cardInfo" escape="false"/>
</div>
</div>
</div>
      </dd>
     </dl>
   </div>

</div>
</div>
</body>
</html>
