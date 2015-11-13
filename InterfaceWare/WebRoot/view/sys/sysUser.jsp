<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.yiya.utils.SessionUtils"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource.jsp" %>
  </head>
	<body class="easyui-layout">
	<%
			String zdbm =  SessionUtils.getZdbm(request).getZdbm();
			String ryid = SessionUtils.getUser(request).getNickName();
	 %>
	<!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 80px;" title="Search box" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
 	 	<p class="ui-fields">
 	 	    <label class="ui-label">操作员账号:</label><input name="dlid" class="easyui-box ui-text" style="width:100px;">
            <label class="ui-label">操作员姓名: </label><input name="ryxm" class="easyui-box ui-text" style="width:100px;">
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
     		 <input class="hidden" name="hroleid" id='hroleid'>
     		 <input class="hidden" name="hrolename" id='hrolename'>
     		 <input class="hidden" name="xh" id='xh'>
     		  <input class="hidden" type="text" name="rybh">
     		 <input class="hidden" name="deleted">
     		 <div class="ui-edit">
	     	   <div class="ftitle">人员信息</div>   
	     	      <div class="fitem"> 
		               <label> 
							站点编码: 
						</label><input type="text" class="easyui-validatebox" name="zdbm" value =<%=zdbm%>   disabled=true data-options="required:true" > 
				</div>
	           <div class="fitem">  
	               <label>人员账号:</label>  
	               <input class="easyui-validatebox" type="text" name="dlid" data-options="required:true">
	           </div>  
	            
	           <div class="fitem">  
	               <label>人员姓名:</label>  
	               <input class="easyui-validatebox" type="text" name="ryxm" data-options="required:true,validType:'length[1,10]'">
	           </div>
	            <div class="fitem">  
	               <label>联系电话:</label>  
	               <input class="easyui-validatebox" type="text" name="lxdh" data-options="required:true"  onkeyup="if(/^[\d]*$/.test(value)==false) value=value.replace(/[^\d]/g,'');" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/\D/g,''))">
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
	            <div class="fitem">  
		               <label>操作员角色:</label>  
		               <select class="easyui-combobox" id="roleIds" name="roleIds"  
                    			data-options="width:105"></select>
		           </div> 
	         </div>
     	</form>
  	 </div> 
  	 
  	 <!-- Edit Password Form -->
     <div id="edit-pwd-win" class="easyui-dialog" buttons="#editPwdbtn" title="Edit PassWord" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:300px;">
     	<form id="pwdForm" class="ui-form" method="post">  
     		 <input class="hidden" name="rybh">
     		 <div class="ui-edit">
	     	   <div class="ftitle">操作员修改密码</div>    
	           <div class="fitem">  
	               <label>操作员账号:</label>  
	               <input class="easyui-validatebox" type="text" readonly="readonly" name="dlid" data-options="required:true,validType:'dlid'">
	           </div>  
	           <div class="fitem">  
	              <label>旧密码:</label>  
	              <input id="oldPwd" name="oldPwd" type="password" class="easyui-validatebox"/>
	           </div>
	            <div class="fitem">  
	               <label>新密码:</label>  
	               <input id="newPwd" name="newPwd" type="password" class="easyui-validatebox" data-options="required:true" />
	           </div> 
	           <div class="fitem">  
	               <label>新密码:</label>  
	              <input id="rpwd" name="rpwd" type="password" class="easyui-validatebox"   required="required" validType="equals['#newPwd']" />
	           </div> 
	         </div>
     	</form>
     	 <div id="editPwdbtn" class="dialog-button">  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-submit">提交</a>  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-close">关闭</a>  
        </div>
  	 </div> 
<script type="text/javascript" src="${msUrl}/js/ux/sys/sysUser.js"></script>
  </body>
</html>
