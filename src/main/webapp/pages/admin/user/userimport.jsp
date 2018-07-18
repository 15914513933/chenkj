<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../env.jsp"%>    
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/admin/css/common.css?v=3"/>
	</head>
	<body>
		<div class="layui-upload-drag import-upload" id="upload">
		  <i class="layui-icon">&#xe681;</i>
		  <p id="uploadinfo">点击上传，或将文件拖拽到此处</p>
		  <input id="importId" type="text" name="importId" hidden="true">
		</div>
	</body>
	<script type="text/javascript">
		layui.use('upload', function(){
		  var upload = layui.upload;
		  upload.render({
		    elem: '#upload',
		    accept:'file',
		    exts:'xls|xlsx',
		    data:{fsection:'user',fitem:'import'}
		    ,url: basePath +'/upload'
		    ,done: function(res){
		      $('#uploadinfo').text(res.data.fname);
		      $('#importId').val(res.data.id);
		    }
		  });
		});
	</script>
</html>
