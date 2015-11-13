// ["name", "sex", "age", "job", "E-mail"];
var vData=
{'55':'55公里',
'121':'121团',
'122':'122团',
'132':'132团',
'133':'133团',
'134':'134团',
'135':'135团',
'136':'136团',
'141':'141团',
'142':'142团',
'143':'143团',
'144':'144团',
'147':'147团',
'148':'148团',
'148':'148团二营',
'149':'149团',
'150':'150团',
'aa':'乌鲁木齐（快）',
'ajh':'安集海',
'al':'阿勒泰',
'bht':'八号跌水',
'bjd':'包家店',
'bjt':'白碱滩',
'bl':'博乐',
'blex':'博乐(小)',
'bt':'北屯',
'cj':'昌吉',
'df':'大丰',
'dhy':'大河沿子',
'dhyq':'大河沿大桥',
'dny':'大农业',
'dsz':'独山子',
'dwp':'地窝堡机场',
'em':'额敏',
'eta':'二台',
'fch':'芳草湖',
'fh':'福海',
'fk':'阜康',
'ghz':'甘河子',
'gqu':'高泉',
'hc':'霍城',
'hmi':'哈密',
'hqn':'红旗农场',
'hs':'和什托洛盖',
'htb':'呼图壁',
'jh':'精河',
'jms':'吉木萨尔',
'kel':'库尔勒',
'kl':'克拉玛依',
'klmx':'克拉玛依（小）',
'kt':'奎屯',
'ktx':'奎屯（小）',
'lcg':'芦草沟',
'lmw':'柳毛湾',
'lsw':'老沙湾',
'lty':'乐土驿',
'meg':'庙尔沟',
'mgc':'莫管处',
'mns':'玛纳斯',
'mqu':'米泉',
'qs':'清水河',
'qt':'奇台',
'sdh':'四道河子',
'sit':'四台',
'sks':'四棵树',
'ssz':'沙山子',
'sta':'三台',
'swa':'沙湾',
'tcg':'铁厂沟',
'tc':'塔城',
'tlf':'吐鲁番',
'tl':'托里',
'ttu':'托托',
'weh':'乌尔禾',
'wlm':'乌鲁木齐',
'wlmp':'乌鲁木齐（普）',
'wlmx':'乌鲁木齐（小）',
'ws':'乌苏',
'wta':'五台',
'xgu':'小拐',
'xhe':'新湖二场',
'xhs':'新湖试站',
'xhy':'新湖一场',
'xh':'新湖总场',
'yfe':'永丰',
'yn':'伊宁'};
$(document).ready(function(){	//一开始加载方法
	
		var highlightindex = -1;///高亮显示的变量值(0-n) 初始-1即无任何 子div 被选中
		var timeout;///服务器交互延迟
		var wordInput = $("#zdmc"); //输入框节点
		var wordInputOffset = wordInput.offset(); //获取输入框的属性函数
		//var autoNode=window.parent.getDiv();
		var autoNode = $("#auto");//初始的auto div节点
		
		autoNode.hide();//隐藏
		autoNode.css("position","absolute"); //相对于其最接近的一个最有定位设置的父对象（wordInput）进行绝对定位
		autoNode.css("z-index","99");//处于顶层
		autoNode.css("cursor","default");//鼠标样式
		//autoNode.css("filter","alpha(opacity=50");//透明度
		autoNode.css("text-overflow","clip");//内容过多时不显示省略标记(...)，而是简单的裁切 
		autoNode.css("border","1px black solid");//边框
		autoNode.css("top",wordInputOffset.top-40+"px");//设置高 以ie8 作为标准
		autoNode.css("left",wordInputOffset.left-2+"px").width(wordInput.width()+30);//设置左边与宽
		//当使用到项目中，会发现弹出框的背景色是透明的，需要这里设置一下
		//autoNode.css("background-color","white");		//设置弹出框的背景色
							    		
	
		wordInput.blur(function()	///失去焦点时促发
	     {
			  setTimeout(function() //延时200毫秒以便 鼠标的点击事件能执行
			{
				 autoNode.hide();
				 highlightindex = -1;
			},200);
		});	
		
	    wordInput.keyup(function(event)//键盘按下
	    {
	    	var myEvent = event || window.event; 	//不同浏览器选不同事件
	    	var keyCode = myEvent.keyCode;///键盘按下的 值
	    	
	    	if(keyCode>=48&&keyCode<=57||keyCode >= 65 && keyCode <= 90 || keyCode==8 || keyCode ==46||keyCode==13||keyCode==32)//是英文 或退格或删除键都进与服务器交互
	    	//if(onChange==true)
	    	{
	    		var textInput = wordInput.val();//获取输入框的值
	    		if(textInput != "" ) //输入不为空
	    		{
	    			clearTimeout(timeout);//清空前一次的倒数时间
	    			
	    			timeout = setTimeout(function(){ ///延迟与服务器交互时间提高效率
	    	
	    			//$.post("servlet/InputServlet",{text:textInput},function(data) ///与服务器交互 采用xml返回格式
	    			//{
						var redata=findEach(textInput);
						if(redata.length>0){
		    			//var jqueryObj = $(data);//获取返回值节点
		    			//var wordNodes = jqueryObj.find("zdmc"); //找到返回的所有xml-word节点 <word>...</word> 节点可自己在服务端定义
		    			autoNode.html("");//清空内容防止div里面重复
		    			//wordNodes.each(function(i)//遍历所有的word节点 变量i从 0-n
						for(i in redata)
		    			{
							var val=redata[i];
			    			//var wordNode = $(this);//获取当前的word节点 
			    			//var NewNode = window.frames["searchForm"].childNode().attr("id",i);//新建一个div节点 并给以id属性且等于i值
								//NewNode.html(val+"---"+vData[val]);
							var NewNode=$('<div></div>'); 
							NewNode.attr("id",i);
							NewNode.html(val+"---"+vData[val]);
							NewNode.appendTo(autoNode);
			    			//NewNode.html(val+"---"+vData[val]).appendTo(autoNode);//把word节点的内容赋给div节点 并把div追加到（相当于内容插入） autoNode节点的div
			    			
			    		/*	NewNode.mouseover(function(){
			    				///鼠标键盘一起用时防止同时高亮
				    			if(highlightindex !=-1)
				    			{
				    				autoNode.children("div").eq(highlightindex).css("background-color","white");
				    			}
				    				highlightindex = $(this).attr("id");
				    				$(this).css("background-color","blue");
			    			});
			    			NewNode.mouseout(function(){
				    				$(this).css("background-color","white");
				    				highlightindex = -1;
				    			});	
				    			*/
				    		NewNode.hover(//鼠标事件
					    		function(){///鼠标移到
					    			if(highlightindex !=-1)
					    			{	///鼠标键盘一起用时防止同时高亮
					    				autoNode.children().eq(highlightindex).css("background-color","white");
					    			}
					    				highlightindex = $(this).attr("id"); //把id值赋给highlightindex
					    				$(this).css("background-color","blue");
					    		},
					    		function(){///鼠标移走
					    			$(this).css("background-color","white");
				  
					    		}
				    		);
				    		NewNode.click(function(){///点击鼠标时
				    			var clickNode = $(this); //获取当前鼠标节点
				    			wordInput.val(clickNode.text().split("---")[0]);//赋值给输入框
				    			autoNode.hide();
				    			highlightindex =-1;
								//....此处可以放点击鼠标选定项时触发的函数
				    		});
						}
		    			//});
			    		//if(wordNodes.length>0) ///有返回值才显示
			    		//{
			    			autoNode.show();
			    		//}
			    		//else{///返回为空隐藏
			    			//autoNode.hide();
			    		//}
					}else{
						autoNode.hide();
					}
	    			//},"xml");///.post里的方法结束
	    			},500);///延时方法结束
	    		
	    		}else{ ///输入为空隐藏div节点autoNode 不与服务器交互
	    			autoNode.hide();
	    			highlightindex = -1;
	    		}
	    	}
	    	else if(keyCode ==38 || keyCode ==40)
	    	{
	    		var autoNodes = autoNode.children();///获取autoNodes div下的所有子节点
	    		if(keyCode == 38)//向上
	    		{
	    			
	    			if(highlightindex != -1)//不为-1 原来有节点被选中
	    			{
	    				autoNodes.eq(highlightindex).css("background-color","white");//改变原来背景色 白色
	    				highlightindex--; //减一 向上移到
	    			}
	    			
	    			if(highlightindex == -1){ //为-1 即原来值为0到顶端了
	    				highlightindex = autoNodes.length - 1;//直接把变量改为最后一个 (注意长度length是1-n，而highlightindex 0-n）
	    			}
	    			autoNodes.eq(highlightindex).css("background-color","blue");//改变新选中的div背景色 蓝色
	    			wordInput.val(autoNodes.eq(highlightindex).text().split("---")[0]); //直接赋值给输入框
	    		}
	    		if(keyCode == 40)//向下
	    		{
	    		
	    			if(highlightindex!=-1)/////不为-1 原来有节点被选中
	    			{
	    				autoNodes.eq(highlightindex).css("background-color","white");//改变原来选中div背景色 
	    				highlightindex++; //加1 即向下移动
	    			}
	    		
	    			if(highlightindex==-1)//为-1及可加 
	    			{
	    				highlightindex++;
	    			}
	  
	    			 if(highlightindex == autoNodes.length)//加1后等于 子div节点长度到达底端  
	    			{
	    				highlightindex = 0;//把顶端值赋给highlightindex
	    			}
	    			
	    			autoNodes.eq(highlightindex).css("background-color","blue"); //改变背景色
	    			wordInput.val(autoNodes.eq(highlightindex).text().split("---")[0]); ////直接赋值给输入框
	    		}
	    	}
	    		else if(keyCode==13)//回车
	    		{
	    				autoNode.hide();//隐藏div
	    				highlightindex = -1;//高亮变量恢复默认值
	    				//....................///可作提交操作	
	    	  	}
	    });
							 });


function findEach(word)    
{        
	var vResult = [];
    if(word==""){    
       return; 
    }    
    if(word!=""){    
        var nPos;     
        for(key in vData){    
            //var sTxt=key;    
            nPos=key.indexOf(word);    
            if(nPos>=0){    
                vResult[vResult.length] = key;    
            }    
        }    
      // alert(vResult);    
    } 
	return vResult;
}   