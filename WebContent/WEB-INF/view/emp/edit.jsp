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

    <title>更新员工信息</title>
    <link href="${pageContext.request.contextPath }/resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/resource/css/navbar-static-top.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/resource/css/bootstrap-datetimepicker.css" rel="stylesheet">
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
	          <div class="panel-heading">员工信息</div>
	          <div class="panel-body">
				&nbsp;	            
	          </div>
	        	<form class="form-horizontal" role="form" method="post">
				  <div class="form-group has-feedback">
				    <label for="empNum" class="col-sm-2 control-label">员工编号</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="empNum" name="empNum" value="${emp.empNum }" placeholder="员工编号">
				      <span class="glyphicon glyphicon-ok form-control-feedback"></span>
				      <input type="hidden" name="id" value="${emp.id }">
				    </div>
				    <label for="password" class="col-sm-2 control-label">密码</label>
				    <div class="col-sm-3">
				      <input type="password" class="form-control" id="password" name="password" placeholder="若不改密码 不要填写任何数据">
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="name" class="col-sm-2 control-label">真实姓名</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="name" name="name" value="${emp.name }" placeholder="真实姓名">
				    </div>
					
				    <label for="gender" class="col-sm-2 control-label">性别</label>&nbsp;&nbsp;
					<c:if test="${emp.gender == '男' }">
						<label class="radio-inline">
						  <input type="radio" name="gender" checked="checked" id="inlineRadio1" value="男"> 男
						</label>
						<label class="radio-inline">
						  <input type="radio" name="gender" id="inlineRadio2" value="女"> 女
						</label>
					</c:if>		
					<c:if test="${emp.gender == '女' }">
						<label class="radio-inline">
						  <input type="radio" name="gender" id="inlineRadio1" value="男"> 男
						</label>
						<label class="radio-inline">
						  <input type="radio" name="gender" checked="checked" id="inlineRadio2" value="女"> 女
						</label>
					</c:if>				    
				    
				  </div>
				  
				  <div class="form-group">
				    <label for="birthday" class="col-sm-2 control-label">出生日期</label>
				    
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="birthday" name="birthday"
				     	value="<fmt:formatDate value="${emp.birthday }" pattern="yyyy-MM-dd"/>" placeholder="出生日期">
				    </div>
				    <label for="phone" class="col-sm-2 control-label">电话号码</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="phone" name="phone" value="${emp.phone }" placeholder="电话号码">
				    </div>
				  </div>
				  
				   <div class="form-group">
				    <label for="email" class="col-sm-2 control-label">电子邮箱</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="email" name="email" value="${emp.email }" placeholder="电子邮箱">
				    </div>
				    <label for="address" class="col-sm-2 control-label">居住地址</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="address" name="address" value="${emp.address }" placeholder="居住地址">
				    </div>
				  </div>
			
				   <div class="form-group">
				   	  <label for="empType" class="col-sm-2 control-label">员工类型</label>
				      <div class="col-sm-3">
					  	  <select class="form-control" name="empType">
						  	<c:forEach items="${empTypes }" var="empType">
						  		<c:choose>
						  			<c:when test="${empType.name == emp.empType.name }">
						  			 	<option value="${empType.id }" selected="selected">${empType.name }</option>
						  			</c:when>
						  			<c:otherwise>
						  				<option value="${empType.id }">${empType.name }</option>
						  			</c:otherwise>
						  		</c:choose>	
						  	</c:forEach>
						  </select>
					  </div>
				      
				      <label for="jobType" class="col-sm-2 control-label">职位</label>
				      <div class="col-sm-3">
					  	  <select class="form-control" name="jobType">
							 <c:forEach items="${jobTypes }" var="jobType">
						  		<c:choose>
						  			<c:when test="${jobType.name == emp.jobType.name }">
						  			 	<option value="${jobType.id }" selected="selected">${jobType.name }</option>
						  			</c:when>
						  			<c:otherwise>
						  				<option value="${jobType.id }">${jobType.name }</option>
						  			</c:otherwise>
						  		</c:choose>	
						  	</c:forEach>
						  </select>
					  </div>
				  </div>
				  
				  <div class="form-group">
					<label for="hiredate" class="col-sm-2 control-label">入职时间</label>
				    <div class="input-group date form_date col-sm-3">
				        <input class="form-control" type="text" 
				        value="<fmt:formatDate value="${emp.hiredate }" pattern="yyyy-MM-dd"/>" id="hiredate" name="hiredate" readonly>
				         <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>	
				    </div>
				  </div>
				  
				  <div class="form-group">
				   <label for="description" class="col-sm-2 control-label">描述</label>
				    <div class="col-sm-3">
				      <textarea class="form-control" rows="3" placeholder="描述" name="description">${emp.description }</textarea>
				    </div>
				  </div>
				 <%--  <div class="form-group input-group date form_date" data-date="" data-date-format="dd MM yyyy">
				    <label for="hiredate" class="col-sm-2 control-label">入职时间</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" id="hiredate" name="hiredate"
				      	value="<fmt:formatDate value="${emp.hiredate }" pattern="yyyy年MM月dd日"/>" placeholder="入职时间">
				      <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>	
				    </div>
				    <label for="description" class="col-sm-2 control-label">描述</label>
				    <div class="col-sm-3">
				      <textarea class="form-control" rows="3" placeholder="描述" name="description">${emp.description }</textarea>
				    </div>
				  </div> --%>
				  
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button type="submit" class="btn btn-primary">更新员工信息</button>
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
    <script src="${pageContext.request.contextPath }/resource/js/bootstrap-datetimepicker.js"></script>
	<script src="${pageContext.request.contextPath }/resource/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
	<script type="text/javascript">
	   $('.form_date').datetimepicker({
		   format: 'yyyy-mm-dd',
	       language: 'zh-CN',
	       weekStart: 1,
	       todayBtn:  1,
		   autoclose: 1,
		   todayHighlight: 1,
		   startView: 2,
		   minView: 2,
		   forceParse: 0
	   });
	   
	</script>
  </body>
</html>
