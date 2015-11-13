<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource.jsp" %>
  </head>
  <body class="easyui-layout">
  	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 80px;" title="Search box" data-options="striped: false,collapsible:false,iconCls:'icon-search',border:false" >   
 	 <form id="searchForm">
 	 	<input class="hidden" id='search_parentId' name="parentId">
 	 	<p class="ui-fields">
            <label class="ui-label">站点名称:</label> 
            <input name="name" class="easyui-box ui-text" style="width:100px;">
            <label class="ui-label">菜单名称:</label> 
            <input name="name" class="easyui-box ui-text" style="width:100px;">
        </p>
        <a id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查找</a>
      </form>  
     </div> 
     <!--  Search panel end -->
     <!-- DataList  -->
	 <div region="center" border="false" >
     	<table id="data-list" ></table>
     </div>
    
     <!-- Edit Win&From -->
     <div id="edit-win" class="easyui-dialog" title="Edit Menu" data-options="closed:true,iconCls:'icon-save',modal:true"  style="width:500px;height:600px;">  
     	<form id="editForm" class="ui-form" method="post"> 
     	 <!-- 隐藏文本框 -->
     	 <input class="hidden" name="id">
     	 <input class="hidden" name="deleted">
    	 <input class="hidden" name="parentId" id='edit_parentId'>
    	 <input class="hidden" name="hidparId" id='hidparId'>
    	 <div class="easyui-panel" border='false' style="width:450px;height: 500px;">  
	        <div class="easyui-layout" data-options="fit:true">
	            <div data-options="region:'north',split:true" style="height:250px;padding:10px">  
	               <div class="ftitle">编辑信息</div>    
		           <div class="fitem">  
		               <label>菜单名称:</label>  
		               <input class="easyui-validatebox" type="text" name="name" data-options="required:true">
		           </div>  
		           <div class="fitem">  
		               <label>URL:</label>  
		               <input type="text" name="url" style="width: 156px; "></input>
		           </div>  
		           <div class="fitem">  
		               <label>级别:</label>  
		               <input class="easyui-numberbox" type="text" value="0" name="rank" data-options="required:true,min:0,max:999">
		           </div> 
		           <div class="fitem">  
		               <label>菜单功能:</label>  
		               <input class="easyui-validatebox" type="text" name="actions" >
		               <span>注册的Action.按"|"分隔</span>
		           </div>
		           <div class="fitem">  
		               <label>父菜单:</label>  
		               <select class="easyui-validatebox" id="parentid" name="parentid" style="width: 153px; height: 29px"></select>
		           </div> 
	            </div>
	            <div data-options="region:'center'">  
	              	<div id="toolbar">  
				        <a href="javascript:void(0)" id='addLine_btn' class="easyui-linkbutton" iconCls="icon-add" plain="true" >新增</a>  
				        <a href="javascript:void(0)" id='addDefLine_btn'class="easyui-linkbutton" iconCls="icon-add" plain="true" >修改</a>
				        <a href="javascript:void(0)" id='delAllLine_btn'class="easyui-linkbutton" iconCls="icon-remove" plain="true" >删除</a>  
				    </div>  
				    <table id="btn-tb" style="width:100%">
				    	<thead>
				    	<tr>
				    		<th width="5%"></th>
				    		<th width="25%">按钮名称:</th>
				    		<th width="25%">按钮类型</th>
				    		<th width="35%">注册Action(用"|"分格)</th>
				    		<th width="10%">操作</th>
				    	</tr>
				    	</thead>
				    	<tbody>
				    	</tbody>
				    </table>
	            </div>
	         </div>
	       </div>
     	</form>
  	 </div>
  <script type="text/javascript" src="${msUrl}/js/ux/sys/sysMenu.js"></script>
  </body>
</html>
