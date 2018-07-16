<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../env.jsp"%>    
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/admin/css/common.css?v=2"/>
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
            
	<script type="text/javascript">
	layui.use(['form','table'], function(){
		  var table = layui.table;
		  table.render({
			height:'600',
		    elem: '#user-data-table',
		    url:basePath + '/user/getUsers',
		    cellMinWidth: 80,
		    id:'userTable',
		    cols: [[
			  {checkbox: true, fixed: true},
		      {field:'userid', width:'15%', title: '账号'},
		      {field:'name', width:'15%', title: '姓名'},
		      {field:'sex', width:'10%', title: '性别',templet:function(row){return sexText(row.sex)}},
		      {field:'tel', width:'12%', title: '联系方式'},
		      {field:'email', width:'12%', title: '电子邮箱'},
		      {field:'status', width:'10%', title: '状态',templet:function(row){return statusText(row.status)}},
		      {fixed:'right', width:'20%', align: 'center',toolbar:'#barUser'}
		    ]],
		    request: {
		    	  pageName: 'pageNum', //页码的参数名称，默认：page
		    	  limitName: 'pageSize' //每页数据量的参数名，默认：limit
		    	},
		    response: {
		    	  statusName: 'code', //数据状态的字段名称，默认：code
		    	  statusCode: 0, //成功的状态码，默认：0
		    	  msgName: 'msg', //状态信息的字段名称，默认：msg
		    	  countName: 'total', //数据总数的字段名称，默认：count
		    	  dataName: 'data' //数据列表的字段名称，默认：data
		    	},
		   page: true
		  });
		  
		table.on('tool(user)', function(obj){
		    var data = obj.data;
		    if(obj.event === 'detail'){
		      layer.msg('userid：'+ data.userid );
		    } else if(obj.event === 'del'){
		      layer.confirm('确定删除？', function(index){
		        obj.del();
		        layer.close(index);
		      });
		    } else if(obj.event === 'edit'){
		      layer.alert('编辑行：<br>'+ JSON.stringify(data))
		    }
		  });
		function sexText(value){
			  if(value==1){
				  return '男';
			  }else if(value==2){
				  return '女';
			  }else{
				  return '保密';
			  }
		  }
		  
		  function statusText(value){
			  if(value==0){
				  return '有效';
			  }else{
				  return '冻结';
			  }
		  }
		  
		  var active = {
		    search: function(){ 
		    	var paramMap = {};
		    	var userid = $('#userid').val();
		    	var name = $('#name').val();
		    	var sex = $('#sex').find("option:selected").val();
		    	if(userid!=''){
		    		paramMap.userid = userid;
		    	}
		    	if(name!=''){
		    		paramMap.name = name;
		    	}
		    	if(sex!=''){
		    		paramMap.sex = sex;
		    	}
		        table.reload('userTable', {
		          page: {
		            curr: 1 //重新从第 1 页开始
		          }
		          ,where: {
		            	params: JSON.stringify(paramMap)
		          }
		        });
		    },
		    add: function(){
		    	var that = this; 
		        //多窗口模式，层叠置顶
		        layer.open({
		          type: 0 
		          ,title: '添加用户'
		          ,area: ['500px', '400px']
		          ,shade: 0
		          ,resize:false
		          ,content: '添加用户'
		          ,btn: ['保存', '关闭'] 
		          ,yes: function(){
		            $(that).click(); 
		          }
		          ,btn2: function(){
		            layer.closeAll();
		          }
		          ,zIndex: layer.zIndex //重点1
		          ,success: function(layero){
		            layer.setTop(layero); //重点2
		          }
		        });
		    },
		    batdel: function(){
		      var checkStatus = table.checkStatus('userTable');
		      var datas = checkStatus.data.userid;
		    },
		    importuser: function(){
		      
		    },
		    exportuser: function(){
			      
		    }
		  };
		  
		  $('.operateBtn .layui-btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
		  });
		  
	});

		
	</script>
</html>
