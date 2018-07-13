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
					<div class="layui-inline tool-btn">
						<button class="layui-btn layui-btn-small layui-btn-normal go-btn hidden-xs" data-url="danye-detail.html"><i class="layui-icon">&#xe654;</i></button>
					</div>
					<div class="layui-inline">
						<input type="text" name="title" placeholder="请输入标题" autocomplete="off" class="layui-input">
					</div>
					<button class="layui-btn layui-btn-normal" lay-submit="search">搜索</button>
				</div>
			</form>
			<div class="layui-form" id="table-list">
				<table class="layui-table" lay-even lay-skin="nob">
					<colgroup>
						<col width="50">
						<col class="hidden-xs" width="50">
						<col class="hidden-xs" width="100">
						<col>
						<col class="hidden-xs" width="200">
						<col width="80">
						<col width="150">
					</colgroup>
					<thead>
						<tr>
							<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose"></th>
							<th class="hidden-xs">ID</th>
							<th class="hidden-xs">排序</th>
							<th>菜单名称</th>
							<th>发布时间</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox" name="" lay-skin="primary" data-id="1"></td>
							<td class="hidden-xs">1</td>
							<td class="hidden-xs"><input type="text" name="title" autocomplete="off" class="layui-input" value="0" data-id="1"></td>
							<td>关于我们</td>
							<td>2016-09-06 20:46:16</td>
							<td><button class="layui-btn layui-btn-mini layui-btn-normal table-list-status" data-status='1'>显示</button></td>
							<td>
								<div class="layui-inline">
									<button class="layui-btn layui-btn-mini layui-btn-normal  go-btn" data-id="1" data-url="danye-detail.html"><i class="layui-icon">&#xe642;</i></button>
									<button class="layui-btn layui-btn-mini layui-btn-danger del-btn" data-id="1" data-url="del.html"><i class="layui-icon">&#xe640;</i></button>
								</div>
							</td>
						</tr>
						<tr>
							<td><input type="checkbox" name="" lay-skin="primary" data-id="1"></td>
							<td class="hidden-xs">1</td>
							<td class="hidden-xs"><input type="text" name="title" autocomplete="off" class="layui-input" value="0" data-id="1"></td>
							<td>产品中心</td>
							<td>2016-09-06 20:46:16</td>
							<td><button class="layui-btn layui-btn-mini layui-btn-normal table-list-status" data-status='1'>显示</button></td>
							<td>
								<div class="layui-inline">
									<button class="layui-btn layui-btn-mini layui-btn-normal  go-btn" data-id="1" data-url="danye-detail.html"><i class="layui-icon">&#xe642;</i></button>
									<button class="layui-btn layui-btn-mini layui-btn-danger del-btn" data-id="1" data-url="del.html"><i class="layui-icon">&#xe640;</i></button>
								</div>
							</td>
						</tr>
						<tr>
							<td><input type="checkbox" name="" lay-skin="primary" data-id="1"></td>
							<td class="hidden-xs">1</td>
							<td class="hidden-xs"><input type="text" name="title" autocomplete="off" class="layui-input" value="0" data-id="1"></td>
							<td>新闻中心</td>
							<td>2016-09-06 20:46:16</td>
							<td><button class="layui-btn layui-btn-mini layui-btn-normal table-list-status" data-status='1'>显示</button></td>
							<td>
								<div class="layui-inline">
									<button class="layui-btn layui-btn-mini layui-btn-normal  go-btn" data-id="1" data-url="danye-detail.html"><i class="layui-icon">&#xe642;</i></button>
									<button class="layui-btn layui-btn-mini layui-btn-danger del-btn" data-id="1" data-url="del.html"><i class="layui-icon">&#xe640;</i></button>
								</div>
							</td>
						</tr>
						<tr>
							<td><input type="checkbox" name="" lay-skin="primary" data-id="1"></td>
							<td class="hidden-xs">1</td>
							<td class="hidden-xs"><input type="text" name="title" autocomplete="off" class="layui-input" value="0" data-id="1"></td>
							<td>业务范围</td>
							<td>2016-09-06 20:46:16</td>
							<td><button class="layui-btn layui-btn-mini layui-btn-normal table-list-status" data-status='1'>显示</button></td>
							<td>
								<div class="layui-inline">
									<button class="layui-btn layui-btn-mini layui-btn-normal  go-btn" data-id="1" data-url="danye-detail.html"><i class="layui-icon">&#xe642;</i></button>
									<button class="layui-btn layui-btn-mini layui-btn-danger del-btn" data-id="1" data-url="del.html"><i class="layui-icon">&#xe640;</i></button>
								</div>
							</td>
						</tr>
						<tr>
							<td><input type="checkbox" name="" lay-skin="primary" data-id="1"></td>
							<td class="hidden-xs">1</td>
							<td class="hidden-xs"><input type="text" name="title" autocomplete="off" class="layui-input" value="0" data-id="1"></td>
							<td>联系我们</td>
							<td>2016-09-06 20:46:16</td>
							<td><button class="layui-btn layui-btn-mini layui-btn-normal table-list-status" data-status='1'>显示</button></td>
							<td>
								<div class="layui-inline">
									<button class="layui-btn layui-btn-mini layui-btn-normal  go-btn" data-id="1" data-url="danye-detail.html"><i class="layui-icon">&#xe642;</i></button>
									<button class="layui-btn layui-btn-mini layui-btn-danger del-btn" data-id="1" data-url="del.html"><i class="layui-icon">&#xe640;</i></button>
								</div>
							</td>
						</tr>
						<tr>
							<td><input type="checkbox" name="" lay-skin="primary" data-id="1"></td>
							<td class="hidden-xs">1</td>
							<td class="hidden-xs"><input type="text" name="title" autocomplete="off" class="layui-input" value="0" data-id="1"></td>
							<td>在线留言</td>
							<td>2016-09-06 20:46:16</td>
							<td><button class="layui-btn layui-btn-mini layui-btn-normal table-list-status" data-status='1'>显示</button></td>
							<td>
								<div class="layui-inline">
									<button class="layui-btn layui-btn-mini layui-btn-normal go-btn" data-id="1" data-url="danye-detail.html"><i class="layui-icon">&#xe642;</i></button>
									<button class="layui-btn layui-btn-mini layui-btn-danger del-btn" data-id="1" data-url="del.html"><i class="layui-icon">&#xe640;</i></button>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="page-wrap">
						<ul class="pagination">
							<li class="disabled"><span>«</span></li>
							<li class="active"><span>1</span></li>
							<li>
								<a href="#">2</a>
							</li>
							<li>
								<a href="#">»</a>
							</li>
						</ul>
					</div>
			</div>
		</div>
	</body>
	<script>
			layui.use(['form', 'jquery', 'layer', 'dialog'], function() {
				var $ = layui.jquery;

				//修改状态
				$('#table-list').on('click', '.table-list-status', function() {
					var That = $(this);
					var status = That.attr('data-status');
					var id = That.parent().attr('data-id');
					if(status == 1) {
						That.removeClass('layui-btn-normal').addClass('layui-btn-warm').html('隐藏').attr('data-status', 2);
					} else if(status == 2) {
						That.removeClass('layui-btn-warm').addClass('layui-btn-normal').html('显示').attr('data-status', 1);

					}
				})

			});
		</script>
</html>
