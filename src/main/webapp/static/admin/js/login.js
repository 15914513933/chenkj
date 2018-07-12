layui.use(['form'], function() {
				var form = layui.form;
			    var layer = layui.layer;				
				form.on('submit(login)', function(data) {
					$.ajax({
						  type: 'POST',
						  url: basePath+'/user/doLogin',
						  data: JSON.stringify(JSON.stringify(data.field)),		  
						  success: function(data){
							  if(data.code==0){
								  window.location.href= basePath + "index";
							  }else{
								  layer.alert(data.msg, {title: '错误信息'});
							  }
						  },
						  error: function(data) {
							  layer.alert(data, {title: '错误信息'});
						  }, 
						  dataType: 'JSON'
					});
					return false;
				});

			});