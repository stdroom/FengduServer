<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@include file="/view/resource.jsp"%>
	</head>
	<body class="easyui-layout">
		<!-- Search panel start -->
		<div class="ui-search-panel" region="north" style="height: 80px;"
			title="货物托运单录入"
			>
			<form id="searchForm">
				<p class="ui-fields">
					<label class="ui-label">
						车牌号:
					</label>
					<input id="cpbh" name="cpbh" class="easyui-combobox" style="width: 100px;" >
					<label class="ui-label">
						收货人联系电话:
					</label>
					<input id="shrlxdh" name="shrlxdh" class="easyui-box ui-text" style="width: 150px;">
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
				    <a href="#" id="btn-search" class="easyui-linkbutton">查询</a>
					<a href="#" id="btn-submit" class="easyui-linkbutton">保存</a>
			</form>
		</div>
		
		<div id="data-list">
		</div>
		<div region="center" border="false">
	<br>&nbsp;
	 <table  border="0"  name="xbplr"  width="100%"  class=""  cellspacing="1"  cellpadding="2"  id="xbplr"   >
	<form id="editForm" class="ui-form" method="post">
  <!-- <tr width="100%"  class="cssnr2"> -->
     <tr width="100%"  class="cssnr2">
      <td width="15%" height="30" align="right"><font size="4px">车牌号</font></td>
      <td width="25%">
      	<input name="cph" id="cph" type="text"  class="inputcss"  value="" ondblclick='relationcph(this);xbplrForm.fhrdh.select();' onkeydown='if(event.keyCode==32){relationcph(this);xbplrForm.fhrdh.select();}'>
      </td>
      <td width="25%">
      	<div align="right"><font size="4px">收货人联系电话</font><font  color="red"  size="3"  >* </font></div>
      </td>
      <td width="15%"><input name="fhrdh" id="fhrdh" type="text"  class="inputcss"  value="" onKeyUp="if(/^[\d]*$/.test(value)==false) value=value.replace(/[^\d]/g,'');" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/\D/g,''))"></td>
      <td width="20%">&nbsp;</td>
     </tr>
     <tr width="100%"  class="cssnr2">
      <td width="15%" height="30"><div align="right"><font size="4px">货物种类</font><font  color="red"  size="3"  >* </font> </div></td>
      <td width="25%">
	     <div  style="wdith:30%;float:left">
        <select name="zhonglei" id="zhonglei"   class="select"  onkeydown=catch_keydown(this) onkeypress=catch_press(this) onfocus=catch_focus(this)>
        	<option value=''></option>
         	<option  selected="selected" value="信封">信封</option>
         	<option value="箱子">箱子</option>
         	<option value="大箱子">大箱子</option>
					<option value="小箱子">小箱子</option>
					<option value="袋子">袋子</option>
					<option value="包">包</option>
					<option value="盒子">盒子</option>
					<option value="配件">配件</option>
					<option value="设备">设备</option>
					<option value="食品">食品</option>
				</select>          
	     </div>     
	     <div  align="left"></div></td>
       <td width="25%"  align="right"><font size="4px">货物件数</font></td>
       <td width="15%">
       	<div  align="left">
         <input name="jianshu" id="jianshu" type="text"  class="inputcss"   value="1" onKeyUp="if(/^[\d]*$/.test(value)==false) value=value.replace(/[^\d]/g,''); if(event.keyCode!=13) hejisum();"onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/\D/g,''))">
        </div>        
        <div  align="left"></div>
       </td>
       <td width="20%">&nbsp;</td>
      </tr>
      <tr width="100%"  class="cssnr2">
       <td  width="15%" height="30" align="right"><font size="4px">付费方式</font><font  color="red"  size="3"  >*</font></td>
       <td colspan="5">
       	<div  align="left"></div>        
       	<div  align="left">
        <input id="fffs" name="fffs" type="radio" checked value="0" onClick="radioClickfkfs_yf()"><font size="4px">已付</font>
        <input id="fffs" name="fffs" type="radio" value="1" onClick="radioClickfkfs_wf()"><font size="4px">未付</font>
        <input id="fffsVal" name="fffsVal" type="hidden" value="0">
        </div>
       </td>
      </tr>
      <tr width="100%"  class="cssnr2">
	      <td>
	      	<div align="right"><font size="4px">运费</font><font  color="red"  size="3"  >* </font>
	      </td>
        <td colspan="5"><div  align="left">
        	<input id="yf" name="yf" type="text"  class="inputcss"  disabled="true "  value="0.00"  onkeyup="if(event.keyCode!=13) hejisum();">
        </td>
      </tr>
      <tr width="100%"  class="cssnr2">
       <td width="15%" height="30" align="right"><font size="4px">单件保管费</font></td>
       <td colspan="5">
       	<div  align="left">
          <input name="bgf" id="bgf" type="text"  class="inputcss"   value="5"  onKeyUp="if(event.keyCode!=13) hejisum();" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/\D/g,''))">
        </div>        
        <div  align="left"></div>
       </td>
      </tr>
      <tr width="100%"  class="cssnr2">
       <td  width="15%" height="30" align="right"><font size="4px">合计金额[元]</font></td>
       <td colspan="5"><div  align="left">
        <input  id="heji" name="heji" type="text"   readonly="true" class="inputcss"   value="5"  onfocus="hejisum()"  ></div>        
        <div  align="left">        </div>
        </td>
      </tr>
       <tr width="100%"  class="cssnr2">
       <td  width="15%" height="30" align="right"><font size="4px">发送短信</font><font  color="red"  size="3"  >*</font></td>
       <td colspan="5">
       	<div  align="left"></div>        
       	<div  align="left">
        <input id="fsdx" name="fsdx" type="radio" checked value="0" onClick="radioClickfkfs_dxfs()"><font size="4px">发送</font>
        <input id="fsdx" name="fsdx" type="radio" value="1" onClick="radioClickfkfs_dxbfs()"><font size="4px">不发送</font>
        <input id="fsdxVal" name="fsdxVal" type="hidden" value="0">
        </div>
       </td>
      </tr>
      <tr width="100%"  class="cssnr2">
        <td width="15%" height="30" align="right"><font size="4px">备 注</font></td>
        <td colspan="5"><div  align="left"> <input  id="bz" name="bz" type="text" class="inputcss"   value=""></div>        </td>
      </tr>
      <input  id="writepsr" name="writepsr" type="hidden" value="" >
      
   </form>
