function getOtherInfo(){
	var domain =jQuery("#domain").val();
    jQuery.ajax({
     type: "post",
     url: "/ajaxAlexa.action",
     data: "domain="+domain,
     async: true,
     success: function(msg){
        var rs =msg.split("_split_");
        jQuery("#RankToday").html(rs[0]);
        jQuery("#RankwkAvg").html(rs[1]);
        jQuery("#RankmosAvg").html(rs[2]);
        jQuery("#AllRank").html(rs[3]);
        if(rs[4].indexOf("-")!=-1){
        jQuery("#RankmosChange").html("<img src='/images/down_arrow.gif' title='下降'/>"+rs[4].replace("-",""));
        }else if(rs[4].indexOf("+")!=-1){
         jQuery("#RankmosChange").html("<img src='/images/up_arrow.gif' title='上升'/>"+rs[4].replace("+",""));
        }else{
        jQuery("#RankmosChange").html(rs[4]);
        }
        jQuery("#ranks").html("<a title='查看Alexa官方信息' href='http://www.alexa.com/data/details/traffic_details?q=&url="+domain+"' target='_blank'>"+rs[5]+"</a>");
        jQuery("#chinarank").html(rs[6]);
     },
     error: function(){
        alert("get data error happens");
     }
    });
}

function getGoogle(){
	var domain =jQuery("#domain").val();
	   jQuery.ajax({
	     type: "post",
	     url: "/googleShoulu.action",
	     data: "shoulu_domain="+domain,
	     async: true,
	     success: function(msg){
	        var rs =msg.split("_split_");
	        jQuery("#google").html("<a href='"+rs[1]+"' target='_blank'>"+rs[0]+"</a>");
	     },
	     error: function(){
	        alert("google error happens");
	     }
	    });
	}

	function getBaidu(){
	var domain =jQuery("#domain").val();
	    jQuery.ajax({
	     type: "post",
	     url: "/baiduShoulu.action",
	     data: "shoulu_domain="+domain,
	     async: true,
	     success: function(msg){
	        var rs =msg.split("_split_");
	        jQuery("#baidu").html("<a href='"+rs[1]+"' target='_blank'>"+rs[0]+"</a>");
	     },
	     error: function(){
	        alert("baidu error happens");
	     }
	    });
	}

	function getYahoo(){
		var domain =jQuery("#domain").val();
		    jQuery.ajax({
		     type: "post",
		     url: "/yahooShoulu.action",
		     data: "shoulu_domain="+domain,
		     async: true,
		     success: function(msg){
		        var rs =msg.split("_split_");
		        jQuery("#yahoo").html("<a href='"+rs[1]+"' target='_blank'>"+rs[0]+"</a>");
		     },
		     error: function(){
		        alert("yahoo error happens");
		     }
		    });
	}

	function getSoso(){
		var domain =jQuery("#domain").val();
		    jQuery.ajax({
		     type: "post",
		     url: "/sosoShoulu.action",
		     data: "shoulu_domain="+domain,
		     async: true,
		     success: function(msg){
		        var rs =msg.split("_split_");
		        jQuery("#soso").html("<a href='"+rs[1]+"' target='_blank'>"+rs[0]+"</a>");
		     },
		     error: function(){
		        alert("soso error happens");
		     }
		    });
	}

	function getSogou(){
		var domain =jQuery("#domain").val();
		    jQuery.ajax({
		     type: "post",
		     url: "/sogouShoulu.action",
		     data: "shoulu_domain="+domain,
		     async: true,
		     success: function(msg){
		    	var rs =msg.split("_split_");
		    	jQuery("#sogou").html("<a href='"+rs[1]+"' target='_blank'>"+rs[0]+"</a>");
		     },
		     error: function(){
		        alert("sogou error happens");
		     }
		    });
	}
	
	function getGoogleL(){
		var domain =jQuery("#domain").val();
		   jQuery.ajax({
		     type: "post",
		     url: "/googleLink.action",
		     data: "shoulu_domain="+domain,
		     async: true,
		     success: function(msg){
		        var rs =msg.split("_split_");
		        jQuery("#googlef").html("<a href='"+rs[1]+"' target='_blank'>"+rs[0]+"</a>");
		     },
		     error: function(){
		        alert("google error happens");
		     }
		    });
		}

		function getBaiduL(){
		var domain =jQuery("#domain").val();
		    jQuery.ajax({
		     type: "post",
		     url: "/baiduLink.action",
		     data: "shoulu_domain="+domain,
		     async: true,
		     success: function(msg){
		        var rs =msg.split("_split_");
		        jQuery("#baiduf").html("<a href='"+rs[1]+"' target='_blank'>"+rs[0]+"</a>");
		     },
		     error: function(){
		        alert("baidu error happens");
		     }
		    });
		}

		function getYahooL(){
			var domain =jQuery("#domain").val();
			    jQuery.ajax({
			     type: "post",
			     url: "/yahooLink.action",
			     data: "shoulu_domain="+domain,
			     async: true,
			     success: function(msg){
			        var rs =msg.split("_split_");
			        jQuery("#yahoof").html("<a href='"+rs[1]+"' target='_blank'>"+rs[0]+"</a>");
			     },
			     error: function(){
			        alert("yahoo error happens");
			     }
			    });
		}

		function getSosoL(){
			var domain =jQuery("#domain").val();
			    jQuery.ajax({
			     type: "post",
			     url: "/sosoLink.action",
			     data: "shoulu_domain="+domain,
			     async: true,
			     success: function(msg){
			        var rs =msg.split("_split_");
			        jQuery("#sosof").html("<a href='"+rs[1]+"' target='_blank'>"+rs[0]+"</a>");
			     },
			     error: function(){
			        alert("soso error happens");
			     }
			    });
		}

		function getSogouL(){
			var domain =jQuery("#domain").val();
			    jQuery.ajax({
			     type: "post",
			     url: "/sogouLink.action",
			     data: "shoulu_domain="+domain,
			     async: true,
			     success: function(msg){
			        var rs =msg.split("_split_");
			        jQuery("#sogouf").html("<a href='"+rs[1]+"' target='_blank'>"+rs[0]+"</a>");
			     },
			     error: function(){
			        alert("sogou error happens");
			     }
			    });
		}
