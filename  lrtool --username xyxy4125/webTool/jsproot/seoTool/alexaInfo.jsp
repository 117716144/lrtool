<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Alexa排名查询- 站长工具 - 懒人工具 --Alexa网站排名,访问量,搜索引擎收录,alexa排名查询,中文ALEXA排名查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Keywords" content="Alexa排名查询,全球alexa排名查询,懒人工具查询网站的Alexa排名信息,访问量,搜索引擎收录,www.lrtool.net">
<meta name="description" content="懒人工具查询网站的Alexa排名信息,访问量,搜索引擎收录,专业提供中文ALEXA世界排名查询服务" />
<script language="javascript" type="text/javascript" src="/js/alexaInfo.js"></script>
</head>
<body>
<div class="main">
	<div class="col">
		<dl class="clist">
			<dt><strong>欢迎您使用本站的 全球alexa排名 查询工具，如果您觉得本站对您有帮助，请收藏或者推荐给您的朋友。</strong></dt>
			<dd>
				<form action="siteAlexa.action" method="post" style="padding:0;margin:0;">
    Alexa排名查询的网址：http://www.
    <input name="domain" type="text" class="inp" id="domain" value="<s:property value='domain'/>" size="55">
    <input type="submit" value="点击查询"  class="sec"> 
  </form>
			</dd>
		</dl>
		<p>友情提示：Alexa网站排名是根据对用户安装 Alexa工具条 嵌入到 IE 等浏览器，监控其访问的网站数据进行统计，因此排名并不具有绝对的可靠性。</p>
	</div>
	<div class="col">
		<dl claa="clist">
			<dt><strong>网站 <s:property value="domain"/>的Alexa排名综合信息</strong></dt>
			<dd class="clear">
			<div style="float:left;width:230;text-align:center;">
    <!--GOOGLE ADS--><br>
   <a href="http://www.<s:property value="domain"/>" target="_blank"><img src="/images/temp.jpg" border="0"/></a><br>
	<div style="margin-top:8px;">
    <a href="http://thumbnails.alexa.com/update_thumbnail?url=<s:property value='domain'/>" target="_blank">更新缩略图</a> | <a href="http://www.alexa.com/data/details/contact_info?url=<s:property value='domain'/>" target="_blank">修改信息</a> | <a href="http://www.alexa.com/data/details/editor?type=rl&url=<s:property value='domain'/>" target="_blank">提交链接</a></div>
    <!--GOOGLE ADS-->
  </div>
  <div style="float:right;width:500;text-align:left;">
  <table width="100%" cellpadding="1" cellspacing="1">
        <TR>
          <TD width="85" align="right" noWrap bgColor="#EAEAEA">站点名称:</TD>
          <TD width="178" title="<s:property value='alexaInfo.SiteTitle'/>"><a href="http://<s:property value='domain'/>" target=_blank><s:property value='alexaInfo.SiteTitle'/></a></TD>
          <TD width="79" align="right" nowrap bgColor="#EAEAEA">网站域名:</TD>
          <TD width="163" title="<s:property value='domain'/>"><strong><s:property value='domain'/></strong></TD>
        </TR>
        <TR>
          <TD align="right" nowrap bgColor="#EAEAEA" title="alexa综合排名">综合排名:</TD>
          <TD id="ranks"><A title="查看Alexa官方信息" href="http://www.alexa.com/data/details/traffic_details?q=&url=<s:property value='domain'/>" target="_blank"><img src="/images/loading.gif" width="16" height="16" border="0"></A></TD>
          <TD align="right" nowrap bgColor="#EAEAEA" title="网站在中国的排名">中国排名:</TD>
          <TD id="chinarank" title="网站在中国的排名"><img src="/images/loading.gif" width="16" height="16" border="0"></TD>
        </TR>
        <TR>
          <TD align="right" nowrap bgColor="#EAEAEA">所属国家:</TD>
          <TD title="<s:property value='alexaInfo.COUNTRY'/>"><s:property value='alexaInfo.COUNTRY'/></TD>
          <TD align="right" nowrap bgColor="#EAEAEA">编码方式:</TD>
          <TD title="<s:property value='alexaInfo.xCode'/>"><s:property value='alexaInfo.xCode'/></TD>
        </TR>
        <TR>
          <TD align="right" nowrap bgColor="#EAEAEA">网站站长:</TD>
          <TD title="<s:property value='alexaInfo.xOwner'/>"><s:property value='alexaInfo.xOwner'/></TD>
          <TD align="right" nowrap bgColor="#EAEAEA">电子信箱:</TD>
          <TD title="<s:property value='alexaInfo.xEmail'/>"><s:property value='alexaInfo.xEmail'/></TD>
        </TR>
        <TR>
          <TD align="right" nowrap bgColor="#EAEAEA">访问速度:</TD>
          <TD nowrap title="<s:property value='alexaInfo.xSpeed'/>Ms/<s:property value='alexaInfo.xPct'/>分"><s:property value='alexaInfo.xSpeed'/>Ms/<s:property value='alexaInfo.xPct'/>分</TD>
          <TD align="right" nowrap bgColor="#EAEAEA">反向链接:</TD>
          <TD nowrap title="<s:property value='alexaInfo.xLinksin'/>"><A href="http://www.alexa.com/data/ds/linksin?q=link:<s:property value='domain'/>/&url=<s:property value='domain'/>" target="_blank"><s:property value='alexaInfo.xLinksin'/></A> 个</TD>
        </TR>
        <TR>
          <TD align="right" nowrap bgColor="#EAEAEA">收录日期:</TD>
          <TD nowrap title="<s:property value='alexaInfo.xDate'/>"><s:if test="alexaInfo.xDate!=null && alexaInfo.xDate!=''"><s:property value='alexaInfo.xDate'/></s:if><s:else>不详</s:else></TD>
          <TD align="right" nowrap bgColor="#EAEAEA">联系电话:</TD>
          <TD title="<s:property value='alexaInfo.xPhone'/>" noWrap><s:if test="alexaInfo.xPhone!=null && alexaInfo.xPhone!=''"><s:property value='alexaInfo.xPhone'/></s:if><s:else>不详</s:else></TD>
        </TR>
        <TR>
          <TD align="right" nowrap bgColor="#EAEAEA">详细地址:</TD>
          <TD title="<s:property value='alexaInfo.STREET'/><s:property value='alexaInfo.CITY'/>" colSpan="3"><s:property value='alexaInfo.STREET'/><s:property value='alexaInfo.CITY'/></TD>
        </TR>
        <TR>
          <TD align="right" nowrap bgColor="#EAEAEA">网站简介:</TD>
          <TD title="<s:property value='alexaInfo.SiteDesc'/>" colSpan="3"><s:property value='alexaInfo.SiteDesc'/></TD>
        </TR>
        <TR>
          <TD align="right" nowrap bgColor="#EAEAEA">所属目录:</TD>
          <TD title="<s:property value='alexaInfo.Cat'/>" colSpan="3"><s:if test="alexaInfo.Cat!=null && alexaInfo.Cat!=''"><s:property value='alexaInfo.Cat'/></s:if><s:else>不详</s:else></TD>
        </TR>
      </table>
  </div>
			</dd>
		</dl>
	</div>
	

