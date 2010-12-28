<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Alexa排名查询- 站长工具 - 懒人工具 --Alexa网站排名,访问量,搜索引擎收录,alexa排名查询,中文ALEXA排名查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Keywords" content="Alexa排名查询,全球alexa排名查询,懒人工具查询网站的Alexa排名信息,访问量,搜索引擎收录,www.lrtool.net">
<meta name="description" content="懒人工具查询网站的Alexa排名信息,访问量,搜索引擎收录,专业提供中文ALEXA世界排名查询服务" />
</head>
<body>
<DIV id=lovexin1 class="totop" style='Z-INDEX: 10; LEFT: 6px; POSITION: absolute; TOP: 117px; width: 108px;'><div style="background:#ccc;height:18px;width: 108px;font-size:12px;font-weight:bold; color:#FFF;" onClick='javascript:window.hide()'>最近查询记录</div>
<div style="WORD-BREAK: break-all; text-align:center; line-height:25px;"><ul>	<%
		Set fso = CreateObject("Scripting.FileSystemObject")
	  Set f = fso.OpenTextFile( server.MapPath("cache.asp"), 1, True)
	  if f.AtEndOfStream=false then
	  	content = f.readline()
	  end if
	  f.close
	  if fso.fileexists(server.MapPath("cache.asp"))=true then
	  	fso.deletefile(server.MapPath("cache.asp"))
	  end if
	  Set f = fso.OpenTextFile( server.MapPath("cache.asp"), 8, True)
	  if isnull(content) or len(trim(content))=0 then
	  	content = domain&"|"
	  else
	  	if instr(content,domain)>0 then
	  		set content = replace(content,domain&"|","")
	  	else
	  		content = domain&"|"&content
	  	end if
	  end if
	  names = split(content,"|")
	  tmpcontent = ""
	  for tt=0 to ubound(names)-1
	  if tt<15 then
	  	tmpcontent = tmpcontent&names(tt)&"|"
	  end if
	  %>
	  <li><a href="Index.asp?url=<%=names(tt)%>" title="www.<%=names(tt)%>"><%=names(tt)%></a></li>
	  <%
		next
		f.write(trim(tmpcontent))
		f.close
		set f = nothing
	%>	
</ul></DIV>
</DIV>
<DIV id=lovexin2 class="totop" style='Z-INDEX: 10; LEFT: 93%; POSITION: absolute; TOP: 117px; width: 108; '><div style="background:#ccc;height:18px;font-size:12px;font-weight:bold; color:#FFF;" onClick='javascript:window.hide()'>您关注的站点</div>
<div  style="WORD-BREAK: break-all; text-align:center; line-height:25px;">
<ul>
<%
		for ttt=0 to ubound(ttnames)-1
		%>
		<li><a href="index.asp?url=<%=ttnames(ttt)%>" title="www.<%=ttnames(ttt)%>"><%=ttnames(ttt)%></a></li>
		<%
		next
%>

</ul>
</div>
</DIV>
<div class="w960 center clear">
<div class="conent">
<div class="totop">
     <dl class="tbox">
     <dt>欢迎您使用本站的 全球alexa排名 查询工具，如果您觉得本站对您有帮助，请收藏或者推荐给您的朋友。</dt>
      <dd class="tc">
      <form action="" method="get" style="padding:0;margin:0;">
    Alexa排名查询的网址：http://www.
    <input name="url" type="text" class="inp_t" value="<%=domain%>" size="55">
    <input type="submit" value="点击查询"  class="sb_c"> 
    &nbsp;
  </form><br />
  友情提示：Alexa网站排名是根据对用户安装 Alexa工具条 嵌入到 IE 等浏览器，监控其访问的网站数据进行统计，因此排名并不具有绝对的可靠性。
      </dd>
     </dl>
   </div>

<br />

