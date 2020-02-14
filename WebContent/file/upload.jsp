<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="uploads.do" method="post" enctype="multipart/form-data">

<input type="file" name="file" multiple="multiple"><br><br>

<input type="button" value="提交" onclick="sss()">
</form>

<script src="../js/jquery-3.4.1.js"></script>
<script>
function sss(){
	$("form").submit();
	
/* 	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index); */
}
</script>
</body>
</html>