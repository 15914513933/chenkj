layui.use('element', function(){
	  var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
	//监听导航点击
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
					content: '<iframe src="' + basePath+url + '" name="iframe' + id + '" class="iframe" frameborder="0"" data-id="' + id + '" scrolling="auto" width="100%"  height="100%" ></iframe>',
					id: id
				});
				element.tabChange('tab', id);
				
			}
			//mainLayout.removeClass('hide-side');
		});
	});