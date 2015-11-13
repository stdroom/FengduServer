$package('YiYa.sysMenu');

YiYa.sysMenu = function(){
	var _box = null;
	var _this = {

		config:{
  			dataGrid:{
  				title:'Menu List',
	   			url:'dataList.do',
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'xh',title:'序号',width:50,sortable:true},
					{field:'name',title:'菜单名称',width:120,sortable:true},
					{field:'url',title:'URL',width:220,sortable:true},					
					{field:'createTime',title:'登记时间',width:120,sortable:true},
					{field:'rank',title:'级别',align:'right',width:80,sortable:true},
					{field:'menuNo',title:'菜单编号',align:'right',width:80,hidden:true}
				]],
				toolbar:[
					{id:'btnadd',text:'新增',btnType:'add'},
					{id:'btnedit',text:'编辑',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'},
					{
						id:'btnback',
						text:'back',
						disabled: true,
						iconCls:'icon-back',
						handler:function(){
							_this.toList();
						}
					}
				]
			}
		},
		init:function(){
			$("#parentid").combobox({			
				url:'../sysMenu/loadMenuList.do',
				valueField:'id',
				textField:'name',
				multiple:false,
				onSelect:function(record){
					$("#hidparId").val(record.id);
				}
			});						
			_box = new YDataGrid(_this.config); 
			_box.init();			
		}
		
		
	}
	return _this;
}();

$(function(){
	YiYa.sysMenu.init();
});		