<div class="totop">
     <dl class="tbox">
     <dt>网站 <%=domain%> 的Alexa排名综合信息</dt>
      <dd class="tc">
      <div style="float:left;width:230;text-align:center;">
    <!--GOOGLE ADS--><br>
   <a href="http://www.<%=domain%>" target="_blank"><img src="/skin/temp.jpg" border="0"/></a><br>
	<div style="margin-top:8px;">
    <a href="http://thumbnails.alexa.com/update_thumbnail?url=<%=domain%>" target="_blank">更新缩略图</a> | <a href="http://www.alexa.com/data/details/contact_info?url=<%=domain%>" target="_blank">修改信息</a> | <a href="http://www.alexa.com/data/details/editor?type=rl&url=<%=domain%>" target="_blank">提交链接</a></div>
    <!--GOOGLE ADS-->
  </div>
  <div style="float:right;width:500;text-align:left;">
  <table width="100%" cellpadding="1" cellspacing="1">
        <TR>
          <TD width="85" align="right" noWrap bgColor="#EAEAEA">站点名称:</TD>
          <TD width="178" title="<%=SiteTitle%>"><a href="http://<%=domain%>" target=_blank><%=SiteTitle%></a></TD>
          <TD width="79" align="right" nowrap bgColor="#EAEAEA">网站域名:</TD>
          <TD width="163" title="<%=domain%>"><strong><%=domain%></strong></TD>
        </TR>
        <TR>
          <TD align="right" nowrap bgColor="#EAEAEA" title="alexa综合排名">综合排名:</TD>
          <TD id="ranks"><A title="查看Alexa官方信息" href="http://www.alexa.com/data/details/traffic_details?q=&url=<%=domain%>" target="_blank"><img src="skin/loading.gif" width="16" height="16" border="0"></A></TD>
          <TD align="right" nowrap bgColor="#EAEAEA" title="网站在中国的排名">中国排名:</TD>
          <TD id="chinarank" title="网站在中国的排名"><img src="skin/loading.gif" width="16" height="16" border="0"></TD>
        </TR>
        <TR>
          <TD align="right" nowrap bgColor="#EAEAEA">所属国家:</TD>
          <TD title="<%=COUNTRY%>"><%=fget(COUNTRY)%></TD>
          <TD align="right" nowrap bgColor="#EAEAEA">编码方式:</TD>
          <TD title="<%=xCode%>"><%=fget(xCode)%></TD>
        </TR>
        <TR>
          <TD align="right" nowrap bgColor="#EAEAEA">网站站长:</TD>
          <TD title="<%=xOwner%>"><%=fget(xOwner)%></TD>
          <TD align="right" nowrap bgColor="#EAEAEA">电子信箱:</TD>
          <TD title="<%=xEmail%>"><%=fget(xEmail)%></TD>
        </TR>
        <TR>
          <TD align="right" nowrap bgColor="#EAEAEA">访问速度:</TD>
          <TD nowrap title="<%=xSpeed%>Ms/<%=xPct%>分"><%=fget(xSpeed)%>Ms/<%=fget(xPct)%>分</TD>
          <TD align="right" nowrap bgColor="#EAEAEA">反向链接:</TD>
          <TD nowrap title="<%=xLinksin%>"><A href="http://www.alexa.com/data/ds/linksin?q=link:<%=domain%>/&url=<%=domain%>" target="_blank"><%=fget(xLinksin)%></A> 个</TD>
        </TR>
        <TR>
          <TD align="right" nowrap bgColor="#EAEAEA">收录日期:</TD>
          <TD nowrap title="<%=xDate%>"><%=fget(xDate)%></TD>
          <TD align="right" nowrap bgColor="#EAEAEA">联系电话:</TD>
          <TD title="<%=xPhone%>" noWrap><%=fget(xPhone)%></TD>
        </TR>
        <TR>
          <TD align="right" nowrap bgColor="#EAEAEA">详细地址:</TD>
          <TD title="<%=STREET%> <%=CITY%>" colSpan="3"><%=fget(lens(STREET&CITY,65))%></TD>
        </TR>
        <TR>
          <TD align="right" nowrap bgColor="#EAEAEA">网站简介:</TD>
          <TD title="<%=SiteDesc%>" colSpan="3"><%=fget(lens(SiteDesc,69))%></TD>
        </TR>
        <TR>
          <TD align="right" nowrap bgColor="#EAEAEA">所属目录:</TD>
          <TD title="<%=Cat%>" colSpan="3"><%=fget(Cat)%></TD>
        </TR>
      </table>
  </div>
  
  <div class="clear"></div>
      </dd>
     </dl>
   </div>

