function callback() {
	history.back();
};
function Search() {
    InitForm();
};
function firstStep() {
    $("#tb").find("tbody").empty();
    $("#loading").show();
    setTimeout(function () { InitForm(); }, 300);
}
function InitForm() {
    var txt_Branch = $("#txt_Branch").val();
    var state = $("#state").val();
    var roleid = $("#roleid").val();
    $("#loading").show();
    $.ajax({
        type: "POST",
        url: "",
        data: "func=UserList&pageSize=" + pageSize + "&currentPage=" + currentPage
            + "&txt_Branch=" + txt_Branch + "&state=" + state + "&roleid=" + roleid,
        dataType: "json",
        error: function () {
            // alert("出错了");
        },
        success: function (data) {
            if (data == "-2") {
                _alert("登录过期请重新登录",2);
                window.parent.location.href = "/Login.aspx?Out=A";
            }
            else {
                currentPage = data.currentPage;
                dataCount = data.dataCount;
                maxPage = data.maxPage;
                PagerInit("pager");
                $(".message").html("共<i class=\"blue\">" + dataCount + "</i>条记录，当前显示第" + currentPage + "</i>页");
                $("#tb").find("tbody").empty();
                $("#tb").find("tbody").append(data.dataHtml);
                $("#loading").hide();
            }
        }
    });
}
function GetOption() {
    $.ajax({
        type: "POST",
        url: "/Ajax/UserHandler.ashx",
        data: {
            func: "GetOption"
        },
        dataType: "text",
        error: function () {
            //alert("出错了"); 
        },
        success: function (data) {
            $("#branch").empty();
            $("#branch").append(data);
        }
    });
};


function Role() {
    $("#uname").val("");
    if ($("#branch").val() > 0){
    		if($("#roleid").val() > 0){
    			 $("#uname").val($("#branch").find("option:selected").text() + $("#roleid").find("option:selected").text());
    			}
    		else{
    			$("#uname").val($("#branch").find("option:selected").text())
    		}
    	}
}
function BranchChange() {
    $("#uname").val("");
    $("#roleid").val(0)
    Role();
}
function GetData() {
    id = $("#id").val();
    $.ajax({
        type: "POST",
        url: "",//部门列表
        data: "func=GetOption",
        dataType: "text",
        error: function () {
            //alert("出错了");
        },
        success: function (data) {
            $("#branch").empty();
            $("#branch").append(data);
            if (id > 0) {
                $.ajax({
                    type: "POST",
                    url: "",//个人信息
                    data: "func=GetData&id=" + id,
                    dataType: "json",
                    error: function () {
                        //alert("出错了！"); 
                    },
                    success: function (data) {
                        $("#branch").val(data.data.DepartmentID);
                        $("#uname").val(data.data.UserName);
                        $("#roleid").val(data.data.RoleID);
                        if (data.data.State == 2) {
                            $("input[name='state']:eq(1)").attr("checked", 'checked');
                        }
                    }
                });
            }
        }
    });
};

//function save() {
//    if (branch()&&roleid()) {
//    	 $.ajax({
//    	        type: "POST",
//    	        url: "",
//    	        data: {
//    	            func: "saveuser",
//    	            id: $("#id").val(),
//    	            branch: $("#branch").val(), 
//    	            state: $("input[name='state']:checked").val(), 
//    	            uname: $.trim($("#uname").val()), 
//    	            upwd: $.md5($.trim($("#upwd").val())), 
//    	            roleid: $("#roleid").val(),	
//    	        },
//    	        dataType: "text",
//    	        error: function () {
//    	            //alert("出错了"); 
//    	        },
//    	        success: function (data) {
//    	        	alert(response);
//    	            if ($("#id").val() < 1) {
//    	                $("#roleid").val(-1);
//    	                $("#branch").val(-1);
//    	                $("#uname").val("");
//    	                $("#upwd").val("");
//    	                $("input[name='state']:eq(0)").attr("checked", 'checked');
//    	                $(".yzcg").hide();
//    	                $(".yzsb").hide();
//    	            }
//    	        }
//    	    });
//    }
//};
