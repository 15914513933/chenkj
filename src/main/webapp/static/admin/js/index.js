layui.use(['element','layer'], function(){
  var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
  var layer = layui.layer;
	element.on('nav(leftNav)', function(elem) {
		var id = elem.attr('data-id');
		var url = elem.attr('data-url');
		var text = elem.attr('data-text');
		if(!url){
			return;
		}
		var isActive = $('.main-layout-tab .layui-tab-title').find("li[lay-id=" + id + "]");
		if(isActive.length > 0) {
			//切换到选项卡
			element.tabChange('tab', id);
		} else {
			element.tabAdd('tab', {
				title: text,
				content: '<iframe src="' + basePath+url + '" name="iframe' + id + '" class="iframe" frameborder="0"" data-id="' + id + '" scrolling="auto" width="100%"  height="80%" ></iframe>',
				id: id
			});
			element.tabChange('tab', id);
			
		}
	});
	element.on('nav(rightNav)', function(elem) {
		debugger;
		var id = elem.attr('data-id');
		var url = elem.attr('data-url');
		var text = elem.attr('data-text');
		if(!url){
			return;
		}
		var isActive = $('.main-layout-tab .layui-tab-title').find("li[lay-id=" + id + "]");
		if(isActive.length > 0) {
			//切换到选项卡
			element.tabChange('tab', id);
		} else {
			element.tabAdd('tab', {
				title: text,
				content: '<iframe src="' + basePath+url + '" name="iframe' + id + '" class="iframe" frameborder="0"" data-id="' + id + '" scrolling="auto" width="100%"  height="80%" ></iframe>',
				id: id
			});
			element.tabChange('tab', id);
			
		}
	});
	$('#logout').click(function(){
		layer.msg('确认退出？', {
			time: 0,
			shade: 0.2,
	        btn: ['退出', '取消'],
	        success: function(layero){
	            var btn = layero.find('.layui-layer-btn');
	            btn.find('.layui-layer-btn0').attr({href: basePath+'/user/logout'})
	        }
	      });
	});
});
