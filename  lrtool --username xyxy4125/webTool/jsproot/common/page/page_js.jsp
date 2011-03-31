<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h1 id="result">Click the pager below.</h1>
<div id="pager" ></div>
<script>
jQuery(document).ready(function() {
    jQuery("#pager").pager({ pagenumber: <s:property value='curpage'/>, pagecount: <s:property value='pageCount'/>, buttonClickCallback: PageClick });
});

</script>
<s:if test="totalCount>pagesize"><script>jQuery("#pager").show();</script></s:if>
<s:else><script>jQuery("#pager").hide();</script></s:else>