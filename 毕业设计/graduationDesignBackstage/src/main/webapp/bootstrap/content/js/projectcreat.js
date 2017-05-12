var fund=1;//科研经费
function closeDiv(obj){
			$(obj).parent().css('display','none');
			$(obj).parent().parent().find('i').text('+');
			$(obj).parent().parent().find('h2').removeClass('on');
		}
/****************************************************************************************************/
/************************************************申报确认******************************************/
				function shangbao(){
					_confirm("确认申报？",1,"shangbaojia()");
					//alert(audit1);
					 // _confirm("确认申报？",1,"jia("+departmentID1+")");
					//if(confirm("确认申报？")){
						//shangbaojia(departmentID1,audit1,departmenttype);
					//}
				}
				function shangbaojia(){
					$.ajaxSettings.async=false;
		        	$.getJSON("../projectDeclareController/shangBaoSaveproject.do?departmentID1=1",{},function(data){
		    			if(data){
		    				_alert("申报成功!",1);
		    				//将数据取过来追加在第一行
		    				window.setTimeout(window.location.href="../projectDeclareController/toDeclareproject.do?audit1=0&flg=1", 2000);
		    				//window.location.href="../projectDeclareController/toDeclareproject.do?audit1=0&flg=1";
		    			}else{
		    				_alert("系统正在维护或者尝试重新登录。。。。。。",2);
		    			}
		    	    });
		    		$.ajaxSettings.async=true;
				}
/****************************************************************************************************/
/****************************************************************************************************/
/****************************************************************************************************/
/************************************************修改项目的数据回显**************************************/
		//关闭弹出层，清空弹出框，再隐藏
        function CloseDiv2(show_div, bg_div) {
        	//清空
        	$("#alterreasonForPurchase").val("");//科研主管人
        	$("#alterfundsTypeID").val(-1);//经费类型
        	$(".syt_lb_top_conment_txt").val("");
            document.getElementById(show_div).style.display = 'none';
            document.getElementById(bg_div).style.display = 'none';
        };
  		//弹出隐藏层并利用ajax获取数据后加载出数据
        function ShowDiv2(show_div, bg_div,projectID) {
    		$.ajaxSettings.async=false;
        	$.getJSON("../projectCreateController/findById.do?projectID="+projectID+"",{},function(data){
    			if(data){
    				$("#alterprojectID").val(projectID);//
    				$("#alterprojectApplicant").val(data.projectApplicant);//项目负责人
    	        	$("#altercontactInformation").val(data.contactInformation);//联系方式
    	        	$("#alterdepartmentID1").val(data.departmentID1);//一级审核部门
    	        	$("#alterprojectName").val(data.projectName);//采购项目
    	        	$("#alterspecModel").val(data.specModel);//规格型号
    	        	$("#alterprocurementDirectory").val(data.procurementDirectory);//采购目录
    	        	$("#alterfundsTypeID").val(data.fundsTypeID);//经费类型
    	        	if("".length==data.mangeName.length){
    	        		$("#altermangeName").val("");
    	            	$("#altermangeName").hide();
    	        	}else{
    	        		$("#altermangeName").show();
    	        		$("#altermangeName").val(data.mangeName);//科研主管人
    	        	}
    	        	$("#alterprojectUnivalent").val(data.projectUnivalent);//预算单价
    	        	$("#alterprojectAmount").val(data.projectAmount);//采购数量
    	        	$("#alterprojectUnit").val(data.projectUnit);//单位
    	        	if("".length==data.reasonForPurchase.length){
    	        		$("#alterreasonForPurchase").val("");
    	            	$("#alteraaa").hide();
    	        	}else{
    	        		$("#alteraaa").show();
    	        		$("#alterreasonForPurchase").val(data.reasonForPurchase);//科研主管人
    	        	}
    	        	//如果是驳回修改，添加反馈意见，创建人查看一级反馈意见，审核人查看二级反馈意见
    	        	if(userInfomationroleID==1 && data.audit1==3 && data.auditOpinion1!=null){
    	        		//创建人驳回修改
    	        		$("#alteradvice").show();
    	        		$("#advice").val(data.auditOpinion1);//科研主管人 
    	        	}else if(userInfomationroleID==2 && data.audit2==3 && data.auditOpinion2!=null){
    	        		$("#alteradvice").show();
    	        		$("#advice").val(data.auditOpinion2);//科研主管人
    	        	}
    	        	document.getElementById(show_div).style.display = 'block';
    	            document.getElementById(bg_div).style.display = 'block';
    	            var bgdiv = document.getElementById(bg_div);
    	            bgdiv.style.width = document.body.scrollWidth;
    	            $("#" + bg_div).height($(document).height());
    			}else{
    				_alert("系统出错没有获取到数据！",2);
    			}
    	    });
    		$.ajaxSettings.async=true;
        };

