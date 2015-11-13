<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@include file="/view/resource.jsp"%>
		<script language="javaScript" src="${msUrl}/js/ux/sfz/idCardck.js"></script>
        <script language="javaScript" src="${msUrl}/js/ux/sfz/sfzyz.js"></script>
        <object id="CardReader1" codebase="${msUrl}/js/ux/sfz/FirstActivex.cab#version=1,0,3,1" classid="CLSID:F225795B-A882-4FBA-934C-805E1B2FBD1B">
	<param name="_Version" value="65536"/>
	<param name="_ExtentX" value="2646"/>
	<param name="_ExtentY" value="1323"/>
	<param name="_StockProps" value="0"/>
	</object>
	</head>
	<body class="easyui-layout">
		<!-- Search panel start -->
		<div class="ui-search-panel" region="north" style="height: 80px;"
			title="Search box"
			data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false">
			<form id="searchForm">
				<p class="ui-fields">
					<label class="ui-label">
						车牌号:
					</label>
					<input id='cpbh' name="cpbh" class="easyui-box ui-text" style="width: 100px;" ondblclick='relationcph(this);' onkeydown='relationcph(this)'>
					<label class="ui-label">
						收货人联系电话:
					</label>
					<input id="shrlxdh" name="shrlxdh" class="easyui-box ui-text" style="width: 150px;">
					<label>
							货物状态:
						</label>
						<select class="easyui-combo" id="hwztser" name="hwztser" data-options="required:false">
							<option value="0" selected="selected">
								落货
							</option>
							<option value="1">
								取货
							</option>
							<option value="2">
								作废
							</option>
						</select>
					<label class="ui-label">
						开始日期:
					</label>
					<input id="lrrqstart" name="lrrqstart" class="easyui-datebox"
						data-options="formatter:myformatter,parser:myparser"
						style="width: 100px;">
					<label class="ui-label">
						结束日期:
					</label>
					<input id="lrrqend" name="lrrqend" class="easyui-datebox"
						data-options="formatter:myformatter,parser:myparser"
						style="width: 100px;">

				</p>
				<a href="#" id="btn-search" class="easyui-linkbutton"
					iconCls="icon-search">查询</a>
			</form>
		</div>
		<!--  Search panel end -->

		<!-- DataList  -->
		<div region="center" border="false">
			<table id="data-list"></table>
		</div>

		<!-- Edit Form -->
		     <div id="edit-win" class="easyui-dialog" title="编辑打印窗口" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:600px;height:500px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
					<div class="ftitle"> 
						落货详细信息<br><br> 
					</div>

					<div class="fitem">
					
					<label> 
						序号: 
						</label><input type="text" readonly="readonly" class="easyui-validatebox" id="xh" name="xh" data-options="required:true"> 
						</div>
					    <div class="fitem"> 
						<label> 
							货物名称: 
						</label><input type="text" readonly="readonly" disabled="disabled" class="easyui-validatebox" name="hwmc" data-options="required:true" > 
						</div>
					    <div class="fitem"> 
						<label>
							车牌编号:
						</label>
						<input class="easyui-validatebox" type="text" name="cpbh"
							data-options="required:true" readonly="readonly" disabled="disabled"> 
						</div>
					    <div class="fitem"> <label>
							货物状态:
						</label>
						<select class="easyui-combo"  disabled="disabled" readonly="readonly" id="hwzt" name="hwzt"
							data-options="required:true">
							<option value="0" >
								落货
							</option>
							<option value="1">
								取货
							</option>
							<option value="2">
								作废
							</option>
						</select>
					</div>

					<div class="fitem">
						<label> 
							件 数: 
						</label><input type="text"    class="easyui-validatebox" id="jianshu" name="jianshu" data-options="required:true">
						 </div>
					    <div class="fitem"> <label>
							收货人联系电话:
						</label>
						<input readonly="readonly" disabled="disabled" class="easyui-validatebox" type="text" name="shrlxdh"
							data-options="required:true">
					</div>
					<div class="fitem">
						<label> 
							保管费: 
						</label><input type="text" class="easyui-numberbox"   id="bgf" name="bgf"   onkeyup="if(event.keyCode!=13) hejisum();">
						</div>
					    <div class="fitem"> 
					    <label>
							运费:
						</label>
						<input class="easyui-numberbox"   type="text" id="yf" name="yf"
							 onkeyup="if(event.keyCode!=13) hejisum();">
					</div>
	
					<div class="fitem">
						<label> 
							总费用: 
						</label><input type="text" class="easyui-numberbox"   id="zfy" name="zfy"> 
						</div>
					    <div class="fitem"> <label>  
							付费方式:  
						</label><select class="easyui-combo" disabled="disabled" readonly="readonly" id="fkfs" name="fkfs" data-options="required:true"> 
							<option value="0"> 
								运费现付 
							</option> 
							<option value="1"> 
								运费提付 
							</option> 
						</select>
					</div>
					
                    <div class="fitem"> <label> 
							取货人身份证号: 
						</label><input type="text" class="easyui-validatebox"   id="qhrsfz" name="qhrsfz"  data-options="required:true" onClick="countIDcard();"> 
					</div>
					<div class="fitem">
						<label> 
							取货人姓名: 
						</label><input type="text" class="easyui-validatebox"   id="qhrxm" name="qhrxm"  data-options="required:false" >  
						</div>
					    
				</div>
			</form>
		</div>

		<script type="text/javascript"
			src="${msUrl}/js/ux/siteMain/sysUsertest.js"></script>
		<script type="text/javascript">
		
		 $(function(){
 var $inp = $("#cpbh");
         $inp.bind('keydown',function(event){
             if(event.keyCode==32||event.keyCode==0) {
		openrCar(event.srcElement);
		event.srcElement.blur();
		event.cancelBubble = true;
	}
         });
     });
     
     function openrCar(event_obj){
 var srcVar ="/ms/view/carquery.jsp??sqlSenParm=select xh,cpbh,zdmc from t_xt_hyclsj";
  srcVar+=" where dbo.fun_getPY(cpbh,'') like '％"+event_obj.value+"％'";
  srcVar+=" and zdmc='"+qszStr+"'";
  srcVar+=" and qxbz='0'";
  srcVar+=" order by cpbh";
  srcVar+="&colChinese=序号,车牌编号,站点名称 &colEnglish=xh,cpbh,zdmc &colWidth=0-,50-,50-";
  var winFeature = "dialogWidth:700px;dialogHeight=500px;scroll=yes;resizable=no;help=no;status=no;";
	window.showModalDialog(srcVar,event_obj,winFeature);
}
		function myformatter(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
		}
		function myparser(s){
			if (!s) return new Date();
			var ss = (s.split('-'));
			var y = parseInt(ss[0],10);
			var m = parseInt(ss[1],10);
			var d = parseInt(ss[2],10);
			if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
				return new Date(y,m-1,d);
			} else {
				return new Date();
			}
		}
		
	function getYestoday(date){      
    var yesterday_milliseconds=date.getTime()-1000*60*60*48;       
    var yesterday = new Date();       
        yesterday.setTime(yesterday_milliseconds);       
        
    var strYear = yesterday.getFullYear();    
    var strDay = yesterday.getDate();    
    var strMonth = yesterday.getMonth()+1;  
    if(strMonth<10)    
    {    
        strMonth="0"+strMonth;    
    }    
    datastr = strYear+"-"+strMonth+"-"+strDay;  
    return datastr;  
  }  
	$(function(){  
    //设置时间  
 var curr_time = new Date();   
 $("#lrrqstart").datebox("setValue",getYestoday(curr_time));  
 $("#lrrqend").datebox("setValue",myformatter(curr_time));  
 //获取时间  
 var beginTime=$("#lrrqstart").datebox("getValue");  
  var endTime=$("#lrrqend").datebox("getValue");  
})

function hejisum(){
    var jianshu=Number($("#jianshu").val());
	var yf=Number($("#yf").val());
	var bgf=Number($("#bgf").val());
	var hj=yf+bgf*jianshu;;
 $("#zfy").val(hj);
}


	</script>
	</body>
</html>
