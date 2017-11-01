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
		$("#rentParamGet").click(function () {
			ajaxRequestGet("rentParam/get/15");
		})
		
		$("#rentParamModify").click(function () {
			var data={"rentParamId":1,"rentParamName":"否","paramTypeId":"15","paramTypeName":"是否开始选房","isDelete":"false"}
			ajaxRequestPostType("rentParam/modify","PUT",data);
		})
		
		$("#rentParamDelete").click(function () {
			//var data={"rentParamId":2}
			ajaxRequestPostType("rentParam/delete/7","DELETE",null);
		})
		
		$("#rentParamAdd").click(function () {
			var data={"rentParamName":"否","paramTypeId":"15","paramTypeName":"是否开始选房","isDelete":"false"}
			ajaxRequestPostType("rentParam/add","POST",data);
		})
		
	})
	
</script>

</head>
<body>
	
	<h4>租赁参数获取测试</h4>
	<input type="button" value="RentParamGet" id="rentParamGet"/>
	<br>
	<h4>租赁参数修改测试</h4>
	<input type="button" value="RentParamModify" id="rentParamModify"/>
	<br>
	<h4>租赁参数删除测试</h4>
	<input type="button" value="RentParamDelete" id="rentParamDelete"/>
	<br>
	<h4>租赁参数增添测试</h4>
	<input type="button" value="RentParamAdd" id="rentParamAdd"/>
	
	
</body>
</html>