/***********************************************修改项目验证提交************************************************/
/****************************************************************************************************/
//修改项目的表单验证和提交
function altersave(audit1,audit2,flg,projectName,departmentID){
	if($("#alteradvice").is(":visible")){
		$("#alteradvice").show();
	}
	if(piliangpannull(
			"alterprojectApplicant","altercontactInformation",
 			"alterprojectUnit",
 			"altermangeName","alterreasonForPurchase",
 			"alterprojectUnivalent","alterprojectName",
 			"alterfundsTypeID",
 			"alterprojectAmount") &&
 	  regnum("alterprojectAmount") &&//判断数字 
 	  verifyPric("alterprojectUnivalent") &&//判断金额
 	  verifymobile("altercontactInformation") &&  //验证手机号
 	  xiaoguo("alterprojectName","alterprojectUnivalent",
 			  "alterreasonForPurchase","alteraaa","alterspecModel",
 			  "alterprocurementDirectory",$("#alterprojectID").val())){
		_confirm("请确认修改！",1,"altersavejia("+audit1+","+audit2+","+flg+","+projectName+","+departmentID+")");
		//if(confirm("请确认修改！")){
		//	altersavejia(audit1,audit2,flg,projectName,departmentID);
		//}
	}
}
function altersavejia(audit1,audit2,flg,projectName,departmentID){
	$.ajaxSettings.async=false;
	   $.getJSON("../projectCreateController/altersave.do?" +
			"projectID="+$("#alterprojectID").val()+"&" +//项目名称
			"projectName="+encodeURIComponent($("#alterprojectName").val())+"&" +//项目名称
			"fundsTypeID="+$("#alterfundsTypeID").val()+"&" +//经费类型
			"mangeName="+encodeURIComponent($("#altermangeName").val())+"&" +//科研经费主管人
			"projectApplicant="+encodeURIComponent($("#alterprojectApplicant").val())+"&" +//项目负责人
			"contactInformation="+$("#altercontactInformation").val()+"&" +//联系方式
			"procurementDirectory="+encodeURIComponent($("#alterprocurementDirectory").val())+"&" +//采购目录
			"specModel="+encodeURIComponent($("#alterspecModel").val())+"&" +//规格型号
			"projectAmount="+$("#alterprojectAmount").val()+"&" +//采购数量
			"projectUnit="+encodeURIComponent($("#alterprojectUnit").val())+"&" +//单位
			"projectUnivalent="+$("#alterprojectUnivalent").val()+"&" +//预算单价
			"budgetAmount="+$("#alterprojectUnivalent").val()*$("#alterprojectAmount").val()+"&" +//预算单价*采购数量
			"audit1="+audit1+"&" +//审核状态
			"reasonForPurchase="+encodeURIComponent($("#alterreasonForPurchase").val())+""//原因******
		,{},function(data){
			if(data){
				_alert("修改项目成功!",1);
				if(audit1==9){//一个上报修改，驳回修改
					//跳转项目创建界面
					window.location.href="../projectCreateController/toAddproject.do?projectName="+projectName+"&currentPage="+currentPage+"";
				}else if(audit1==8){
					//_alert("国资处",2);
					//跳转国资处审核界面../projectAuditController/getAuditDetialList.do?departmentID=${List.departmentID}&MethodId=3&state=${state}${audit1}
					window.location.href="../projectAuditController/getAuditDetialList.do?departmentID="+departmentID+"&MethodId=3&audit2="+projectName+"&currentPage="+currentPage+"";
				}else{
					//跳转申请人项目上报界面
					//alert("123"+flg);//../projectDeclareController/toAlterProject.do?departmentID1=${li.departmentID1 }&audit1=${audit1}&audit2=${audit2}&flg=${flg}"
					if(flg==1){
						//var intent=window.setTimeout(function(){
							window.location.href="../projectDeclareController/toAlterProject.do?&currentPage="+currentPage+"&departmentID1="+$("#alterdepartmentID1").val()+"&audit1="+audit1+"&flg="+flg+"";
						//},5000);
						//window.location.href="../projectDeclareController/toAlterProject.do?&currentPage="+currentPage+"&departmentID1="+$("#alterdepartmentID1").val()+"&audit1="+audit1+"&flg="+flg+"";
					}else{
						window.location.href="../projectDeclareController/toAlterProject.do?&currentPage="+currentPage+"&departmentID1="+$("#alterdepartmentID1").val()+"&audit1="+audit1+"";
					}
					
				}
						
			}else{
				_alert("提交失败，请尝试重登陆系统再提交!",2);
			}
		});	
		$.ajaxSettings.async=true;
}
/****************************************************************************************************/
/************************************************创建项目验证提交****************************************/
//创建项目前的表单验证和提交 
function creatsave(){
     if(piliangpannull("creatprojectApplicant","creatcontactInformation",
    		 			"creatprojectUnit",
    		 			"creatmangeName","creatreasonForPurchase",
    		 			"creatprojectUnivalent","creatprojectName",
    		 			"creatfundsTypeID","creatprojectAmount") && //批量判空
        regnum("creatprojectAmount") &&//判断数字 
        verifyPric("creatprojectUnivalent") &&//判断金额
        verifymobile("creatcontactInformation") &&//验证手机号
        xiaoguo("creatprojectName","creatprojectUnivalent","creatreasonForPurchase","aaa","creatspecModel","creatprocurementDirectory")){ //预算单价是否超过上限
        $.ajaxSettings.async=false;
    	$.getJSON("../projectCreateController/save.do?" +
    			"projectName="+encodeURIComponent($("#creatprojectName").val())+"&" +//项目名称
    			"fundsTypeID="+$("#creatfundsTypeID").val()+"&" +//经费类型
    			"mangeName="+encodeURIComponent($("#creatmangeName").val())+"&" +//科研经费主管人********
    			"projectApplicant="+encodeURIComponent($("#creatprojectApplicant").val())+"&" +//项目负责人
    			"contactInformation="+$("#creatcontactInformation").val()+"&" +//联系方式
    			"procurementDirectory="+encodeURIComponent($("#creatprocurementDirectory").val())+"&" +//采购目录
    			"specModel="+encodeURIComponent($("#creatspecModel").val())+"&" +//规格型号
    			"projectAmount="+$("#creatprojectAmount").val()+"&" +//采购数量
    			"projectUnit="+encodeURIComponent($("#creatprojectUnit").val())+"&" +//单位
    			"projectUnivalent="+$("#creatprojectUnivalent").val()+"&" +//预算单价
    			"budgetAmount="+$("#creatprojectUnivalent").val()*$("#creatprojectAmount").val()+"&" +//预算单价*采购数量
    			"reasonForPurchase="+encodeURIComponent($("#creatreasonForPurchase").val())+""//原因******
    	,{},function(data){
    		if(data){
    			_alert("保存成功！",1);//data.projectID	
    			window.location.href="../projectCreateController/toAddproject.do?projectApplicant="+$("#creatprojectApplicant").val()+"&contactInformation="+$("#creatcontactInformation").val()+"";
    		}else{
    			_alert("提交失败，请尝试重登陆系统再提交!",2);
    		}
    		
        });	
    	$.ajaxSettings.async=true;
     }
}
/****************************************************************************************************/
/****************************************************************************************************/
//验证名称和参数和采购目录
function verifyNameAndModel(id1,id5,id6){
	var data=verifyUnivalent("../projectCreateController/getPric.do",$.trim($("#"+id1+"").val()),$.trim($("#"+id5+"").val()),$.trim($("#"+id6+"").val()));
	if(data!=null){
		return true;
	}else{
		return false;
	}
}

