<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="env.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<title>后台登录</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/admin/css/login.css" />
</head>
	<body>
		<div class="m-login-bg">
			<div class="m-login">
				<h3>用户登录</h3>
				<div class="m-login-warp">
					<form class="layui-form">
						<div class="layui-form-item">
							<input type="text" name="userid" required lay-verify="required" placeholder="用户名" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-form-item">
							<input type="password" name="password" required lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-form-item">
							<div class="layui-inline">
								<input type="text" name="checkCode" required lay-verify="required" placeholder="验证码" autocomplete="off" class="layui-input">
							</div>
							<div class="layui-inline">
								<img id="checkCode" class="check-code-img"  src="<%=basePath%>/public/checkCode" />
							</div>
						</div>
						<div class="layui-form-item m-login-btn">
							<div class="layui-inline">
								<button id="login" class="layui-btn layui-btn-normal" lay-submit lay-filter="login">登录</button>
							</div>
							<div class="layui-inline">
								<button type="reset" class="layui-btn layui-btn-primary">取消</button>
							</div>
						</div>
					</form>
				</div>
				<p class="copyright">Copyright 2018 by chenkj</p>
			</div>
		</div>
	</body>
	<script src="<%=basePath%>/static/admin/js/login.js" type="text/javascript" charset="utf-8"></script>
</html>