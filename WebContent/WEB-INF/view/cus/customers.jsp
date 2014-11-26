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

    <title>客户信息</title>
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
	          <div class="panel-heading">客户信息</div>
	          <div class="panel-body">
	            <p>
	            	<input type="button" class="btn btn-primary" id="add" value="添加客户">
	            </p>
	          </div>
	        
	          <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead>
	                <tr>
	                   	<th>序号</th> <th>公司名称</th> <th>联系人</th> <td>联系电话</td> 
	                   	<th>联系地址</th> <th>公司背景</th> <th>添加时间</th> <th>备注</th> <th>操作</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<c:forEach items="${pager.datas }" var="cus" varStatus="status">
           			<tr>
           				<td>${status.count }</td>
            			<td>${cus.name }</td> 
            			<td>${cus.contacts }</td> 
            			<td>${cus.phone }</td>
            			<td>${cus.address }</td>
	  					<td>${cus.background }</td>
	  					<td><fmt:formatDate value="${cus.addtime }" pattern="yyyy年MM月dd日 "/></td>
	  					<td>${cus.remarks }</td>
	  					<td><a href="customer/update?id=${cus.id }" style="cursor: pointer;">编辑</a></td>
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
				      <pg:pager url="customers" items="${pager.totalRecord }" export="currentPageNumber=pageNumber" maxPageItems="5">  
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
	     </div> <!-- end of row -->
    </div> <!-- /container -->
    
    <!-- 编辑弹框 -->
	<!-- Button trigger modal 
	<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
		  Launch demo modal
	</button>
	-->
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-md">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel">客户信息录入</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal" role="form" id="form">
			  <div class="form-group">
			    <label for="name" class="col-sm-2 control-label">公司名称</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="name" name="name" placeholder="公司名称">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="contacts" class="col-sm-2 control-label">联系人</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="contacts" name="contacts" placeholder="联系人">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="phone" class="col-sm-2 control-label">联系电话</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="phone" name="phone" placeholder="联系电话">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="address" class="col-sm-2 control-label">公司地址</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="address" name="address" placeholder="公司地址">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="background" class="col-sm-2 control-label">公司背景</label>
			    <div class="col-sm-10">
			      <textarea class="form-control" rows="3" id="background" name="background" placeholder="公司背景"></textarea>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="remarks" class="col-sm-2 control-label">备注信息</label>
			    <div class="col-sm-10">
			      <textarea class="form-control" rows="3" id="remarks" name="remarks" placeholder="备注信息"></textarea>
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="addCus">添加客户</button>
	      </div>
	    </div>
	  </div>
	</div>
    


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="resource/bootstrap/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="resource/js/ie10-viewport-bug-workaround.js"></script>
    
    <script type="text/javascript">
		$(function(){
			// 显示添加框
			$("#add").click(function(){
				$('#myModal').modal();
			});
			
			$("#addCus").click(function(){
				var data = $("#form").serialize();
				// 发送Ajax请求
				$.ajax({
			         type: "POST",
			         url: "customer/add",
			         data: decodeURIComponent(data, true),
			         dataType: "text",
			         success: function(msg) {
			        	 if(msg == 'success'){
							alert("添加成功");		
							$('#myModal').modal('hide')
			        	 }else {
			        		alert("添加失败");
			        	 }
			         }
				});
			});
		});    
   	 	
    </script>
  </body>
</html>








