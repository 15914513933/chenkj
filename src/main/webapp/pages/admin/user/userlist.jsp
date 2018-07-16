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
				        <option value="0">保密</option>
				      </select>
				    </div>
				    <button class="layui-btn" lay-submit="search">查询</button>
				</div>
			</form>
			<table class="layui-hide" id="user-data-table"></table>
		</div>
	</body>
	<script type="text/html" id="tar-user">
  		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<script type="text/javascript">
	layui.use(['form','table'], function(){
		  var table = layui.table;
		  table.render({
			height:'650',
		    elem: '#user-data-table',
		    url:basePath + '/user/getUsers',
		    cellMinWidth: 80,
		    cols: [[
		      {field:'userid', width:'15%', title: '账号'},
		      {field:'name', width:'15%', title: '姓名'},
		      {field:'sex', width:'10%', title: '性别'},
		      {field:'tel', width:'15%', title: '联系方式'},
		      {field:'email', width:'15%', title: '电子邮箱'},
		      {field:'status', width:'10%', title: '状态'},
		      {fixed:'right', width:'20%', align: 'center',toolbar:'#tar-user'}
		    ]],
		    request: {
		    	  pageName: 'pageNum', //页码的参数名称，默认：page
		    	  limitName: 'pageSize' //每页数据量的参数名，默认：limit
		    	},
		    response: {
		    	  statusName: 'code' //数据状态的字段名称，默认：code
		    	  ,statusCode: 0 //成功的状态码，默认：0
		    	  ,msgName: 'msg' //状态信息的字段名称，默认：msg
		    	  ,countName: 'total' //数据总数的字段名称，默认：count
		    	  ,dataName: 'data' //数据列表的字段名称，默认：data
		    	},
		    	page: true
		  });
		});

		
	</script>
</html>
