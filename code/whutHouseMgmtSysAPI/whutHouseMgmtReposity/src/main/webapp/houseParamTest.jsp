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
		$("#houseParamGet").click(function () {
			ajaxRequestGet("houseParam/get/1");

		})
		
		$("#houseParamDelete").click(function () {
			var data={'houseParamId':5};
			ajaxRequestPostType("houseParam/delete","DELETE",data);
		})
		
		$("#houseParamAdd").click(function () {
			var data={'houseParamName':'测试房1', 'paramTypeId':1, 'paramTypeName':'住房类型'};
			ajaxRequestPostType("houseParam/add","POST",data);
		})
		
		$("#houseParamModify").click(function () {
			var data={'houseParamId':8, 'houseParamName':'修改测试', 'paramTypeId':2, 'paramTypeName':'户型'};
			ajaxRequestPostType("houseParam/modify","PUT",data);
		})
	})
	
	$(function () {
		$("#fixParamGet").click(function () {
			ajaxRequestGet("fixParam/get/20");
		})
		
		$("#fixParamDelete").click(function () {
			var data={'fixParamDelete':1};
			ajaxRequestPostType("fixParam/delete","DELETE",data);
		})
		
		$("#fixParamAdd").click(function () {
			var data={'fixParamName':'测试维修', 'paramTypeId':20, 'paramTypeName':'维修内容'};
			ajaxRequestPostType("fixParam/add","POST",data);
		})
		
		$("#fixParamModify").click(function () {
			var data={'fixParamId':1, 'fixParamName':'修改测试', 'paramTypeId':20, 'paramTypeName':'维修内容'};
			ajaxRequestPostType("fixParam/modify","PUT",data);
		})
	})
	
	$(function () {
		$("#rentalParamGet").click(function () {
			ajaxRequestGet("rentalParam/get/21");
		})
		
		$("#rentalParamDelete").click(function () {
			var data={'rentalParamDelete':1};
			ajaxRequestPostType("rentalParam/delete","DELETE",data);
		})
		
		$("#rentalParamAdd").click(function () {
			var data={'rentalParamName':'租金参数内容测试', 'paramTypeId':23, 'paramTypeName':'新老职工如何划分'};
			ajaxRequestPostType("rentalParam/add","POST",data);
		})
		
		$("#rentalParamModify").click(function () {
			var data={'rentalParamId':1, 'rentalParamName':'修改测试', 'paramTypeId':21, 'paramTypeName':'划分'};
			ajaxRequestPostType("rentalParam/modify","PUT",data);
		})
	})
	
</script>

</head>
<body>
	<h4>HouseParameterGetTest</h4>
	<input type="button" value="HouseParamGet" id="houseParamGet" />
	<input type="button" value="HouseParamDelete" id="houseParamDelete" />
	<input type="button" value="HouseParamAdd" id="houseParamAdd" />
	<input type="button" value="HouseParamModify" id="houseParamModify" />
	
	<hr>
	<h4>FixParameterGetTest</h4>
	<input type="button" value="FixParamGet" id="fixParamGet" />
	<input type="button" value="FixParamDelete" id="fixParamDelete" />
	<input type="button" value="FixParamAdd" id="fixParamAdd" />
	<input type="button" value="FixParamModify" id="fixParamModify" />
	
	<hr>
	<h4>RentalParameterGetTest</h4>
	<input type="button" value="RentalParamGet" id="rentalParamGet" />
	<input type="button" value="RentalParamDelete" id="rentalParamDelete" />
	<input type="button" value="RentalParamAdd" id="rentalParamAdd" />
	<input type="button" value="RentalParamModify" id="rentalParamModify" />
</body>
</html>