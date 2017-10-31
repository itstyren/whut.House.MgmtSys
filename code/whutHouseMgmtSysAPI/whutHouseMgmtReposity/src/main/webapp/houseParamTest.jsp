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
			ajaxRequestGet("houseParam/get/2?pn=5");
		})
		
		$("#houseParamDelete").click(function () {
			ajaxRequestPostType("houseParam/delete/3","DELETE",null);
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
			ajaxRequestGet("fixParam/get/20?pn=1");
		})
		
		$("#fixParamDelete").click(function () {
			ajaxRequestPostType("fixParam/delete/3","DELETE",null);
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
	
	
</script>

</head>
<body>
	<h4>HouseParameterGetTest</h4>
	<input type="button" value="HouseParamGet" id="houseParamGet" />
	<h4>HouseParameterDeleteTest</h4>
	<input type="button" value="HouseParamDelete" id="houseParamDelete" />
	<h4>HouseParameterAddTest</h4>
	<input type="button" value="HouseParamAdd" id="houseParamAdd" />
	<h4>HouseParameterModifyTest</h4>
	<input type="button" value="HouseParamModify" id="houseParamModify" />
	
	<hr>
	<h4>FixParameterGetTest</h4>
	<input type="button" value="FixParamGet" id="fixParamGet" />
	<input type="button" value="FixParamDelete" id="fixParamDelete" />
	<input type="button" value="FixParamAdd" id="fixParamAdd" />
	<input type="button" value="FixParamModify" id="fixParamModify" />
	
</body>
</html>