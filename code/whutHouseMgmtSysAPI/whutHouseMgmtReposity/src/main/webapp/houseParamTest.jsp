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
			type : "get",
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
	function ajaxRequestPostType(uri, method, data) {
		//alert("${API_Path }/" + uri);
		$.ajax({
			type : method,
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

	$(function() {
		$("#houseParamGet").click(function() {
			ajaxRequestGet("houseParam/get/1");

		})

		$("#houseParamDelete").click(function() {
			ajaxRequestPostType("houseParam/delete/3", "DELETE", null);
		})

		$("#houseParamAdd").click(function() {
			var data = {
				'houseParamName' : '测试房1',
				'paramTypeId' : 1,
				'paramTypeName' : '住房类型'
			};
			ajaxRequestPostType("houseParam/add", "POST", data);
		})

		$("#houseParamModify").click(function() {
			var data = {
				'houseParamId' : 8,
				'houseParamName' : '修改测试',
				'paramTypeId' : 2,
				'paramTypeName' : '户型'
			};
			ajaxRequestPostType("houseParam/modify", "PUT", data);
		})
	})

	$(function() {
		$("#fixParamGet").click(function() {
			ajaxRequestGet("fixParam/get/20");
		})

		$("#fixParamDelete").click(function() {
			ajaxRequestPostType("fixParam/delete/3", "DELETE", null);
		})

		$("#fixParamAdd").click(function() {
			var data = {
				'fixParamName' : '测试维修',
				'paramTypeId' : 20,
				'paramTypeName' : '维修内容'
			};
			ajaxRequestPostType("fixParam/add", "POST", data);
		})

		$("#fixParamModify").click(function() {
			var data = {
				'fixParamId' : 1,
				'fixParamName' : '修改测试',
				'paramTypeId' : 20,
				'paramTypeName' : '维修内容'
			};
			ajaxRequestPostType("fixParam/modify", "PUT", data);
		})
	})

	$(function() {
		$("#rentalParamGet").click(function() {
			ajaxRequestGet("rentalParam/get/18");
		})

		$("#rentalParamDelete").click(function() {
			ajaxRequestPostType("rentalParam/delete/3", "DELETE", null);
		})

		$("#rentalParamAdd").click(function() {
			var data = {
				'rentalParamName' : '租金参数内容测试',
				'paramTypeId' : 20,
				'paramTypeName' : '新老职工如何划分'
			};
			ajaxRequestPostType("rentalParam/add", "POST", data);
		})

		$("#rentalParamModify").click(function() {
			var data = {
				'rentalParamId' : 1,
				'rentalParamName' : '修改测试',
				'paramTypeId' : 17,
				'paramTypeName' : '划分'
			};
			ajaxRequestPostType("rentalParam/modify", "PUT", data);
		})
	})
	
	$(function() {
		$("#regionGet").click(function() {
			ajaxRequestGet("region/get");
		})

		$("#regionDelete").click(function() {
			ajaxRequestPostType("region/delete/13", "DELETE", null);
		})

		$("#regionAdd").click(function() {
			var data = {
				'regionName' : "南湖",
				'regionDescription' : '南湖大草原'
			};
			ajaxRequestPostType("region/add", "POST", data);
		})

		$("#regionModify").click(function() {
			var data = {
				'regionId' : 1,
				'regionName' : '北湖',
				'regionDescription' : '北湖大草原'
			};
			ajaxRequestPostType("region/modify", "PUT", data);
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

	<hr>
	<hr>
	<h4>RegionGetTest</h4>
	<input type="button" value="RegionGet" id="regionGet" />
	<input type="button" value="RegionDelete" id="regionDelete" />
	<input type="button" value="RegionAdd" id="regionAdd" />
	<input type="button" value="RegionModify" id="regionModify" />
</body>
</html>