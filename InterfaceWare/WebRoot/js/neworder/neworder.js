$package('YiYa.newOrderAction');
YiYa.newOrderAction = function(){
       
      var Form = {
					search:$("#searchForm")
                 }
	 var Handler = {
			//serach 查询事件
			search: function(callback){
			 var param = Form.search.serializeObject();
			 var dqdh=param.dqdh;
			  window.location="/ms/zhcxtydcx/list.shtml?tydh="+dqdh;
			  if(jQuery.isFunction(callback)){
					callback();
				}
				return false;	
			}
		}
		
var Events ={
			//serach 查询事件
			search:  Handler.search

		}
     var initForm = function(){
			if(Form.search && Form.search[0]){
				Form.search.find("#btn-search").click(Events.search); //搜索事件
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
	YiYa.newOrderAction.init();
});		