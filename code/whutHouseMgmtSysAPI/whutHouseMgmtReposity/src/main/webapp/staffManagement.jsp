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
<script type="text/javascript" src="${API_Path }/static/js/common.js"></script>
<script type="text/javascript">
	$(function() {
		$("#staffDeptGet").click(function() {
			ajaxRequestGet("staff/getDepts");
		})

		$("#staffGet").click(function() {
			ajaxRequestGet("staff/get/65");
		})


		$("#staffDelete").click(function() {
			//var data={'staffParamId':189};
			ajaxRequestPostType("staff/delete/5", "DELETE", null);
		})

		$("#staffAdd").click(function() {
			var data = {
				'no' : '4232',
				'name' : 'xh',
				'sex':'男',
				'marriageState':'未知',
				'title':95,
				'post':89,
				'type':144,
				'status':153,
				'dept':49,
				'code':'429006198711208754',
				'joinTime':'2017-11-20',
				'goUniversityTime':'2015-9-6',
				'retireTime':'2020-11-2',
				'tel':'13277582789',
				'remark':'无',
				'relation':'active'
			};
			ajaxRequestPostType("staff/add", "POST", data);
		})

		$("#staffModify").click(function() {
			var data = {
					'id':14,
					'no' : '4330',
					'name' : 'xh',
					'sex':'男',
					'marriageState':'未知',
					'title':95,
					'post':89,
					'type':144,
					'status':153,
					'dept':49,
					'code':'429006198711208754',
					'joinTime':'2017-11-20',
					'goUniversityTime':'2015-9-6',
					'retireTime':'2020-11-2',
					'tel':'13277582789',
					'remark':'无',
					'relation':'active'
			};
			ajaxRequestPostType("staff/modify", "PUT", data);
		})
	})
</script>

</head>
<body>
	<h4>获取所有部门</h4>
	<input type="button" value="StaffDeptGet"
		id="staffDeptGet" />
	<h4>根据部门ID获取员工</h4>
	<input type="button" value="StaffGet" id="staffGet" />
	<h4>删除一个员工</h4>
	<input type="button" value="StaffDelete" id="staffDelete" />
	<h4>添加一个员工</h4>
	<input type="button" value="StaffAdd" id="staffAdd" />
	<h4>修改员工数据</h4>
	<input type="button" value="StaffModify" id="staffModify" />
</body>
</html>