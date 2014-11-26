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

    <title>创建任务</title>
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
          		<jsp:include page="../left.jsp"></jsp:include>
          	</div>
          	<div class="col-md-10">
          	<div class="panel panel-primary">
	          <div class="panel-heading">创建任务</div>
	          <div class="panel-body">
				&nbsp;	            
	          </div>
	        	<form class="form-horizontal" role="form" method="post">
				  <div class="form-group">
				    <label for="title" class="col-sm-4 control-label">任务标题</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="title" name="title" placeholder="任务标题">
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="period" class="col-sm-4 control-label">工期</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="period" name="period" placeholder="工期">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="executor" class="col-sm-4 control-label">任务执行人</label>
				    <div class="col-sm-3">
						<input type="text" class="form-control" id="executor" name="executor" placeholder="任务执行人员工号">
					</div>
				  </div>
				   <div class="form-group">
				    <label for="starttime" class="col-sm-4 control-label">计划开始时间</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="starttime" name="starttime" placeholder="计划开始时间">
				    </div>
				  </div>
			
				   <div class="form-group">
				   	  <label for="endtime" class="col-sm-4 control-label">计划结束时间</label>
				      <div class="col-sm-3">
					  	  <input type="text" class="form-control" id="endtime" name="endtime" placeholder="计划结束时间">
					  </div>
				  </div>
				  
				  <div class="form-group">
			         <label for="priority" class="col-sm-4 control-label">优先级</label>
			         <div class="col-sm-3">
				  	  <select class="form-control" name="priority">
				  		<option value="暂不">暂不</option>
				  		<option value="一般">一般</option>
				  		<option value="需要">需要</option>
				  		<option value="急">急</option>
				  		<option value="很急">很急</option>
					  </select>
				     </div>
				  </div>
				  <div class="form-group">
			         <label for="status" class="col-sm-4 control-label">完成状态</label>
			         <div class="col-sm-3">
				  	  <select class="form-control" name="status">
				  		<option value="尚未开始">尚未开始</option>
				  		<option value="正在进行">正在进行</option>
				  		<option value="已完成">已完成</option>
					  </select>
				     </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="explain" class="col-sm-4 control-label">任务说明</label>
				    <div class="col-sm-3">
				      <textarea class="form-control" rows="3" placeholder="任务说明" id="explain" name="explain"></textarea>
				    </div>
				  </div>
				  
				  
				  <div class="form-group">
				    <div class="col-sm-offset-5 col-sm-10">
				      <button type="submit" class="btn btn-primary">创建任务</button>
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
  </body>
</html>
