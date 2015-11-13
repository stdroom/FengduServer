
/*打开页面通用函数*/
function publicOpenWin(srcStr,winTop){
	var  iWidth=750; //模态窗口宽度
	var  iHeight=500;//模态窗口高度
	var  iTop=(window.screen.height-iHeight)/2;
	var  iLeft=(window.screen.width-iWidth)/2;
	window.open(srcStr,winTop,"width="+iWidth+",height="+iHeight+",directions=no,status=no,toolbar=no,location=no,menubar=no,scrollbars=yes,resizable=no,top=" + iTop + ",left="+iLeft+"");
}

/*其他按钮单击事件*/
function qtClick(){
	parent.shuru.menu.style.visibility = 'visible';
}

//打印功能
function submitDy() {
	 var dqdh=$("#dqdh").val();
	 var url="/ms/view/print/tydcdreport.jsp?dqdh="+dqdh;
	 var str=window.open(url,'','scrollbars=auto;resizable=1');
	 str.blur();
	 str.focus();
	 str.resizeTo(800,700); 
}

//根据单选框判断付费方式
//运费先付方式值为"0"运费提付方式值为"1",货到付款方式值为"2"	
function radioClickffjyms(itemObj){
		document.xbplrForm.fffsVal.value = itemObj.value;
		if (document.xbplrForm.fffsVal.value == "0"){
			document.hiddenInfo.fffsStr.value="运费现付";
			if(document.xbplrForm.dshkVal.value == "0"){
				window.xbplr.rows.item(14).cells.item(0).innerHTML="";
				window.xbplr.rows.item(14).cells.item(1).innerHTML="";
			}
		}else if (document.xbplrForm.fffsVal.value == "1"){
			document.hiddenInfo.fffsStr.value="运费提付";
			window.xbplr.rows.item(14).cells.item(0).innerHTML="担保类型\r\n<font  color='red'  size='3'  >*     </font>";
			window.xbplr.rows.item(14).cells.item(1).innerHTML="<div align='left'><input id='dblxfhr' name='dblx' type='radio' checked value='0' onClick='radioClickys(this)'>发货人保证<input id='dblxshr' name='dblx' type='radio' value='1' onClick='radioClickys(this)'>收货人确认<input id='dblxjbr' name='dblx' type='radio' value='2' onClick='radioClickys(this)'>经办人担保<input id='dblxVal' name='dblxVal' type='hidden' value='0'></div>";
		}
	}
//代收货款
function radioClickhk(itemObj){		
		document.xbplrForm.dshkVal.value = itemObj.value;
		if (document.xbplrForm.dshkVal.value == "0"){
			document.hiddenInfo.hkjeStr.value="0.0";
			window.xbplr.rows.item(10).cells.item(0).innerHTML="";
			document.xbplrForm.hkje.style.display="none";
			window.xbplr.rows.item(10).cells.item(3).innerHTML="";
			document.xbplrForm.dsf.style.display="none";
			if(document.xbplrForm.fffsVal.value == "0"){
				window.xbplr.rows.item(17).cells.item(0).innerHTML="";
				window.xbplr.rows.item(17).cells.item(1).innerHTML="";
			}
			document.xbplrForm.jianshu.focus();
		}else if (document.xbplrForm.dshkVal.value == "1"){				
			window.xbplr.rows.item(10).cells.item(0).innerHTML="货款金额[元]\r\n<font  color='red'  size='3'  >*     </font>";
			window.xbplr.rows.item(10).cells.item(1).innerHTML="<div align='left'><input id='hkje' name='hkje' type='text'  class='csstext32underline_small'   value='' onkeyup='if(event.keyCode!=13) clearNoNum(this)'></div>";		
			document.getElementById("hkje").focus();
			window.xbplr.rows.item(10).cells.item(3).innerHTML="代收费[元]\r\n";
			window.xbplr.rows.item(10).cells.item(4).innerHTML="<div align='left'><input id='dsf' name='dsf' type='text'  class='csstext32underline_small' readonly='true'  value='' onkeyup='if(event.keyCode!=13) clearNoNum(this)'></div>";
			window.xbplr.rows.item(17).cells.item(0).innerHTML="担保类型\r\n<font  color='red'  size='3'  >*     </font>";
			window.xbplr.rows.item(17).cells.item(1).innerHTML="<div align='left'><input id='dblxfhr' name='dblx' type='radio' checked value='0' onClick='radioClickdblx(this)'>发货人保证<input id='dblxshr' name='dblx' type='radio' value='1' onClick='radioClickdblx(this)'>收货人确认<input id='dblxjbr' name='dblx' type='radio' value='2' onClick='radioClickdblx(this)'>经办人担保<input id='dblxVal' name='dblxVal' type='hidden' value='0'></div>";
		}
	}
	
	//根据单选框判断短信通知
