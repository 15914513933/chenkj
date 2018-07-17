<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../env.jsp"%>    
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/admin/css/common.css?v=1"/>
		<script src="<%=basePath%>/CryptoJS/rollups/sha256.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<div class="page-content-wrap">
			<form class="layui-form" action="">
				<div class="layui-form-item">
				    <label class="layui-form-label label-small label-pl">账号</label>
				    <div class="layui-input-inline">
				        <input id="userid" type="text" name="userid" autocomplete="off" placeholder="请输入账号" class="layui-input">
				    </div>
				    <label class="layui-form-label label-small label-pl">姓名</label>
				    <div class="layui-input-inline">
				        <input id="name" type="text" name="name" autocomplete="off" placeholder="请输入名字" class="layui-input">
				    </div>
				    <label class="layui-form-label label-small label-pl">性别</label>
				    <div class="layui-input-inline">
				      <select id="sex" name="sex">
				        <option value="">请选择性别</option>
				        <option value="1">男</option>
				        <option value="2">女</option>
				        <option value="0">保密</option>
				      </select>
				    </div>
				</div>
			</form>
			<div class="layui-btn-group operateBtn">
			  <button class="layui-btn layui-btn-sm" data-type="search">查询</button>
			  <button class="layui-btn layui-btn-sm" data-type="add">添加</button>
			  <button class="layui-btn layui-btn-sm" data-type="batdel">批量删除</button>
			  <button class="layui-btn layui-btn-sm" data-type="importuser">导入</button>
			  <button class="layui-btn layui-btn-sm" data-type="exportuser">导出</button>
			</div>
			<table class="layui-hide" id="user-data-table" lay-filter="user"></table>
		</div>
	</body>
	<script type="text/html" id="barUser">
  		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<script src="<%=basePath%>/static/admin/js/userlist.js" type="text/javascript" charset="utf-8"></script>
</html>
