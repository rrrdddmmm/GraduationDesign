var idtishi = "MyDiv1";
var idtique = "MyDiv2";
var idfade = "fade";
var img = "";
var strOK = "";
var ndiv = 1;
//var intent=window.setTimeout(function(){
//},5000);
function _alert(txt, imgtp, ndiv) {
	//var intent=window.setTimeout(function(){
		_alert1(txt, imgtp, ndiv);
	//},5000);
}
function _alert1(txt, imgtp, ndiv) {
    img = "../content/images/baocuncg.jpg";
    if (imgtp == 1)
        img = "../content/images/baocuncg.jpg";
    else if (imgtp == 2)
        img = "../content/images/shibai.jpg";
    if ($("#" + idtishi).length > 0) {
        $("#" + idtishi).remove();
    }

    if (ndiv == 0) { 
        ShowBJ('fade1');
        idfade = "fade1";
    } else if (ndiv == 2) {
        ShowBJ('fade2');
        idfade = "fade2";
    }
    else {
        ShowBJ('fade');
        idfade = "fade";
    }
    var _d = document;
    var alert_bg = _d.createElement("div");
    alert_bg.setAttribute("id", idtishi);
    alert_bg.setAttribute("class", "white_content");
    alert_bg.setAttribute("style", "display: none; position: fixed!important; top: 20%;left: 50%;width: 304px; height: 142px;z-index: 1002;_position:absolute;_top: expression(eval(document.compatMode && document.compatMode == 'CSS1Compat') ?documentElement.scrollTop + (document.documentElement.clientHeight - this.offsetHeight) / 2 : document.body.scrollTop + (document.body.clientHeight - this.clientHeight) / 2);overflow: hidden; margin:-75px 0 0 -152px; border:2px solid #7db8f0; background:#ffffff;");
    _d.body.appendChild(alert_bg);
    var _this = $("#" + idtishi);
    _this.html(txt).fadeIn(function () {
    });
    $("#" + idtishi).html("<div class=\"tuichubg\"><h1 class=\"tishi\">系统提示</h1><div class=\"guanbitc\"><img src=\"../content/images/hong.gif\" class=\"sdcq_tck_right_cha\" width=\"1\" height=\"16\" onclick=\"CloseDiv('" + idtishi + "','" + idfade + "')\" /></div><div class=\"clearfix\"></div></div><div class=\"tuichumain\"><div style=\"background: url(" + img + ") no-repeat;\" class=\"baocuncg\"></div> <span class=\"tuichune\">" + txt + "</span><div class=\"clearfix\"></div></div><div class=\"dialog-console\"><a class=\"console-btn-confirm\" href=\"javascript:\" onclick=\"CloseDiv('" + idtishi + "','" + idfade + "')\" >确定</a><div class=\"clearfix\"></div></div><div class=\"clearfix\"></div>");
}