function radioClickdx(itemObj){
	var s= itemObj.value;
	if (s == "0"){
		$("#dxtsVal").val("0");
	}else if (s== "1"){
		$("#dxtsVal").val("1");
	}
}

//是否垫付
function radioClickdf(itemObj){
		document.xbplrForm.sfdfVal.value = itemObj.value;
		if (document.xbplrForm.sfdfVal.value == "0"){
			window.xbplr.rows.item(15).cells.item(3).innerHTML="";
			document.xbplrForm.dfje.style.display="none";
		}else if (document.xbplrForm.sfdfVal.value == "1"){
			window.xbplr.rows.item(15).cells.item(3).innerHTML="<div align='right'>垫付金额[元]\r\n<font  color='red'  size='3'  >*     </font></div>";
			window.xbplr.rows.item(15).cells.item(4).innerHTML="<div align='left'><input id='dfje' name='dfje' type='text'  class='csstext32underline_small'   value='' onkeyup='if(event.keyCode!=13) clearNoNum(this)'></div>";
		}
	}

//根据单选框判断是否保价	
function radioClickbj(itemObj){
		document.xbplrForm.sfbjVal.value = itemObj.value;
		if (document.xbplrForm.sfbjVal.value == "0"){
			document.hiddenInfo.sfbjStr.value="0.0";
			window.xbplr.rows.item(14).cells.item(3).innerHTML="";
			document.xbplrForm.bjje.style.display="none";
			window.xbplr.rows.item(14).cells.item(0).innerHTML="";
			document.xbplrForm.gjje.style.display="none";
		}else if (document.xbplrForm.sfbjVal.value == "1"){
			window.xbplr.rows.item(14).cells.item(0).innerHTML="估价金额[元]\r\n<font  color='red'  size='3'  >*     </font>";
			window.xbplr.rows.item(14).cells.item(1).innerHTML="<div align='left'><input id='gjje' name='gjje' type='text'  class='csstext32underline_small'   value='' onkeyup='if(event.keyCode!=13) clearNoNum(this)'></div>";
			window.xbplr.rows.item(14).cells.item(3).innerHTML="保价金额[元]\r\n";
			window.xbplr.rows.item(14).cells.item(4).innerHTML="<div align='left'><input id='bjje' name='bjje' type='text'  class='csstext32underline_small'  readonly='true' value='' onkeyup='if(event.keyCode!=13) clearNoNum(this)'></div>";
			document.getElementById("gjje").focus();	
		}
	}
	
