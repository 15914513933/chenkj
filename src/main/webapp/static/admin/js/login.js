layui.use(['form'], function() {
	var form = layui.form;
    var layer = layui.layer;				
	form.on('submit(login)', function(data) {
		data.field.password = CryptoJS.SHA256(data.field.checkCode) + CryptoJS.SHA256(data.field.password);
		$.ajax({
			  type: 'POST',
			  url: basePath+'/public/doLogin',
			  data: data.field,		  
			  success: function(data){
				  if(data.code==0){
					  window.location.href= basePath + "/index";
				  }else{
					  layer.msg(data.msg,{time:1000});
				  }
			  },
			  error: function(data) {
				  layer.msg(data,{time:1000});
			  }, 
			  dataType: 'JSON'
		});
		return false;
	});
	$('#checkCode').click(function(){
		this.src = basePath + "/public/checkCode?c="+Math.random();
	})
});