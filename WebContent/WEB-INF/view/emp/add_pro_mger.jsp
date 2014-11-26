<%@page import="com.epms.pojo.Task"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>     
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>添加项目经理</title>
    <link href="${pageContext.request.contextPath }/resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/resource/css/navbar-static-top.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${pageContext.request.contextPath }/resource/js/ie-emulation-modes-warning.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/res/.pond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">
    	.page-context {
    		width: 100%;
    		height: 800px;
    		border: 1px solid #ccc;
    	}
    </style>
  
    
  </head>
  <body>
   	<jsp:include page="../header.jsp"></jsp:include>
    <div class="container page-context">
          <div class="row">
          	<div class="col-md-2">
          		<!-- 左边菜单 -->
          		<jsp:include page="../left.jsp"></jsp:include>
          	</div>
          	<div class="col-md-10">
          	<div class="panel panel-primary">
	          <div class="panel-heading">添加项目经理</div>
	          <div class="panel-body">
				&nbsp;	            
	          </div>
	        	<form class="form-horizontal" role="form" method="post">
				  <div class="form-group">
				    <label for="title" class="col-sm-4 control-label">员工编号</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="title" name="title" value="${task.title }" placeholder="项目经理的员工编号">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="title" class="col-sm-4 control-label">选择项目</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="title" name="title" value="${task.title }">
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="col-sm-offset-4 col-sm-10">
				      <button type="submit" class="btn btn-primary">添加项目经理</button>
				    </div>
				  </div>
				</form>
	        </div> <!-- end of panel -->
        	</div>
			
	     </div>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="${pageContext.request.contextPath }/resource/bootstrap/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath }/resource/js/ie10-viewport-bug-workaround.js"></script>
    
    <script type="text/javascript">
    	$(function(){
    		
    		$("#updateCus").click(function(){
    			
    			var data = $("form").serialize();
    			
    			$.ajax({
    				type: "POST",
    				url: "update",
    				data: decodeURIComponent(data,true),/* 解决中文乱码问题 */
    				dataType: "text",
    				success: function(msg){
    					var message = "";
    					if(msg == 'success'){
							message = "更新成功";		
			        	}else if(msg = 'fail'){
			        		message = "更新失败";	
			        	}else {
			        		message = "服务器端出错";	
			        	}

    					alert(message);
    					
    					window.location.href="${pageContext.request.contextPath }/customers";
    				}
    			});
    		});
    		
    	});
    </script>

  </body>
</html>








