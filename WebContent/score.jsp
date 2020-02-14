<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


          <!-- Page Header-->
          <header class="page-header">
            <div class="container-fluid">
              <h2 class="no-margin-bottom">Tables</h2>
            </div>
          </header>
          <!-- Breadcrumb-->
          <div class="breadcrumb-holder container-fluid">
            <ul class="breadcrumb">
              <li class="breadcrumb-item"><a href="index.html">Home</a></li>
              <li class="breadcrumb-item active">Tables            </li>
            </ul>
          </div>
          
     <div>
        <li onclick="addScore()" style="margin-left:50px"  class="addbtn"><span style="color:green; font-weight: 900;font-size: 30px">+ &nbsp;</span>新增信息</li>
        <li style="margin-left:15px" class="addbtn" ><span  style="color:red; font-weight: 900;font-size: 30px">- &nbsp;</span>批量删除</li>
     </div>
        <br>
        <br>
          
          
          <section class="tables"  style="width:2500px ; margin-left:25px">   
            <div class="container-fluid">
              <div class="row">
                <div class="col-lg-6" style="width:90%">
                  <div class="card">
                    <div class="card-close">
                      <div class="dropdown">
                        <button type="button" id="closeCard1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>
                        <div aria-labelledby="closeCard1" class="dropdown-menu dropdown-menu-right has-shadow"><a href="#" class="dropdown-item remove"> <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit"> <i class="fa fa-gear"></i>Edit</a></div>
                      </div>
                    </div>
                    <div class="card-header d-flex align-items-center">
                      <h3 class="h4">Basic Table</h3>
                    </div>
                    <div class="card-body">
                      <div class="table-responsive">
                        <table lay-filter="demo" class="layui-table" >
                          <thead>
                            <tr>
                              <th   lay-data="{field:'i1',align:'center'}"><input type="checkbox"/></th>
                            <!--   <th>编号</th> -->
                              <th  lay-data="{field:'i2',align:'center'}">学生ID</th>
                              <th  lay-data="{field:'i3',align:'center'}">课程</th>
                            
                              <th  lay-data="{field:'i4',align:'center'}">成绩</th>
                                      
                               <th  lay-data="{field:'i5',align:'center'}">#</th>   
                                <th  lay-data="{field:'i6',align:'center'}">#</th>                          
                            </tr>
                          </thead>
                          
                          <tbody>
                           <c:forEach items="${scores}" var="s" varStatus="i">
                            <tr>
                              <td >${i.count }</td>
                            <%--   <td>${s.id }</td> --%>
                              <td>${s.sname }</td>
                              <td>${s.cname }</td>
                              
                              <td>${s.score }</td>
                           
                             
                              <td><a href="#">修改</a></td> 
                            <td><a href="javascript:deleteScore(${s.sid},${s.cid} )">删除</a></td> 
                            </tr>
                           </c:forEach> 
                           
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                </div>
                
            
              </div>
            </div>
          </section>
<script type="text/javascript">
layui.use('table',function (){
	var table=layui.table;
	table.init('demo' ,{
	// 这里写你初始化渲染的参数
	height: 315, //设置高度
	limit:5,
	page: true 
	});
	});



</script>
</body>
</html>