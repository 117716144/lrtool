<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<div id="pager"></div>
<div style="display:none">
<ul class="pages">
<s:bean name="org.apache.struts2.util.Counter" id="counter">
<s:param name="first"><s:property value="curpage" /></s:param>
<s:param name="last"><s:property value="curpage+pagesize-1" /></s:param>
<s:iterator>
<li class="page-number"><s:property/></li>
</s:iterator>
</s:bean>
</ul>
</div>
<script>
jQuery(document).ready(function() {
    jQuery("#pager").pager({ pagenumber: <s:property value='curpage'/>, pagecount: <s:property value='pageCount'/>, buttonClickCallback: PageClick });
});

var PageClick = function(pageclickednumber) {
    $("#pager").pager({ pagenumber: pageclickednumber, pagecount: <s:property value='pageCount'/>, buttonClickCallback: PageClick });
    $("#result").html("Clicked Page " + pageclickednumber);
}
</script>
