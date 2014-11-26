<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.list-group {
	text-align: center;
}

.list-group a:hover {
	background-color: #FAF2CC;
}
</style>
<script src="/epms/resource/js/jquery-1.11.1.min.js"></script>
<script src="/epms/resource/js/jquery-ui.js"></script>
<script>
	$(function() {
		$("#accordion").accordion({
			collapsible : true
		});
	});
</script>

<div id="accordion">
	<div class="list-group-item">任务管理</div>
	<div class="list-group">
		<a href="${pageContext.request.contextPath }/task/add-task" class="list-group-item">创建任务</a> 
		<a href="${pageContext.request.contextPath }/tasks" class="list-group-item">任务信息查看</a>
	</div>

	<div class="list-group-item">项目系统</div>
	<div class="list-group">
		<a href="${pageContext.request.contextPath }/project/add" class="list-group-item">项目基本信息查看</a> 
		<a href="#" class="list-group-item">项目需求信息查看</a> 
		<a href="#" class="list-group-item">项目模块信息查看</a>
	</div>

	<div class="list-group-item">客户系统</div>
	<div class="list-group">
		<a href="${pageContext.request.contextPath }/customers" class="list-group-item">客户信息查看</a>
	</div>

	<div class="list-group-item">人员系统</div>
	<div class="list-group">
		<a href="${pageContext.request.contextPath }/emps" class="list-group-item">人员信息查看</a>
	</div>

	<div class="list-group-item">系统管理</div>
	<div class="list-group">
		<a href="${pageContext.request.contextPath }/add-pro-manager" class="list-group-item">添加项目经理</a>
	</div>
</div>
