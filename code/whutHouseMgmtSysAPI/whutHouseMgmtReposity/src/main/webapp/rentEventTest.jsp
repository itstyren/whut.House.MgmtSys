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
<<<<<<< HEAD
	$(function() {
		$("#rentEventGet").click(function() {
			ajaxRequestGet("rentEvent/get?page=1&size=3");
		})

		$("#rentEventModify").click(function() {
			var data = {
				"rentEventId" : 3,
				"paramTypeId" : "15",
				"paramTypeName" : "选房选项",
				"rentIsOpenSel" : "否",
				"rentTimeBegin" : new Date(),
				"isDelete" : "false"
			}
			ajaxRequestPostType("rentEvent/modify", "PUT", data);
=======
		
	$(function () {
		$("#rentEventGet").click(function () {
			ajaxRequestGet("rentEvent/get?page=1&size=5");
		})
		
		$("#rentEventModify").click(function () {
			var data={"rentEventId":3,"rentTimeBegin":"2017-10-20","rentTimeRanges":"2017-11-4","rentSelValReq":5,"rentSelRules":"无规则"}
			ajaxRequestPostType("rentEvent/modify","PUT",data);
>>>>>>> Terry-Ren/master
		})

		$("#rentEventDelete").click(function() {
			//var data={"rentParamId":2}
			ajaxRequestPostType("rentEvent/delete/2", "DELETE", null);
		})
<<<<<<< HEAD

		$("#rentEventAdd").click(function() {
			var data = {
				"paramTypeId" : "15",
				"paramTypeName" : "选房选项",
				"rentIsOpenSel" : "否",
				"rentTimeBegin" : new Date(),
				"isDelete" : "false"
			}
			ajaxRequestPostType("rentEvent/add", "POST", data);
=======
		
		$("#rentEventAdd").click(function () {
			var data={"rentTimeBegin":"2017-10-30","rentTimeRanges":"2017-11-4","rentSelValReq":5,"rentSelRules":"无规则"}
			ajaxRequestPostType("rentEvent/add","POST",data);
>>>>>>> Terry-Ren/master
		})

	})
</script>
</head>
<body>

	<h4>租赁历史获取测试</h4>
	<input type="button" value="RentEventGet" id="rentEventGet" />
	<br>
	<h4>租赁历史修改测试</h4>
	<input type="button" value="RentEventModify" id="rentEventModify" />
	<br>
	<h4>租赁历史删除测试</h4>
	<input type="button" value="RentEventDelete" id="rentEventDelete" />
	<br>
	<h4>租赁历史增添测试</h4>
	<input type="button" value="RentEventAdd" id="rentEventAdd" />

</body>
</html>