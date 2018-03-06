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
<script	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
			beforeSend: function(request) {
				request.setRequestHeader("X-token", "OF8xMjNfM18yMDE4LTAzLTA2IDEwOjI4OjAy");
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
		$.ajax({
			type : method,
			contentType : 'application/json;charset=UTF-8',
			dataType : 'json',
			beforeSend: function(request) {
				request.setRequestHeader("X-token", "OF8xMjNfM18yMDE4LTAzLTA2IDEwOjI4OjAy");
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

	//房屋参数
	$(function() {
		
		$("#houseTypeParamGet").click(function() {
			ajaxRequestGet("houseParam/getHouseParamId/2");

		})
		
		$("#houseParamGet").click(function() {
			ajaxRequestGet("houseParam/get/1");
		})
		
		$("#houseParamGetWithoutPage").click(function() {
			ajaxRequestGet("houseParam/getWithoutPage/1");
		})

		$("#houseParamDelete").click(function() {
			ajaxRequestPostType("houseParam/delete/3", "DELETE", null);
		})

		$("#houseParamAdd").click(function() {
			var data = {
				'houseParamName' : '租赁',
				'paramTypeId' : 3,
				'paramTypeName' : '使用状态'
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

	//维修参数
	$(function() {
		$("#fixParamGet").click(function() {
			ajaxRequestGet("fixParam/get/16");
		})

		$("#fixParamDelete").click(function() {
			ajaxRequestPostType("fixParam/delete/3", "DELETE", null);
		})

		$("#fixParamAdd").click(function() {
			var data = {
				'fixParamName' : '测试维修',
				'paramTypeId' : 16,
				'paramTypeName' : '维修内容'
			};
			ajaxRequestPostType("fixParam/add", "POST", data);
		})

		$("#fixParamModify").click(function() {
			var data = {
				'fixParamId' : 1,
				'fixParamName' : '修改测试',
				'paramTypeId' : 16,
				'paramTypeName' : '维修内容'
			};
			ajaxRequestPostType("fixParam/modify", "PUT", data);
		})
	})

	//租金参数
	$(function() {
		$("#rentalParamGet").click(function() {
			ajaxRequestGet("rentalParam/get");
		})

		$("#rentalParamModify").click(function() {
			var data = {
				//可以不设置rentalTypeId
				'rentalParamId' : 189,
				'rentalTimeDiv' : 2,
				'rentalOldDct' : '0.3',
				'rentalNewDctYear' : 5,
				'rentalNewDct' : '0.4'
			};
			ajaxRequestPostType("rentalParam/modify", "PUT", data);
		})
	})

	//地区
	$(function() {
		$("#regionGet").click(function() {
			ajaxRequestGet("region/get/1");
			//ajaxRequestGet("region/get?page=1&size=10"); 不带参数的才能加page和size 带参数的时候只获取一个 不能加
		})
		
		$("#getRegionWithBuildings").click(function() {
			ajaxRequestGet("region/getRegionWithBuildings/1");
			//ajaxRequestGet("region/get?page=1&size=10"); 
		})

		$("#regionDelete").click(function() {
			ajaxRequestPostType("region/delete/12", "DELETE", null);
		})

		$("#regionAdd").click(function() {
			var data = {
				'name' : "北冰洋",
				'description' : '南湖大草原'
			};
			ajaxRequestPostType("region/add", "POST", data);
		})

		$("#regionModify").click(function() {
			var data = {
				'id' : 1,
				'name' : '北湖de南边',
				'description' : '北湖大草原'
			};
			ajaxRequestPostType("region/modify", "PUT", data);
		})
	})
	
	//楼栋
	$(function() {
		$("#buildingGet").click(function() {
			ajaxRequestGet("building/get/1");
			//ajaxRequestGet("building/get?page=1&size=10"); 不带参数的才能加page和size 带参数的时候只获取一个，不能加page和size
		})
		
		$("#getBuildingByRegionId").click(function() {
			ajaxRequestGet("building/getAllByRegionId/1");
			//不带page=1&size=10默认不分页
		})

		$("#buildingDelete").click(function() {
			ajaxRequestPostType("building/delete/162", "DELETE", null);
		})

		$("#buildingAdd").click(function() {
			var data = {
				'name' : "南湖",
				'description' : '南湖大草原',
				'finishTime' : '2017-11-4',
				'floorArea' : '41.4',
				'usedArea' : '41.22',
				'floorCount' : '66',
				'regionId' : 1
			};
			ajaxRequestPostType("building/add", "POST", data);
		})

		$("#buildingModify").click(function() {
			var data = {
				'id' : 3,
				'name' : "2栋",
				'description' : '南湖大草原',
				'finishTime' : '2017-11-4',
				'floorArea' : '41.4',
				'usedArea' : '41.22',
				'floorCount' : '66',
				'regionId' : 2
			};
			ajaxRequestPostType("building/modify", "PUT", data);
		})
	})
	
	//房屋
	$(function() {
		$("#houseGet").click(function() {
			ajaxRequestGet("house/get/44");
			//ajaxRequestGet("house/get?page=1&size=10"); 不带参数的才能加page和size 带参数的时候只获取一个，不能加page和size
		})
		
		$("#houseGetAll").click(function() {
			ajaxRequestGet("house/get");
			//ajaxRequestGet("house/get?page=1&size=10"); 不带参数的才能加page和size 带参数的时候只获取一个，不能加page和size
		})
		
		$("#getViewHouseByRegionId").click(function() {
			ajaxRequestPostType("house/getViewHousesByRegionId/1");
			//不带page=1&size=10默认不分页
		})
		
		$("#getViewHouseByBuildingId").click(function() {
			ajaxRequestPostType("house/getViewHousesByBuildingId/4?page=1&size=10");
			//不带page=1&size=10默认不分页
		})

		$("#houseDelete").click(function() {
			ajaxRequestPostType("house/delete/12", "DELETE", null);
		})

		$("#houseAdd").click(function() {
			var data = {
				'no' : '576',
				'type' : 77,
				'layout' : 19,
				'struct' : 29,
				'buildArea' : 66,
				'usedArea' : 66,
				'basementArea' : 66,
				'address' : '水立方',
				'buildingId' : 5,
				'image':null,
				'proId' : '66',
				'remark':'凤梨酥',
				'rental':'26.9',
				'finishTime':new Date(),
				'recordStatus':1
			};
			ajaxRequestPostType("house/add", "POST", data);
		})

		$("#houseModify").click(function() {
			var data = {
					'id':7,
					'no' : '5776',
					'type' : 6,
					'layout' : 19,
					'struct' : 29,
					'buildArea' : 66,
					'usedArea' : 66,
					'basementArea' : 66,
					'address' : '水方',
					'buildingId' : 5,
					'image':null,
					'proId' : '66',
					'remark':'凤梨酥',
					'rental':'26.9',
					'finishTime':new Date(),
					'recordStatus':1
			};
			ajaxRequestPostType("house/modify", "PUT", data);
		})
	})
	
	//权限right&class
	$(function() {
		$("#rightGet").click(function() {
			ajaxRequestGet("right/getClassWithRights/2");
		})

		$("#getAllClassWithRight").click(function() {
			ajaxRequestGet("right/get");
		})
	})

	//角色
	$(function() {
		$("#roleGet").click(function() {
			ajaxRequestGet("role/get");
		})
		
		
	})
	
	//登陆
	$(function() {
		$("#login").click(function() {
			var data ={
					'no':'8',
					'password':'123',
					'roleId':3
			};
			ajaxRequestPostType("userLogin/login", "POST", data);
		})
		
		$("#logout").click(function() {
			ajaxRequestGet("userLogin/logout")
		})
		
		$("#tokenLogin").click(function() {
			ajaxRequestGet("userLogin/tokenLogin?token=OF8xMjNfMw==")
		})
		
	})
	
	//维修
	$(function() {
		$("#fixGetApply").click(function() {
			ajaxRequestGet("fix/getApply/1");
		})

		$("#fixAddApply").click(function() {
			var data = {
				'fixContentId':4,
				'description':'有什么东西坏了',
				'staffId':4,
				'houseId':4,
				'phone':'13329911694',
				'email':'123456@qq.com'
			};
			ajaxRequestPostType("fix/addApply", "POST", data);
		})
		
		$("#fixGetAccept").click(function() {
			ajaxRequestGet("fix/getAccept/1");
		})

		$("#fixAddAccept").click(function() {
			var data = {
				'id':45,
				'acceptState':'通过',
				'acceptNote':'先给他',
				'acceptMan':'任天宇'
			};
			ajaxRequestPostType("fix/addAccept", "PUT", data);
		})
		
		$("#fixGetAgree").click(function() {
			ajaxRequestGet("fix/getAgree/1");
		})
		
		$("#fixGetCheck").click(function() {
			var data = {
				//'conditionId':4,
				//'conditionContent':'20',
				'startTime':'2017-01-31',
				'endTime':'2018-02-27'
			};
			ajaxRequestPostType("fix/getCheckByAllMultiCondition?page=1&size=10", "POST", data);
		})
		
		$("#fixAddAgree").click(function() {
			var data = {
				'id':45,
				'agreeState':'拒绝',
				'agreeNote':'先给他同意，先给他同意',
				'agreeMan':'任天宇'
			};
			ajaxRequestPostType("fix/addAgree", "PUT", data);
		})
		
		
		$("#fixGetDirectApplyByStaffId").click(function() {
			ajaxRequestGet("fix/getDirectApplyByStaffId/1");
		})
		
		
		$("#fixGetDirectApplyByStaffName").click(function() {
			ajaxRequestGet("fix/getDirectApplyByStaffName?staffName=任天宇");
		})
		

		
		$("#fixAddDirectApply").click(function() {
			var data = {
				'directApplyMan':'任天宇1',
				'staffId':1,
				'houseId':1,
				'fixContentId':4,
				'fixDirectApplyNote':'直批直批'
			};
			ajaxRequestPostType("fix/addDirectApply", "POST", data);
		})
		
		$("#fixAddPrice").click(function() {
			var data = {
				'id':45,
				'price':'20.5',
				'priceMan':'任天宇1'
			};
			ajaxRequestPostType("fix/addPrice", "PUT", data);
		})
		
		$("#fixAddCheck").click(function() {
			var data = {
				'id':45	,
				'checkMan':'任天宇1'
			};
			ajaxRequestPostType("fix/addCheck", "PUT", data);
		})
		
		$("#fixReAccept").click(function() {
			ajaxRequestGet("fix/reAccept/45");
		})
		
		$("#fixReAgree").click(function() {
			ajaxRequestGet("fix/reAgree/45");
		})
		
		$("#fixGetManagement").click(function() {
			ajaxRequestGet("fix/getFixManagement?page=1&size=10");
		})
	})
	
	
	//房屋申请
	$(function() {
		$("#hireGetApply").click(function() {
			ajaxRequestGet("hire/getApply/1");
		})
		
		$("#hireAddApply").click(function() {
			var data = {
				'staffId' : 18,
				'phone' : '1654646465',
				'email' : '546456@163.com',
				'reason':'心情不好'
			};
			ajaxRequestPostType("hire/addApply", "POST", data);
		})

		$("#hireGetAccept").click(function() {
			ajaxRequestGet("hire/getAccept/1");
		})

		$("#hireAddAccept").click(function() {
			var data = {
				'id':91,
				'totalVal':54,
				'titleVal':54,
				'timeVal':2,
				'spouseVal':11,
				'otherVal':23,
				'acceptNote':'可以可以',
				'acceptMan':'ky',
				'acceptState':'通过'
			};
			ajaxRequestPostType("hire/addAccept", "PUT", data);
		})
		
		$("#hireReAccept").click(function() {
			ajaxRequestGet("hire/reAccept/91");
		})
		
		
		$("#hireGetAgree").click(function() {
			ajaxRequestGet("hire/getAgree/1");
		})
		
		$("#hireAddAgree").click(function() {
			var data = {
				'id':91,
				'houseId':7,
				'agreeNote':'可以可以',
				'agreeMan':'ky',
				'agreeState':'通过'
			};
			ajaxRequestPostType("hire/addAgree", "PUT", data);
		})
		
		$("#hireReAgree").click(function() {
			ajaxRequestGet("hire/reAgree/91");
		})
		
		$("#hireGetApprove").click(function() {
			ajaxRequestGet("hire/getApprove/1");
		})
		
		$("#hireAddApprove").click(function() {
			var data = {
				'id':91,
				'approveNote':'可以可以',
				'approveMan':'ky',
				'approveState':'通过'
			};
			ajaxRequestPostType("hire/addApprove", "PUT", data);
		})
		
		$("#hireReApprove").click(function() {
			ajaxRequestGet("hire/reApprove/91");
		})
		
		$("#hireGetSignContract").click(function() {
			ajaxRequestGet("hire/getSignContract");
		})
		
		$("#hireAddSignContract").click(function() {
			var data = {
				'id':91,
				'bookTime':'2017-01-31'
			};
			ajaxRequestPostType("hire/addSignContract", "POST", data);
		})
	})
	//下拉列表
	$(function() {
		$("#building_regionDown").click(function() {
			ajaxRequestGet("building/getList");
		})
	})
</script>

</head>
<body>


	<hr>
	<hr>
	<ul id="myTab" class="nav nav-tabs">
		<li class="active"><a href="#houseParam" data-toggle="tab">houseParam</a></li>
		<li><a href="#fixParam" data-toggle="tab">fixParam</a></li>
		<li><a href="#rentalParam" data-toggle="tab">rentalParam</a></li>
		<li><a href="#region" data-toggle="tab">region</a></li>
		<li><a href="#building" data-toggle="tab">building</a></li>
		<li><a href="#house" data-toggle="tab">house</a></li>
		<li><a href="#right" data-toggle="tab">right</a></li>
		<li><a href="#role" data-toggle="tab">role</a></li>
		<li><a href="#userlogin" data-toggle="tab">login</a></li>
		<li><a href="#fix" data-toggle="tab">fix</a></li>
		<li><a href="#hire" data-toggle="tab">hire</a></li>
		
		
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="houseParam">
			<input class="btn btn-info btn-lg" type="button" value="Get" id="houseParamGet" /> <br>
			<input class="btn btn-info btn-lg" type="button" value="GetHouseType" id="houseTypeParamGet" /> <br>
			<input class="btn btn-info btn-lg" type="button" value="houseParamGetWithoutPage" id="houseParamGetWithoutPage" /><br>
			<input class="btn btn-info btn-lg"type="button" value="Delete" id="houseParamDelete" /><br>
			<input class="btn btn-info btn-lg"type="button" value="Add" id="houseParamAdd" /> <br>
			<input class="btn btn-info btn-lg"type="button" value="Modify" id="houseParamModify" />
			<br>
		</div>
		<div class="tab-pane fade" id="fixParam">
			<input class="btn btn-info btn-lg" type="button" value="FixParamGet" id="fixParamGet" /> <br>
			<input class="btn btn-info btn-lg" type="button" value="FixParamDelete" id="fixParamDelete" /> <br>
			<input class="btn btn-info btn-lg" type="button" value="FixParamAdd" id="fixParamAdd" /> <br>
			<input class="btn btn-info btn-lg" type="button" value="FixParamModify" id="fixParamModify" /> <br>
		</div>
		<div class="tab-pane fade" id="rentalParam">
			<input class="btn btn-info btn-lg" type="button" value="RentalParamGet" id="rentalParamGet" /> <br>
			<input class="btn btn-info btn-lg" type="button" value="RentalParamModify" id="rentalParamModify" /><br>
		</div>
		<div class="tab-pane fade" id="region">
			<input class="btn btn-info btn-lg" type="button" value="RegionGet" id="regionGet" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="GetRegionWithBuildings" id="getRegionWithBuildings" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="RegionDelete" id="regionDelete" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="RegionAdd" id="regionAdd" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="RegionModify" id="regionModify" /> <br>
		</div>
		<div class="tab-pane fade" id="building">
			<input class="btn btn-info btn-lg" type="button" value="BuildingGet" id="buildingGet" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="GetBuildingByRegionId" id="getBuildingByRegionId" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="BuildingDelete" id="buildingDelete" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="BuildingAdd" id="buildingAdd" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="BuildingModify" id="buildingModify" /> <br>
		</div>
		<div class="tab-pane fade" id="house">
		            根据house的id获取一个house <br>
			<input class="btn btn-info btn-lg" type="button" value="HouseGet" id="houseGet" /> <br> <br>
			不传参获取全部的house，默认不分页<br>
			<input class="btn btn-info btn-lg" type="button" value="HouseGetAll" id="houseGetAll" /> <br><br>
			根据regionId获取一个地区的全部house，默认不分页<br>
			<input class="btn btn-info btn-lg" type="button" value="getViewHouseByRegionId" id="getViewHouseByRegionId" /> <br><br> 
			根据buildingId获取一个楼栋中的全部house，默认不分页<br>
			<input class="btn btn-info btn-lg" type="button" value="getViewHouseByBuildingId" id="getViewHouseByBuildingId" /> <br><br> 
			删除一个house<br>
			<input class="btn btn-info btn-lg" type="button" value="HouseDelete" id="houseDelete" /> <br> <br>
			增加一个house<br>
			<input class="btn btn-info btn-lg" type="button" value="HouseAdd" id="houseAdd" /> <br> <br>
			修改一个house<br>
			<input class="btn btn-info btn-lg" type="button" value="HouseModify" id="houseModify" /> <br><br>
		</div>
		<div class="tab-pane fade" id="right">
			<input class="btn btn-info btn-lg" type="button" value="获取带right的class" id="rightGet" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="获取全部带right的class" id="getAllClassWithRight" /> <br> 
			
		</div>
		<div class="tab-pane fade" id="role">
			<input class="btn btn-info btn-lg" type="button" value="role" id="roleGet" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="roleAdd" id="roleAdd" /> <br> 
		</div>
		<div class="tab-pane fade" id="userlogin">
			<br><div>
			<div>登陆 <br>
			<input class="btn btn-info btn-lg" type="button" value="登陆" id="login" /> <br> <br></div>
			</div>
			<div>退出登陆 <br>
			<input class="btn btn-info btn-lg" type="button" value="退出" id="logout" /> <br> <br></div>
			<div>token登陆 <br>
			<input class="btn btn-info btn-lg" type="button" value="token登陆" id="tokenLogin" /> <br> <br></div>
		</div>
		<div class="tab-pane fade" id="fix">
			<div>进入维修申请页面 <br>
			<input class="btn btn-info btn-lg" type="button" value="维修申请页面" id="fixGetApply" /> <br> <br></div>
			<div>维修申请 <br>
			<input class="btn btn-info btn-lg" type="button" value="维修申请" id="fixAddApply" /> <br> <br></div>
			<div>进入维修受理页面  0代表未经受理流程的全部信息，1代表受理过程结束的全部信息<br>
			<input class="btn btn-info btn-lg" type="button" value="维修受理页面" id="fixGetAccept" /> <br> <br></div>
			<div>维修受理   acceptMan为当前登录人的姓名，acceptState只能为'通过'或者'拒绝'<br>
			<input class="btn btn-info btn-lg" type="button" value="维修受理" id="fixAddAccept" /> <br> <br></div>
			<div>进入维修审核页面  0代表未经审核流程的全部信息，1代表审核过程结束的全部信息，包括同意审核<br>
			<input class="btn btn-info btn-lg" type="button" value="维修审核页面" id="fixGetAgree" /> <br> <br></div>
			<div>维修审核   agreeMan为当前登录人的姓名，agreeState只能为'通过'或者'拒绝'<br>
			<input class="btn btn-info btn-lg" type="button" value="维修审核" id="fixAddAgree" /> <br> <br></div>
			
			<div>维修直批页面  根据员工Id获取<br>
			<input class="btn btn-info btn-lg" type="button" value="维修直批页面" id="fixGetDirectApplyByStaffId" /> <br> <br></div>
			<div>维修直批页面  根据员工姓名获取 <br>
			<input class="btn btn-info btn-lg" type="button" value="维修直批页面" id="fixGetDirectApplyByStaffName" /> <br> <br></div>
			<div>维修直批 <br>
			<input class="btn btn-info btn-lg" type="button" value="维修直批" id="fixAddDirectApply" /> <br> <br></div>
			
			<div>维修结算  conditionId为筛选条件，conditionContent为对应的内容,例如condition=1，condition=“20”就代表选择单据号为"20"的数据，为null则默认没有这个条件<br>
			conditionId=1，单据号； conditionId=2，职工号； conditionId=3，住房号；conditionId=4，员工姓名；<br>
			<input class="btn btn-info btn-lg" type="button" value="维修结算页面" id="fixGetCheck" /> <br> <br></div>
			
			<div>维修定价   priceMan为当前登录人的姓名<br>
			<input class="btn btn-info btn-lg" type="button" value="维修定价" id="fixAddPrice" /> <br> <br></div>
			<div>维修结算   checkMan为当前登录人的姓名<br>
			<input class="btn btn-info btn-lg" type="button" value="维修结算" id="fixAddCheck" /> <br> <br></div>
			
			<div>重新受理   传入参数为fix的id<br>
			<input class="btn btn-info btn-lg" type="button" value="重新受理" id="fixReAccept" /> <br> <br></div>
			<div>重新审核   传入参数为fix的id<br>
			<input class="btn btn-info btn-lg" type="button" value="重新审核" id="fixReAgree" /> <br> <br></div>
			<div>维修管理页面<br>
			<input class="btn btn-info btn-lg" type="button" value="维修管理页面" id="fixGetManagement" /> <br> <br></div>
		</div>
		<div class="tab-pane fade" id="hire">
			<br><div>
			<div>住房申请页面 <br>
			<input class="btn btn-info btn-lg" type="button" value="住房申请页面" id="hireGetApply" /> <br> <br></div>
			</div>
			<div>住房申请 <br>
			<input class="btn btn-info btn-lg" type="button" value="住房申请" id="hireAddApply" /> <br> <br></div>
			
			<div>进入房屋申请受理页面  0代表未经受理流程的全部信息，1代表受理过程结束的全部信息<br>
			<input class="btn btn-info btn-lg" type="button" value="住房申请受理页面" id="hireGetAccept" /> <br> <br></div>
			<div>维修受理   acceptMan为当前登录人的姓名，acceptState只能为'通过'或者'拒绝'<br>
			<input class="btn btn-info btn-lg" type="button" value="住房申请受理" id="hireAddAccept" /> <br> <br></div>
			<div>重新受理   传入参数为hire的id<br>
			<input class="btn btn-info btn-lg" type="button" value="重新受理" id="hireReAccept" /> <br> <br></div>
			
			
			<div>进入房屋申请审核页面  0代表未经审核流程的全部信息，1代表审核过程结束的全部信息<br>
			<input class="btn btn-info btn-lg" type="button" value="住房申请审核页面" id="hireGetAgree" /> <br> <br></div>
			<div>维修审核   agreeMan为当前登录人的姓名，agreeState只能为'通过'或者'拒绝'<br>
			<input class="btn btn-info btn-lg" type="button" value="住房申请审核" id="hireAddAgree" /> <br> <br></div>
			<div>重新审核   传入参数为hire的id<br>
			<input class="btn btn-info btn-lg" type="button" value="重新审核" id="hireReAgree" /> <br> <br></div>
			
			<div>进入房屋申请审批页面  0代表未经审批流程的全部信息，1代表审批过程结束的全部信息<br>
			<input class="btn btn-info btn-lg" type="button" value="住房申请审批页面" id="hireGetApprove" /> <br> <br></div>
			<div>维修审批   approveMan为当前登录人的姓名，approveState只能为'通过'或者'拒绝'<br>
			<input class="btn btn-info btn-lg" type="button" value="住房申请审批" id="hireAddApprove" /> <br> <br></div>
			<div>重新审批   传入参数为hire的id<br>
			<input class="btn btn-info btn-lg" type="button" value="重新审批" id="hireReApprove" /> <br> <br></div>
			
			<div>进入房屋申请签订合同页面<br>
			<input class="btn btn-info btn-lg" type="button" value="住房申请签订合同页面" id="hireGetSignContract" /> <br> <br></div>
			<div>签订合同<br>
			<input class="btn btn-info btn-lg" type="button" value="签订合同" id="hireAddSignContract" /> <br> <br></div>
		</div>
	</div>



</body>
</html>