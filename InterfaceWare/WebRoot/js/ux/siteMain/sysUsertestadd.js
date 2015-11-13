$package('YiYa.sysUsertestadd');
YiYa.sysUsertestadd = function(){
       
      var Form = {
					search:$("#searchForm"),
					edit:$("#editForm")}
	  var Action = {
			'save': 'save.do',
			'getId': 'getId.do',
			'remove': 'delete.do'
		}
	  var Grid = $('#data-list');  
	   var _url = urls['msUrl'] + '/getActionBtn.do';
	   var data = {'url':window.location.href};
		var Handler = {
			//serach 查询事件
			search: function(callback){
			 var param = Form.search.serializeObject();
			 var cpbh=param.cpbh;
			 var shrlxdh=param.shrlxdh;
			 var lrrqstart=param.lrrqstart;
			 var lrrqend=param.lrrqend;
			 window.location= "/ms/sysUsertest/list.shtml?cpbh="+cpbh+"&shrlxdh="+shrlxdh+"&lrrqstart="+lrrqstart+"&lrrqend="+lrrqend;		
				if(jQuery.isFunction(callback)){
					callback();
				}
				return false;	
			},
			//刷新页面
			refresh: function(callback){
				//
				    Form.edit.resetForm();
				//回调函数
				if(jQuery.isFunction(callback)){
					callback();
				}
			},
            //保存调用方法
			save: function(callback){
				if(Form.edit.form('validate')){
					Form.edit.attr('action',Action.save);
					var parentId =$('#search_parentId').val();
					$("#edit_parentId").val(parentId)
					YiYa.saveForm(Form.edit,function(data){
					$.messager.confirm('Confirm','确定要保存吗?',function(r){  
				    if (r){  
				         YiYa.closeProgress();
				           YiYa.alert('提示',data.msg,'保存成功');  
					       Events.refresh();
					      Form.edit.resetForm();
					      
				     	//回调函数
						if(jQuery.isFunction(callback)){
							callback(data);
						}
				    }
				})
					});
				 }
			}
		}
		
var Events ={
			//serach 查询事件
			search:  Handler.search,
			//刷新Grid 数据
			refresh:  Handler.refresh,
			//保存调用方法
			save:  Handler.save

		}
     var initForm = function(){
			if(Form.search && Form.search[0]){
				Form.search.find("#btn-search").click(Events.search); //搜索事件
			}
			if(Form.search && Form.search[0]){
				Form.search.find("#btn-submit").click(Events.save); //保存事件
			}
			if(Form.search && Form.search[0]){
				Form.search.find("#btn-refresh").click(Events.refresh); //刷新事件
			}
		}
		
		this.form = Form;
		this.handler = Handler;
		
		this.init = function(){
			initForm();
		}
		//调用初始化
		return this;
}();

$(function(){
	YiYa.sysUsertestadd.init();
});			