//根据单选框判断是否保价	
function radioClick(itemObj){
		document.xbplrForm.jffsVal.value = itemObj.value;
		if (document.xbplrForm.jffsVal.value == "0"){
			window.xbplr.rows.item(7).cells.item(0).innerHTML="议得票价[元]\r\n<font  color='red'  size='3'  >*     </font>";
			window.xbplr.rows.item(7).cells.item(1).innerHTML="<div align='left'><input id='ydpj' name='ydpj' type='text'  class='csstext32underline_small'   value='' onkeyup='if(event.keyCode!=13) clearNoNum(this)'></div>";
			window.xbplr.rows.item(7).cells.item(3).innerHTML="";
			if(typeof(document.xbplrForm.tyf)=="object"){
				document.xbplrForm.tyf.style.display="none";
			}
			if(typeof(window.xbplr.rows.item(7).cells.item(4))=="object"){
				window.xbplr.rows.item(7).cells.item(4).innerHTML="";
			}			
		}else if (document.xbplrForm.jffsVal.value == "1"){
			if(document.xbplrForm.qsz.value!="" && document.xbplrForm.qsz.value!=null && document.xbplrForm.ddz.value!="" && document.xbplrForm.ddz.value!=null){
				window.xbplr.rows.item(7).cells.item(0).innerHTML="发货点费用[元]\r\n<font  color='red'  size='3'  >*     </font>";
				window.xbplr.rows.item(7).cells.item(3).innerHTML="托运费用[元]\r\n<font  color='red'  size='3'  >*     </font>";
				window.xbplr.rows.item(7).cells.item(1).innerHTML="<div align='left'><input id='fhdfy' name='fhdfy' type='text'  class='csstext32underline_small' readonly='true'  value='0'></div> ";
				window.xbplr.rows.item(7).cells.item(4).innerHTML="<div align='left'><input id='tyf' name='tyf' type='text'  class='csstext32underline_small'  readonly='true'  value='0'></div>";
				
			}else {
				alert("起始站和到达站点不能为空！请先选择到达站点！");
				window.xbplr.rows.item(7).cells.item(0).innerHTML="发货点费用[元]\r\n<font  color='red'  size='3'  >*     </font>";
				window.xbplr.rows.item(7).cells.item(3).innerHTML="托运费用[元]\r\n<font  color='red'  size='3'  >*     </font>";
				window.xbplr.rows.item(7).cells.item(1).innerHTML="<div align='left'><input id='fhdfy' name='fhdfy' type='text'  class='csstext32underline_small' readonly='true'  value='0'></div> ";
				window.xbplr.rows.item(7).cells.item(4).innerHTML="<div align='left'><input id='tyf' name='tyf' type='text'  class='csstext32underline_small'  readonly='true'  value='0'></div>";
				}

		}else if (document.xbplrForm.jffsVal.value == "2"){

		}else if (document.xbplrForm.jffsVal.value == "3"){
			if(document.xbplrForm.qsz.value!="" && document.xbplrForm.qsz.value!=null && document.xbplrForm.ddz.value!="" && document.xbplrForm.ddz.value!=null){
				window.xbplr.rows.item(7).cells.item(0).innerHTML="货物重量[千克]\r\n<font  color='red'  size='3'  >*     </font>";
				window.xbplr.rows.item(7).cells.item(3).innerHTML="每公斤收费标准[元]\r\n<font  color='red'  size='3'  >*     </font>";
				window.xbplr.rows.item(7).cells.item(1).innerHTML="<div align='left'><input id='hwweight' name='hwweight' type='text'  class='csstext32underline_small'  value='0' onkeyup='if(event.keyCode!=13) clearNoNum(this)'></div> ";
				window.xbplr.rows.item(7).cells.item(4).innerHTML="<div align='left'><input id='mgjmglsf' name='mgjmglsf' type='text'  class='csstext32underline_small'  readonly='true'  value='0'></div>";
				
			}else {
				alert("起始站和到达站点不能为空！请先选择到达站点！");
				window.xbplr.rows.item(7).cells.item(0).innerHTML="货物重量[千克]\r\n<font  color='red'  size='3'  >*     </font>";
				window.xbplr.rows.item(7).cells.item(3).innerHTML="每公斤收费标准[元]\r\n<font  color='red'  size='3'  >*     </font>";
				window.xbplr.rows.item(7).cells.item(1).innerHTML="<div align='left'><input id='hwweight' name='hwweight' type='text'  class='csstext32underline_small'  value='0' onkeyup='if(event.keyCode!=13) clearNoNum(this)'></div> ";
				window.xbplr.rows.item(7).cells.item(4).innerHTML="<div align='left'><input id='mgjmglsf' name='mgjmglsf' type='text'  class='csstext32underline_small'  readonly='true'  value='0'></div>";
				}
		}
	}
	
