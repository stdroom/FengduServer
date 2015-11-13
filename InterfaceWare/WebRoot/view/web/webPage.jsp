<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource.jsp" %>
   <!-- markItUp! skin -->
	<link rel="stylesheet" type="text/css" href="${markitupUrl}/skins/markitup/style.css">
	<link rel="stylesheet" type="text/css" href="${markitupUrl}/sets/default/style.css">
  </head>
  <body class="easyui-layout">
	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 80px;" title="Search box" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
 	 	<p class="ui-fields">
            <label class="ui-label">Name:</label>
            <input name="name" class="easyui-box ui-text" style="width:100px;">
        </p>
        <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">Search</a>
      </form>  
     </div> 
     <!--  Search panel end -->
     
     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list"></table>
     </div>
     
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="页面信息" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:300px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <input class="hidden" name="deleted">
     		 <input class="hidden" name="typeid">
     		 <input class="hidden" name="templateContent">
     		  <div class="ui-edit">
		     	   <div class="ftitle">Page Information</div>    
		           <div class="fitem">  
		               <label>页面名称:</label>  
		               <input class="easyui-validatebox" type="text" name="name" data-options="required:true">
		           </div>  
		           <div class="fitem">  
		               <label>路径:</label>  
		               <input class="easyui-validatebox" type="text" name="localPath" data-options="required:true">
		           </div>  
		            <div class="fitem">  
		               <label>标题:</label>  
		               <input type="text" name="title" >
		           </div> 
		            <div class="fitem">  
		               <label>关键字:</label>  
		               <input type="text" name="keyword" >
		           </div> 
		           <div class="fitem">  
		               <label>描述:</label>  
		               <textarea class="easyui-validatebox" data-options="length:[0,200]" name="description"></textarea>
		           </div> 
	         </div>
     	</form>
  	 </div>
  	 
  	  <!-- Edit PageTemp Win&Form -->
     <div id="edit-temp-win" class="easyui-dialog" title="编辑页面" buttons="#editTempBtn" data-options="closed:true,iconCls:'icon-save',modal:true,maximized:true" style="width:400px;height:300px;">  
     	<form id="editTempForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <input class="hidden" name="deleted">
     		 <input class="hidden" name="typeid">
     		  <div class="fitem">  
	               <label style="width:60px">页面名称:</label>  
	               <input  type="text" name="name" readonly="readonly">
	           </div> 
     		  <div class="ui-edit">
		           <div class="fitem">  
		               <textarea id="markItUp" name="templateContent"></textarea>
		           </div> 
	         </div>
     	</form>
     	<div id="editTempBtn" class="dialog-button">  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-temp-submit">Save</a>  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-temp-close">Close</a>  
        </div>
  	 </div> 
<!-- Js Start -->
<script type="text/javascript" src="${msUrl}/js/ux/web/webPage.js"></script>
<!-- markItUp! -->
<script type="text/javascript" src="${markitupUrl}/jquery.markitup.js"></script>
<script type="text/javascript" src="${markitupUrl}/sets/default/set.js"></script>
  </body>
</html>
