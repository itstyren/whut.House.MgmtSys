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
		$("#rentEventGet").click(function () {
			ajaxRequestGet("rentEvent/get?page=1&size=3");
		})
		
		$("#rentEventModify").click(function () {
			var data={"rentEventId":3,"paramTypeId":"15","paramTypeName":"选房选项","rentIsOpenSel":"否","rentTimeBegin":new Date(),"isDelete":"false"}
			ajaxRequestPostType("rentEvent/modify","PUT",data);
		})
		
		$("#rentEventDelete").click(function () {
			//var data={"rentParamId":2}
			ajaxRequestPostType("rentEvent/delete/2","DELETE",null);
		})
		
		$("#rentEventAdd").click(function () {
			var data={"paramTypeId":"15","paramTypeName":"选房选项","rentIsOpenSel":"否","rentTimeBegin":new Date(),"isDelete":"false"}
			ajaxRequestPostType("rentEvent/add","POST",data);
		})
		
	})
	
</script>
</head>
<body>
	
	<h4>租赁历史获取测试</h4>
	<input type="button" value="RentEventGet" id="rentEventGet"/>
	<br>
	<h4>租赁历史修改测试</h4>
	<input type="button" value="RentEventModify" id="rentEventModify"/>
	<br>
	<h4>租赁历史删除测试</h4>
	<input type="button" value="RentEventDelete" id="rentEventDelete"/>
	<br>
	<h4>租赁历史增添测试</h4>
	<input type="button" value="RentEventAdd" id="rentEventAdd"/>
	
</body>
</html>