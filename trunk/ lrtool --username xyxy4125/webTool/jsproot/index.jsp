<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>站长工具 - 日常生活 - 网站搜一搜 - 个性化导航WZS1S.com - 致力全民个性化快捷的上网方式！</title>
<meta name ="keywords" content="便民工具,网站搜索,网址导航，搜一搜,个性化导航,全民搜索,起始页,上网主页,上网首页,收藏夹,网络收藏夹,网址收藏夹,书签,QQ书签,网络书签,上网导航,网址,网址导航,导航,快捷上网,网址之家,实用工具,搜索,社区" />
<meta name="description" content="网站搜一搜，让全民上网更加方便更加快捷，最具个性化的导航搜索平台，让你工作生活无忧!" />
<link href="/style/css.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="/js/Blank_link.js"></script>
<script language="javascript" type="text/javascript" src="/js/Main.js"></script>
<Script Language="JavaScript">if(self!=top){top.location=self.location;}</script>

<script language="JavaScript">var Sys_LoadStart=new Date(); </script>
</head>

<body>
<div class="w960 center clear">
  <div class="header">
<h1><a class="logo" title="网站搜一搜 - 个性化导航WZS1S.com" href="javascript:void(0)" onClick="this.style.behavior='url(#default#homepage)';this.setHomePage(location.href);return(false);">网站搜一搜 - 个性化导航WZS1S.com</a></h1>
<p class="nav"> <a  title="网站搜一搜 - 设为首页" href="javascript:void(0)" onClick="this.style.behavior='url(#default#homepage)';this.setHomePage(location.href);return(false);">设为首页</a>  
<a  title="网站搜一搜 - 加入收藏" href="javascript:window.external.AddFavorite('http://www.wzs1s.com','网站搜一搜')">加入收藏</a>  
<a  title="帮助中心" href="/about/help.html">使用帮助</a>  
</p>
<div class="menu">
			<ul>
				<li><a href="http://www.wzs1s.com/">网站首页</a></li>
				<li><a href="http://www.wzs1s.com//bianmin">便民查询</a></li>
				<li class="active"><a href="http://www.wzs1s.com//tool">站长工具</a></li>
				<li><a href="http://www.wzs1s.com//link">名站导航</a></li>
				<li><a href="http://www.wzs1s.com//web2.0">好站推荐</a></li>
				
			</ul>		
		</div>
        <div class="clear"></div>  
    </div>
    <!--  header -->
</div> 

<div class="w960 center clear">
<div class="conent">
   <div class="totop">
     <dl class="tbox">
     <dt><strong>搜索引擎收录情况查询</strong><p><a href="Shoulu/" target="_blank"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
      <dd class="tc"><form method="post" target="_blank" action="shouLuAction.action">请输入要查询的网址: <font face="Arial">http://</font> <input name="shoulu_domain" type="text" size="65" value="" class="inp_t">&nbsp;<input type="submit" value="开始查询"  class="sb_c"><br />
<input name="googlecheck" type="checkbox" class="checkbox" value="checked" > 谷歌
<input name="baiducheck" type="checkbox" class="checkbox" value="checked" > 百度
<input name="yahoocheck" type="checkbox" class="checkbox" value="checked" > 雅虎
<input name="sosocheck" type="checkbox" class="checkbox" value="checked" > SOSO
<input name="sogoucheck" type="checkbox" class="checkbox" value="checked" > 搜狗
<input name="youdaocheck" type="checkbox" class="checkbox" value="checked" > 有道
<input name="bingcheck" type="checkbox" class="checkbox" value="checked" > 必应
<input name="chkall" type="checkbox" class="checkbox" value=on onclick=checkall(this.form)> 全选</form>可查询各大搜索引擎对指定网站的收录数量和对比情况。
      </dd>
     </dl>
   </div>
   
   
    <div class="totop w50 left">
     <dl class="tbox">
        <dt><strong>IP/服务器物理定位查询</strong><p><a href="ip/" target="_blank"><img src="//images/right.gif" width="16" height="16" /></a></p></dt>
        <dd><form method="post" target="_blank" action="Ip/Index.asp">IP / 域名：<input name="Ip" type="text" size="30" value="<%=request.getRemoteAddr()%>" class="inp_t">&nbsp;<input type="submit" value="开始查询" class="sb_c"></form>直接输入IP则可查询该IP的物理位置；
      </dd>
     </dl>
    </div>
    
    
     <div class="totop w50 right">
     <dl class="tbox">
        <dt><strong>域名 WHOIS 信息查询</strong><p><a href="ip/whois.asp" target="_blank"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd><form method="post" target="_blank" action="Ip/Whois.asp">网站域名：<input name="domain" type="text" size="30" value="www." class="inp_t">&nbsp;<input type="submit"value="开始查询" class="sb_c"></form>输入域名则可检测服务器的IP及其 WHOIS 信息。
      </dd>
     </dl>
    </div>
    
    <div class="clear"></div><br />
    <div class="totop">
     <dl class="tbox">
     <dt><strong>搜索引擎反向链接情况查询</strong><p><a href="LinkIn/" target="_blank"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
      <dd class="tc"><form method="post" target="_blank" action="LinkIn/Index.asp">网站地址：<input name="link_domain" type="text" size="65" value="http://" class="inp_t">&nbsp;<input type="submit" value="开始查询" class="sb_c" /><br />
