$package('YiYa.sysRole');
YiYa.sysRole = function(){
	var _box = null;
	var _this = {
		menu: $('#menu-tree'),
		buildTreeData:function(nodes){
			$.each(nodes,function(i,note){
				var id = note.attributes.id;
				var type = note.attributes.type;
				var $id = $("<input type='hidden' name='menuIds' class='c_menus'>");
				if(type == 0){
					$id.attr('name','menuIds');
				}
				$id.val(id);
				_box.form.edit.append($id);
			});
		},
		setTreeValue:function(id){
			var node = _this.menu.tree("find",id);
			if(node && node.target){
				//判断是否选择或者半选状态 
				if($(node.target).find(".tree-checkbox0")[0]){
					_this.menu.tree('check',node.target);
				}
			}
		},
		clearTreeData:function(){
			$(".tree-checkbox1",_this.menu).removeClass("tree-checkbox1").addClass("tree-checkbox0")
			$(".tree-checkbox2",_this.menu).removeClass("tree-checkbox2").addClass("tree-checkbox0");
			$('.c_menus').remove();
		},
		save:function(){
			var checknodes = _this.menu.tree('getChecked');	
			var innodes = _this.menu.tree('getChecked','indeterminate');
			_this.buildTreeData(checknodes);
			_this.buildTreeData(innodes);
			_box.handler.save();
		},
		config:{
			event:{
				add:function(){
					_this.clearTreeData();
					_box.handler.add();
				},
				edit:function(){
					_this.clearTreeData();	
				
					_box.handler.edit(function(result){
						var menuIds  = result.data.menuIds;										
						$.each(menuIds,function(i,id){
							_this.setTreeValue("menu_"+id);
						});
					});
				},
				save:function(){
						_this.save();
				}
			},
  			dataGrid:{
  				title:'Role List',
	   			url:'dataList.do',
	   			columns:[[
						{field:'id',checkbox:true},
						{field:'xh',title:'序号',width:80,sortable:false,hidden:true},
						{field:'roleid',title:'角色编码',width:80,sortable:true},
						{field:'jsmc',title:'角色名称',width:120,sortable:true},
						{field:'djry',title:'登记人员',width:100,sortable:true},
						{field:'djsj',title:'登记时间',width:120,sortable:true},
						{field:'qxbz',title:'取消标志',width:100,sortable:true}
						
				]]
				,
				toolbar:[
					{id:'btnadd',text:'新增',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
					
				]
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
			
			_this.menu.tree({
				url:'../sysRole/getMenuTree.do',
				checkbox:true
			});
		}
	}
	return _this;
}();

$(function(){
	YiYa.sysRole.init();
});		