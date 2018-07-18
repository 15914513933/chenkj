<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="env.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>主页</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/admin/css/index.css"/>
	</head>
	<body>
		<div class="main-layout" id='main-layout'>
			<!--侧边栏-->
			<div class="main-layout-side">
				<div class="m-logo"></div>
				<ul class="layui-nav layui-nav-tree layui-inline" lay-filter="leftNav">
					<c:forEach var="menu" items="${menulist}" varStatus="st">
						<c:if test="${st.index==0}">
							<li class="layui-nav-item layui-nav-itemed">
						</c:if>
						<c:if test="${st.index>0}">
							<li class="layui-nav-item">
						</c:if>
						<a href="javascript:;" data-id="${menu.menuid }" data-text="${menu.menuname }">${menu.menuname }</a>
						<c:if test="${fn:length(menu.subMenus) > 0  }">
							<dl class="layui-nav-child">
								<c:forEach var="subMenu" items="${menu.subMenus}">
									<dd><a href="javascript:;" data-url="${subMenu.url }" data-id="${subMenu.menuid }" data-text="${subMenu.menuname }"><span class="l-line"></span>${subMenu.menuname }</a></dd>
								</c:forEach>
							</dl>
						</c:if>
					</c:forEach>
				</ul>
			</div>
			<!--右侧内容-->
			<div class="main-layout-container">
				<!--头部-->
				<div class="main-layout-header">
					<div class="menu-btn" id="hideBtn">
						<a href="javascript:;" title="隐藏菜单">
							<span class="iconfont">&#xe60e;</span>
						</a>
					</div>
					<ul class="layui-nav" lay-filter="rightNav">
					  <li class="layui-nav-item">
					    <a href="javascript:;" data-url="" data-id='' data-text="个人信息">${userInfo.name }</a>
					     <dl class="layui-nav-child">
					      <dd><a href="">个人信息</a></dd>
					      <dd><a href="">修改密码</a></dd>
					    </dl>
					  </li>
					  <li class="layui-nav-item"><a href="javascript:;" id="logout">退出</a></li>
					</ul>
				</div>
				<!--主体内容-->
				<div class="layui-tab layui-tab-brief main-layout-tab" lay-filter="tab" lay-allowClose="true" lay-filter="demo" >
				  <ul class="layui-tab-title">
					    <li class="layui-this welcome">欢迎页面</li>
					  </ul>
					  <div class="layui-tab-content">
					    <div class="layui-tab-item layui-show">Welcome</div>
					  </div>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="<%=basePath%>/static/admin/js/index.js?v=2"></script>
</html>