//判预算单价是否超过上限
function panduancunzai(projectName,id2,id3,id4,specModel){
	var data=verifyUnivalent("../projectCreateController/getPricUpperLimit.do",$("#"+projectName+"").val(),$("#"+specModel+"").val(),"");
	if($("#"+id2+"").val()<=data){
		return true;
	}else{
		return false;
	}
}
//xiaoguo("creatprojectName","creatprojectUnivalent","creatreasonForPurchase","aaa","creatspecModel","creatprocurementDirectory")
//显示效果
function xiaoguo(id1,id2,id3,id4,id5,id6,projectID){
	 if(verifyNameAndModel(id1,id5,id6) &&
       panduancunzai(id1,id2,id3,id4,id5)){ //预算单价是否超过上限
		 if($("#"+id4+"").is(":visible")){
				$("#"+id3+"").val("");
				$("#"+id4+"").hide();
			} 
			return true;
	 }else{
		 if($("#"+id4+"").is(":hidden")){
				_alert("特殊项目说明不允许为空!",2);
				$("#"+id3+"").val("");
				$("#"+id4+"").show();
				return false;
			}
			if(verifynull(id3)){
				return true;
			}
	 }
}
/**********************************************************************************/
/**********************************************************************************/
var Directory,projectName;
function dd(obj){
	projectName=$(obj).attr("data-id");
	Directory=$(obj).parent().parent().prev().attr("id");
	//alert($(obj).attr("data-id"));
	//alert($(obj).parent().parent().prev().attr("id"));
}
//根据选择设置名称、价格、型号
function aa(){
	//alert($(this).attr("data-id"));
	//alert($("input[name='c1']:checked").parent().text());
	$("#creatspecModel").val($("input[name='c1']:checked").parent().text());
	//$("input[name='c1']:checked").val()Directory
	//$("#creatprojectName").val($("input[name='c1']:checked").parent().parent().prev().attr("data-id"));
	$("#creatprojectName").val(projectName);
	//$("#creatprocurementDirectory").val($("input[name='c1']:checked").parent().parent().parent().parent().prev().attr("id"));
	$("#creatprocurementDirectory").val(Directory);
	//ajax异步提交设置值
	
	var data=verifyUnivalentbyId("../projectCreateController/findByconfigAndPricId.do",$("input[name='c1']:checked").val());
	//var data=verifyUnivalent("../projectCreateController/getPric.do",$("#creatprojectName").val(),$("#creatspecModel").val());
	if(data){
		if($("#aaa").is(":visible")){
			$("#creatreasonForPurchase").val("");
			$("#aaa").hide();
		}
	}else{
		//没有找到我会尝试用目录和名称去找
		$.getJSON("../projectCreateController/findUnivalent.do?configName="+$("#creatprojectName").val()+"&procurementDirectory="+$("#creatprocurementDirectory").val()+"",{},function(data){
			if(data!=-1){
				$("#creatprojectUnivalent").val(data);
				if($("#aaa").is(":visible")){
					$("#creatreasonForPurchase").val("");
					$("#aaa").hide();
				}
			}else{
				if($("#aaa").is(":hidden")){
					$("#creatreasonForPurchase").val("");
					$("#aaa").show();
				}
			}
	    });	
	}
	$("#creatprojectUnivalent").val(data.projectUnivalent);
	$(".cp span").parent().parent().remove();
}
//
function verifyUnivalent(url,configName,specModle,procurementDirectory){//procurementDirectory
	var flag=0;
	$.ajaxSettings.async=false;
	$.getJSON(""+url+"?configName="+encodeURIComponent(configName)+"&specModle="+encodeURIComponent(specModle)+"&procurementDirectory="+encodeURIComponent(procurementDirectory)+"",{},function(data){
		flag=data;
    });	
	$.ajaxSettings.async=true;
	return flag;
}
//价格是否合法验证
function verifyUnivalentbyId(url,figAndPricId){
	var flag=0;
	$.ajaxSettings.async=false;
	$.getJSON(""+url+"?figAndPricId="+figAndPricId+"",{},function(data){
		flag=data;
    });	
	$.ajaxSettings.async=true;
	return flag;
}
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
//判空验证
function verifynull(id){
	if($("#"+id+"").is(":visible") && $("#"+id+"").val()==""){
		if(id=="creatmangeName" || id=="altermangeName"){
			_alert("科研经费主管人不允许为空!",2);
		}else{
			_alert(""+$("#"+id+"").parent().prev().text()+"不允许为空!",2);
		}
		return false;
	}else{
		return true;
	}
}
//经费类型判空验证
function verifyTypeID(id){
	if($("#"+id+"").is(":visible") && $("#"+id+"").val()==-1){
		_alert("请选择经费类型!",2);
		return false;
	}else{
		return true;
	}
}
//批量判空验证
function piliangpannull(id1,id2,id3,id5,id6,id7,id8,id10,id11){
	//判空
	if(verifynull(id1) && verifynull(id2) && verifynull(id3) && 
	   verifynull(id5) && verifynull(id6) && 
	   verifynull(id7) && verifynull(id8) &&
	   verifyTypeID(id10) && verifynull(id11)){
	   return true;
	}
	return false;
}
//当是科研经费时显示主管人框框
function kk(id,name){
	if($("#"+id+" option:selected").val()!=1){//
		$("#"+name+"").val("");
		$("#"+name+"").hide();	
		$("#zhuguanrenbitian").hide();	
	}else{
		$("#"+name+"").val("");
		$("#"+name+"").show();	
		$("#zhuguanrenbitian").show();	
	}
}
//将所有控件至空
function reset(){
	$(".syt_lb_top_conment_txt").val("");
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