/*行包票售票信息保存记帐*/
function saveClick(){
	var dblxstr;
	if(true){
			if( $("#dqdh").val()==""){
				YiYa.alert('警告','当前单号不能为空！','warning');  
				return;		
			}
			if($("#ddz").val()==""){
				YiYa.alert('警告','到达站不能为空！','warning');  
				return;		
			}
			if($("#shrdh").val()==""){
				YiYa.alert('警告','收货人电话不能为空！','warning');  
				return;		
			}		
			if($("#zhonglei").val()==""){
				YiYa.alert('警告','货物种类不能为空！','warning');  
				return;		
			}
			if($("#jianshu").val()==""){
				YiYa.alert('警告','货物件数不能为空！','warning');  
				return;		
			}	
			if($("#jffsVal").val()=="0"){
				if(document.xbplrForm.ydpj.value==""|| document.xbplrForm.ydpj.value==null){
					alert("议得票价不能为空！");
					return;		
				}
				var ydpjStr=document.xbplrForm.ydpj.value;
				ydpjStr=ydpjStr.replace(/[ ]/g,""); 
			}else if($("#jffsVal").val()=="1"){
				if(document.xbplrForm.fhdfy.value==""|| document.xbplrForm.fhdfy.value==null){
					alert("发货点费用不能为空！");
					return;		
				}
				if(document.xbplrForm.tyf.value==""|| document.xbplrForm.tyf.value==null){
					alert("托运费不能为空！");
					return;		
				}
				var fhdfyStr=document.xbplrForm.fhdfy.value;
				fhdfyStr=fhdfyStr.replace(/[ ]/g,""); 
				var tyfStr=document.xbplrForm.tyf.value;
				tyfStr=tyfStr.replace(/[ ]/g,""); 
			}else if($("#jffsVal").val()=="3"){
				if(document.xbplrForm.hwweight.value==""|| document.xbplrForm.hwweight.value==null){
					alert("货物重量不能为空！");
					return;		
				}
				if(document.xbplrForm.mgjmglsf.value==""|| document.xbplrForm.mgjmglsf.value==null){
					alert("每公斤收费标准不能为空！");
					return;		
				}
				var hwweightStr=document.xbplrForm.hwweight.value;
				hwweightStr=hwweightStr.replace(/[ ]/g,""); 
				var mgjmglsfStr=document.xbplrForm.mgjmglsf.value;
				mgjmglsfStr=mgjmglsfStr.replace(/[ ]/g,""); 
			}
			if(document.xbplrForm.dshkVal.value == "1"){	
				if(document.xbplrForm.hkje.value==""|| document.xbplrForm.hkje.value==null){
					alert("货款金额不能为空！");
					return;		
				}
				var hkjeStr=document.xbplrForm.hkje.value;
				hkjeStr=hkjeStr.replace(/[ ]/g,""); 
			}
			if(document.xbplrForm.sfpsVal.value == "1"){
				if(document.xbplrForm.psje.value==""|| document.xbplrForm.psje.value==null){
					alert("配送金额不能为空！");
					return;		
				}
				var psjeStr=document.xbplrForm.psje.value;
				psjeStr=psjeStr.replace(/[ ]/g,"");
			}
			if(document.xbplrForm.sfbjVal.value == "1"){
				if(document.xbplrForm.gjje.value==""|| document.xbplrForm.gjje.value==null){
					alert("估价金额不能为空！");
					return;		
				}
				var gjjeStr=document.xbplrForm.gjje.value;
				gjjeStr=gjjeStr.replace(/[ ]/g,"");
			}
			if(document.xbplrForm.sfdfVal.value == "1"){
				if(document.xbplrForm.dfje.value==""|| document.xbplrForm.dfje.value==null){
					alert("垫付金额不能为空！");
					return;		
				}
				var dfjeStr=document.xbplrForm.dfje.value;
				dfjeStr=dfjeStr.replace(/[ ]/g,"");
			}
		  if(document.xbplrForm.fffsVal.value == "1" || document.xbplrForm.dshkVal.value == "1"){
				dblxstr=document.xbplrForm.dblxVal.value;		
			}else{
				dblxstr="无担保";
			}
			if(document.xbplrForm.bzf.value == "" || document.xbplrForm.bzf.value == null){
				document.xbplrForm.bzf.value="0.00";		
			}
	
		var dqdhStr=document.forms['searchForm'].dqdh.value;
		dqdhStr=dqdhStr.replace(/[ ]/g,""); 
		var fhrxmStr= document.xbplrForm.qhrxm.value;
		fhrxmStr=fhrxmStr.replace(/[ ]/g,""); 
		var fhrdhStr=document.xbplrForm.fhrdh.value;
		fhrdhStr=fhrdhStr.replace(/[ ]/g,""); 
		var shrxmStr=document.xbplrForm.shrxm.value;
		shrxmStr=shrxmStr.replace(/[ ]/g,""); 
		var shrdhStr= document.xbplrForm.shrdh.value;
		shrdhStr=shrdhStr.replace(/[ ]/g,""); 
		var zhongleiStr=document.xbplrForm.zhonglei.value;
		zhongleiStr=zhongleiStr.replace(/[ ]/g,""); 
		var jianshuStr=document.xbplrForm.jianshu.value;
		jianshuStr=jianshuStr.replace(/[ ]/g,"");
		var bzStr= document.xbplrForm.bz.value;
		bzStr=bzStr.replace(/[ ]/g,"");
		var bzfStr=document.xbplrForm.bzf.value;
		bzfStr=bzfStr.replace(/[ ]/g,""); 
			var UrlVar="save.do?handleType=saveRecord&dqdh="+dqdhStr+"&qsz="+document.xbplrForm.qsz.value+"&ddz="+document.xbplrForm.ddz.value
					+"&fhrxm="+fhrxmStr+"&fhrdh="+fhrdhStr+"&shrxm="+shrxmStr+"&shrdh="+shrdhStr+"&zhonglei="+zhongleiStr+"&jianshu="+jianshuStr+"&jffs="+document.xbplrForm.jffsVal.value
					+"&ydpj="+ydpjStr+"&fhdfy="+fhdfyStr+"&tyf="+tyfStr+"&fffs="+document.xbplrForm.fffsVal.value+"&hkje="+hkjeStr+"&sfdx="+document.xbplrForm.dxtsVal.value
					+"&sfps="+document.xbplrForm.sfpsVal.value+"&psje="+psjeStr+"&fhrzjh="+document.xbplrForm.qhrsfz.value+"&fhrdz="+document.xbplrForm.fhrdz.value
					+"&shrzjh="+document.xbplrForm.shrzjh.value+"&shrdz="+document.xbplrForm.shrdz.value+"&tyms="+1+"&weight="+hwweightStr
					+"&mgjmglsf="+mgjmglsfStr+"&sfbj="+document.xbplrForm.sfbjVal.value+"&gjje="+gjjeStr+"&dfje="+dfjeStr+"&sfdshk="+document.xbplrForm.dshkVal.value
					+"&sfdf="+document.xbplrForm.sfdfVal.value+"&sfys="+document.xbplrForm.sfysVal.value+"&dblx="+dblxstr+"&bz="+bzStr
					+"&cpbh="+document.searchForm.cpbh.value+"&bzf="+bzfStr+"dblx="+dblxstr;
			var con = window.confirm("是否保存订单并打印？");
			if (con == true){	
				//YiYa.ajaxJson(UrlVar, '', function(){alert();});
				var x=encodeURI(UrlVar);				
				window.location.href=UrlVar;
				submitDy();
				
			 }else{
				return;	 			
			}
		}else{
	
		}

		
}



