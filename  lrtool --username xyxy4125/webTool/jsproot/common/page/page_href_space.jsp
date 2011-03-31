<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<div id="pager"></div>
<s:if test="totalCount>pagesize">
<div style="display:none"><ul>
<s:if test="pageCount<=9"><s:bean name="org.apache.struts2.util.Counter" id="counter">  
<s:param name="first"><s:property value="1"/></s:param><s:param name="last"><s:property value="pageCount"/></s:param>
<s:iterator><li><a href="/lrspace/<s:property/>.html"><s:property/></a></li></s:iterator>
</s:bean></s:if><s:elseif test="curpage<=5"><s:bean name="org.apache.struts2.util.Counter" id="counter">  
<s:param name="first"><s:property value="1"/></s:param><s:param name="last"><s:property value="9"/></s:param>
<s:iterator><li><a href="/lrspace/<s:property/>.html"><s:property/></a></li></s:iterator>
</s:bean></s:elseif><s:else><s:bean name="org.apache.struts2.util.Counter" id="counter"><s:param name="first"><s:property value="curpage-4"/></s:param>  
<s:param name="last"><s:property value="curpage-4+8"/></s:param><s:iterator><li><li><a href="/lrspace/<s:property/>.html"><s:property/></a></li></li></s:iterator>
</s:bean>
</s:else>
</ul>   
</div>
</s:if>
<script>
jQuery(document).ready(function() {
    jQuery("#pager").pager({ pagenumber: <s:property value='curpage'/>, pagecount: <s:property value='pageCount'/>, buttonClickCallback: PageClick });
});
var PageClick = function(cnum) {
    location.href ="/lrspace/"+cnum+".html";
}
</script>
<s:if test="totalCount>pagesize"><script>jQuery("#pager").show();</script></s:if>
<s:else><script>jQuery("#pager").hide();</script></s:else>

