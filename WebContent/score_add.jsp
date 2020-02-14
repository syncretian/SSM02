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
<div class="formtitle"><span>新增成绩信息</span></div>

<form class="forminfo" action="addScore.do" method="post">
<ul>
	
	<li><label>学生：</label>
		<select name="sid" class="dfinput">
		<option>选择学生</option>
		 <c:forEach items="${allstudent }" var="t">
		 	<option value="${t.sid}" >${t.sid}-${t.sname}</option>
		 </c:forEach>
		 </select>
	</li>
	
	<li><label>课程：</label>
		<select name="cid" class="dfinput">
		<option>选择课程</option>
		 <c:forEach items="${allcourse}" var="t">
		 	<option value="${t.cid}" title="${t.cid}">${t.cname}</option>
		 </c:forEach>
		 </select>
	</li>

	

	<li><label>成绩：</label><input type="text" name="score"></li>
	<li><span id="formbtn" class="formbtn">提交</span></li>
</ul>

</form>

</div>
<script>

$("#formbtn").click(function(){

	var str = $("form").serialize();
	console.log(str);
	
	$.ajax({
		url:"addScore.do?"+str,
				
		success:function(data){
			if(data=="true"){
				
				parent.layer.msg('新增操作成功', {
		    	     time: 20000, //2s后自动关闭
		    	  
		    	   }); 
							
			}else{
				
				parent.layer.msg('新增操作失败', {
		    	     time: 20000, //2s后自动关闭
		    	  
		    	   }); 
			}
			
			var index = parent.layer.getFrameIndex(window.name); 
			parent.layer.close(index); 
		},
		error:function (XMLHttpRequest, textStatus, errorThrown) {
		    // 通常 textStatus 和 errorThrown 之中
		    // 只有一个会包含信息
		   parent.layer.msg('请求失败', {
		    	     time: 20000, //2s后自动关闭
		    	  
		    	   }); 
		
		   var index = parent.layer.getFrameIndex(window.name); 
			parent.layer.close(index); 
		}
		});
		
	  
		
})
	
	
	


</script>
</body>
</html>