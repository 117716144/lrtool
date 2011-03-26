<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title> 新闻管理- 站长工具 - 懒人工具 - lrtool.net - 实用的网站！</title>
<script language="javascript" type="text/javascript" src="/editor/kindeditor.js"></script>
<script><%--
KE.show({
	id : 'content1',
	newlineTag : 'br',
	//newlineTag : 'p'
	shadowMode : false,
	autoSetDataMode: false,
	allowPreviewEmoticons : false,
	afterCreate : function(id) {
		KE.event.add(KE.$('example'), 'submit', function() {
			KE.util.setData(id);
		});
	}
});

--%>

KE.show({
	id : 'content1',
	cssPath : '/editor/index.css',
	newlineTag : 'br',
	afterCreate : function(id) {
		KE.event.ctrl(document, 13, function() {
			KE.util.setData(id);
			document.forms['news'].submit();
		});
		KE.event.ctrl(KE.g[id].iframeDoc, 13, function() {
			KE.util.setData(id);
			document.forms['news'].submit();
		});
	}
});

</script>
<style>
			form {
				margin: 0;
			}
			textarea {
				display: block;
			}
		</style>

</head>
<body>
<div class="main">
	<div class="col">
<form name="news" action ="addNews.action" method="post">
标题：<input type="text" name="news.title"/><br/><br/>
内容：
<textarea id="content1" name="news.content" style="width:700px;height:300px;visibility:hidden;">
</textarea>
关键词：<input type="text" name="news.keyword"/><br/><br/>
<button type="submit">确定</button>
</form>
	</div>
</div>
</body>
</html>
