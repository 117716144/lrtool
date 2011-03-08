<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<s:iterator value="areas" id="area">
   <option value="<s:property value='#area.id'/>"><s:property value='#area.areaName'/></option>
</s:iterator>