</table>
		</div>
        <script type="text/javascript"
			src="${msUrl}/js/ux/siteMain/sysUsertestadd.js"></script>
		<script type="text/javascript">
		
		 $(function(){
           var $inp = $("#cpbh");
           $inp.bind('keydown',function(event){
             if(event.keyCode == "13")    
             {
	               // var url="/ms/view/querycar.jsp?";
	               // var str=window.open(url,'','scrollbars=auto;resizable=1');
	               /// str.blur();
	               // str.focus();
	               // str.resizeTo(800,700); 
             }
         });
     });
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
    var jianshu="";
	var yf="";
	var bgf="";
	var hj="";
	jianshu=Number($("#jianshu").val());
	yf=Number($("#yf").val());
	bgf=Number($("#bgf").val());
  hj=yf+bgf*jianshu;
 $("#heji").val(hj);
}

function radioClickfkfs_wf(){
	$("#yf").val('');
	$("#fffsVal").val('1');//设置付费方式
	$("#yf").attr("disabled",false);
	$("#yf").select(); //未付选中运费
	}
function radioClickfkfs_yf(){
	$("#yf").val('0.00');
	$("#fffsVal").val('0');
	$("#yf").attr("disabled",true);
	hejisum();
	}
	
function radioClickfkfs_dxfs(){
//短信发送
	$("#fsdxVal").val('0');
	}
function radioClickfkfs_dxbfs(){
     $("#fsdxVal").val('0'); //短信不发送

	}
	
    	
	//定义 select 原值
  var oldValue,oldText;
  //select下拉框的onkeydown事件，修改下拉框的值
  function catch_keydown(sel){
   switch(event.keyCode) {
    case 13: //回车键
     event.returnValue = false;
     break;
    case 27: //Esc键
     sel.options[sel.selectedIndex].text = oldText;
     sel.options[sel.selectedIndex].value = oldValue;
     event.returnValue = false;
     break;
    case 8:  //空格健
     var s = sel.options[sel.selectedIndex].text;
     s = s.substr(0,s.length-1);
     if (sel.options[0].value==sel.options[sel.selectedIndex].text){
      sel.options[sel.selectedIndex].value=s;
      sel.options[sel.selectedIndex].text=s;
     }
     event.returnValue = false;
     break;
   }
   if (!event.returnValue && sel.onchange)
    sel.onchange(sel)
  }

  //select下拉框的onkeypress事件，修改下拉框的值
  function catch_press(sel){
   if(sel.selectedIndex>=0){
    var s = sel.options[sel.selectedIndex].text + String.fromCharCode(event.keyCode);
    if (sel.options[sel.selectedIndex].value==sel.options[sel.selectedIndex].text){
     sel.options[sel.selectedIndex].value=s;
     sel.options[sel.selectedIndex].text=s;
    }
    event.returnValue = false;
    if (!event.returnValue && sel.onchange)
     sel.onchange(sel)
   }
  }

  //select下拉框的onfocus事件，保存下拉框原来的值
  function catch_focus(sel) {
   oldText = sel.options[sel.selectedIndex].value;
   oldValue = sel.options[sel.selectedIndex].value;
  }   
	</script>
	</body>
</html>