<input name="googlecheck" type="checkbox" class="checkbox" value="checked" > Google
<input name="baiducheck" type="checkbox" class="checkbox" value="checked" > 百度
<input name="yahoocheck" type="checkbox" class="checkbox" value="checked" > 雅虎
<input name="msncheck" type="checkbox" class="checkbox" value="checked" > MSN
<input name="sogoucheck" type="checkbox" class="checkbox" value="checked" > 搜狗
<input name="zhongsoucheck" type="checkbox" class="checkbox" value="checked" > 中搜
<input name="sosocheck" type="checkbox" class="checkbox" value="checked" > SOSO
<input name="sinacheck" type="checkbox" class="checkbox" value="checked" > 新浪
<input name="iaskcheck" type="checkbox" class="checkbox" value="checked" > 爱问
<input name="alexacheck" type="checkbox" class="checkbox" value="checked" > ALEXA
<input name="chkall" type="checkbox" class="checkbox" value=on onclick=checkall(this.form) class="check" />全选</form>可查询各搜索引擎收录的指定网站在其他站上的链接情况。
      </dd>
     </dl>
   </div>
     <div class="clear"></div>
    <div class="totop w50 left">
     <dl class="tbox">
        <dt><strong>ALEXA 详细排名查询</strong><p><a href="alexa/"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd><form action="alexa/" method="get" target="_blank">
网站地址：<input name="url"  type="text" size="30" value="http://www." class="inp_t">&nbsp;<input type="submit" value="开始查询" class="sb_c"></form>可查询网站的世界排名、流量、访问量、联系方式等综合信息。
      </dd>
     </dl>
    </div>
    
    
     <div class="totop w50 right">
     <dl class="tbox">
        <dt><strong>GG PR & SOGOU RANK 查询</strong><p><a href="Rank/" target="_blank"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd><form method="post" target="_blank" name="get_rank" onsubmit="return(ranks());">网站地址：<input name="domain" type="text" size="20" value="www." class="inp_t">&nbsp;<select name="rank_site"><option value="1">Google</option><option value="2">Sogou</option></select> <input type="submit" value="开始查询" class="sb_c"></form>可查询网页在GG或搜狗上的页面等级（影响搜索引擎排名）信息。
