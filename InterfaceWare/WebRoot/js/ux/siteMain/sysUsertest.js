$package('YiYa.sysUsertest');
YiYa.sysUsertest = function(){
	var _box = null;
	var Win = { edit:$("#edit-win")}
	var Grid = $('#data-list');
   var Action = {
			'save': 'save.do',
			'getId': 'getId.do',
			'remove': 'delete.do',
			'print': 'dataList.do'
		}
	var Form = {
				search:$("#searchForm"),
				print:$("#divMain"),
				edit:$("#editForm")}
	var handler = {
	
	    print:function(callback){
			if(Form.edit.form('validate')){
					YiYa.progress();
					Form.edit.attr('action',Action.save);
					var parentId =$('#search_parentId').val();
					$("#edit_parentId").val(parentId);
					YiYa.saveForm(Form.edit,function(data){
						YiYa.closeProgress();
						Win.edit.dialog('close');
					    Events.refresh();
					    Form.edit.resetForm();
					     //回调函数
						if(jQuery.isFunction(callback)){
							callback(data);
						}
					});
					 var xh=$("#xh").val();
	                 var url="/ms/view/print/tydqhreport.jsp?xh="+xh;
	                 var str=window.open(url,'','scrollbars=auto;resizable=1');
	                 str.blur();
	                 str.focus();
	                 str.resizeTo(800,700); 
		 }
	  },
	  refresh: function(callback){
				var param = Form.search.serializeObject();
				Grid.datagrid('reload',param);
				//回调函数
				if(jQuery.isFunction(callback)){
					callback();
				}
			},
	   close : function (callback){
				$.messager.confirm('Confirm','你确定想关闭窗口吗?',function(r){  
				    if (r){  
				     	Win.edit.dialog('close');
				     	Events.refresh();
				     	//回调函数
						if(jQuery.isFunction(callback)){
							callback(data);
						}
				    }
				});
			},
		config:{
  			dataGrid:{
  				title:'货物列表',
	   			url:'dataList.do',
	   			columns:[[
	   			
						{field:'id',checkbox:true},
						{field:'xh',title:'序号',width:30,sortable:true},
						{field:'cpbh',title:'车牌编号',width:70,sortable:true},
						{field:'hwmc',title:'货物名称',width:70,sortable:true},
						{field:'shrlxdh',title:'收货人联系电话',width:100,sortable:true},
						{field:'jianshu',title:'件数',width:40,sortable:true},
						{field:'yf',title:'运费',width:50,sortable:true},
						{field:'bgf',title:'保管费',width:50,sortable:true},
						{field:'zfy',title:'总费用',width:50,sortable:true},
						{field:'lrrq',title:'录入日期',width:120,sortable:true},
						{field:'qhrxm',title:'取货人姓名',width:80,sortable:true},
						{field:'qhrzjh',title:'取货人证件号',width:150,sortable:true},
						{field:'qhsj',title:'取货时间',width:120,sortable:true},
						{field:'fkfs',title:'付费方式',width:80,align:'center',sortable:true,styler:function(value,row,index){
							if(value == 1){
							  return 'color:red;';  
							}
						},
						formatter:function(value,row,index){
							if(value == 0){
								return "运费现付";
							}
							if(value == 1){
								return "运费提付";
							}
						}},
						{field:'hwzt',title:'货物状态',width:80,align:'center',sortable:true,styler:function(value,row,index){
							if(value == 0){
							  return 'color:red;';  
							}
						},
						formatter:function(value,row,index){
							if(value == 0){
								return "落货";
							}
							if(value == 1){
								return "取货";
							}
							if(value == 2){
								return "作废";
							}
						}}
				]],
				toolbar:[
					{id:'btnedit',text:'取货确认',btnType:'edit'},
					{id:'btndelete',text:'作废',btnType:'remove'},
				]
				
			}
		  }
		}
		var Events ={
			print:  handler.print,
			refresh: handler.refresh,
			close: handler.close
		}
		var initWin = function(){
			if(Win.edit && Win.edit[0]){
				//判断页面是否设置buttons，如果没有设置默认按钮
				var btns = Win.edit.attr("buttons");
				if(!btns){
					//设置 保存,关闭按钮
					Win.edit.dialog({
						buttons:[
							{
								text:'保存并打印',
								
								handler:Events.print
							},{
								text:'关闭',
								handler:Events.close
							}
						]
					});
				}
			}
		}
		this.handler = handler;
		this.init = function(){
		_box = new YDataGrid(handler.config); 
		_box.init();
		initWin();
	    }
	
	return this;
}();

$(function(){
	YiYa.sysUsertest.init();
});			