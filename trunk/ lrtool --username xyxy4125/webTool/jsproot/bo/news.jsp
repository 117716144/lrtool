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

KE.show({
	id : 'summary',
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
<s:if test="news.title!=''">
<input type="hidden" value="<s:property value='news.id'/>" name="nid"/>
</s:if>
标题：<input type="text" name="news.title" value="<s:property value='news.title'/>"/><br/><br/>
内容：
<textarea id="content1" name="news.content" style="width:700px;height:300px;visibility:hidden;">
<s:property value='news.content' escape="false"/>
</textarea><br/>
摘要：
<textarea id="summary" name="news.summary" style="width:580px;height:300px;visibility:hidden;">
<s:property value='news.summary' escape="false"/>
</textarea>
所属分类:<select name="itsCategory">
<s:iterator value="categorys" id="category">
<option value="<s:property value='#category.id'/>" <s:if test="#category.id == news.itsCategory.id">selected="selected" </s:if>><s:property value='#category.categoryName'/></option>
</s:iterator>
</select><br/><br/>
关键词：<input type="text" name="news.keyword" value="<s:property value='news.keyword'/>"/><br/><br/>
<button type="submit">确定</button>
</form>
	</div>
</div>
</body>
</html>
