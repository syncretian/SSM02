<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增学生信息</title>
	<link rel="stylesheet" href="css/my.css">
	<script src="layer/layer.js"></script>
	<script src="js/jquery-3.4.1.js"></script>

</head>
<body>

<div class="formbody">
<div class="formtitle"><span>新增学生信息</span></div>

<form class="forminfo" action="addStudent.do" method="post">
<ul>
	<li><label>姓名：</label><input type="text" name="sname" class="dfinput"></li>
	<li><label>班级：</label>
		<select name="cid" class="dfinput">
		<option>选择班级</option>
		 <c:forEach items="${grade}" var="g">
		 	<option value="${g.gid}" title="${g.gid}">${g}</option>
		 </c:forEach>
		 </select>
	</li>
	
	<li><label>性别：</label>
		<input type="radio" name="sex" value="男">男
		<input type="radio" name="sex" value="女">女
	</li>
	
	<li><label>年龄：</label><input type="text" name="age" class="dfinput"></li>
	
	<li><label>地址：</label>
		<select name="aid" class="dfinput">
			 <option>选择班级</option>
			 <c:forEach items="${address}" var="a">
			 	<option value="${a.aid}" title="${a.aid }">${a }</option>
			 </c:forEach>
		
		</select>
	
	
	</li>
	<li><span id="formbtn" class="formbtn">提交</span></li>
</ul>

</form>


<script>

$("#formbtn").click(function(){
/* 	$("form").submit();
	var index = parent.layer.getFrameIndex(window.name); 
	parent.layer.close(index); */
	
	
	var str = $("form").serialize();
	console.log(str);
	
	$.ajax({
		url:"addStudent.do?"+str,
		type:"post",
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
		   parent.layer.msg('请求失败失败', {
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