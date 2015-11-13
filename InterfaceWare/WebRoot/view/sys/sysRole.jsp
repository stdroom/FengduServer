<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.yiya.utils.SessionUtils"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource.jsp" %>
  </head>
	<body  class="easyui-layout">
	<%
			String zdbm =  SessionUtils.getZdbm(request).getZdbm();
			String ryid = SessionUtils.getUser(request).getNickName();
	 %>
	<!-- Search panel start -->
 	<div class="ui-search-panel" region="north" style="height: 80px;" title="Search box" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
 	 	<p class="ui-fields">
            <label class="ui-label">角色名称:</label> 
            <input name="roleName" class="easyui-box ui-text" style="width:100px;">
        </p>  
        <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->
     
     <!-- DataList  -->
     <div region="center" border="false" >
    	 <table id="data-list"></table>
	 </div>
     <!-- Edit Form -->
     <div id="edit-win" class="easyui-dialog" title="Edit" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:450px;height:500px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" name="xh">
     		 <input class="hidden" type="text" name="roleid">
     		 <div class="ui-edit">
	     	   <div class="ftitle">角色信息</div>
	     	    <div class="fitem"> 
		               <label> 
							站点编码: 
						</label><input type="text" class="easyui-validatebox" name="zdbm" value =<%=zdbm%>   disabled=true data-options="required:true" > 
				</div>    
	           <div class="fitem">  
	               <label>角色名称:</label>  
	               <input class="easyui-validatebox" type="text" name="jsmc" data-options="required:true">
	           </div>  
	            <div class="fitem">
						<label> 
							登记人员: 
						&nbsp;&nbsp;</label> <input class="easyui-validatebox" type="text"  name="djry"  value =<%=ryid%>   disabled=true  data-options="required:true,validType:'djry'">
						</div>   
					<div class="fitem">
						<label> 
							取消标志: 
						</label><input type="text" class="easyui-validatebox"   id="qxbz" name="qxbz" value="0"   disabled=true  data-options="required:true"> 
					</div>   
	           <!-- 
	           <div class="fitem">  
	               <label>Description:</label>  
	               <textarea class="easyui-validatebox" data-options="length:[0,100]" name="descr"></textarea>
	           </div>
	            -->
	            <div class="fitem" style="">  
	               <label>菜单授权:</label>
	               <div style="border: 1px solid #A4BED4; width:230px;height:200px;margin-left: 105px ;overflow: auto; ">  
	               	<ul id="menu-tree"  >
	               	</ul>
	               </div>
	               <!-- 
	               <select id="menu-tree" name="menuIds" class="easyui-combotree" data-options="url:'${msUrl}/sysMenu/getMenuTree.do'" multiple style="width:180px;"></select>
	                -->
	           </div>
	         </div>
     	</form>
  	 </div> 
<script type="text/javascript" src="${msUrl}/js/ux/sys/sysRole.js"></script>
  </body>
</html>