function _alertlogin(txt, imgtp, ndiv) {
	//var intent=window.setTimeout(function(){
		_alert1login(txt, imgtp, ndiv);
	//},5000);
}
function _alert1login(txt, imgtp, ndiv) {
    img = "content/images/baocuncg.jpg";
    if (imgtp == 1)
        img = "content/images/baocuncg.jpg";
    else if (imgtp == 2)
        img = "content/images/shibai.jpg";
    if ($("#" + idtishi).length > 0) {
        $("#" + idtishi).remove();
    }

    if (ndiv == 0) { 
        ShowBJ('fade1');
        idfade = "fade1";
    } else if (ndiv == 2) {
        ShowBJ('fade2');
        idfade = "fade2";
    }
    else {
        ShowBJ('fade');
        idfade = "fade";
    }
    var _d = document;
    var alert_bg = _d.createElement("div");
    alert_bg.setAttribute("id", idtishi);
    alert_bg.setAttribute("class", "white_content");
    alert_bg.setAttribute("style", "display: none; position: fixed!important; top: 20%;left: 50%;width: 304px; height: 142px;z-index: 1002;_position:absolute;_top: expression(eval(document.compatMode && document.compatMode == 'CSS1Compat') ?documentElement.scrollTop + (document.documentElement.clientHeight - this.offsetHeight) / 2 : document.body.scrollTop + (document.body.clientHeight - this.clientHeight) / 2);overflow: hidden; margin:-75px 0 0 -152px; border:2px solid #7db8f0; background:#ffffff;");
    _d.body.appendChild(alert_bg);
    var _this = $("#" + idtishi);
    _this.html(txt).fadeIn(function () {
    });
    $("#" + idtishi).html("<div class=\"tuichubg\"><h1 class=\"tishi\">系统提示</h1><div class=\"guanbitc\"><img src=\"content/images/hong.gif\" class=\"sdcq_tck_right_cha\" width=\"1\" height=\"16\" onclick=\"CloseDiv('" + idtishi + "','" + idfade + "')\" /></div><div class=\"clearfix\"></div></div><div class=\"tuichumain\"><div style=\"background: url(" + img + ") no-repeat;\" class=\"baocuncg\"></div> <span class=\"tuichune\">" + txt + "</span><div class=\"clearfix\"></div></div><div class=\"dialog-console\"><a class=\"console-btn-confirm\" href=\"javascript:\" onclick=\"CloseDiv('" + idtishi + "','" + idfade + "')\" >确定</a><div class=\"clearfix\"></div></div><div class=\"clearfix\"></div>");
}
function _alert111(txt, imgtp, ndiv) {
    img = "../content/images/baocuncg.jpg";
    if (imgtp == 1)
        img = "../content/images/baocuncg.jpg";
    else if (imgtp == 2)
        img = "../content/images/shibai.jpg";
    if ($("#" + idtishi).length > 0) {
        $("#" + idtishi).remove();
    }

    if (ndiv == 0) { 
        ShowBJ('fade1');
        idfade = "fade1";
    } else if (ndiv == 2) {
        ShowBJ('fade2');
        idfade = "fade2";
    }
    else {
        ShowBJ('fade');
        idfade = "fade";
    }
    var _d = document;
    var alert_bg = _d.createElement("div");
    alert_bg.setAttribute("id", idtishi);
    alert_bg.setAttribute("class", "white_content");
    alert_bg.setAttribute("style", "display: none; position: fixed!important; top: 50%;left: 50%;width: 304px; height: 142px;z-index: 1002;_position:absolute;_top: expression(eval(document.compatMode && document.compatMode == 'CSS1Compat') ?documentElement.scrollTop + (document.documentElement.clientHeight - this.offsetHeight) / 2 : document.body.scrollTop + (document.body.clientHeight - this.clientHeight) / 2);overflow: hidden; margin:-75px 0 0 -152px; border:2px solid #7db8f0; background:#ffffff;");
    _d.body.appendChild(alert_bg);
    var _this = $("#" + idtishi);
    _this.html(txt).fadeIn(function () {
    });
    $("#" + idtishi).html("<div class=\"tuichubg\"><h1 class=\"tishi\">系统提示</h1><div class=\"guanbitc\"><img src=\"../content/images/hong.gif\" class=\"sdcq_tck_right_cha\" width=\"1\" height=\"16\" onclick=\"CloseDiv('" + idtishi + "','" + idfade + "')\" /></div><div class=\"clearfix\"></div></div><div class=\"tuichumain\"><div style=\"background: url(" + img + ") no-repeat;\" class=\"baocuncg\"></div> <span class=\"tuichune\">" + txt + "</span><div class=\"clearfix\"></div></div><div class=\"dialog-console\"><a class=\"console-btn-confirm\" href=\"javascript:\" onclick=\"CloseDiv('" + idtishi + "','" + idfade + "')\" >确定</a><div class=\"clearfix\"></div></div><div class=\"clearfix\"></div>");
}


//关闭弹出层
function CloseDiv(show_div, bg_div) {
    document.getElementById(show_div).style.display = 'none';
    document.getElementById(bg_div).style.display = 'none';
};
function ShowBJ(divfade) {
    var _b = document;
    var alert_bj = _b.createElement("div");
    alert_bj.setAttribute("id", divfade);
    alert_bj.setAttribute("class", "black_overlay");
    _b.body.appendChild(alert_bj);
    document.getElementById(divfade).style.display = 'block';
    var bgdiv = document.getElementById(divfade);
    bgdiv.style.width = document.body.scrollWidth;
    //$("#" + divfade).height($(document).height());
}
function sleep(numberMillis) { 
	var now = new Date(); 
	var exitTime = now.getTime() + numberMillis; 
	while (true) { 
	now = new Date(); 
	if (now.getTime() > exitTime) 
	return; 
	} 
	}

