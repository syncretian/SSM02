<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
div{
line-height:40px;
height:40px;
}
label{
margin-left:40px;
width:86px;line-height:34px; display:block; float:left;

}
.input1{
 	outline-style: none ;
    border: 1px solid #ccc; 
    border-radius: 3px;
    padding: 5px 5px;
    width: 300px;
    font-size: 14px;
    font-family: "Microsoft soft";
}
</style>
</head>
<body>

<form action="insertFile.do" method="post" enctype="multipart/form-data">
	<div>
	
	<label>账号：</label>
	<input type="text" name="username" class="input1">
	</div>
	<div>
	
	<label>描述：</label>
	<input type="text" name="description" class="input1">
	</div>
	<div>
	
	<label>我的文件：</label>
	<input type="file" name="text">
	</div>
	<div>
	
	<label>我的图片：</label>
	<input type="file" name="picture" >
	</div>
	
	<div>
	
	
	<input type="button" onclick="sss()" value="提交" style="margin-left:120px; width: 70px;font-size: 14px;" >
	</div>
</form>

<script src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript">
function sss(){
var formData = new FormData( $("form")[0]);
	
	$.ajax({
		url:"insertFile.do",

	       //jQuery参数，默认为false，当设置为true的时候，ajax提交的时候不会序列化data，而是直接使用data
        processData: false,
        //避免jQuery对contentType进行操作，从而与<form>中的enctype="multipart/form-data产生冲突
        contentType: false,
        //上传文件不需要缓存
        cache: false,
        type:"POST",
        data:formData,	
		success:function(data){
			if(data=="true"){
				
				parent. layer.msg('上传操作成功', {
		    	     time: 30000, //2s后自动关闭
		    	  
		    	   }); 
							
			}else{
				
				parent.layer.msg('上传操作失败', {
		    	     time: 30000, //2s后自动关闭
		    	  
		    	   }); 
			}
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);  
		},
		error:function (XMLHttpRequest, textStatus, errorThrown) {
			parent.layer.msg('请求失败', {
	    	     time: 30000, //2s后自动关闭
	    	  
	    	   }); 
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);  
		}
		});
	
	

}
</script>
</body>
</html>