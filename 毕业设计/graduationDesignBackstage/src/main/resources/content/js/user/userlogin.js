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
		alert("用户名和密码不为空");
		return;
	} else {
		location.href = "default.html";
		/*
		$.ajax({
			type : "POST",
			url : "../loginController/loginDealwith.do",
			data : "username=" + $.trim($("#uname").val())
					+ "userpass=" + $.md5($.trim($("#upwd").val())),
			dataType : "json",
			error : function() {
				// alert("出错了");
			},
			success : function(response) {
				if (response != "") {
					alert(response);
					return;
				} else {
					window.location.href = "../toPageController/toDefault.do";
					$("#uname").val("");
					$("#upwd").val("");
				}
			}
		})
		*/
	}
}
