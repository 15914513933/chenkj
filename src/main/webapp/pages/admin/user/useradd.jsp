<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../env.jsp"%>    
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/admin/css/common.css?v=2"/>
	</head>
	<body>
		<form class="layui-form add-user" action="" lay-filter="example">
		  <div class="layui-form-item">
		    <label class="layui-form-label">账号</label>
		    <div class="layui-input-inline">
		      <input type="text" id="new_userid" name="userid" required lay-verify="required" lay-verify="title" autocomplete="off" placeholder="请输入账号" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">密码</label>
		    <div class="layui-input-inline">
		      <input type="password" id="new_password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">姓名</label>
		    <div class="layui-input-inline">
		      <input type="text" id="new_name" name="name" required lay-verify="required" lay-verify="title" autocomplete="off" placeholder="请输入姓名" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">性别</label>
		    <div class="layui-input-block">
		      <input type="radio" name="sex" value="1" title="男" checked>
		      <input type="radio" name="sex" value="2" title="女" >
		      <input type="radio" name="sex" value="0" title="保密">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">联系方式</label>
		    <div class="layui-input-inline">
		      <input id="new_tel" type="text" name="tel" placeholder="请输入联系方式" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">Email</label>
		    <div class="layui-input-inline">
		      <input id="new_email" type="text" name="email" placeholder="请输入Email" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="error-msg"></div>
		</form>
	</body>
	<script type="text/javascript">
	layui.use(['form'], function(){
		
	});
	</script>
</html>
