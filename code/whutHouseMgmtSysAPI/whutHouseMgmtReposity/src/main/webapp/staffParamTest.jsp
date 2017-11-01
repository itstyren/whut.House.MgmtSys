<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("API_Path", request.getContextPath());
%>

<script type="text/javascript"
	src="${API_Path }/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	//模拟Get请求
	function ajaxRequestGet(uri) {
		//alert("${API_Path }/" + uri);
		$.ajax({
			url : uri,
			type:"get",
			contentType : 'application/json',
			dataType : 'json',
			success : function(response) {
				console.log(response);
			},
			error : function() {
				console.log('Ajax请求失败！');
			}
		});
	}
	
	//模拟Post类请求
	function ajaxRequestPostType(uri,method,data) {
		//alert("${API_Path }/" + uri);
		$.ajax({
			type: method,
			contentType : 'application/json;charset=UTF-8',
			dataType : 'json',
			data : JSON.stringify(data),
			url : uri,
			success : function(response) {
				console.log(response);
			},
			error : function() {
				console.log('Ajax请求失败！');
			}
		});
	}
	
	$(function () {
		$("#staffWorkDeptParamGet").click(function () {
			ajaxRequestGet("staffParam/get/5?page=10&size=3");
		})
		
		$("#staffDutyParamGet").click(function () {
			ajaxRequestGet("staffParam/get/6");
		})
		
		$("#staffJobTitleParamGet").click(function () {
			ajaxRequestGet("staffParam/get/7");
		})
		
		$("#staffTypeParamGet").click(function () {
			ajaxRequestGet("staffParam/get/8");
		})
		
		$("#staffWorkStatusParamGet").click(function () {
			ajaxRequestGet("staffParam/get/9");
		})
		
		$("#staffSpouseDeptNatureParamGet").click(function () {
			ajaxRequestGet("staffParam/get/10");
		})
		
		$("#staffParamDelete").click(function () {
			//var data={'staffParamId':189};
			ajaxRequestPostType("staffParam/delete/189","DELETE",null);
		})
		
		$("#staffParamAdd").click(function () {
			var data={'staffParamName':'党员','paramTypeId':5,'paramTypeName':'工作部门'};
			ajaxRequestPostType("staffParam/add","POST",data);
		})
		
		$("#staffParamModify").click(function () {
			var data={'staffParamId':187,'staffParamName':'修改测试3','paramTypeId':5,'paramTypeName':'工作部门'};
			ajaxRequestPostType("staffParam/modify","PUT",data);
		})
	})
	
	
</script>

</head>
<body>
	<h4>获取职工参数</h4>
	<input type="button" value="StaffWorkDeptParamGet" id="staffWorkDeptParamGet" />
	<br>
	<br>
	<input type="button" value="StaffDutyParamGet" id="staffDutyParamGet" />
	<br>
	<br>
	<input type="button" value="StaffJobTitleParamGet" id="staffJobTitleParamGet" />
	<br>
	<br>
	<input type="button" value="StaffTypeParamGet" id="staffTypeParamGet" />
	<br>
	<br>
	<input type="button" value="StaffWorkStatusParamGet" id="staffWorkStatusParamGet" />
	<br>
	<br>
	<input type="button" value="StaffSpouseDeptNatureParamGet" id="staffSpouseDeptNatureParamGet" />
	<h4>删除职工参数</h4>
	<input type="button" value="StaffParamDelete" id="staffParamDelete" />
	<h4>添加职工参数</h4>
	<input type="button" value="StaffParamAdd" id="staffParamAdd" />
	<h4>修改职工参数</h4>
	<input type="button" value="StaffParamModify" id="staffParamModify" />
</body>
</html>