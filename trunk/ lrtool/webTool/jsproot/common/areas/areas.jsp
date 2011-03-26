<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<script language="javascript" type="text/javascript" src="/js/area.js"></script>
地区：<select name="province" id="province" onchange="resetArea();"></select>--
<select name="area" id="area" onchange="resetCity();"><option value="-1">--请选择--</option></select>--
<select name="city" id="city"><option value="-1">--请选择--</option></select>
