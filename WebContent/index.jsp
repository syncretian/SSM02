<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%	
	//获取项目名
	String path = request.getContextPath();
	//获取tomcat 协议+地址+端口号+ 获取项目名
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//获取tomcat 协议+地址+端口号
	String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/img/";
	
%>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Bootstrap Material Admin </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="<%=basePath %>vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="<%=basePath %>vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="<%=basePath %>css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="<%=basePath %>css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="<%=basePath %>css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="<%=basePath %>img/favicon.ico">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
       <link rel="stylesheet" href="layer/theme/default/layer.css">  
       <link rel="stylesheet" href="css/my.css">
       
       <link rel="stylesheet" href="layui/css/layui.css">
       <script src="layui/layui.js"></script>

     
       
  </head>
  <body>
    <div class="page">
      <!-- Main Navbar-->
      <header class="header">
        <nav class="navbar">
          <!-- Search Box-->
          <div class="search-box">
            <button class="dismiss"><i class="icon-close"></i></button>
            <form id="searchForm" action="#" role="search">
              <input type="search" placeholder="What are you looking for..." class="form-control">
            </form>
          </div>
          <div class="container-fluid">
            <div class="navbar-holder d-flex align-items-center justify-content-between">
              <!-- Navbar Header-->
              <div class="navbar-header">
                <!-- Navbar Brand --><a href="index.html" class="navbar-brand d-none d-sm-inline-block">
                  <div class="brand-text d-none d-lg-inline-block"><span>咔咔中学</span><strong> 学生信息管理系统</strong></div>
                  <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>BD</strong></div></a>
                <!-- Toggle Button--><a id="toggle-btn" href="#" class="menu-btn active"><span>1</span><span></span><span></span></a>
              </div>
              <!-- Navbar Menu -->
              <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                <!-- Search-->
                <li class="nav-item d-flex align-items-center"><a id="search" href="#"><i class="icon-search"></i></a></li>
                <!-- Notifications-->
                <li class="nav-item dropdown"> <a id="notifications" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link"><i class="fa fa-bell-o"></i><span class="badge bg-red badge-corner">12</span></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification">
                          <div class="notification-content"><i class="fa fa-envelope bg-green"></i>You have 6 new messages </div>
                          <div class="notification-time"><small>4 minutes ago</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification">
                          <div class="notification-content"><i class="fa fa-twitter bg-blue"></i>You have 2 followers</div>
                          <div class="notification-time"><small>4 minutes ago</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification">
                          <div class="notification-content"><i class="fa fa-upload bg-orange"></i>Server Rebooted</div>
                          <div class="notification-time"><small>4 minutes ago</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification">
                          <div class="notification-content"><i class="fa fa-twitter bg-blue"></i>You have 2 followers</div>
                          <div class="notification-time"><small>10 minutes ago</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong>view all notifications                                            </strong></a></li>
                  </ul>
                </li>
                <!-- Messages                        -->
                <li class="nav-item dropdown"> <a id="messages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link"><i class="fa fa-envelope-o"></i><span class="badge bg-orange badge-corner">10</span></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item d-flex"> 
                        <div class="msg-profile"> <img src="<%=basePath %>img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="msg-body">
                          <h3 class="h5">Jason Doe</h3><span>Sent You Message</span>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item d-flex"> 
                        <div class="msg-profile"> <img src="<%=basePath %>img/avatar-2.jpg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="msg-body">
                          <h3 class="h5">Frank Williams</h3><span>Sent You Message</span>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item d-flex"> 
                        <div class="msg-profile"> <img src="<%=basePath %>img/avatar-3.jpg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="msg-body">
                          <h3 class="h5">Ashley Wood</h3><span>Sent You Message</span>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong>Read all messages   </strong></a></li>
                  </ul>
                </li>
                <!-- Languages dropdown    -->
                <li class="nav-item dropdown"><a id="languages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link language dropdown-toggle"><img src="<%=basePath %>img/flags/16/GB.png" alt="English"><span class="d-none d-sm-inline-block">English</span></a>
                  <ul aria-labelledby="languages" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item"> <img src="<%=basePath %>img/flags/16/DE.png" alt="English" class="mr-2">German</a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> <img src="<%=basePath %>img/flags/16/FR.png" alt="English" class="mr-2">French                                         </a></li>
                  </ul>
                </li>
                <!-- Logout    -->
                <li class="nav-item"><a href="login.html" class="nav-link logout"> <span class="d-none d-sm-inline">Logout</span><i class="fa fa-sign-out"></i></a></li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <div class="page-content d-flex align-items-stretch"> 
        <!-- Side Navbar -->
        <nav class="side-navbar">
          <!-- Sidebar Header-->
          <div class="sidebar-header d-flex align-items-center">
            <div class="avatar"><img src="<%=basePath %>img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
            <div class="title">
              <h1 class="h4">${user.uname }</h1>
              <p>${user.role }</p>
              
            </div>
          </div>
          <!-- Sidebar Navidation Menus--><span class="heading">导航栏</span>
          <ul class="list-unstyled">
                    <li class="active"><a href="index.jsp"> <i class="icon-home"></i>Home </a></li>
                    <li><a href="javascript:studentfind()"> <i class="icon-grid"></i>学生信息管理</a></li> 
                    <li><a href="javascript:coursefind()"> <i class="icon-grid"></i>课程信息管理</a></li>
                    <li><a href="javascript:scorefind()"> <i class="icon-grid"></i>成绩信息管理</a></li>
                    
                    <li><a href="#"> <i class="icon-padnote"></i>Forms </a></li>
                    <li><a href="#exampledropdownDropdown" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>文件 </a>
                      <ul id="exampledropdownDropdown" class="collapse list-unstyled ">
                        <li><a href="javascript:fileupload()">单文件上传</a></li>
                        <li><a href="javascript:upload()">多文件上传</a></li>
                        <li><a href="javascript:uploadfile()">表单上传</a></li>
                      </ul>
                    </li>
                   <li><a href="#exampledropdownDropdown" aria-expanded="false" data-toggle="collapse"> <i class="fa fa-bar-chart"></i>Charts </a>
                      <ul id="exampledropdownDropdown" class="collapse list-unstyled ">
                        <li><a href="javascript:chart1()">柱状图</a></li>
                       <li><a href="javascript:chart2()">饼状图</a></li>
                       <li><a href="javascript:chart3()">折线图</a></li>
                      </ul>
                    </li>
                  
          </ul><span class="heading">Extras</span>
          <ul class="list-unstyled">
            <li> <a href="#"> <i class="icon-flask"></i>Demo </a></li>
            <li> <a href="#"> <i class="icon-screen"></i>Demo </a></li>
            <li> <a href="#"> <i class="icon-mail"></i>Demo </a></li>
            <li> <a href="#"> <i class="icon-picture"></i>Demo </a></li>
          </ul>
        </nav>
        
        
        
   
    
        <div class="content-inner">
        
        
        <div id="div_studentfind">
        
        
        
          <header class="page-header">
            <div class="container-fluid">
              <h2 class="no-margin-bottom">首页</h2>
            </div>
          </header>
        </div>
        
  
        
        
      </div>
    </div>
    
    
    
    
    <!-- JavaScript files-->
    <script src="<%=basePath %>vendor/jquery/jquery.min.js"></script>
    <script src="<%=basePath %>vendor/popper.js/umd/popper.min.js"> </script>
    <script src="<%=basePath %>vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="<%=basePath %>vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="<%=basePath %>js/charts-home.js"></script>
    <!-- Main File-->
    <script src="<%=basePath %>js/front.js"></script>
    
     <script src="js/jquery-3.4.1.js"></script> 
     <script src="layer/layer.js"></script>
   
    
     <script type="text/javascript">
     $(".list-unstyled>li").click(function(){
     	$(this).addClass('active').siblings('li').removeClass('active');
     })
     
     
     function studentfind(){
      	$.get("Studentfind.do",  function (data){
      		
      		$("#div_studentfind").html(data);
      	});
      }
      
      function coursefind(){
       	$.get("Coursefind.do",  function (data){
       		$("#div_studentfind").html("");
       		$("#div_studentfind").html(data);
       	});
       }
      
      
      function scorefind(){
        	$.get("Scorefind.do",  function (data){
        		
        		$("#div_studentfind").html(data);
        	});
        }
      
      
      
    ///////////---------------学生信息页面

      function addStudent(){
     	 
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
      
     
    //删除学生
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
    	
    
    ///////--------------课程信息页面
    
    
    
    function addCourse(){   	
    	 
     	layer.open({
    		  type: 2,    //1.静态内容弹出   ，2.url地址弹出
    		  skin: 'layui-layer-lan', //加上边框
    		  area: ['600px', '500px'], //宽高
    		  /* title: "", */
    		  content: 'addCoursePage.do',   //弹出内容
    		  
    		 end:function (){
    			 
    			 coursefind();
           	  }

    		});
      }
    
    function deleteCourse(cid){
    	//询问框

	   	 layer.confirm('确定删除该条数据？', {
	   	   btn: ['删除','取消'] //按钮
	   	 }, function(){
	   		//执行删除操作
	   		 $.get("deleteCourse.do",{"cid":cid},function(data){
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
    //////-------------添加成绩
    function addScore(){
    	layer.open({
  		  type: 2,    //1.静态内容弹出   ，2.url地址弹出
  		  skin: 'layui-layer-lan', //加上边框
  		  area: ['600px', '500px'], //宽高
  		  /* title: "", */
  		  content: 'addScorePage.do',   //弹出内容
  		  
  		 end:function (){
  			 
  			scorefind();
         	  }

  		});
    }
    
    function deleteScore(sid,cid){
    	//询问框
console.log(sid+"---"+cid);
	   	 layer.confirm('确定删除该条数据？', {
	   	   btn: ['删除','取消'] //按钮
	   	 }, function(){
	   		//执行删除操作
	   		 $.get("deleteScore.do",{"sid":sid,"cid":cid},function(data){
	   			 console.log(data);
	   			 if(data=="true"){
	   				 layer.msg('删除成功', {icon: 1});
	   				 //删除成功
	   				 scorefind();
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
    
    
    //////----------------文件上传
    function fileupload(){
    	layer.open({
  		  type: 2,    //1.静态内容弹出   ，2.url地址弹出
  		  skin: 'layui-layer-lan', //加上边框
  		  area: ['600px', '500px'], //宽高
  		  title: "单文件上传",
  		  content: 'file/fileupload.jsp',   //弹出内容
  		  
  		});
    }
    
    function upload(){
    	layer.open({
  		  type: 2,    //1.静态内容弹出   ，2.url地址弹出
  		  skin: 'layui-layer-lan', //加上边框
  		  area: ['600px', '500px'], //宽高
  		  title: "多文件上传",
  		  content: 'file/upload.jsp',   //弹出内容
  		  
  		});
    }
    
    
    function uploadfile(){
    	layer.open({
    		  type: 2,    //1.静态内容弹出   ，2.url地址弹出
    		  skin: 'layui-layer-lan', //加上边框
    		  area: ['600px', '500px'], //宽高
    		  title: "多文件上传",
    		  content: 'file/fileinfo.jsp',   //弹出内容
    		  
    		});
    }
    
    ////////----

    ///-----柱状图
    function chart1(){
    		$.get("chart1.do",  function (data){
          		
          		$("#div_studentfind").html(data);
          	});
    	
    	}
    //------饼状图
    function chart2(){
		$.get("chart2.do",  function (data){
      		
      		$("#div_studentfind").html(data);
      	});
	
	}
    ///---折线图
    function chart3(){
		$.get("chart3.do",  function (data){
      		
      		$("#div_studentfind").html(data);
      	});
	
	}
     </script>
   
    
  </body>
</html>