<script language="javascript">
<!--
function ranks()
{
var pr_domain = get_rank.domain.value

//pr查询
if(get_rank.rank_site.value=="1")
get_rank.action ='Rank/Index.asp';
//sr查询
if(get_rank.rank_site.value=="2")
get_rank.action ='Sogou_Rank/Index.asp';
}
//-->
</script>
      </dd>
     </dl>
    </div>
    
    <div class="clear"></div>
    
    <div class="totop w50 left">
     <dl class="tbox">
        <dt><strong>关键词排名查询</strong><p><a href="KeyWords/"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd><form action="KeyWords/" method="get" target="_blank">网站域名：<input name="domain" type="text" size="12"  class="inp_t">&nbsp;关键词：<input name="word" type="text" value="" size="6"  class="inp_t">&nbsp;<input type="submit" value="开始查询" class="sb_c"></form>可查询指定站点在GG中搜索指定关键词时的排名位置。
      </dd>
     </dl>
    </div>
    
    
     <div class="totop w50 right">
     <dl class="tbox">
        <dt><strong>页面关键词密度查询</strong><p><a href="Seo/"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd><form method="post" target="_blank" action="Seo/Key_Density.asp">网站页面：<input name="domain" type="text" size="14" value="www." class="inp_t">&nbsp;关键词：<input name="KeyWords" type="text" size="7" value="" class="inp_t">&nbsp;<input type="submit" value="开始查询" class="sb_c"></form>可查询指定页面中某一关键词的出现频率和密度。
      </dd>
     </dl>
    </div>
    <div class="clear"></div>
    
    <div class="totop w50 left">
     <dl class="tbox">
        <dt><strong>搜索引擎模拟抓取页面</strong><p><a href="seo/robot.asp"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd><form action="seo/robot.asp" method="get"  target="_blank"><input name="domain" type="text"size="20" value="www." class="inp_t">&nbsp;网页编码：<select name="code" id="RCharactorSet">
	                                        <option selected="selected" value="GB2312">GB2312</option>
	                                        <option value="UTF-8">UTF-8</option>
	                                        <option value="GBK">GBK</option>
                                        </select>&nbsp;<input type="submit" value="开始查询" class="sb_c"></form>该查询模拟搜索引擎的机器人或爬虫访问你页面所抓取到的信息。<br />此模拟功能对于针对搜索引擎专门优化过的页面可能无效。
      </dd>
     </dl>
    </div>
    
    
     <div class="totop w50 right">
     <dl class="tbox">
        <dt><strong>网页 META 信息检测</strong><p><a href="seo/metacheck.asp"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd><form action="seo/metacheck.asp" method="get"  target="_blank"><input name="domain" type="text" size="32" value="www." class="inp_t">&nbsp;<select name="code" id="MCharactorSet">
	                                            <option selected="selected" value="GB2312">GB2312</option>
	                                            <option value="UTF-8">UTF-8</option>
	                                            <option value="GBK">GBK</option>
                                            </select>&nbsp;<input type="submit" value="开始查询" class="sb_c"></form>可判断页面标题、关键词、描述等是否有利于搜索引擎收录。<br />此查询功能对于针对搜索引擎专门优化过的页面可能无效。
      </dd>
     </dl>
    </div>
    <div class="clear"></div>
    
    <div class="totop w50 left">
     <dl class="tbox">
        <dt><strong>HTML/JS代码 互转工具</strong><p><a href="/trans/Html_Js.asp"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd> 可以把 HTML代码 JS代码 互相转化输出。<br />由于页面空间有限，请 [<a href="/trans/Html_Js.asp" style="border-bottom:dashed 1px;" rel="external">点此链接至详细转换页面</a>]。
      </dd>
     </dl>
    </div>
    
    
     <div class="totop w50 right">
     <dl class="tbox">
        <dt><strong>ESCAPE 加密/解密工具</strong><p><a href="/trans/Escape.asp"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd>可以把代码以 ESCAPE 加密/解密输出。<br />由于页面空间有限，请 [<a href="/trans/Escape.asp" style="border-bottom:dashed 1px;" rel="external">点此链接至详细转换页面</a>]。 
      </dd>
     </dl>
    </div>
    <div class="clear"></div>
    
    <div class="totop w50 left">
     <dl class="tbox">
        <dt><strong>GB2312/BIG5 互转工具</strong><p><a href="/trans/Gb_Big.asp"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd> 可以在 GB2312（简体中文）/BIG5（繁体中文）之间自由转换。<br />由于页面空间有限，请 [<a href="/trans/Gb_Big.asp" style="border-bottom:dashed 1px;" rel="external">点此链接至详细转换页面</a>]。
      </dd>
     </dl>
    </div>
    
    
     <div class="totop w50 right">
     <dl class="tbox">
        <dt><strong>网页代码 JS/VB 加密工具</strong><p><a href="/trans/Encode.asp"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd>使用 JS/VBS 方式实现的网页代码和字符串的加密和解密。<br />由于页面空间有限，请 [<a href="/trans/Encode.asp" style="border-bottom:dashed 1px;" rel="external">点此链接至详细转换页面</a>]。 
      </dd>
     </dl>
    </div>
    
    <div class="clear"></div>
    
    <div class="totop w50 left">
     <dl class="tbox">
        <dt><strong>字符到ASCII码 转换工具</strong><p><a href="/trans/Ascii.asp"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd> <Script language="" Src="//trans/Ascii.asp"></Script>输入键盘上任一字符转换该键ACSII码，大小写字母ASCII码不同。<br />为了不造成混淆，每次只能查询一个字符的ASCII码。
      </dd>
     </dl>
    </div>
    
    
     <div class="totop w50 right">
     <dl class="tbox">
        <dt><strong>字符串32/16位MD5 加密工具</strong><p><a href="/trans/Md5.asp"><img src="/images/right.gif" width="16" height="16" /></a></p></dt>
        <dd><Script language="" Src="/trans/Md5.asp"></Script>
      </dd>
     </dl>
    </div>
    
    
    <div class="clear"></div>
</div>
</div>

 <div class="close clear center"><a href="/" target="_self" onClick="clickCount(this.href);"><img src="/images/fh.gif" border=0 alt=返回首页></a>　　<a href="javascript:window.opener =null;window.close()" target="_self" onClick="clickCount(this.href);"><img src="/images/close.gif"  border=0 alt=关闭本页></a></div>
 
 <div  class="footer clear">
    <div class="group">
 <a href="http://www.wzs1s.com/about/" target="_blank">关于本站</a> | <a href="http://www.wzs1s.com/about/help.html" target="_blank">帮助中心</a> | <a href="http://www.wzs1s.com/about/ad.html" target="_blank">广告服务</a> | <a href="http://www.wzs1s.com/about/contact.html" target="_blank">在线客服</a> | <a href="http://www.coooltong.com" target="_blank">酷通设计</a> | <script src="http://s73.cnzz.com/stat.php?id=1083816&web_id=1083816" language="JavaScript" charset="gb2312"></script>

    </div>
    <div class="copyright">
 Copyright &copy; 2009 Wzs1s.com.com All Rights Reserved. 网站搜一搜 版权所有<br />
 建议使用1024*768以上的屏幕分辨率和6.0以上版本的IE来访问本站
    </div>
    <div class="miibeian"><a href="http://www.miibeian.gov.cn/">网络警察</a><noscript><a href="http://www.linezing.com"><img src="http://img.tongji.linezing.com/1078870/tongji.gif"/></a></noscript></div>
 </div>
 
 
 
</body>
</html>