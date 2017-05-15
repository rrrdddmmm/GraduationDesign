$(function() {
	$(".btn_submit").click(function() {
		login();
	});
	$(".btn_reset").click(function() {
		$("#email").val("");
		$("#password").val("");
		$("#role").val("");
	});
});
function login() {
	if ($("#email").attr("value") == "" || 
		$("#password").attr("value") == "" || 
		$("#role").attr("value") == "-1") {
		_alert("用户名和密码和角色不为空",2);
		return;
	} else if(!varifyEmail($.trim($("#email").val()))){
		_alert("请输入正确邮箱!",2);
	}else{
		$.ajax({
			type : "POST",
			url : "../userLoginController/loginHandle.do",
			data : "email=" + $.trim($("#email").val())+
				   "&password=" + $.md5($.trim($("#password").val()))+
			       "&role=" + $.trim($("#role").val()),
			dataType : "json",
			error : function() {
				_alert("错误输出",2);
			},
			success : function(result) {
				//解析返回的JSON结果
      		  	if(result.status==0){//成功 		  		
      		  	window.location.href = "../commonController/toDefault.do";
				$("#email").val("");
				$("#password").val("");
				$("input[name='role']:checked").val("-1");
      		  	}else {
      		  	_alert(result.msg,2);
					return;
				}
			}
		})
	}
}
function varifyEmail(email){
  //对电子邮件的验证
  var myreg =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/
  if(!myreg.test(email)){
    return false;
  }
  return true;
}