<div class="col">
     <dl class="clist">
     <dt><strong>站点 <s:property value='alexaInfo.SiteTitle'/> 的 Alexa 排名查询结果</strong></dt>
      <dd class="tc">
      <div class="body1">
  <div class="x bg2">&nbsp;&nbsp;流量排名数据信息：Traffic Rank for <s:property value='domain'/></div>
  <div class="mainbar">
    <div class="title" style="width:150px">昨日排名</div>
    <div class="title" style="width:152px">最近一周平均</div>
    <div class="title" style="width:152px">最近一月平均</div>
    <div class="title" style="width:152px">最近三月平均</div>
    <div class="title2" style="width:152px">最近三月改变量</div>
  </div>
  <div class="mainbar2">
    <div id="RankToday" class="title" style="width:150px"><img src="/images/loading.gif" width="16" height="16" border="0"></div>
    <div id="RankwkAvg" class="title" style="width:152px"><img src="/images/loading.gif" width="16" height="16" border="0"></div>
    <div id="RankmosAvg" class="title" style="width:152px"><img src="/images/loading.gif" width="16" height="16" border="0"></div>
    <div id="AllRank" class="title" style="width:152px"><img src="/images/loading.gif" width="16" height="16" border="0"></div>
    <div id="RankmosChange" class="title2" style="width:150px"><img src="/images/loading.gif" width="16" height="16" border="0"></div>
  </div>
      </dd>
     </dl>
   </div>
