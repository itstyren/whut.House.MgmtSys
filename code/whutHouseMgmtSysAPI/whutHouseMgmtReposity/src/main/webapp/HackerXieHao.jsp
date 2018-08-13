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
		$
				.ajax({
					url : uri,
					beforeSend : function(request) {
						request
								.setRequestHeader(
										"X-token",
										"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI4IiwiaWF0IjoxNTMzOTk1MzE3LCJleHAiOjE1MzQwMzEzMTZ9.xWxoNEEKzTgzJLRrqBtxxIVWxUBuKdwqgEyuqrHqfqw");
					},
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
		$
				.ajax({
					type : method,
					contentType : 'application/json;charset=UTF-8',
					dataType : 'json',
					beforeSend : function(request) {
						request
								.setRequestHeader(
										"X-token",
										"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI4IiwiaWF0IjoxNTMzOTk1MzE3LCJleHAiOjE1MzQwMzEzMTZ9.xWxoNEEKzTgzJLRrqBtxxIVWxUBuKdwqgEyuqrHqfqw");
					},
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
		$
				.ajax({
					type : method,
					contentType : 'multipart/form-data;charset=UTF-8',
					dataType : 'json',
					beforeSend : function(request) {
						request
								.setRequestHeader(
										"X-token",
										"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI4IiwiaWF0IjoxNTIzMTEyMzE5LCJleHAiOjE1MjMxMTU5MTl9.R7GUW_KTTuyPXzXbtjOaUPXa8PcueAjDkYLqkUHfLAw");
					},
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

	//导入文件
	function importExp() {
		var formData = new FormData();
		var name = $("#upfile").val();
		formData.append("file", $("#upfile")[0].files[0]);
		formData.append("name", name);
		$
				.ajax({
					url : "dataImport/staffDataImport",
					type : 'POST',
					async : false,
					data : formData,
					// 告诉jQuery不要去处理发送的数据
					processData : false,
					// 告诉jQuery不要去设置Content-Type请求头
					contentType : false,
					beforeSend : function(request) {
						request
								.setRequestHeader(
										"X-token",
										"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI4IiwiaWF0IjoxNTIxOTUzNzU4LCJleHAiOjE1MjE5NTczNTh9.VDMxBC1_KXGNIQYLU72_zubaZGf-rwtxbEYVGwjL3Oo");
					},
					success : function(response) {
						console.log(response);
					},
					error : function() {
						console.log('Ajax请求失败！');
					}
				});
	}

	//数据导入
	$(function() {
		/* $("#staffDataImport").click(function() {
			ajaxRequestPostTypeForDataImport("dataImport/staffDataImport","POST",null);
		}) */
	})

	//租赁历史
	$(function() {
		$("#rentEventGet").click(function() {
			ajaxRequestGet("rentEvent/get?page=1&size=10");
		})

		$("#rentEventModify").click(function() {
			var data = {
				"rentEventId" : 26,
				"rentTimeBegin" : "2018-4-3 16:40:00",
				"rentTimeRanges" : 30,
				"dayRentTimeBegin" : "08:15",
				"dayRentTimeEnd" : "17:30",
				"rentSelValReq" : 5,
				"rentSelRules" : "无规则"
			}
			ajaxRequestPostType("rentEvent/modify", "PUT", data);
		})

		$("#rentEventDelete").click(function() {
			//var data={"rentParamId":2}
			ajaxRequestPostType("rentEvent/delete/3", "DELETE", null);
		})

		$("#rentEventAdd").click(function() {
			var data = {
				"rentTimeBegin" : "2018-4-5 17:40:00",
				//"rentTimeRanges" : "2017-11-4",
				"dayRentTimeBegin" : "09:15",
				"dayRentTimeEnd" : "17:30",
				"rentTimeRanges" : 30,
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

		$("#add").click(function() {
			var data = {
				'isUsed' : true,
				'subParam' : 20,
				'remark' : '测试住房补贴参数'
			};
			ajaxRequestPostType("monetarySubParam/add", "POST", data);
		})

		$("#getAll").click(function() {
			ajaxRequestGet("monetarySubParam/getAll?page=1&size=2");
		})

		$("#delete").click(function() {
			ajaxRequestPostType("monetarySubParam/delete/1", "DELETE", null);
		})

		$("#update").click(function() {
			var data = {
				'id' : 2,
				'isUsed' : true,
				'subParam' : 30,
				'remark' : '测试住房补贴参数'
			};
			ajaxRequestPostType("monetarySubParam/update", "PUT", data);
		})

		$("#addHouseSub").click(function() {
			var data = {
				'year' : '2018',
				'subsidiesCoe' : 2.1,
				'remark' : '测试住房补贴参数'
			};
			ajaxRequestPostType("staffParam/addHouseSub", "POST", data);
		})

		$("#getAllHouseSub").click(function() {
			ajaxRequestGet("staffParam/getAllHouseSub?page=1&size=2");
		})

		$("#deleteHouseSub").click(function() {
			ajaxRequestPostType("staffParam/deleteHouseSub/1", "DELETE", null);
		})

		$("#updateHouseSub").click(function() {
			var data = {
				'id' : 1,
				'year' : '2018',
				'subsidiesCoe' : 2.8,
				'remark' : '测试住房补贴参数'
			};
			ajaxRequestPostType("staffParam/updateHouseSub", "PUT", data);
		})

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
		
		$("#updateStaffRole").click(function() {
			ajaxRequestPostType("staff/updateStaffRole/3/0","POST",null);
		})
		
		//854
		$("#unbind").click(function() {
			ajaxRequestGet("staff/unbind/3");
		})
		
		$("#getIcon").click(function() {
			ajaxRequestGet("staff/getIcon/1");
		})

		$("#saveIcon").click(function() {
			var data = {
				'id' : 1,
				'icon' : 'C:\\Users\\Administrator\\Desktop\\icon测试.jpg'
			};
			ajaxRequestPostType("staff/saveIcon", "POST", data);
		})

		$("#calculateStaffValueByStaffNo").click(
				function() {
					ajaxRequestPostType(
							"staff/calculateStaffValueByStaffNo/2788", "POST",
							null);
				})
		$("#calculateAllStaffValue").click(function() {
			ajaxRequestPostType("staff/calculateAllStaffValue", "POST", null);
		})
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
				'no' : '2788',
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
				'retireTime' : '2020-11-2',
				'tel' : '13129917437',
				'remark' : '无',
				'relation' : 'active'
			};
			ajaxRequestPostType("staff/add", "POST", data);
		})

		$("#staffModify").click(function() {
			var data = {
				/* 'id' : 14,
				'no' : '4330',
				'name' : 'asd',
				'sex' : '男',
				'marriageState' : '未知',
				'title' : 100,
				'post' : 89,
				'type' : 144,
				'status' : 153,
				'dept' : 49,
				'code' : ' 429006199704237849',
				'firstJobTime' : '2014-11-20',
				'joinTime' : '2017-11-20',
				'retireTime' : '2020-11-2',
				'tel' : '13277582789',
				'remark' : '无',
				'spouseName' : 'ccc',
				'spouseCode' : '429006199503247864',
				'spouseTitle' : 104,
				'spousePost' : 176,
				'spouseDept' : '退休人员',
				'spouseKind' : 157,
				'buyAccount' : 20,
				'fixFund' : 100,
				'relation' : 'active',
				'discountRate' : 20 */

				'id' : 2,
				'no' : '2',
				'title' : 95,
				'post' : 84,

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
						//'houseType' : '周转房342萨达',
						//'useStatus' : '空闲',
						//'houseZone' : '武汉市洪山区工大路20号',
						//'building' : '1栋（原鉴湖401栋）'
						'houseTypeId' : 6,
						'useStatusId' : 24,
						'campusId' : 1,
						'regionId' : 1,
						'buildingId' : 1
					};
					ajaxRequestPostType("houseRegister/getByMultiCondition",
							"POST", data);
				})

		$("#getByAllMultiCondition")
				.click(
						function() {
							var data = {
								//键的名字与Model属性名一致
								'houseTypeId' : 6,
								'useStatusId' : 24,
								'structId' : 29,
								'layoutId' : 19,
								'areaParameter' : {
									'areaParamName' : '建筑面积',
									'minArea' : 35,
									'maxArea' : 52
								},
								'finishTime' : {
									'startTime' : '1999-01-31',
									'endTime' : '2012-02-02'
								},
								'campusId' : 1,
								'regionId' : 1,
								'buildingId' : 1
							//'finishTime':['2017-01-31','2017-02-02'],

							//'page' : 1,
							//'size' : 2 
							};
							ajaxRequestPostType(
									"houseRegister/getByAllMultiCondition?page=1&&size=25",
									"POST", data);
						})

		$("#getStaffHouseRel").click(function() {
			ajaxRequestGet("houseRegister/getStaffHouseRel/2");
		})

		$("#register").click(function() {
			var data = {
				//键的名字与Model属性名一致
				'staffId' : 2,
				'house' : "腾讯大楼",
				'houseRel' : 82,
				'bookTime' : '2018-01-28 00:00:00'
			};
			ajaxRequestPostType("houseRegister/register", "PUT", data);
		})

		$("#isRegistered").click(function() {
			var data = {
				//键的名字与Model属性名一致
				'staffId' : 3,
				'houseId' : 1,
				'houseRel' : 26,
				'bookTime' : '2018-01-23 00:00:00'
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

	//网上选房
	$(function() {

		$("#isSelectingHouse").click(function() {
			ajaxRequestGet("selfHelpSelectHouse/isSelectingHouse/8");
		})

		$("#getAllSelectedStaff")
				.click(
						function() {
							ajaxRequestGet("selfHelpSelectHouse/getAllSelectedStaff?page=5&size=3");
						})

		$("#submitSelectHouseApplication")
				.click(
						function() {
							ajaxRequestGet("selfHelpSelectHouse/submitSelectHouseApplication?staffId=6&houseId=1");
						})

		$("#getAllCanselectHouse")
				.click(
						function() {
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

		$("#activeHouseShowByMultiCondition")
				.click(
						function() {
							var data = {
								'houseTypeId' : 6,
								'useStatusId' : 26,
								'structId' : 29,
								'layoutId' : 19,
								'rentalScope' : {
									'minRental' : 500,
									'maxRental' : 1500
								},
								'campusId' : 1,
								'regionId' : 1,
								'buildingId' : 1,
							/* 'areaParameter' : {
								'areaParamName' : '使用面积',
								'minArea' : 20,
								'maxArea' : 40
							}, */
							//'page' : 1,
							//'size' : 2
							};
							ajaxRequestPostType(
									"housingSet/activeHouseShowByMultiCondition?page=1&&size=2",
									"POST", data);
						})

		$("#canselectHouseShowByMultiCondition")
				.click(
						function() {
							var data = {
								'houseTypeId' : 6,
								'useStatusId' : 26,
								'structId' : 29,
								'layoutId' : 19,
								'rentalScope' : {
									'minRental' : 500,
									'maxRental' : 1500
								},
								'campusId' : 1,
								'regionId' : 1,
								'buildingId' : 1,
							};
							ajaxRequestPostType(
									"housingSet/canselectHouseShowByMultiCondition?page=1&&size=2",
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
							ajaxRequestGet("selHouseQuaAuth/selectByNoOrName?conditionValue=郑&page=2&size=2");
						})

		$("#setCanselect").click(function() {
			//传递的是职工编号staffNo数组
			var data = [ 6, 8 ];
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

	//租金生成
	$(function() {

		$("#selectRentByStaffNoOrName")
				.click(
						function() {
							ajaxRequestGet("rentGenerate/selectRentByStaffNoOrName?conditionValue=任&page=2&size=2");
						})

		$("#queryRent").click(
				function() {
					var data = {
						'startTime' : '2016-11-07',
						'endTime' : '2017-11-06'
					};
					ajaxRequestPostType("rentGenerate/queryRent?page=2&size=2",
							"POST", data);
				})

		$("#rentGen").click(function() {
			/*var data = {
				'dept' : '绿色建材中心33',
				'post' : '厅级3',
				'title' : '副研究员',
				'type' : '专业技术人员3',
				'status' : '调离',
				'houseTypeName' : '周转房342萨达',
				'marriageState' : '已婚',
				'joinTime' : {
					'startTime' : '1965-01-27',
					'endTime' : '1965-06-05'
				},
				'goUniversityTimeRange' : {
					'startTime' : '2015-12-5',
					'endTime' : '2015-12-25'
				},
				'sex' : '女',
				'isExpire' : true,
				'regionName' : '武汉市洪山区工大路20号'

			};*/
			var data = [ 4 ];
			ajaxRequestPostType("rentGenerate/rentGen", "POST", data);
		})

		$("#selectRentByMultiCondition")
				.click(
						function() {
							var data = {
								'dept' : '绿色建材中心33',
								'post' : '厅级3',
								'title' : '副研究员',
								'type' : '专业技术人员3',
								'status' : '调离',
								'houseTypeName' : '周转房342萨达',
								'marriageState' : '已婚',
								'joinTime' : {
									'startTime' : '1965-01-27',
									'endTime' : '1965-06-05'
								},
								/* 'goUniversityTimeRange' : {
									'startTime' : '2015-12-5',
									'endTime' : '2015-12-25'
								}, */
								'sex' : '女',
								'isExpire' : true,
								'regionName' : '武汉市洪山区工大路20号'

							};
							ajaxRequestPostType(
									"rentGenerate/selectRentByMultiCondition?page=2&size=2",
									"POST", data);
						})
	})

	//个人信息
	$(function() {

		$("#getFixInfoByStaffId").click(function() {
			ajaxRequestGet("fix/getByStaffId/3");
		})

		$("#getHireInfoByStaffId").click(function() {
			ajaxRequestGet("hire/getAllByStaffId/3");
		})
		$("#getFixProcessStateChangeInfo").click(function() {
			ajaxRequestGet("staffHomePage/getFixProcessStateChangeInfo/6");
		})

		$("#getHireProcessStateChangeInfo").click(function() {
			ajaxRequestGet("staffHomePage/getHireProcessStateChangeInfo/18");
		})
		$("#fixEvaluation").click(function() {
			var data = {
				'fixId' : 63,
				'ratings' : 3,
				'description' : '还行'
			};
			ajaxRequestPostType("fixRatings/fixEvaluation", "PUT", data);
		})
		$("#getResidentHouseByStaffId").click(function() {
			ajaxRequestGet("houseInfo/getResidentHouseByStaffId/2");
		})

	})

	//查询统计
	$(function() {

		$("#staffMoreHouseQuery")
				.click(
						function() {
							var data = {
							/* 'houseTypeId' : 7,
							'staffTypeId' : 141 */
							};
							ajaxRequestPostType(
									"moreHouseQuery/staffMoreHouseQuery?page=1&size=15",
									"POST", data);
						})

		$("#staffMoreHouseSta").click(
				function() {
					var data = {
					/* 'houseTypeId':6,
					'staffTypeId':145 */
					};
					ajaxRequestPostType("moreHouseQuery/staffMoreHouseSta",
							"POST", data);
				})
		$("#staffMoreHouseStaByStaffId").click(
				function() {
					var data = {
					/* 'houseTypeId':6,
					'staffTypeId':145 */
					};
					ajaxRequestPostType(
							"moreHouseQuery/staffMoreHouseStaByStaffId/3",
							"POST", data);
				})

	})

	//货币化补贴
	$(function() {
		
		$("#getFormulaParameter").click(function() {
			ajaxRequestGet("staffMonetarySub/getFormulaParameter/2");
		})
		
		$("#addPromoteSub").click(
				function() {
					ajaxRequestPostType("oneTimeMonetarySub/addPromoteSub/2",
							"POST", null);
				})

		$("#getAllOneTimeMonetarySub").click(function() {
			ajaxRequestGet("oneTimeMonetarySub/getAllOneTimeMonetarySub");
		})

		$("#getOneTimeMonetarySubByStaffNo")
				.click(
						function() {
							ajaxRequestGet("oneTimeMonetarySub/getOneTimeMonetarySubByStaffNo/3");
						})

		$("#deleteOneTimeMonetarySub").click(
				function() {
					ajaxRequestPostType(
							"oneTimeMonetarySub/deleteOneTimeMonetarySub/1",
							"DELETE", null);
				})
		$("#addOneTimeMonetarySub").click(
				function() {
					var data = {
						'staffNo' : '2',
						'oneTimeSubYear' : '1999',
						'remark' : '一次性补偿'

					};
					ajaxRequestPostType(
							"oneTimeMonetarySub/addOneTimeMonetarySub", "POST",
							data);
				})

		$("#getAllMonetarySub").click(function() {
			ajaxRequestGet("staffMonetarySub/getAllMonetarySub");
		})

		$("#getMonetarySubByStaffNo").click(function() {
			ajaxRequestGet("staffMonetarySub/getMonetarySubByStaffNo/2");
		})

		$("#deleteMonetarySub").click(
				function() {
					ajaxRequestPostType("staffMonetarySub/deleteMonetarySub/1",
							"DELETE", null);
				})
		$("#addMonetarySub").click(
				function() {
					var data = {
						'staffNo' : '3',
						'year' : '2018',
						'annualSal' : '180000',
						'remark' : '2018年货币化补贴'

					};
					ajaxRequestPostType("staffMonetarySub/addMonetarySub",
							"POST", data);
				})
				
		$("#getAllMonetarySubByCondition").click(
				function() {
					var data = {
						'deptId' : '49',
						'postId' : '84',
						'titleId' : '95',
						'typeId' : '144',
						'yearStart':2017,
						'yearEnd':2018
					};
					ajaxRequestPostType("staffMonetarySub/getAllMonetarySubByCondition",
							"POST", data);
				})
		$("#getAllOneTimeMonetarySubByCondition").click(
				function() {
					var data = {
						'deptId' : '49',
						'postId' : '84',
						'titleId' : '95',
						'typeId' : '144',
						'yearStart':2017,
						'yearEnd':2018
					};
					ajaxRequestPostType("oneTimeMonetarySub/getAllOneTimeMonetarySubByCondition",
							"POST", data);
				})
				
	})
	
	//权限控制测试
	$(function() {
		$("#authGet").click(function() {
			ajaxRequestGet("auth/testGetAuth");
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
		<li><a href="#rentGenerate" data-toggle="tab">租金生成</a></li>
		<li><a href="#personalInfo" data-toggle="tab">个人信息</a></li>
		<li><a href="#querySta" data-toggle="tab">查询统计</a></li>
		<li><a href="#houseSub" data-toggle="tab">货币化补贴</a></li>
		<li><a href="#authTest" data-toggle="tab">权限控制测试版</a></li>
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="authTest">
			<h4>权限获取测试</h4>
			<input class="btn btn-info btn-lg" type="button" value="Get"
				id="authGet" /> <br> <br>
		</div>
	
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

			<h4>添加一条补贴比例参数记录</h4>
			<input class="btn btn-info btn-lg" type="button" value="Add" id="add" /><br>
			<h4>删除一条补贴比例参数记录</h4>
			<input class="btn btn-info btn-lg" type="button" value="Delete"
				id="delete" /><br>
			<h4>获取所有补贴比例参数记录</h4>
			<input class="btn btn-info btn-lg" type="button" value="GetAll"
				id="getAll" /><br>
			<h4>更新一条补贴比例参数记录</h4>
			<input class="btn btn-info btn-lg" type="button" value="Update"
				id="update" /><br>

			<!-- <h4>添加一条住房补贴参数记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="AddHouseSub" id="addHouseSub" /><br>
			<h4>删除一条住房补贴参数记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="DeleteHouseSub" id="deleteHouseSub" /><br>
			<h4>获取所有住房补贴参数记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetAllHouseSub" id="getAllHouseSub" /><br>
			<h4>更新一条住房补贴参数记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="UpdateHouseSub" id="updateHouseSub" /><br> -->
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
			<h4>设置角色</h4>
			<input class="btn btn-info btn-lg" type="button" value="UpdateStaffRole"
				id="updateStaffRole" /> <br> <br>
			<h4>解除绑定</h4>
			<input class="btn btn-info btn-lg" type="button" value="Unbind"
				id="unbind" /> <br> <br>
			<h4>获取头像</h4>
			<input class="btn btn-info btn-lg" type="button" value="GetIcon"
				id="getIcon" /> <br> <br>
			<h4>上传头像</h4>
			<input class="btn btn-info btn-lg" type="button" value="SaveIcon"
				id="saveIcon" /> <br> <br>
			<h4>计算单个职工总分</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="calculateStaffValueByStaffNo"
				id="calculateStaffValueByStaffNo" /> <br> <br>
			<h4>计算所有职工总分</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="CalculateAllStaffValue" id="calculateAllStaffValue" /> <br>
			<br>
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
			<h4>工资数据导入，计算货币化补贴</h4>
			<form action="dataImport/salaryImport" method="post"
				enctype="multipart/form-data">
				SalaryFile:<input type="file" name="salaryFile"> <input
					type="submit" value="Submit">
			</form>
			<h4>职工数据导入</h4>
			<form action="dataImport/staffDataImport" method="post"
				enctype="multipart/form-data">
				StaffFile:<input type="file" name="staffFile"> <input
					type="submit" value="Submit">
			</form>
			<br>
			<h4>住房数据导入</h4>
			<form action="dataImport/houseDataImport" method="post"
				enctype="multipart/form-data">
				HouseFile:<input type="file" name="houseFile"> <input
					type="submit" value="Submit">
			</form>
			<br>
			<h4>居民数据导入</h4>
			<form action="dataImport/residentDataImport" method="post"
				enctype="multipart/form-data">
				ResidentFile:<input type="file" name="residentFile"> <input
					type="submit" value="Submit">
			</form>
			<br>
			<h4>下载</h4>
			<a href="dataImport/staffDownLoad">职工模板下载</a> <br> <br> <a
				href="dataImport/houseDownLoad">住房模板下载</a><br> <br> <a
				href="dataImport/residentDownLoad">住户模板下载</a> <a
				href="exportToWord/hire/18">word</a> <a
				href="dataImport/salaryDownLoad">工资模板下载</a>
			<!-- <input type="file" id="upfile" name="upfile" placeholder="" />
			<button onclick="importExp();">导入</button> -->
			<!-- <input class="btn btn-info btn-lg" type="file"
				value="StaffDataImport" id="staffDataImport" /> <br> -->
		</div>
		<div class="tab-pane fade" id="internetSelectHouse">
			<h4>自助选房：获取当前能否点房相关信息</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="IsSelectingHouse" id="isSelectingHouse" /> <br>
			<h4>自助选房：显示所有已选房职工</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetAllSelectedStaff" id="getAllSelectedStaff" /> <br>
			<h4>自助选房：提交点房申请</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="SubmitSelectHouseApplication"
				id="submitSelectHouseApplication" /> <br>
			<h4>自助选房：显示所有未选房职工</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetAllCanselectHouse" id="getAllCanselectHouse" /> <br>
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

		<div class="tab-pane fade" id="rentGenerate">
			<h4>根据职工号或姓名查询</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="SelectRentByStaffNoOrName" id="selectRentByStaffNoOrName" />
			<br>
			<h4>租金查询</h4>
			<input class="btn btn-info btn-lg" type="button" value="QueryRent"
				id="queryRent" /> <br>
			<h4>多条件查询</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="SelectRentByMultiCondition" id="selectRentByMultiCondition" />
			<br>
			<h4>租金生成</h4>
			<input class="btn btn-info btn-lg" type="button" value="RentGen"
				id="rentGen" /> <br>
		</div>

		<div class="tab-pane fade" id="personalInfo">
			<h4>根据职工id获取维修信息</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetFixInfoByStaffId" id="getFixInfoByStaffId" /> <br>
			<h4>根据职工id获取租赁信息</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetHireInfoByStaffId" id="getHireInfoByStaffId" /> <br>
			<h4>首页维修信息更新通知</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetFixProcessStateChangeInfo"
				id="getFixProcessStateChangeInfo" /> <br>
			<h4>首页住房申请信息更新通知</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetHireProcessStateChangeInfo"
				id="getHireProcessStateChangeInfo" /> <br>
			<h4>维修评价</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="FixEvaluation" id="fixEvaluation" /> <br>
			<h4>获取职工房屋信息</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetResidentHouseByStaffId" id="getResidentHouseByStaffId" />
			<br>


		</div>
		<div class="tab-pane fade" id="querySta">
			<h4>多住房查询统计</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="StaffMoreHouseQuery" id="staffMoreHouseQuery" /> <br>
			<h4>多住房统计，根据staffId查询个人的多住房</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="StaffMoreHouseStaByStaffId" id="staffMoreHouseStaByStaffId" />
			<br>
			<h4>多住房统计</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="StaffMoreHouseSta" id="staffMoreHouseSta" /> <br>
		</div>
		<div class="tab-pane fade" id="houseSub">
			<h4>根据员工ID获取年度补贴计算公式参数</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetFormulaParameter" id="getFormulaParameter" /> <br>
		
			<h4>根据条件获取一次性补贴记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetAllOneTimeMonetarySubByCondition" id="getAllOneTimeMonetarySubByCondition" /> <br>
		
			<h4>添加一条老职工晋升补贴记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="AddPromoteSub" id="addPromoteSub" /> <br>

			<h4>获取所有一次性补贴记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetAllOneTimeMonetarySub" id="getAllOneTimeMonetarySub" /> <br>
			<h4>根据职工编号获取其所有一次性补贴记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetOneTimeMonetarySubByStaffNo"
				id="getOneTimeMonetarySubByStaffNo" /> <br>
			<h4>根据id删除一条一次性补贴记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="DeleteOneTimeMonetarySub" id="deleteOneTimeMonetarySub" /> <br>
			<h4>添加一条一次性住房补贴记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="AddOneTimeMonetarySub" id="addOneTimeMonetarySub" /> <br>


			<h4>根据条件获取补贴记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetAllMonetarySubByCondition" id="getAllMonetarySubByCondition" /> <br>
			<h4>获取所有补贴记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetAllMonetarySub" id="getAllMonetarySub" /> <br>
			<h4>根据职工编号获取其所有补贴记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="GetMonetarySubByStaffNo" id="getMonetarySubByStaffNo" /> <br>
			<h4>根据id删除一条补贴记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="DeleteMonetarySub" id="deleteMonetarySub" /> <br>
			<h4>添加一条住房补贴记录</h4>
			<input class="btn btn-info btn-lg" type="button"
				value="AddMonetarySub" id="addMonetarySub" /> <br>
		</div>

	</div>



</body>
</html>