function _confirm(txt, imgtp, submit_fun, ndiv) {
    img = "../content/images/tanhao.jpg";
    if (imgtp == 0)
        img = "../content/images/tanhao.jpg";
    else if (imgtp == 1)
        img = "../content/images/shangbao.jpg";
    if ($("#" + idtique).length > 0) {
        $("#" + idtique).remove();
    }
    if (ndiv == 0) {
        ShowBJ('fade1');
        idfade = "fade1";
    } else {
        ShowBJ('fade');
        idfade = "fade";
    }
    var _d = document;
    var alert_bg = _d.createElement("div");
    alert_bg.setAttribute("id", idtique);
    alert_bg.setAttribute("class", "white_content");
    alert_bg.setAttribute("style", "display: none; position: absolute; top: 20%;left: 51%;width: 304px; height: 142px;z-index: 1002;overflow: hidden; margin:-75px 0 0 -152px; border:2px solid #7db8f0; background:#ffffff;");
    _d.body.appendChild(alert_bg);
    var _this = $("#" + idtique);
    _this.html(txt).fadeIn(function () {
    });
    $("#" + idtique).html("<div class=\"tuichubg\"><h1 class=\"tishi\">系统提示</h1><div class=\"guanbitc\"><img src=\"../content/images/hong.gif\" class=\"sdcq_tck_right_cha\" width=\"1\" height=\"16\" onclick=\"CloseDiv('" + idtique + "','" + idfade + "')\" /></div><div class=\"clearfix\"></div></div><div class=\"tuichumain\"><div style=\"background: url(" + img + ") no-repeat;\" class=\"baocuncg\"></div> <span class=\"tuichune\">" + txt + "</span><div class=\"clearfix\"></div></div><div class=\"dialog-console\"><a class=\"console-btn-cancel\" href=\"javascript:CloseDiv('" + idtique + "','" + idfade + "');\">取消</a><a class=\"console-btn-confirm\" id=\"btnconfirm\" href=\"javascript:" + submit_fun + ";\" >确定</a><div class=\"clearfix\"></div></div><div class=\"clearfix\"></div>");
    if (submit_fun == "tc") {
        $("#btnconfirm").bind("click",
           function () {
               submit_funTC();
           })
    } else if (ndiv == 0) {
        $("#btnconfirm").bind("click",
           function () {
               CloseDiv(idtique, 'fade1');
           })
    } else {
        $("#btnconfirm").bind("click",
           function () {
               CloseDiv(idtique, idfade);
           })
    }
}



function _back101(txt, imgtp, submit_fun, ndiv) {
    img = "../content/images/tanhao.jpg";
    if (imgtp == 0)
        img = "../content/images/tanhao.jpg";
    else if (imgtp == 1)
        img = "../content/images/shangbao.jpg";
    if ($("#" + idtique).length > 0) {
        $("#" + idtique).remove();
    }
    if (ndiv == 0) {
        ShowBJ('fade1');
        idfade = "fade1";
    } else {
        ShowBJ('fade');
        idfade = "fade";
    }
    var _d = document;
    var alert_bg = _d.createElement("div");
    alert_bg.setAttribute("id", idtique);
    alert_bg.setAttribute("class", "back_content");
    alert_bg.setAttribute("style", "display: none; position: absolute; top: 55%;left: 51%;width: 304px; height: 142px;z-index: 1002;overflow: hidden; margin:-75px 0 0 -152px; border:2px solid #7db8f0; background:#ffffff;");
    _d.body.appendChild(alert_bg);
    var _this = $("#" + idtique);
    _this.html(txt).fadeIn(function () {
    });
    $("#" + idtique).html("<div class=\"tuichubg\"><h1 class=\"tishi\">系统提示</h1><div class=\"guanbitc\"><img src=\"../content/images/hong.gif\" class=\"sdcq_tck_right_cha\" width=\"1\" height=\"16\" onclick=\"CloseDiv('" + idtique + "','" + idfade + "')\" /></div><div class=\"clearfix\"></div></div><div class=\"tuichumain\"><div style=\"background: url(" + img + ") no-repeat;\" class=\"baocuncg\"></div> <span class=\"tuichune\">" + txt + "</span><div class=\"clearfix\"></div></div><div class=\"dialog-console\"><a class=\"console-btn-cancel\" href=\"javascript:CloseDiv('" + idtique + "','" + idfade + "');\">取消</a><a class=\"console-btn-confirm\" id=\"btnconfirm\" href=\"javascript:" + submit_fun + ";\" >确定</a><div class=\"clearfix\"></div></div><div class=\"clearfix\"></div>");
    if (submit_fun == "tc") {
        $("#btnconfirm").bind("click",
           function () {
               submit_funTC();
           })
    } else if (ndiv == 0) {
        $("#btnconfirm").bind("click",
           function () {
               CloseDiv(idtique, 'fade1');
           })
    } else {
        $("#btnconfirm").bind("click",
           function () {
               CloseDiv(idtique, idfade);
           })
    }
}


function submit_funTC() {
    location.href = '../userLoginController/loginOut.do';
}
