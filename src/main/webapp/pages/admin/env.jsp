<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String CONTEXT_PATH = request.getContextPath() ;
String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ CONTEXT_PATH ;
 %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/admin/fonts/iconfont.css" />
		<script src="<%=basePath%>/jquery-3.3.1/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			var basePath = "<%=basePath%>";
		</script>
	</head>
</html>
