<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../env.jsp"%>    
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/admin/css/common.css"/>
	</head>
	<body>
		<div class="page-content-wrap">
			<form class="layui-form" action="">
				<div class="layui-form-item">
				    <label class="layui-form-label label-small">账号</label>
				    <div class="layui-input-inline">
				        <input type="text" name="userid" autocomplete="off" placeholder="请输入账号" class="layui-input">
				    </div>
				    <label class="layui-form-label label-small">姓名</label>
				    <div class="layui-input-inline">
				        <input type="text" name="name" autocomplete="off" placeholder="请输入名字" class="layui-input">
				    </div>
				    <label class="layui-form-label label-small">性别</label>
				    <div class="layui-input-inline">
				      <select name="sex">
				        <option value="">请选择性别</option>
				        <option value="1">男</option>
				        <option value="2">女</option>
				      </select>
				    </div>
				    <button class="layui-btn layui-btn-primary">查询</button>
				</div>
			</form>
		</div>
	</body>
	<script type="text/javascript">
	layui.use(['form'], function(){
		
	});
		
	</script>
</html>