<div class="col">
     <dl class="clist">
     <dt><strong>站点 <s:property value='alexaInfo.SiteTitle'/>  的搜索引擎收录、反向链接情况</strong></dt>
      <dd>
      <div class="mainbar">
    <div class="title" style="width:130px">搜索引擎</div>
    <div class="title" style="width:120px">百度</div>
    <div class="title" style="width:120px">Google</div>
    <div class="title" style="width:120px">yahoo</div>
	 <div class="title" style="width:120px">sogou</div>
    <div class="title2" style="width:120px">soso</div>
  </div>
  <div class="mainbar2">
    <div class="title" style="width:130px">收录情况</div>
    <div id="baidu" class="title" style="width:120px"><img src="/images/loading.gif" width="16" height="16" border="0"></div>
    <div id="google" class="title" style="width:120px"><img src="/images/loading.gif" width="16" height="16" border="0"></div>
    <div id="yahoo" class="title" style="width:120px"><img src="/images/loading.gif" width="16" height="16" border="0"></div>
    <div id="sogou" class="title" style="width:120px"><img src="/images/loading.gif" width="16" height="16" border="0"></div>
    <div id="soso" class="title2" style="width:120px"><img src="/images/loading.gif" width="16" height="16" border="0"></div>
  </div>
    <div class="mainbar2">
    <div class="title" style="width:130px">反向链接</div>
    <div id="baiduf" class="title" style="width:120px"><img src="/images/loading.gif" width="16" height="16" border="0"></div>
    <div id="googlef" class="title" style="width:120px"><img src="/images/loading.gif" width="16" height="16" border="0"></div>
    <div id="yahoof" class="title" style="width:120px"><img src="/images/loading.gif" width="16" height="16" border="0"></div>
    <div id="sogouf" class="title" style="width:120px"><img src="/images/loading.gif" width="16" height="16" border="0"></div>
    <div id="sosof" class="title2" style="width:120px"><img src="/images/loading.gif" width="16" height="16" border="0"></div>
  </div>
      </dd>
     </dl>
   </div>

<div class="col">
     <dl class="clist">
     <dt><strong>网站日平均排名走势图 [点击时间段查看相应时段曲线]</strong></dt>
      <dd>
      <div class="mainbar">
  <div class="title" style="width:150px"><a style="CURSOR: hand" onClick="document.getElementById('rank1').style.display='';document.getElementById('rank2').style.display='none';document.getElementById('rank3').style.display='none';document.getElementById('rank4').style.display='none';document.getElementById('rank5').style.display='none';">六个月数据</a></div>
  <div class="title" style="width:152px"><a style="CURSOR: hand" onClick="document.getElementById('rank1').style.display='none';document.getElementById('rank2').style.display='';document.getElementById('rank3').style.display='none';document.getElementById('rank4').style.display='none';document.getElementById('rank5').style.display='none';">三个月数据</a></div>
  <div class="title" style="width:152px"><a style="CURSOR: hand" onClick="document.getElementById('rank1').style.display='none';document.getElementById('rank2').style.display='none';document.getElementById('rank3').style.display='';document.getElementById('rank4').style.display='none';document.getElementById('rank5').style.display='none';">一个月数据</a></div>
  <div class="title" style="width:152px"><a style="CURSOR: hand" onClick="document.getElementById('rank1').style.display='none';document.getElementById('rank2').style.display='none';document.getElementById('rank3').style.display='none';document.getElementById('rank4').style.display='';document.getElementById('rank5').style.display='none';">半个月数据</a></div>
  <div class="title2" style="width:150px"><a style="CURSOR: hand" onClick="document.getElementById('rank1').style.display='none';document.getElementById('rank2').style.display='none';document.getElementById('rank3').style.display='none';document.getElementById('rank4').style.display='none';document.getElementById('rank5').style.display='';">一星期数据</a></div>
</div>
<div class="mainbar2" style="padding:10 0 10 0;height:300px">
  <div id=rank1><img src="http://traffic.alexa.com/graph?w=750&h=280&r=6m&y=t&u=<s:property value='domain'/>"></div>
  <div id=rank2 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=3m&y=t&u=<s:property value='domain'/>"></div>
  <div id=rank3 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=1m&y=t&u=<s:property value='domain'/>"></div>
  <div id=rank4 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=15.0m&y=t&u=<s:property value='domain'/>"></div>
  <div id=rank5 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=7.0&y=t&u=<s:property value='domain'/>"></div>
</div>
      </dd>
     </dl>
   </div>


