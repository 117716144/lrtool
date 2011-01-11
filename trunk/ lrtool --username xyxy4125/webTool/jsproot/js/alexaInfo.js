function getOtherInfo(){
	var domain =jQuery("#domain").val();
    jQuery.ajax({
     type: "post",
     url: "ajaxAlexa.action",
     data: "domain="+domain,
     async: true,
     success: function(msg){
        var rs =msg.split("_split_");
        jQuery("#RankToday").html(rs[0]);
        jQuery("#RankwkAvg").html(rs[1]);
        jQuery("#RankmosAvg").html(rs[2]);
        jQuery("#AllRank").html(rs[3]);
        jQuery("#RankmosChange").html(rs[4]);
        jQuery("#ranks").html("<a title='查看Alexa官方信息' href='http://www.alexa.com/data/details/traffic_details?q=&url="+domain+"' target='_blank'>"+rs[5]+"</a>");
        jQuery("#chinarank").html(rs[6]);
     },
     error: function(){
        alert("get data error happens");
     }
    });
}