<br />
<div class="totop">
     <dl class="tbox">
     <dt>站点 <%=SiteTitle%> 的 Alexa 排名查询结果</dt>
      <dd class="tc">
      <div class="body1">
  <div class="x bg2">&nbsp;&nbsp;流量排名数据信息：Traffic Rank for <%=domain%></div>
  <div class="mainbar">
    <div class="title" style="width:150px">昨日排名</div>
    <div class="title" style="width:152px">一周平均</div>
    <div class="title" style="width:152px">一月平均</div>
    <div class="title" style="width:152px">三月平均</div>
    <div class="title2" style="width:152px">综合排名变化</div>
  </div>
  <div class="mainbar2">
    <div id="RankToday" class="title" style="width:150px"><img src="skin/loading.gif" width="16" height="16" border="0"></div>
    <div id="RankwkAvg" class="title" style="width:152px"><img src="skin/loading.gif" width="16" height="16" border="0"></div>
    <div id="RankmosAvg" class="title" style="width:152px"><img src="skin/loading.gif" width="16" height="16" border="0"></div>
    <div id="AllRank" class="title" style="width:152px"><img src="skin/loading.gif" width="16" height="16" border="0"></div>
    <div id="RankmosChange" class="title2" style="width:150px"><img src="skin/loading.gif" width="16" height="16" border="0"></div>
  </div>
      </dd>
     </dl>
   </div>

<br />

<div class="totop">
     <dl class="tbox">
     <dt>站点 <%=SiteTitle%>  的搜索引擎收录、反向链接情况</dt>
      <dd class="tc">
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
    <div id="baidu" class="title" style="width:120px"><img src="skin/loading.gif" width="16" height="16" border="0"></div>
    <div id="google" class="title" style="width:120px"><img src="skin/loading.gif" width="16" height="16" border="0"></div>
    <div id="yahoo" class="title" style="width:120px"><img src="skin/loading.gif" width="16" height="16" border="0"></div>
    <div id="sogou" class="title" style="width:120px"><img src="skin/loading.gif" width="16" height="16" border="0"></div>
    <div id="soso" class="title2" style="width:120px"><img src="skin/loading.gif" width="16" height="16" border="0"></div>
  </div>
    <div class="mainbar2">
    <div class="title" style="width:130px">反向链接</div>
    <div id="baiduf" class="title" style="width:120px"><img src="skin/loading.gif" width="16" height="16" border="0"></div>
    <div id="googlef" class="title" style="width:120px"><img src="skin/loading.gif" width="16" height="16" border="0"></div>
    <div id="yahoof" class="title" style="width:120px"><img src="skin/loading.gif" width="16" height="16" border="0"></div>
    <div id="sogouf" class="title" style="width:120px"><img src="skin/loading.gif" width="16" height="16" border="0"></div>
    <div id="sosof" class="title2" style="width:120px"><img src="skin/loading.gif" width="16" height="16" border="0"></div>
  </div>
      </dd>
     </dl>
   </div>

<br />

