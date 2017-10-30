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
		$("#empWorkDeptPramaGet").click(function () {
			ajaxRequestGet("getEmployeeParameter/5");
		})
		
		$("#empDutyPramaGet").click(function () {
			ajaxRequestGet("getEmployeeParameter/6");
		})
		
		$("#empJobTitlePramaGet").click(function () {
			ajaxRequestGet("getEmployeeParameter/7");
		})
		
		$("#empTypePramaGet").click(function () {
			ajaxRequestGet("getEmployeeParameter/8");
		})
		
		$("#empWorkStatusPramaGet").click(function () {
			ajaxRequestGet("getEmployeeParameter/9");
		})
		
		$("#empSpouseDeptNaturePramaGet").click(function () {
			ajaxRequestGet("getEmployeeParameter/10");
		})
		
		$("#empPramaDelete").click(function () {
			ajaxRequestPostType("deleteEmployeeParameter/3","DELETE",null);
		})
		
		$("#empPramaAdd").click(function () {
			var data={'employeeParamName':'党员', 'paramTypeId':5, 'paramTypeName':'工作部门'};
			ajaxRequestPostType("addEmployeeParameter","POST",data);
		})
		
		$("#empPramaModify").click(function () {
			var data={'employeeParamId':165, 'employeeParamName':'修改测试', 'paramTypeId':5, 'paramTypeName':'工作部门'};
			ajaxRequestPostType("modifyEmployeeParameter","PUT",data);
		})
	})
	
	
</script>

</head>
<body>
	<h4>EmployeeParameterGetTest</h4>
	<input type="button" value="EmpWorkDeptPramaGet" id="empWorkDeptPramaGet" />
	<br>
	<br>
	<input type="button" value="EmpDutyPramaGet" id="empDutyPramaGet" />
	<br>
	<br>
	<input type="button" value="EmpJobTitlePramaGet" id="empJobTitlePramaGet" />
	<br>
	<br>
	<input type="button" value="EmpTypePramaGet" id="empTypePramaGet" />
	<br>
	<br>
	<input type="button" value="EmpWorkStatusPramaGet" id="empWorkStatusPramaGet" />
	<br>
	<br>
	<input type="button" value="EmpSpouseDeptNaturePramaGet" id="empSpouseDeptNaturePramaGet" />
	<h4>EmployeeParameterDeleteTest</h4>
	<input type="button" value="EmpPramaDelete" id="empPramaDelete" />
	<h4>EmployeeParameterAddTest</h4>
	<input type="button" value="EmpPramaAdd" id="empPramaAdd" />
	<h4>EmployeeParameterModifyTest</h4>
	<input type="button" value="EmpPramaModify" id="empPramaModify" />
</body>
</html>