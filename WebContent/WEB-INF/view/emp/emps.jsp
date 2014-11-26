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

    <title>员工信息</title>
    <link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="resource/css/navbar-static-top.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="resource/js/ie-emulation-modes-warning.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
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
	        
	          <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead>
	                <tr>
	                   	<th>序号</th> <th>员工编号</th> <th>员工姓名</th> <td>职位</td> 
	                   	<th>员工类型</th> <th>性别</th> <th>出生年月</th> <th>联系电话</th> <th>操作</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<c:forEach items="${pager.datas }" var="emp" varStatus="status">
           			<tr>
           				<td>${status.count }</td>
            			<td>${emp.empNum }</td> 
            			<td>${emp.name }</td> 
            			<td>${emp.jobType.name }</td>
            			<td>${emp.empType.name }</td>
	  					<td>${emp.gender }</td>
	  					<td><fmt:formatDate value="${emp.birthday }" pattern="yyyy年MM月dd日 "/></td>
	  					<td>${emp.phone }</td>
	  					<td><a href="${pageContext.request.contextPath }/emp/update?id=${emp.id }">编辑</a></td>
           			</tr>
           			</c:forEach>
	            </tbody>
	          </table>
	            <div class="panel-footer">
	          		<!-- 
		          	分页显示
		          	maxPageItems:每页显示的行数，默认为10 
		          	maxIndexPages:在循环输出页码的时候，最大输出多少个页码，默认是10 
		           -->	
		          <nav style="text-align:center;">
				  <ul class="pagination">
				      <pg:pager url="emps" items="${pager.totalRecord }" export="currentPageNumber=pageNumber" maxPageItems="5">  
						   <%--  <li><a>总记录数${pager.totalRecord }</a></li>
						    <li><a>总页数${pager.totalPage }</a></li>
						    <li><a>当前页${currentPageNumber }</a></li> --%>
						    
						    <c:if test="${currentPageNumber != 1 }">
						    <pg:first>
						    	<li><a href="${pageUrl}">首页</a></li>
						    </pg:first>  
						    </c:if>

						    <pg:prev>
						    	<li><a href="${pageUrl }">上一页</a></li>
						    </pg:prev>  
			
						   <pg:pages>  
					         <c:choose>  
					            <c:when test="${currentPageNumber eq pageNumber}">  
					             	<li class="active"><a>${pageNumber }</a></li>
					            </c:when>  
					            <c:otherwise>  
					           		 <li><a href="${pageUrl }">${pageNumber }</a></li>
					            </c:otherwise>  
					         </c:choose>  
					   	   </pg:pages>  
			
						    <pg:next>  
						        <li><a href="${pageUrl }">下一页</a></li>
						    </pg:next>  
						    
						    <c:if test="${currentPageNumber != pager.totalPage }">
						    <pg:last>  
						         <li><a href="${pageUrl }">尾页</a></li>  
						    </pg:last>  
						    </c:if> 
						</pg:pager>  
					</ul>
					</nav>
	            </div>
	        </div> <!-- end of panel -->
        	</div>
			
	     </div>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="resource/bootstrap/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="resource/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