<div class="totop">
     <dl class="tbox">
     <dt>网站日平均排名走势图 [点击时间段查看相应时段曲线]</dt>
      <dd class="tc">
      <div class="mainbar">
  <div class="title" style="width:150px"><a style="CURSOR: hand" onClick="document.all.rank1.style.display='';document.all.rank2.style.display='none';document.all.rank3.style.display='none';document.all.rank4.style.display='none';document.all.rank5.style.display='none';">六个月数据</a></div>
  <div class="title" style="width:152px"><a style="CURSOR: hand" onClick="document.all.rank1.style.display='none';document.all.rank2.style.display='';document.all.rank3.style.display='none';document.all.rank4.style.display='none';document.all.rank5.style.display='none';">三个月数据</a></div>
  <div class="title" style="width:152px"><a style="CURSOR: hand" onClick="document.all.rank1.style.display='none';document.all.rank2.style.display='none';document.all.rank3.style.display='';document.all.rank4.style.display='none';document.all.rank5.style.display='none';">一个月数据</a></div>
  <div class="title" style="width:152px"><a style="CURSOR: hand" onClick="document.all.rank1.style.display='none';document.all.rank2.style.display='none';document.all.rank3.style.display='none';document.all.rank4.style.display='';document.all.rank5.style.display='none';">半个月数据</a></div>
  <div class="title2" style="width:150px"><a style="CURSOR: hand" onClick="document.all.rank1.style.display='none';document.all.rank2.style.display='none';document.all.rank3.style.display='none';document.all.rank4.style.display='none';document.all.rank5.style.display='';">一星期数据</a></div>
</div>
<div class="mainbar2" style="padding:10 0 10 0;height:300px">
  <div id=rank1><img src="http://traffic.alexa.com/graph?w=750&h=280&r=6m&y=t&u=<%=domain%>"></div>
  <div id=rank2 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=3m&y=t&u=<%=domain%>"></div>
  <div id=rank3 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=1m&y=t&u=<%=domain%>"></div>
  <div id=rank4 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=15.0m&y=t&u=<%=domain%>"></div>
  <div id=rank5 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=7.0&y=t&u=<%=domain%>"></div>
</div>
      </dd>
     </dl>
   </div>

<br />

<div class="totop">
     <dl class="tbox">
     <dt>日平均访问人数走势图 [点击时间段查看相应时段曲线]</dt>
      <dd class="tc">
      <div class="mainbar">
  <div class="title" style="width:150px"><a style="cursor: hand" onClick="document.all.reachs1.style.display='';document.all.reachs2.style.display='none';document.all.reachs3.style.display='none';document.all.reachs4.style.display='none';document.all.reachs5.style.display='none';">六个月数据</a></div>
  <div class="title" style="width:152px"><a style="cursor: hand" onClick="document.all.reachs1.style.display='none';document.all.reachs2.style.display='';document.all.reachs3.style.display='none';document.all.reachs4.style.display='none';document.all.reachs5.style.display='none';">三个月数据</a></div>
  <div class="title" style="width:152px"><a style="cursor: hand" onClick="document.all.reachs1.style.display='none';document.all.reachs2.style.display='none';document.all.reachs3.style.display='';document.all.reachs4.style.display='none';document.all.reachs5.style.display='none';">一个月数据</a></div>
  <div class="title" style="width:152px"><a style="cursor: hand" onClick="document.all.reachs1.style.display='none';document.all.reachs2.style.display='none';document.all.reachs3.style.display='none';document.all.reachs4.style.display='';document.all.reachs5.style.display='none';">半个月数据</a></div>
  <div class="title2" style="width:150px"><a style="cursor: hand" onClick="document.all.reachs1.style.display='none';document.all.reachs2.style.display='none';document.all.reachs3.style.display='none';document.all.reachs4.style.display='none';document.all.reachs5.style.display='';">一星期数据</a></div>
</div>
<div class="mainbar2" style="padding:10 0 10 0;height:300px">
  <div id=reachs1><img src="http://traffic.alexa.com/graph?w=750&h=280&r=6m&y=r&u=<%=domain%>"></div>
  <div id=reachs2 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=3m&y=r&u=<%=domain%>"></div>
  <div id=reachs3 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=1m&y=r&u=<%=domain%>"></div>
  <div id=reachs4 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=15.0m&y=r&u=<%=domain%>"></div>
  <div id=reachs5 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=7.0m&y=r&u=<%=domain%>"></div>
</div>
      </dd>
     </dl>
   </div>
   
<br />

