$package('YiYa.webPage');
YiYa.webPage = function(){
	
	var _this = {
		TempWin:$("#edit-temp-win"),
		TempForm:$("#editTempForm"),
		Action:{
			getId:'getId.do',
			saveTemp:"saveTemplate.do" 
		},
		config:{
  			dataGrid:{
  				title:'Page List',
	   			url:'dataList.do',
	   			columns:[[
						{field:'id',checkbox:true},
						{field:'name',title:'Name',width:80,sortable:true},
						{field:'localPath',title:'LocalPath',width:80,sortable:true},
						{field:'title',title:'title',width:80,sortable:true},
						{field:'createTime',title:'CreateTime',width:120,sortable:true},
						{field:'updateTime',title:'UpdateTime',width:120,sortable:true},
				]],
				toolbar:[
					{id:'btnadd',text:'Add',btnType:'add'},
					{id:'btnedit',text:'Edit',btnType:'edit'},
					{id:'btnedit',text:'EditPage',btnType:'editPage',iconCls:'icon-edit',handler:function(){
							var selected = _box.utils.getCheckedRows();
							if ( _box.utils.checkSelectOne(selected)){
								YiYa.progress();//打开
								var data ={id:selected[0].id};
								YiYa.getById(_this.Action.getId,data,function(result){
									YiYa.closeProgress();//关闭缓冲条
									_this.TempForm.form('load',result.data);
									_this.TempWin.dialog('open'); 
								});
							}
						}},
					{id:'btndelete',text:'Delete',btnType:'remove'}
				]
			}
		},
		saveTemp:function(){
			YiYa.progress();//缓冲条
			if(_this.TempForm.form('validate')){
				_this.TempForm.attr('action',_this.Action.saveTemp);
				YiYa.saveForm(_this.TempForm,function(data){
					YiYa.closeProgress(); //关闭缓冲条
					_this.TempWin.dialog('close');
				});
			 }
		},
		initTempWin:function(){
			$('#markItUp').markItUp(mySettings);
			//修改密码
			$("#btn-temp-submit").click(_this.saveTemp);
			$("#btn-temp-close").click(function(){	
				$.messager.confirm('Confirm','Are you sure you want close Window?',function(r){  
				    if (r){  
				     	_this.TempWin.dialog('close');
				    }  
				});
			});
			
			
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
			_this.initTempWin();
			
		}
	}
	return _this;
}();

$(function(){
	YiYa.webPage.init();
});		