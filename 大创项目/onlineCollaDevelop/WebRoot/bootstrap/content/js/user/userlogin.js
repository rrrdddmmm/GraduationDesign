$(function() {
	$(".btn_submit").click(function() {
		login();
	});
	$(".btn_reset").click(function() {
		$("#uname").val("");
		$("#upwd").val("");
	});
});
function login() {
	if ($("#uname").attr("value") == "" || $("#upwd").attr("value") == "") {
		_alert("用户名和密码不为空",2);
		return;
	} else {
		$.ajax({
			type : "POST",
			url : "../loginController/loginDealwith.do",
			data : "loginName=" + $.trim($("#uname").val())+"&loginPwd=" + $.md5($.trim($("#upwd").val())),
			dataType : "json",
			error : function() {
				// alert("出错了");
			},
			success : function(response) {
				if (response=="3") {
					window.location.href = "../toPageController/toDefault.do";
					$("#uname").val("");
					$("#upwd").val("");
					
				} else {
					_alert(response,2);
					return;
				}
			}
		})
	}
}
