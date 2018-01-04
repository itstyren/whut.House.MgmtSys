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
<link
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://cdn.static.runoob.com/libs/jquery/2.0.0/jquery.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="${API_Path }/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	//选项卡
	$(function() {
		$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
			// Get the name of active tab
			var activeTab = $(e.target).text();
			// Get the name of previous tab
			var previousTab = $(e.relatedTarget).text();
			$(".active-tab span").html(activeTab);
			$(".previous-tab span").html(previousTab);
		});
	});

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

	//租赁历史
	$(function() {
		$("#rentEventGet").click(function () {
			ajaxRequestGet("rentEvent/get?page=1&size=5");
		})
		
		$("#rentEventModify").click(function () {
			var data={"rentEventId":3,"rentTimeBegin":"2017-10-20","rentTimeRanges":"2017-11-4","rentSelValReq":5,"rentSelRules":"无规则"}
			ajaxRequestPostType("rentEvent/modify","PUT",data);
		})
		
		$("#rentEventDelete").click(function () {
			//var data={"rentParamId":2}
			ajaxRequestPostType("rentEvent/delete/2","DELETE",null);
		})
		
		$("#rentEventAdd").click(function () {
			var data={"rentTimeBegin":"2017-10-30","rentTimeRanges":"2017-11-4","rentSelValReq":5,"rentSelRules":"无规则"}
			ajaxRequestPostType("rentEvent/add","POST",data);
		})
		
	})

	//和职工有关的租赁参数
	$(function() {
		$("#rentParamAboutStaffGet").click(function () {
			ajaxRequestGet("rentParamAboutStaff/get/11?page=2&size=4");
		})
		
		$("#rentParamAboutStaffModify").click(function () {
			var data={"staffParamId":88,"staffParamName":"否","paramTypeId":6,"paramTypeName":"职务","staffParamVal":70,"staffParamSpouseVal":3,"isDelete":"false"}
			ajaxRequestPostType("rentParamAboutStaff/modify","PUT",data);
		})
	})

	//职工参数
	$(function() {
		$("#staffWorkDeptParamGet").click(function() {
			ajaxRequestGet("staffParam/get/5?page=1&size=25");
		})

		$("#staffDutyParamGet").click(function() {
			ajaxRequestGet("staffParam/get/6");
		})

		$("#staffJobTitleParamGet").click(function() {
			ajaxRequestGet("staffParam/get/7");
		})

		$("#staffTypeParamGet").click(function() {
			ajaxRequestGet("staffParam/get/8");
		})

		$("#staffWorkStatusParamGet").click(function() {
			ajaxRequestGet("staffParam/get/9");
		})

		$("#staffSpouseDeptNatureParamGet").click(function() {
			ajaxRequestGet("staffParam/get/10");
		})

		$("#staffParamDelete").click(function() {
			//var data={'staffParamId':189};
			ajaxRequestPostType("staffParam/delete/49", "DELETE", null);
		})

		$("#staffParamAdd").click(function() {
			var data = {
				'staffParamName' : '党员',
				'paramTypeId' : 5,
				'paramTypeName' : '工作部门'
			};
			ajaxRequestPostType("staffParam/add", "POST", data);
		})

		$("#staffParamModify").click(function() {
			var data = {
				'staffParamId' : 187,
				'staffParamName' : '修改测试3',
				'paramTypeId' : 5,
				'paramTypeName' : '工作部门'
			};
			ajaxRequestPostType("staffParam/modify", "PUT", data);
		})
	})

	//职工管理
	$(function() {
		$("#staffDeptGet").click(function() {
			ajaxRequestGet("staff/getDepts");
		})
		
		$("#staffByInputGet").click(function() {
			ajaxRequestGet("staff/getStaffByInput?input=h");
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
				'no' : '4234',
				'name' : 'xh',
				'sex':'男',
				'marriageState':'未知',
				'title':95,
				'post':89,
				'type':144,
				'status':153,
				'dept':49,
				'code':'4290061987112087',
				'joinTime':'2017-11-20',
				'goUniversityTime':'2015-9-6',
				'retireTime':'2020-11-2',
				'tel':'12345678901',
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


	<hr>
	<script type="text/javascript"
		src="https://api.lwl12.com/hitokoto/main/get?encode=js&charset=utf-8"></script>
	<div id="lwlhitokoto">
		<script>
			lwlhitokoto()
		</script>
	</div>

	<hr>
	<ul id="myTab" class="nav nav-tabs">
		<li class="active"><a href="#rentEvent" data-toggle="tab">租赁历史</a></li>
		<li><a href="#rentParamAboutStaff" data-toggle="tab">和职工有关的租赁参数</a></li>
		<li><a href="#staffParam" data-toggle="tab">职工参数</a></li>
		<li><a href="#staffManagement" data-toggle="tab">职工管理</a></li>
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="rentEvent">
			<h4>租赁历史获取测试</h4>
			<input class="btn btn-info btn-lg" type="button" value="Get" id="rentEventGet" /> <br><br>
			<h4>租赁历史删除测试</h4>
			<input class="btn btn-info btn-lg"type="button" value="Delete" id="rentEventDelete" /><br><br>
			<h4>租赁历史增添测试</h4>
			<input class="btn btn-info btn-lg"type="button" value="Add" id="rentEventAdd" /> <br><br>
			<h4>租赁历史修改测试</h4>
			<input class="btn btn-info btn-lg"type="button" value="Modify" id="rentEventModify" />
			<br>
		</div>
		<div class="tab-pane fade" id="rentParamAboutStaff">
			<h4>和职工有关的租赁参数获取测试</h4>
			<input class="btn btn-info btn-lg" type="button" value="rentParamAboutStaffGet" id="rentParamAboutStaffGet" /> <br><br>
			<h4>和职工有关的租赁参数修改测试</h4>
			<input class="btn btn-info btn-lg" type="button" value="rentParamAboutStaffModify" id="rentParamAboutStaffModify" /> <br>
		</div>
		<div class="tab-pane fade" id="staffParam">
			<h4>获取职工参数</h4>
			<input class="btn btn-info btn-lg" type="button" value="staffWorkDeptParamGet" id="staffWorkDeptParamGet" /> <br>
			<input class="btn btn-info btn-lg" type="button" value="staffDutyParamGet" id="staffDutyParamGet" /><br>
			<input class="btn btn-info btn-lg" type="button" value="staffJobTitleParamGet" id="staffJobTitleParamGet" /><br>
			<input class="btn btn-info btn-lg" type="button" value="staffTypeParamGet" id="staffTypeParamGet" /><br>
			<input class="btn btn-info btn-lg" type="button" value="staffWorkStatusParamGet" id="staffWorkStatusParamGet" /><br>
			<input class="btn btn-info btn-lg" type="button" value="staffSpouseDeptNatureParamGet" id="staffSpouseDeptNatureParamGet" /><br><br>
			<h4>删除职工参数</h4>
			<input class="btn btn-info btn-lg" type="button" value="staffParamDelete" id="staffParamDelete" /><br><br>
			<h4>添加职工参数</h4>
			<input class="btn btn-info btn-lg" type="button" value="staffParamAdd" id="staffParamAdd" /><br><br>
			<h4>修改职工参数</h4>
			<input class="btn btn-info btn-lg" type="button" value="staffParamModify" id="staffParamModify" /><br>
		</div>
		<div class="tab-pane fade" id="staffManagement">
			<h4>获取所有部门</h4>
			<input class="btn btn-info btn-lg" type="button" value="staffDeptGet" id="staffDeptGet" /> <br><br> 
			<h4>模糊查询员工</h4>
			<input class="btn btn-info btn-lg" type="button" value="staffByInputGet" id="staffByInputGet" /> <br><br> 
			<h4>根据部门ID获取员工</h4>
			<input class="btn btn-info btn-lg" type="button" value="staffGet" id="staffGet" /> <br><br>  
			<h4>删除一个员工</h4>
			<input class="btn btn-info btn-lg" type="button" value="staffDelete" id="staffDelete" /> <br><br> 
			<h4>添加一个员工</h4>
			<input class="btn btn-info btn-lg" type="button" value="staffAdd" id="staffAdd" /> <br><br> 
			<h4>修改员工数据</h4>
			<input class="btn btn-info btn-lg" type="button" value="staffModify" id="staffModify" /> <br>
		</div>
	</div>



</body>
</html>