<div class="totop">
     <dl class="tbox">
     <dt>日页面浏览量走势图 [点击时间段查看相应时段曲线]</dt>
      <dd class="tc">
      <div class="mainbar">
  <div class="title" style="width:150px"><a style="cursor: hand" onClick="document.all.pageviews1.style.display='';document.all.pageviews2.style.display='none';document.all.pageviews3.style.display='none';document.all.pageviews4.style.display='none';document.all.pageviews5.style.display='none';">六个月数据</a></div>
  <div class="title" style="width:152px"><a style="cursor: hand" onClick="document.all.pageviews1.style.display='none';document.all.pageviews2.style.display='';document.all.pageviews3.style.display='none';document.all.pageviews4.style.display='none';document.all.pageviews5.style.display='none';">三个月数据</a></div>
  <div class="title" style="width:152px"><a style="cursor: hand" onClick="document.all.pageviews1.style.display='none';document.all.pageviews2.style.display='none';document.all.pageviews3.style.display='';document.all.pageviews4.style.display='none';document.all.pageviews5.style.display='none';">一个月数据</a></div>
  <div class="title" style="width:152px"><a style="cursor: hand" onClick="document.all.pageviews1.style.display='none';document.all.pageviews2.style.display='none';document.all.pageviews3.style.display='none';document.all.pageviews4.style.display='';document.all.pageviews5.style.display='none';">半个月数据</a></div>
  <div class="title2" style="width:150px"><a style="cursor: hand" onClick="document.all.pageviews1.style.display='none';document.all.pageviews2.style.display='none';document.all.pageviews3.style.display='none';document.all.pageviews4.style.display='none';document.all.pageviews5.style.display='';">一星期数据</a></div>
</div>
<div class="mainbar2" style="padding:10 0 10 0;height:300px">
  <div id=pageviews1><img src="http://traffic.alexa.com/graph?w=750&h=280&r=6m&y=p&u=<%=domain%>"></div>
  <div id=pageviews2 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=3m&y=p&u=<%=domain%>"></div>
  <div id=pageviews3 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=1m&y=p&u=<%=domain%>"></div>
  <div id=pageviews4 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=15.0m&y=p&u=<%=domain%>"></div>
  <div id=pageviews5 style="display: none"><img src="http://traffic.alexa.com/graph?w=750&h=280&r=7.0m&y=p&u=<%=domain%>"></div>
</div>
      </dd>
     </dl>
   </div>   
   
</div>
</div>

 <div class="close clear center"><a href="/" target="_self" onClick="clickCount(this.href);"><img src="../images/fh.gif" border=0 alt=返回首页></a>　　<a href="javascript:window.opener =null;window.close()" target="_self" onClick="clickCount(this.href);"><img src="../images/close.gif"  border=0 alt=关闭本页></a></div>
 
 <div  class="footer clear">
    <div class="group">
 <a href="http://www.wzs1s.com/about/" target="_blank">关于本站</a> | <a href="http://www.wzs1s.com/about/help.html" target="_blank">帮助中心</a> | <a href="http://www.wzs1s.com/about/ad.html" target="_blank">广告服务</a> | <a href="http://www.wzs1s.com/about/contact.html" target="_blank">在线客服</a> | <a href="http://www.coooltong.com" target="_blank">酷通设计</a> | <script src="http://s73.cnzz.com/stat.php?id=1083816&web_id=1083816" language="JavaScript" charset="gb2312"></script>

    </div>
    <div class="copyright">
 Copyright &copy; 2009 Wzs1s.com.com All Rights Reserved. 网站搜一搜 版权所有<br />
 建议使用1024*768以上的屏幕分辨率和6.0以上版本的IE来访问本站
    </div>
    <div class="miibeian"><a href="http://www.miibeian.gov.cn/"><% =beian%></a><script type="text/javascript" src="http://js.tongji.linezing.com/1078870/tongji.js"></script><noscript><a href="http://www.linezing.com"><img src="http://img.tongji.linezing.com/1078870/tongji.gif"/></a></noscript></div>
 </div>
 
 <script language="javascript" type="text/javascript" src="ajaxloading.asp?url=<%=domain%>"></script>
    <script language="javascript" type="text/javascript" src="ajaxsites.asp?url=<%=domain%>"></script>
	<script language="javascript" type="text/javascript" src="ajaxlinks.asp?url=<%=domain%>"></script>

 
</body>
</html>