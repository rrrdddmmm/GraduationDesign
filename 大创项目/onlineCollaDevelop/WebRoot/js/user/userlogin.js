$(function() {
	$(".btn_submit").click(function() {
		login();
	});
	$(".btn_reset").click(function() {
		$("#username").val("");
		$("#email").val("");
		$("#role").value("");
	});
});
function login() {
	if ($("#username").attr("value") == "" || $("#email").attr("value") == "") {
		alert("用户名和邮箱不为空",2);
		return;
	} else {
		$.ajax({
			type : "POST",
			url : "../loginController/checkLogin.do",
			data : "username=" + $.trim($("#username").val())+
			"&email=" + $.trim($("#email").val()+"&role="+$.trim($("#role"))),
			dataType : "json",
			error : function() {
			 alert("出错了");
			},
			success : function(response) {
				if (response=="3") {
					window.location.href = "../loginController/toIndex.do";
					$("#username").val("");
					$("#email").val("");
					
				} else {
					alert(response,2);
					return;
				}
			}
		})
	}
}
