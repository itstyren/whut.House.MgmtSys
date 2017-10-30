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
		$("#staffWorkDeptPramaGet").click(function () {
			ajaxRequestGet("staffParam/get/5");
		})
		
		$("#staffDutyPramaGet").click(function () {
			ajaxRequestGet("staffParam/get/6");
		})
		
		$("#staffJobTitlePramaGet").click(function () {
			ajaxRequestGet("staffParam/get/7");
		})
		
		$("#staffTypePramaGet").click(function () {
			ajaxRequestGet("staffParam/get/8");
		})
		
		$("#staffWorkStatusPramaGet").click(function () {
			ajaxRequestGet("staffParam/get/9");
		})
		
		$("#staffSpouseDeptNaturePramaGet").click(function () {
			ajaxRequestGet("staffParam/get/10");
		})
		
		$("#staffPramaDelete").click(function () {
			ajaxRequestPostType("staffParam/delete/3","DELETE",null);
		})
		
		$("#staffPramaAdd").click(function () {
			var data={'staffParamName':'党员', 'paramTypeId':5, 'paramTypeName':'工作部门'};
			ajaxRequestPostType("staffParam/add","POST",data);
		})
		
		$("#staffPramaModify").click(function () {
			var data={'staffParamId':165, 'staffParamName':'修改测试', 'paramTypeId':5, 'paramTypeName':'工作部门'};
			ajaxRequestPostType("staffParam/modify","PUT",data);
		})
	})
	
	
</script>

</head>
<body>
	<h4>StaffParameterGetTest</h4>
	<input type="button" value="StaffWorkDeptPramaGet" id="staffWorkDeptPramaGet" />
	<br>
	<br>
	<input type="button" value="StaffDutyPramaGet" id="staffDutyPramaGet" />
	<br>
	<br>
	<input type="button" value="StaffJobTitlePramaGet" id="staffJobTitlePramaGet" />
	<br>
	<br>
	<input type="button" value="StaffTypePramaGet" id="staffTypePramaGet" />
	<br>
	<br>
	<input type="button" value="StaffWorkStatusPramaGet" id="staffWorkStatusPramaGet" />
	<br>
	<br>
	<input type="button" value="StaffSpouseDeptNaturePramaGet" id="staffSpouseDeptNaturePramaGet" />
	<h4>StaffParameterDeleteTest</h4>
	<input type="button" value="StaffPramaDelete" id="staffPramaDelete" />
	<h4>StaffParameterAddTest</h4>
	<input type="button" value="StaffPramaAdd" id="staffPramaAdd" />
	<h4>StaffParameterModifyTest</h4>
	<input type="button" value="StaffPramaModify" id="staffPramaModify" />
</body>
</html>