<div class="col">
     <dl class="clist">
     <dt><strong>日平均访问人数走势图 [点击时间段查看相应时段曲线]</strong></dt>
      <dd>
      <div class="mainbar">
  <div class="title" style="width:150px"><a style="cursor: hand" onClick="document.getElementById('reachs1').style.display='';document.getElementById('reachs2').style.display='none';document.getElementById('reachs3').style.display='none';document.getElementById('reachs4').style.display='none';document.getElementById('reachs5').style.display='none';">六个月数据</a></div>
  <div class="title" style="width:152px"><a style="cursor: hand" onClick="document.getElementById('reachs1').style.display='none';document.getElementById('reachs2').style.display='';document.getElementById('reachs3').style.display='none';document.getElementById('reachs4').style.display='none';document.getElementById('reachs5').style.display='none';">三个月数据</a></div>
  <div class="title" style="width:152px"><a style="cursor: hand" onClick="document.getElementById('reachs1').style.display='none';document.getElementById('reachs2').style.display='none';document.getElementById('reachs3').style.display='';document.getElementById('reachs4').style.display='none';document.getElementById('reachs5').style.display='none';">一个月数据</a></div>
  <div class="title" style="width:152px"><a style="cursor: hand" onClick="document.getElementById('reachs1').style.display='none';document.getElementById('reachs2').style.display='none';document.getElementById('reachs3').style.display='none';document.getElementById('reachs4').style.display='';document.getElementById('reachs5').style.display='none';">半个月数据</a></div>
  <div class="title2" style="width:150px"><a style="cursor: hand" onClick="document.getElementById('reachs1').style.display='none';document.getElementById('reachs2').style.display='none';document.getElementById('reachs3').style.display='none';document.getElementById('reachs4').style.display='none';document.getElementById('reachs5').style.display='';">一星期数据</a></div>
</div>
<div class="mainbar2" style="padding:10 0 10 0;height:300px">
  <div id=reachs1><img src="http://traffic.alexa.com/graph?w=750&h=280&r=6m&y=r&u=<s:property value='domain'/>"></div>
  <div id=reachs2 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=3m&y=r&u=<s:property value='domain'/>"></div>
  <div id=reachs3 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=1m&y=r&u=<s:property value='domain'/>"></div>
  <div id=reachs4 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=15.0m&y=r&u=<s:property value='domain'/>"></div>
  <div id=reachs5 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=7.0m&y=r&u=<s:property value='domain'/>"></div>
</div>
      </dd>
     </dl>
   </div>
   
<br />

<div class="col">
     <dl class="clist">
     <dt><strong>日页面浏览量走势图 [点击时间段查看相应时段曲线]</strong></dt>
      <dd>
      <div class="mainbar">
  <div class="title" style="width:150px"><a style="cursor: hand" onClick="document.getElementById('pageviews1').style.display='';document.getElementById('pageviews2').style.display='none';document.getElementById('pageviews3').style.display='none';document.getElementById('pageviews4').style.display='none';document.getElementById('pageviews5').style.display='none';">六个月数据</a></div>
  <div class="title" style="width:152px"><a style="cursor: hand" onClick="document.getElementById('pageviews1').style.display='none';document.getElementById('pageviews2').style.display='';document.getElementById('pageviews3').style.display='none';document.getElementById('pageviews4').style.display='none';document.getElementById('pageviews5').style.display='none';">三个月数据</a></div>
  <div class="title" style="width:152px"><a style="cursor: hand" onClick="document.getElementById('pageviews1').style.display='none';document.getElementById('pageviews2').style.display='none';document.getElementById('pageviews3').style.display='';document.getElementById('pageviews4').style.display='none';document.getElementById('pageviews5').style.display='none';">一个月数据</a></div>
  <div class="title" style="width:152px"><a style="cursor: hand" onClick="document.getElementById('pageviews1').style.display='none';document.getElementById('pageviews2').style.display='none';document.getElementById('pageviews3').style.display='none';document.getElementById('pageviews4').style.display='';document.getElementById('pageviews5').style.display='none';">半个月数据</a></div>
  <div class="title2" style="width:150px"><a style="cursor: hand" onClick="document.getElementById('pageviews1').style.display='none';document.getElementById('pageviews2').style.display='none';document.getElementById('pageviews3').style.display='none';document.getElementById('pageviews4').style.display='none';document.getElementById('pageviews5').style.display='';">一星期数据</a></div>
</div>
<div class="mainbar2" style="padding:10 0 10 0;height:300px">
  <div id=pageviews1><img src="http://traffic.alexa.com/graph?w=750&h=280&r=6m&y=p&u=<s:property value='domain'/>"></div>
  <div id=pageviews2 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=3m&y=p&u=<s:property value='domain'/>"></div>
  <div id=pageviews3 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=1m&y=p&u=<s:property value='domain'/>"></div>
  <div id=pageviews4 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=15.0m&y=p&u=<s:property value='domain'/>"></div>
  <div id=pageviews5 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=7.0m&y=p&u=<s:property value='domain'/>"></div>
</div>
      </dd>
     </dl>
   </div>   
   
</div>

<script>getOtherInfo();getGoogle();getBaidu();getYahoo();getSoso();getSogou();
getGoogleL();getBaiduL();getYahooL();getSosoL();getSogouL();</script>
</body>
</html>