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
	
	<form action="dataImport/saveData" method="post">
		<input type="submit" value="保存">
	</form>
	
</body>
</html>