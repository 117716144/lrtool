function Dec(input, key){
        input   = escape(input);

        var int_key = "";
        for(var I=0;I<key.length;I++)
        {
                int_key += key.charCodeAt(I).toString();
        }

        var app = input.substr(input.length - 13,input.length);
        var app1 = app;

        app     = app ^ 99999999;

        var str = input.substr(0,input.length - 13);
        input   = str;

        int_key = int_key + app1;
        var ret = "";

        for(var I=0;I<input.length;I+=2)
        {
                var sig         = input.substr(I,2);
                sig             = parseInt(sig,16);

                var i           = (I/2) % int_key.length;
                var xor_key     = int_key.substr(i,1);
                sig             = sig ^ xor_key;

                ret             += String.fromCharCode(sig);
        }
        return  unescape(ret);
}

window.baidu = window.baidu || {
	version: "1-0-0",
	emptyFn: function() {}
};
baidu.isString = function($) {
	return (typeof $ == "object" && $ && $.constructor == String) || typeof $ == "string"
};
baidu.swf = baidu.swf || {};
baidu.swf.getMovie = function($) {
	return document[$] || window[$]
};
baidu.swf.getVersion = function() {
	var B = navigator;
	if (B.plugins && B.mimeTypes.length) {
		var A = B.plugins["Shockwave Flash"];
		if (A && A.description) return A.description.replace(/([a-zA-Z]|\s)+/, "").replace(/(\s)+r/, ".") + ".0"
	} else if (window.ActiveXObject && !window.opera) for (var C = 10; C >= 2; C--) {
		try {
			var _ = new ActiveXObject("ShockwaveFlash.ShockwaveFlash." + C);
			if (_) {
				return C + ".0.0";
				break
			}
		} catch($) {}
	}
};
baidu.swf.createHTML = function(M) {
	M = M || {};
	var E = baidu.swf.getVersion(),
	J = 1,
	K = M.ver || "6.0.0",
	_,
	$;
	if (E) {
		E = E.split(".");
		K = K.split(".");
		for (var F = 0; F < 3; F++) {
			_ = parseInt(E[F], 10);
			$ = parseInt(K[F], 10);
			if ($ < _) break;
			else if ($ > _) {
				J = 0;
				break
			}
		}
	} else J = 0;
	if (!J) return "";
	var G = M.vars,
	D, B, I, L = ["classid", "codebase", "id", "width", "height", "align"];
	M.align = M.align || "middle";
	M.classid = "clsid:d27cdb6e-ae6d-11cf-96b8-444553540000";
	M.codebase = "http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0";
	M.movie = M.url || "";
	delete M.vars;
	delete M.url;
	if (baidu.isString(G)) M.flashvars = G;
	else {
		var C = [];
		for (D in G) {
			I = G[D];
			if (I) C.push(D + "=" + encodeURIComponent(I))
		}
		M.flashvars = C.join("&")
	}
	var H = ["<object "];
	for (F = 0, B = L.length; F < B; F++) {
		I = L[F];
		H.push(" ", I, '="', M[I], '"')
	}
	H.push(">");
	var A = {
		wmode: 1,
		scale: 1,
		quality: 1,
		play: 1,
		loop: 1,
		menu: 1,
		salign: 1,
		bgcolor: 1,
		base: 1,
		allowscriptaccess: 1,
		allownetworking: 1,
		allowfullscreen: 1,
		seamlesstabbing: 1,
		devicefont: 1,
		swliveconnect: 1,
		flashvars: 1,
		movie: 1
	};
	for (D in M) {
		I = M[D];
		if (A[D] && I) H.push('<param name="' + D + '" value="' + I + '" />')
	}
	M.src = M.movie;
	M.name = M.id;
	delete M.id;
	delete M.movie;
	delete M.classid;
	delete M.codebase;
	M.type = "application/x-shockwave-flash";
	M.pluginspage = "http://www.macromedia.com/go/getflashplayer";
	H.push("<embed");
	for (D in M) {
		I = M[D];
		if (I) H.push(" ", D, '="', I, '"')
	}
	H.push("></embed></object>");
	return H.join("")
};
baidu.swf.create = function(B, _) {
	B = B || {};
	var A = baidu.swf.createHTML(B),
	$ = true;
	if (_ && baidu.isString(_)) _ = document.getElementById(_);
	if (A.length <= 0) {
		A = B.errorMessage || "";
		$ = false
	}
	if (_) _.innerHTML = A;
	else document.write(A);
	return $;
}

