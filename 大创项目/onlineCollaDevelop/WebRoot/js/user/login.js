$(function(){
	$(".confirm").click(function() {
		var username = $("#username").val().trim();
      	var email = $("#email").val().trim();
      	var role=$("#role").val().trim();
      	//检测数据格式合法性
      	var flag = true;//通过检测
      	if(name==""){
      		$("#warning_1").html("2-16个字符，推荐使用中文");
      		flag = false;//未通过检测
      	}
      	if(password==""){
      		$("#warning_2").html("请输入注册时的电子邮箱");
      		flag = false;//未通过检测
      	}if(role==""){
      		$("#role").html("请选择角色");
      	}
      	
      	//通过检测，发送Ajax请求
      	if(flag){
      		$.ajax({
      		  url:"http://localhost:8080/login/logIn.do",
      		  type:"post",
      		  dataType:"json",
      		  data : "username=" + $.trim($("#username").val())+
			"&email=" + $.trim($("#email").val()+"&role="+$.trim($("#role"))),
      		  },
      		  success:function(result){
      		  	//解析返回的JSON结果
      		  	if(result.status==0){//成功 		  		
      		  		window.location.href="index.jsp";
      		  	}else if(result.status==1){//用户错误
      		  		$("#name_msg").html(result.msg);
      		  	}else if(result.status==2){//邮箱错误
      		  		$("#password_msg").html(result.msg);
      		  	}
      		  },
      		  error:function(){
      		  	alert("登录异常");
      		  }
      		});
      	}
      });
	});
	$(".btn_reset").click(function() {
		$("#username").val("");
		$("#email").val("");
		$("#role").val("");
	});
 
});