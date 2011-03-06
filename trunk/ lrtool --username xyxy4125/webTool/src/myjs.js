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
