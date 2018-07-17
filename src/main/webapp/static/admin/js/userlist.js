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
		      var userids = new Array();
		      userids[0] = data.userid;
		      
		      var a = {};
		      a.userids = userids;
		      
		      layer.confirm('确定删除？', function(index){
		        $.ajax({
		  			  type: 'POST',
		  			  url: basePath+'/user/delUsers',
		  			  data: {userid:data.userid},		  
		  			  success: function(data){
		  				  if(data.code==0){
		  					 layer.msg('删除成功！')
		  					 layer.close(index);
		  					 obj.del();
		  				  }else{
		  					 layer.msg(data.msg);
		  				  }
		  			  },
		  			  error: function(data) {
		  				  layer.msg(data,{time:1000});
		  			  }, 
		  			  dataType: 'JSON'
	  			  }); 
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
		        layer.open({
		          type: 2 
		          ,title: '添加用户'
		          ,area: ['550px', '470px']
		          ,shade: 0
		          ,resize:false
		          ,shade:0.1
		          ,content: basePath + "/page/user/add"
		          ,btn: ['保存', '关闭'] 
		          ,yes: function(index,layero){
		            var page_add = layer.getChildFrame('body',index);
		            var new_userid = page_add.find('#new_userid').val();
		            var new_password = page_add.find('#new_password').val();
		            var new_name = page_add.find('#new_name').val();
		            var new_tel = page_add.find('#new_tel').val();
		            var new_email = page_add.find('#new_email').val();
		            var new_sex = page_add.find("input[name='sex']:checked").val();
		            var errorMsg = '';
		            var err = page_add.find('.error-msg');
		            if(new_userid==''){
		            	err.text('账号不能为空！');return;
		            }
		            if(new_password==''){
		            	err.text('密码不能为空！');return;
		            }
		            if(new_name==''){
		            	err.text('姓名不能为空!');return;
		            }
		            var new_user={};
		            new_user.userid = new_userid;
		            new_user.password = CryptoJS.SHA256(new_password)+'';;
		            new_user.name = new_name;
		            new_user.tel = new_tel;
		            new_user.email = new_email;
		            new_user.sex = new_sex;
		            $.ajax({
			  			  type: 'POST',
			  			  url: basePath+'/user/addUser',
			  			  data: new_user,		  
			  			  success: function(data){
			  				  if(data.code==0){
			  					 layer.msg('保存成功！')
			  					 layer.close(index);
			  					 reload();
			  				  }else{
			  					 err.text(data.msg)
			  				  }
			  			  },
			  			  error: function(data) {
			  				  layer.msg(data,{time:1000});
			  			  }, 
			  			  dataType: 'JSON'
		  			  }); 
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
		  
		  function reload(){
			  active['search'].call();
		  }
		  
	});