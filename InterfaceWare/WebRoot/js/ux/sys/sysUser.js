$package('YiYa.sysUser');
YiYa.sysUser = function(){
	var _box = null;
	var _this = {

		updatePwdAction:'updatePwd.do',
		editPwdForm:function(){
			return $("#pwdForm");
		},
		editPwdWin:function(){
			return $("#edit-pwd-win");
		},
		savePwd:function(){
			YiYa.progress();//缓冲条
			if(_this.editPwdForm().form('validate')){
				_this.editPwdForm().attr('action',_this.updatePwdAction);
				YiYa.saveForm(_this.editPwdForm(),function(data){
					YiYa.closeProgress();//关闭缓冲条
					_this.editPwdWin().dialog('close');
				});
			 }
		},
		initForm:function(){
			//修改密码
			_this.editPwdWin().find("#btn-pwd-submit").click(function(){
				_this.savePwd();
			});
			_this.editPwdWin().find("#btn-pwd-close").click(function(){	
				$.messager.confirm('Confirm','确定要关闭窗口吗?',function(r){  
				    if (r){  
				     	_this.editPwdWin().dialog('close');
				    }  
				});
			});
		},
		config:{
  			dataGrid:{
  				title:'用户列表',
	   			url:'dataList.do',
	   			columns:[[
						{field:'id',checkbox:true},
						{field:'xh',title:'序号',width:80,sortable:false,hidden:true},
						{field:'rybh',title:'人员编号',width:80,sortable:true},
						{field:'dlid',title:'人员账号',width:100,sortable:true},
						{field:'ryxm',title:'人员姓名',width:120,sortable:true},
						{field:'lxdh',title:'联系电话',width:100,sortable:true},						
						{field:'djry',title:'登记人员',width:100,sortable:true},
						{field:'djsj',title:'登记时间',width:120,sortable:true},
						{field:'jsmc',title:'岗位名称',width:150,sortable:true}
				]],
				toolbar:[
					{id:'btnadd',text:'新增',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btnedit',text:'修改密码',btnType:'editPwd',iconCls:'icon-edit',handler:function(){
							var selected = _box.utils.getCheckedRows();
							if ( _box.utils.checkSelectOne(selected)){
								_this.editPwdForm().resetForm();
								_this.editPwdForm().find("input[name='rybh']").val(selected[0].rybh);
								_this.editPwdForm().find("input[name='dlid']").val(selected[0].dlid);
								_this.editPwdWin().window('open'); 
							}
						}},
					{id:'btndelete',text:'删除',btnType:'remove'}
					
				]
			}
		},
		init:function(){
		$("#roleIds").combobox({
				url:'../sysUser/loadRoleList.do',
				valueField:'roleid',
				textField:'jsmc',
				multiple:false,
				onSelect:function(record){
					$("#hroleid").val(record.roleid);
					$("#hrolename").val(record.jsmc);
				}
			});
			_this.initForm();
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

$(function(){
	YiYa.sysUser.init();
});		