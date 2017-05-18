//电话号码验证
function verifymobile(id){
	var reg=/^1\d{10}$|^(0\d{2,3}-?|\(0\d{2,3}\))?[1-9]\d{4,7}(-\d{1,8})?$/;
    var result= reg.test($("#"+id+"").val());
    if(!result){
        _alert("请填写正确电话号码格式！",2);
        $("#"+id+"").val("");
		return false;
    }
	return true;
}
//金额验证
function verifyPric(id){
    var reg=/^[0-9]*.{0,1}[0-9]*[0-9]$/;
    var result= reg.test($("#"+id+"").val());
    if(!result){
        _alert("请填写正确金额格式！",2);
        $("#"+id+"").val("");
		return false;
    }
	return true;
}
//数字验证
function regnum(id){
    var reg=/^[0-9]*[0-9]*[0-9]$/;
    var result= reg.test($("#"+id+"").val());
    if(!result){
        _alert("请填写正确数量格式！",2);
        $("#"+id+"").val("");
		return false;
    }
	return true;
}
//对电子邮件的验证
function varifyEmail(email){
	  //对电子邮件的验证
	  var myreg =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/
	  if(!myreg.test($.trim($("#email").val()))){
		_alert("请填写正确邮箱格式！",2);
	    return false;
	  }
	  return true;
	}
//判空验证
function verifynull(id){
	if($("#"+id+"").is(":visible") && $("#"+id+"").val()==""){
		_alert(""+$("#"+id+"").parent().prev().text()+"不允许为空!",2);
		return false;
	}else{
		return true;
	}
}