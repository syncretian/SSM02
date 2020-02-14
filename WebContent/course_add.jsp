<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增课程信息</title>
	<link rel="stylesheet" href="css/my.css">
	<script src="layer/layer.js"></script>
	<script src="js/jquery-3.4.1.js"></script>

</head>
<body>

<div class="formbody">
<div class="formtitle"><span>新增课程信息</span></div>

<form class="forminfo" action="addCourse.do" method="post">
<ul>
	<li><label>课程名：</label><input type="text" name="cname" class="dfinput"></li>
	
	
	<li><label>课程名：</label>
		<select name="teacher_id" class="dfinput">
		<option>选择教师</option>
		 <c:forEach items="${teacher}" var="t">
		 	<option value="${t.tid}" title="${t.tid}">${t}</option>
		 </c:forEach>
		 </select>
	</li>
	
	<li><label>修读学期：</label>
	<select name="term" class="dfinput">
		<option>选择教师</option>
		 <option value="大一">大一</option>
		 <option value="大二">大二</option>
		 <option value="大三">大三</option>
		 <option value="大四">大四</option>
		 </select>
	<li><span id="formbtn" class="formbtn">提交</span></li>
</ul>

</form>


<script>

$("#formbtn").click(function(){
	
	$("form").submit();
	
	
	
		var index = parent.layer.getFrameIndex(window.name); 
		parent.layer.close(index); 
})
	
	
	


</script>

</body>
</html>