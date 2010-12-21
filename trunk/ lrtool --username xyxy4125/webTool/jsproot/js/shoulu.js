jQuery(document).ready( function() {
   
});

function getGoogle(){
var domain =jQuery("#shoulu_domain").val();
   jQuery.ajax({
     type: "post",
     url: "googleShoulu.action",
     data: "shoulu_domain="+domain,
     async: true,
     success: function(msg){
        var rs =msg.split("_split_");
        jQuery("#google_count").html(rs[0]);
        jQuery("#google_site").html("<a href='"+rs[1]+"' target='_blank'>查看</a>");
     },
     error: function(){
        alert("google error happens");
     }
    });
}

function getBaidu(){
var domain =jQuery("#shoulu_domain").val();
    jQuery.ajax({
     type: "post",
     url: "baiduShoulu.action",
     data: "shoulu_domain="+domain,
     async: true,
     success: function(msg){
        var rs =msg.split("_split_");
        jQuery("#baidu_count").html(rs[0]);
        jQuery("#baidu_site").html("<a href='"+rs[1]+"' target='_blank'>查看</a>");
     },
     error: function(){
        alert("baidu error happens");
     }
    });
}

function getYahoo(){
	var domain =jQuery("#shoulu_domain").val();
	    jQuery.ajax({
	     type: "post",
	     url: "yahooShoulu.action",
	     data: "shoulu_domain="+domain,
	     async: true,
	     success: function(msg){
	        var rs =msg.split("_split_");
	        jQuery("#yahoo_count").html(rs[0]);
	        jQuery("#yahoo_site").html("<a href='"+rs[1]+"' target='_blank'>查看</a>");
	     },
	     error: function(){
	        alert("yahoo error happens");
	     }
	    });
}

function getSoso(){
	var domain =jQuery("#shoulu_domain").val();
	    jQuery.ajax({
	     type: "post",
	     url: "sosoShoulu.action",
	     data: "shoulu_domain="+domain,
	     async: true,
	     success: function(msg){
	        var rs =msg.split("_split_");
	        jQuery("#soso_count").html(rs[0]);
	        jQuery("#soso_site").html("<a href='"+rs[1]+"' target='_blank'>查看</a>");
	     },
	     error: function(){
	        alert("soso error happens");
	     }
	    });
}

function getSogou(){
	var domain =jQuery("#shoulu_domain").val();
	    jQuery.ajax({
	     type: "post",
	     url: "sogouShoulu.action",
	     data: "shoulu_domain="+domain,
	     async: true,
	     success: function(msg){
	        var rs =msg.split("_split_");
	        jQuery("#sogou_count").html(rs[0]);
	        jQuery("#sogou_site").html("<a href='"+rs[1]+"' target='_blank'>查看</a>");
	     },
	     error: function(){
	        alert("sogou error happens");
	     }
	    });
}

function getYoudao(){
	var domain =jQuery("#shoulu_domain").val();
	    jQuery.ajax({
	     type: "post",
	     url: "youdaoShoulu.action",
	     data: "shoulu_domain="+domain,
	     async: true,
	     success: function(msg){
	        var rs =msg.split("_split_");
	        jQuery("#youdao_count").html(rs[0]);
	        jQuery("#youdao_site").html("<a href='"+rs[1]+"' target='_blank'>查看</a>");
	     },
	     error: function(){
	        alert("youdao error happens");
	     }
	    });
}

function getBing(){
	var domain =jQuery("#shoulu_domain").val();
	    jQuery.ajax({
	     type: "post",
	     url: "bingShoulu.action",
	     data: "shoulu_domain="+domain,
	     async: true,
	     success: function(msg){
	        var rs =msg.split("_split_");
	        jQuery("#bing_count").html(rs[0]);
	        jQuery("#bing_site").html("<a href='"+rs[1]+"' target='_blank'>查看</a>");
	     },
	     error: function(){
	        alert("bing error happens");
	     }
	    });
}