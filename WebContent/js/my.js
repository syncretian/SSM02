/*    
     function studentfind(){
     	$.get("Studentfind.do",  function (data){
     		
     		$("#div_studentfind").html(data);
     	});
     }
     
     function coursefind(){
      	$.get("Coursefind.do",  function (data){
      		
      		$("#div_studentfind").html(data);
      	});
      }
     
     
     function scorefind(){
       	$.get("Scorefind.do",  function (data){
       		
       		$("#div_studentfind").html(data);
       	});
       }
     
     
     
   //学生信息页面

     function addStudent(){
    	 alert("333..");
    	 
    	 layer.open({
    		  type: 2,    //1.静态内容弹出   ，2.url地址弹出
    		  skin: 'layui-layer-lan', //加上边框
    		  area: ['600px', '500px'], //宽高
    		  title: true,
    		  content: 'addPage.do',   //弹出内容
    		  
    		 end:function (){
    			 
    			 studentfind();
           	  }

    		});
     }
     
     
     $("#addStudent").click(function(){
     	console.log("222..");
     	layer.open({
     		  type: 2,    //1.静态内容弹出   ，2.url地址弹出
     		  skin: 'layui-layer-lan', //加上边框
     		  area: ['600px', '500px'], //宽高
     		  title: true,
     		  content: 'addPage.do',   //弹出内容
     		  
     		 end:function (){
     			 
     			 studentfind();
            	  }

     		});
     })

     function deleteStudent(sid){
    	//询问框

    	 layer.confirm('确定删除该条数据？', {
    	   btn: ['删除','取消'] //按钮
    	 }, function(){
    		//执行删除操作
    		 $.get("deleteStudent.do",{"sid":sid},function(data){
    			 console.log(data);
    			 if(data=="true"){
    				 layer.msg('删除成功', {icon: 1});
    				 //删除成功
    				 studentfind();
    			 }else{
    				 layer.msg('删除失败', {icon: 1});
    			 }
    		 },"text")
    	   
    	 }, function(){
    	   layer.msg('取消删除操作', {
    	     time: 2000, //2s后自动关闭
    	  
    	   });
    	 })
    	}
    	
    	 
    
     
       $("#courseadd").click(function(){
     	
         console.log("23434...")
     	layer.open({
     		  type: 2,    //1.静态内容弹出   ，2.url地址弹出
     		  skin: 'layui-layer-lan', //加上边框
     		  area: ['600px', '500px'], //宽高
     		  title: true,
     		  content: 'addCoursePage.do',   //弹出内容
     		  
     		 end:function (){
     			 
     			coursefind();
            	  }

     		});
       })*/