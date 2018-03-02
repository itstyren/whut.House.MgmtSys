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

	//数据导入的Post类请求
	function ajaxRequestPostTypeForDataImport(uri, method, data) {
		//alert("${API_Path }/" + uri);
		$.ajax({
			type : method,
			contentType : 'multipart/form-data;charset=UTF-8',
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
		$("#rentEventGet").click(function() {
			ajaxRequestGet("rentEvent/get?page=1&size=5");
		})

		$("#rentEventModify").click(function() {
			var data = {
				"rentEventId" : 3,
				"rentTimeBegin" : "2018-03-01 22:20:21",
				"rentTimeRanges" : 30,
				"rentSelValReq" : 5,
				"rentSelRules" : "无规则"
			}
			ajaxRequestPostType("rentEvent/modify", "PUT", data);
		})

		$("#rentEventDelete").click(function() {
			//var data={"rentParamId":2}
			ajaxRequestPostType("rentEvent/delete/2", "DELETE", null);
		})

		$("#rentEventAdd").click(function() {
			var data = {
				"rentTimeBegin" : "2017-10-30 11:21:00",
				//"rentTimeRanges" : "2017-11-4",
				"rentTimeRanges" : 2,
				"rentSelValReq" : 5,
				"rentSelRules" : "无规则"
			}
			ajaxRequestPostType("rentEvent/add", "POST", data);
		})

	})

	//和职工有关的租赁参数
	$(function() {
		$("#rentParamAboutStaffGet").click(function() {
			ajaxRequestGet("rentParamAboutStaff/get/11?page=2&size=4");
		})

		$("#rentParamAboutStaffModify").click(function() {
			var data = {
				"staffParamId" : 88,
				"staffParamName" : "否",
				"paramTypeId" : 6,
				"paramTypeName" : "职务",
				"staffParamVal" : 70,
				"staffParamSpouseVal" : 3,
				"isDelete" : "false"
			}
			ajaxRequestPostType("rentParamAboutStaff/modify", "PUT", data);
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
		$("#resetPassword").click(function() {
			ajaxRequestPostType("staff/resetPassword/1", "PUT", null);
		})

		$("#getByID").click(function() {
			ajaxRequestGet("staff/getByID/1");
		})

		$("#staffDeptGet").click(function() {
			ajaxRequestGet("staff/getDepts");
		})

		$("#staffByInputGet").click(function() {
			ajaxRequestGet("staff/getStaffByInput?input=h");
		})

		$("#staffGet").click(function() {
			ajaxRequestGet("staff/get/48?page=2&size=2");
		})

		$("#staffDelete").click(function() {
			//var data={'staffParamId':189};
			ajaxRequestPostType("staff/delete/5", "DELETE", null);
		})

		$("#staffAdd").click(function() {
			var data = {
				'no' : '9',
				'name' : '任天宇',
				'sex' : '男',
				'marriageState' : '未知',
				'title' : 95,
				'post' : 89,
				'type' : 144,
				'status' : 153,
				'dept' : 49,
				'code' : '429006198711208702',
				'joinTime' : '2017-11-20',
				'goUniversityTime' : '2015-9-6',
				'retireTime' : '2020-11-2',
				'tel' : '13129917437',
				'remark' : '无',
				'relation' : 'active'
			};
			ajaxRequestPostType("staff/add", "POST", data);
		})

		$("#staffModify").click(function() {
			var data = {
				'id' : 14,
				'no' : '4330',
				'name' : 'xh',
				'sex' : '男',
				'marriageState' : '未知',
				//'title':95,
				'post' : 89,
				'type' : 144,
				'status' : 153,
				'dept' : 49,
				'code' : '429006198711208754',
				'joinTime' : '2017-11-20',
				'goUniversityTime' : '2015-9-6',
				'retireTime' : '2020-11-2',
				'tel' : '13277582789',
				'remark' : '无',
				'relation' : 'active'
			};
			ajaxRequestPostType("staff/modify", "PUT", data);
		})
	})

	//住房登记
	$(function() {
		$("#getByMultiCondition").click(
				function() {
					var data = {
						//键的名字与Model属性名一致
						'houseType' : '周转房342萨达',
						'useStatus' : '空闲',
						'houseZone' : '武汉市洪山区工大路20号',
						'building' : '1栋（原鉴湖401栋）'
					};
					ajaxRequestPostType("houseRegister/getByMultiCondition",
							"POST", data);
				})

		$("#getByAllMultiCondition").click(
				function() {
					var data = {
						//键的名字与Model属性名一致
						'houseType' : '周转房342萨达',
						'useStatus' : '空闲',
						'houseZone' : '武汉市洪山区工大路20号',
						'building' : '1栋（原鉴湖401栋）',
						'structName' : '砖木',
						'layoutName' : '两室',
						'areaParameter' : {
							'areaParamName' : '建筑面积',
							'minArea' : 35,
							'maxArea' : 38
						},
						//'finishTime':['2017-01-31','2017-02-02'],
						'finishTime' : {
							'startTime' : '2017-01-31',
							'endTime' : '2017-02-02'
						},
						'page':1,
						'size':2
					};
					ajaxRequestPostType("houseRegister/getByAllMultiCondition",
							"POST", data);
				})

		$("#getStaffHouseRel").click(function() {
			ajaxRequestGet("houseRegister/getStaffHouseRel/3");
		})

		$("#register").click(function() {
			var data = {
				//键的名字与Model属性名一致
				'staffId' : 18,
				'houseId' : 2,
				'houseRel' : 26,
				'bookTime' : '2018-01-28'
			};
			ajaxRequestPostType("houseRegister/register", "PUT", data);
		})

		$("#isRegistered").click(function() {
			var data = {
				//键的名字与Model属性名一致
				'staffId' : 3,
				'houseId' : 1,
				'houseRel' : 26,
				'bookTime' : '2018-01-23'
			};
			ajaxRequestPostType("houseRegister/isRegistered", "POST", data);
		})

		$("#relieveHouseRel").click(
				function() {
					ajaxRequestPostType("houseRegister/relieveHouseRel/23",
							"DELETE", null);
				})

		$("#deleteHouseRel").click(
				function() {
					ajaxRequestPostType("houseRegister/deleteHouseRel/24",
							"DELETE", null);
				})

		$("#getRegisterRel").click(function() {
			ajaxRequestGet("houseRegister/getRegisterRel");
		})

		$("#updateRegisterRel").click(
				function() {
					var data = [
					//前台提交的应该是发生修改的数据
					{
						'houseParamId' : 6,
						'houseParamName' : '周转房342萨达',
						//'paramTypeId' : 1,
						//'paramTypeName' : '住房类型',
						'houseParamRel' : '购买,租赁',
					//'isDelete' : false
					}, {
						'houseParamId' : 7,
						'houseParamName' : '房改房萨达',
						//'paramTypeId' : 1,
						//'paramTypeName' : '住房类型',
						'houseParamRel' : '购买,空闲,租赁',
					//'isDelete' : false
					} ];
					ajaxRequestPostType("houseRegister/updateRegisterRel",
							"POST", data);
				})

	})

	//数据导入
	$(function() {
	})

	//网上选房
	$(function() {
		
		$("#getAllSelectedStaff").click(function() {
			ajaxRequestGet("selfHelpSelectHouse/getAllSelectedStaff?page=5&size=3");
		})
		
		$("#submitSelectHouseApplication").click(function() {
			ajaxRequestGet("selfHelpSelectHouse/submitSelectHouseApplication?staffId=7&houseId=1");
		})
		
		$("#getAllCanselectHouse").click(function() {
			ajaxRequestGet("selfHelpSelectHouse/getAllCanselectHouse?page=2&size=2");
		})

		$("#cancelSetHousing").click(function() {
			//传递的是职工编号staffNo数组
			var data = [ 1, 2 ];
			ajaxRequestPostType("housingSet/cancelSetHousing", "POST", data);

		})

		$("#setHousing").click(function() {
			//传递的是职工编号staffNo数组
			var data = [ 1, 2 ];
			ajaxRequestPostType("housingSet/setHousing", "POST", data);

		})

		$("#activeHouseShowByMultiCondition").click(
				function() {
					var data = {
						'houseType' : '周转房342萨达',
						'useStatus' : '空闲',
						'houseZone' : '武汉市洪山区工大路20号',
						'structName' : '砖木',
						'layoutName' : '两室',
						'building' : '1栋（原鉴湖401栋）',
						'rentalScope' : {
							'minRental' : 500,
							'maxRental' : 1500
						},
						'areaParameter' : {
							'areaParamName' : '使用面积',
							'minArea' : 20,
							'maxArea' : 40
						},
						'page' : 1,
						'size' : 2
					};
					ajaxRequestPostType(
							"housingSet/activeHouseShowByMultiCondition",
							"POST", data);
				})

		$("#canselectHouseShowByMultiCondition").click(
				function() {
					var data = {
						'houseType' : '周转房342萨达',
						'useStatus' : '空闲',
						'houseZone' : '武汉市洪山区工大路20号',
						'structName' : '砖木',
						'layoutName' : '两室',
						'building' : '2栋（原鉴湖402栋）',
						'rentalScope' : {
							'minRental' : 500,
							'maxRental' : 1500
						},
						'areaParameter' : {
							'areaParamName' : '使用面积',
							'minArea' : 20,
							'maxArea' : 40
						},
						'page' : 1,
						'size' : 2
					};
					ajaxRequestPostType(
							"housingSet/canselectHouseShowByMultiCondition",
							"POST", data);
				})

		$("#canselectHouseShow").click(function() {
			ajaxRequestGet("housingSet/canselectHouseShow?page=2&size=2");
		})

		$("#activeHouseShow").click(function() {
			ajaxRequestGet("housingSet/activeHouseShow?page=2&size=2");
		})

		$("#activeShow").click(function() {
			ajaxRequestGet("selHouseQuaAuth/activeShow?page=2&size=10");
		})

		$("#canselectShow").click(function() {
			ajaxRequestGet("selHouseQuaAuth/canselectShow?page=2&size=5");
		})

		$("#selectActiveStaffMultiCondition")
				.click(
						function() {
							var data = {
								'dept' : '道桥中心',
								'post' : '厅级3',
								'title' : '副研究员',
								'type' : '专业技术人员3',
								'status' : '调离',
								'marriageState' : '已婚',
								'joinTime' : {
									'startTime' : '1988-01-27',
									'endTime' : '1988-02-05'
								},
								'sex' : '男'
							};
							ajaxRequestPostType(
									"selHouseQuaAuth/selectActiveStaffMultiCondition?page=2&size=1",
									"POST", data);
						})

		$("#selectCanselectStaffMultiCondition")
				.click(
						function() {
							var data = {
								'dept' : '道桥中心',
								'post' : '厅级3',
								'title' : '副研究员',
								'type' : '专业技术人员3',
								'status' : '调离',
								'marriageState' : '已婚',
								'joinTime' : {
									'startTime' : '1988-01-27',
									'endTime' : '1988-02-05'
								},
								'sex' : '男'
							};
							ajaxRequestPostType(
									"selHouseQuaAuth/selectCanselectStaffMultiCondition?page=2&size=1",
									"POST", data);
						})

		$("#selectByNoOrName")
				.click(
						function() {
							//	var data = {
							//		'conditionName' : '职工姓名',
							//		'conditionValue' : '2'
							//	};
							ajaxRequestGet("selHouseQuaAuth/selectByNoOrName?conditionValue=郑");
						})

		$("#setCanselect").click(function() {
			//传递的是职工编号staffNo数组
			var data = [ 6 ,7 ];
			ajaxRequestPostType("selHouseQuaAuth/setCanselect", "POST", data);

		})

		$("#cancelCanselect").click(
				function() {
					//传递的是职工编号staffNo数组
					var data = [ 1, 2 ];
					ajaxRequestPostType("selHouseQuaAuth/cancelCanselect",
							"POST", data);

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
		<li><a href="#houseRegistration" data-toggle="tab">住房登记</a></li>
		<li><a href="#dataImport" data-toggle="tab">数据导入</a></li>
		<li><a href="#internetSelectHouse" data-toggle="tab">网上选房</a></li>
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="rentEvent">
			<h4>租赁历史获取测试</h4>
			<input class="btn btn-info btn-lg" type="button" value="Get"
				id="rentEventGet" /> <br> <br>
			<h4>租赁历史删除测试</h4>
			<input class="btn btn-info btn-lg" type="button" value="Delete"
				id="rentEventDelete" /><br> <br>
			<h4>租赁历史增添测试</h4>
			<input class="btn btn-info btn-lg" type="button" value="Add"
				id="rentEventAdd" /> <br> <br>
			<h4>租赁历史修改测试</h4>
			<input class="btn btn-info btn-lg" type="button" value="Modify"
				id="rentEventModify" /> <br>
		</div>
		<div class="tab-pane fade" id="rentParamAboutStaff">
			<h4>和职工有关的租赁参数获取测试</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="rentParamAboutStaffGet" id="rentParamAboutStaffGet" /> <br>
			<br>
			<h4>和职工有关的租赁参数修改测试</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="rentParamAboutStaffModify" id="rentParamAboutStaffModify" />
			<br>
		</div>
		<div class="tab-pane fade" id="staffParam">
			<h4>获取职工参数</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="staffWorkDeptParamGet" id="staffWorkDeptParamGet" /> <br>
			<input class="btn btn-info btn-lg" type="button"
				value="staffDutyParamGet" id="staffDutyParamGet" /><br> <input
				class="btn btn-info btn-lg" type="button"
				value="staffJobTitleParamGet" id="staffJobTitleParamGet" /><br>
			<input class="btn btn-info btn-lg" type="button"
				value="staffTypeParamGet" id="staffTypeParamGet" /><br> <input
				class="btn btn-info btn-lg" type="button"
				value="staffWorkStatusParamGet" id="staffWorkStatusParamGet" /><br>
			<input class="btn btn-info btn-lg" type="button"
				value="staffSpouseDeptNatureParamGet"
				id="staffSpouseDeptNatureParamGet" /><br> <br>
			<h4>删除职工参数</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="staffParamDelete" id="staffParamDelete" /><br> <br>
			<h4>添加职工参数</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="staffParamAdd" id="staffParamAdd" /><br> <br>
			<h4>修改职工参数</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="staffParamModify" id="staffParamModify" /><br>
		</div>
		<div class="tab-pane fade" id="staffManagement">
			<h4>根据ID重置该员工密码</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="resetPassword" id="resetPassword" /> <br> <br>
			<h4>根据ID获取单个员工信息</h4>
			<input class="btn btn-info btn-lg" type="button" value="getByID"
				id="getByID" /> <br> <br>
			<h4>获取所有部门</h4>
			<input class="btn btn-info btn-lg" type="button" value="staffDeptGet"
				id="staffDeptGet" /> <br> <br>
			<h4>模糊查询员工</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="staffByInputGet" id="staffByInputGet" /> <br> <br>
			<h4>根据部门ID获取员工</h4>
			<input class="btn btn-info btn-lg" type="button" value="staffGet"
				id="staffGet" /> <br> <br>
			<h4>删除一个员工</h4>
			<input class="btn btn-info btn-lg" type="button" value="staffDelete"
				id="staffDelete" /> <br> <br>
			<h4>添加一个员工</h4>
			<input class="btn btn-info btn-lg" type="button" value="staffAdd"
				id="staffAdd" /> <br> <br>
			<h4>修改员工数据</h4>
			<input class="btn btn-info btn-lg" type="button" value="staffModify"
				id="staffModify" /> <br>
		</div>
		<div class="tab-pane fade" id="houseRegistration">
			<h4>多条件查询测试</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetByMultiCondition" id="getByMultiCondition" /> <br> <br>
			<h4>全面多条件查询测试</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetByAllMultiCondition" id="getByAllMultiCondition" /> <br>
			<br>
			<h4>职工房屋关系查询测试</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetStaffHouseRel" id="getStaffHouseRel" /> <br>
			<h4>登记</h4>
			<input class="btn btn-info btn-lg" type="button" value="Register"
				id="register" /> <br>
			<h4>判断住房是否已有居民登记</h4>
			<input class="btn btn-info btn-lg" type="button" value="IsRegistered"
				id="isRegistered" /> <br>
			<h4>解除登记关系：不保留历史记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="RelieveHouseRel" id="relieveHouseRel" /> <br>
			<h4>删除登记关系：保留历史记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="DeleteHouseRel" id="deleteHouseRel" /> <br>
			<h4>登记关系设置:获取所有登记关系</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetRegisterRel" id="getRegisterRel" /> <br>
			<h4>登记关系设置:更新修改的登记关系</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="UpdateRegisterRel" id="updateRegisterRel" /> <br>
		</div>
		<div class="tab-pane fade" id="dataImport">
			<!-- 数据导入 -->
		</div>
		<div class="tab-pane fade" id="internetSelectHouse">
			<h4>自助选房：显示所有已选房职工</h4>
			<input class="btn btn-info btn-lg" type="button" value="GetAllSelectedStaff"
				id="getAllSelectedStaff" /> <br>
			<h4>自助选房：提交点房申请</h4>
			<input class="btn btn-info btn-lg" type="button" value="SubmitSelectHouseApplication"
				id="submitSelectHouseApplication" /> <br>
			<h4>自助选房：显示所有未选房职工</h4>
			<input class="btn btn-info btn-lg" type="button" value="GetAllCanselectHouse"
				id="getAllCanselectHouse" /> <br>
			<h4>选房资格认定：初始显示未设置选房职工</h4>
			<input class="btn btn-info btn-lg" type="button" value="ActiveShow"
				id="activeShow" /> <br>
			<h4>选房资格认定：初始显示已设置选房职工</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="CanselectShow" id="canselectShow" /> <br>
			<h4>选房资格认定：多条件查询未设置选房资格员工信息</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="SelectActiveStaffMultiCondition"
				id="selectActiveStaffMultiCondition" /> <br>
			<h4>选房资格认定：多条件查询已设置选房资格员工信息</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="SelectCanselectStaffMultiCondition"
				id="selectCanselectStaffMultiCondition" /> <br>
			<h4>选房资格认定：根据职工号或职工姓名模糊查询</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="SelectByNoOrName" id="selectByNoOrName" /> <br>
			<h4>选房资格认定：设为可点房</h4>
			<input class="btn btn-info btn-lg" type="button" value="SetCanselect"
				id="setCanselect" /> <br>
			<h4>选房资格认定：撤销可点房</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="CancelCanselect" id="cancelCanselect" /> <br>
			<h4>房源设置：初始显示未设置房源</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="ActiveHouseShow" id="activeHouseShow" /> <br>
			<h4>房源设置：初始显示已设置房源</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="CanselectHouseShow" id="canselectHouseShow" /> <br>
			<h4>房源设置：根据组合条件查询显示已设置房源</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="CanselectHouseShowByMultiCondition"
				id="canselectHouseShowByMultiCondition" /> <br>
			<h4>房源设置：根据组合条件查询显示未设置房源</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="ActiveHouseShowByMultiCondition"
				id="activeHouseShowByMultiCondition" /> <br>
			<h4>房源设置：设置房源</h4>
			<input class="btn btn-info btn-lg" type="button" value="SetHousing"
				id="setHousing" /> <br>
			<h4>房源设置：撤销设置房源</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="CancelSetHousing" id="cancelSetHousing" /> <br>

		</div>
	</div>



</body>
</html>