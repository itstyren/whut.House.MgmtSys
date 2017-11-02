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
		$("#rentParamAboutStaffGet").click(function () {
			ajaxRequestGet("rentParamAboutStaff/get/11?page=2&size=4");
		})
		
		$("#rentParamAboutStaffModify").click(function () {
			var data={"staffParamId":88,"staffParamName":"否","paramTypeId":6,"paramTypeName":"职务","staffParamVal":70,"staffParamSpouseVal":3,"isDelete":"false"}
			ajaxRequestPostType("rentParamAboutStaff/modify","PUT",data);
		})
		
	})
	
</script>
</head>
<body>
	<h4>和职工有关的租赁参数获取测试</h4>
	<input type="button" value="rentParamAboutStaffGet" id="rentParamAboutStaffGet" />
	<br>
	<h4>和职工有关的租赁参数修改测试</h4>
	<input type="button" value="rentParamAboutStaffModify" id="rentParamAboutStaffModify" />
</body>
</html>