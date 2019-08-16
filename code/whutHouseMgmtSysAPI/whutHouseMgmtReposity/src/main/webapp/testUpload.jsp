<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="testFileUpload" method="post" enctype="multipart/form-data">
		File:<input type="file" name="file">
		<input type="submit" value="Submit">
	</form>
	
	<form action="dataImport/staffDataImport" method="post" enctype="multipart/form-data">
		StaffFile:<input type="file" name="staffFile">
		<input type="submit" value="Submit">
	</form>
	
	<form action="dataImport/houseDataImport" method="post" enctype="multipart/form-data">
		HouseFile:<input type="file" name="houseFile">
		<input type="submit" value="Submit">
	</form>
	
	<form action="dataImport/regionImport" method="post" enctype="multipart/form-data">
		RegionFile:<input type="file" name="regionFile">
		<input type="submit" value="Submit">
	</form>
	
	<form action="dataImport/buildingImport" method="post" enctype="multipart/form-data">
		BuildingFile:<input type="file" name="buildingFile">
		<input type="submit" value="Submit">
	</form>
	
	<form action="dataImport/salaryImport" method="post" enctype="multipart/form-data">
		SalaryFile:<input type="file" name="salaryFile">
		<input type="submit" value="Submit">
	</form>
	
	<form action="dataImport/saveData" method="post">
		<input type="submit" value="保存">
	</form>
	
	<form action="fileUpload/multiFileUpload" method="post" enctype="multipart/form-data">
		File1:<input type="file" name="file">
		File2:<input type="file" name="file">
		<input type="submit" value="Submit">
	</form>
	
	<form action="fileUpload/multiFileNamedUpload" method="post" enctype="multipart/form-data">
		File1:<input type="file" name="file">
		File2:<input type="file" name="file">
		<input type="submit" value="Submit">
	</form>
	
	<!-- 校园网 -->
	<!-- <img alt="图片" src="http://172.16.65.105:8080/images/1.jpg"> -->
	<a href="fileUpload/fileDownLoad?fileName=参数.txt">文件下载</a>
</body>
</html>