jQuery(document).ready(function(){
	jQuery.ajax({
		type: "post",
	    url : "/areas.html",
	    async : true,
	    success : function(msg) {
		    //jQuery("#province").html("<option value=\"-1\">--请选择--</option>");
			//jQuery("#province").append(msg);
			jQuery("#province").append(msg);
	    },
	    error : function(){
	        alert('error');
	    }
	});
	
});

var resetArea = function(){
	jQuery("#area").empty();
	jQuery("#area").html("<option value=\"-1\">--请选择--</option>");
	
	jQuery("#city").empty();
	jQuery("#city").html("<option value=\"-1\">--请选择--</option>");
	var code =jQuery("#province").val();
	if(code==-1){ return;}
	jQuery.ajax({
		type: "post",
	    url : "/areas!area.action",
	    data : "areaCode="+code,
	    async : false,
	    success : function(msg) {
			jQuery("#area").append(msg);
	    },
	    error : function(){
	        alert('error');
	    }
	});
}

var resetCity = function(){
	jQuery("#city").empty();
	jQuery("#city").html("<option value=\"-1\">--请选择--</option>");
	var code =jQuery("#area").val();
	if(code==-1){ return;}
	jQuery.ajax({
		type: "post",
	    url : "/areas!city.action",
	    data : "areaCode="+code,
	    async : false,
	    success : function(msg) {
			jQuery("#city").append(msg);
	    },
	    error : function(){
	        alert('error');
	    }
	});
}