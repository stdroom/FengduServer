var conf={
		inputObj : "#actp",//inputObj 目标输入框
		url:"",//请求联想数据的链接,响应的数据格式必须是一个json格式的数组，每一个数据项必须有一个name项；如[{name:'张三'},{name:'张四'}，{name:'张五'}，。。。]
		showCnt:6,//联想显示个数
		associateDiv:'',//联想div 联想框
		width:undefined,//默认为 obj.inputObj 对象的宽度,在后面注入
		widthOffset:50,
		offsetX:0,//联想框的偏移量
		offsetY:5,//联想框的偏移量
		minInterval:'20',//两次请求的最小间隔时间（毫秒）
		getData:'',//获取数据的主函数
		submitData:'',//提交数据的回调
		selectData:'',//选择一个联想数据项的回调
		position:'',//定位
		setData:''//成功请求数据后，需要把数据注入到对象中
};
function initATC(config){
	config=config||conf;
	return $.htw_associate(config);
}


$.extend({
	htw_associate : function(config) {
        var random = new Date().getTime();
        var htw_associate_div_id = "actp";//"htw_associate_div_"+random;
//        var div = "<div style='position:absolute;display:none;background-color:#ffff;height:100px;border:3px solid #ccc;overflow-x:hidden;' id='"+htw_associate_div_id+"'></div>";
//        $("#actp").append(div);
        var obj = {};
        obj.inputObj =config.inputObj;// 目标输入框
        obj.showCnt =config.showCnt||conf.showCnt;//联想显示个数
        obj.url = config.url;//为getData函数使用，用于获取数据，如果重写了getData，则此属性无效
        obj.associateDiv = $("#"+htw_associate_div_id);
        obj.width =config.width||conf.width;//默认为 obj.inputObj 对象的宽度,在后面注入
        obj.widthOffset =config.widthOffset||conf.widthOffset;
        obj.offsetX = config.offsetX||conf.offsetX;//联想框的偏移量
        obj.offsetY = config.offsetY||conf.offsetY;
        obj.minInterval = config.minInterval||conf.minInterval;//两次请求的最小间隔时间
        obj.keyupfn = function(event) {
        	 alert();
            var i = $(obj.inputObj).data("htw_associate_index");
            var cnt = 0;
            var datas = $(obj.inputObj).data("htw_data");
            if(datas){
                cnt = datas.length;
            }
            cnt = cnt<obj.showCnt ?cnt:obj.showCnt;
            switch (event.keyCode) {
                case 13:
                    obj.submitData($(obj.inputObj).val(),obj);
                    break;
                case 38://上
                	alert("up");
                    i = (i==undefined || i==null)?cnt-1:--i<0?cnt-1:i;
                    $("#"+htw_associate_div_id+" div").css("background", "#fff");
                    var divObj =$("#"+htw_associate_div_id+" div").eq(i); 
                    divObj.css("background", "#efeeff");
                    var datas = $(obj.inputObj).data("htw_data");
                    $(obj.inputObj).data("htw_associate_index",i);
                    obj.selectData(datas[i],divObj,obj);
                    break;
                case 40://下
                	alert("down");
                    i = (i==undefined || i==null)?0:++i>cnt-1?0:i;
                    $("#"+htw_associate_div_id+" div").css("background", "#fff");
                    var divObj =$("#"+htw_associate_div_id+" div").eq(i); 
                    divObj.css("background", "#efeeff");
                    var datas = $(obj.inputObj).data("htw_data");
                    $(obj.inputObj).data("htw_associate_index",i);
                    obj.selectData(datas[i],divObj,obj);
                    break;
                case 37://左
                	 obj.associateDiv.dialog('close');
                	 obj.associateDiv.empty();
                    break;
                default:
//                    var val = $(obj.inputObj).val();
//                    if (val) {
//                        var old = $(obj.inputObj).data("htw_old");
//                        var lastTime = $(obj.inputObj).data("htw_lastTime");//最后请求数据的时间
//                        lastTime = lastTime?lastTime:now;
//                        var now = new Date().getTime();
//                        if (old != val) {//这里应该还可以添加一个延迟请求，以提高效率，减少请求数量
//                           
//                            var time = lastTime+obj.minInterval - now;//lastTime+obj.minInterval<now
//                            if(time <= 0){//超过最小间隔时间，
//                                $(obj.inputObj).data("htw_old", val);
//                                $(obj.inputObj).data("htw_lastTime",now);
//                                obj.position(obj);
//                                obj.getData(val,obj);
//                            }else{//未超过最小间隔时间，就延迟请求，
//                                setTimeout(function(){
//                                    var val0 = $(obj.inputObj).val();
//                                    var old0 = $(obj.inputObj).data("htw_old");
//                                    var now0 = new Date().getTime();
//                                    if(val0 && old0 != val0){
//                                        $(obj.inputObj).data("htw_old", val0);
//                                        $(obj.inputObj).data("htw_lastTime",now0);
//                                        obj.position(obj);
//                                        obj.getData(val0,obj);
//                                    }
//                                }, time);
//                            }
//                        }
//                    }
                    break;
            }
        };
        //$(obj.inputObj).on('keydown', obj.keyupfn(event));
        obj.blurfn = function() {
            setTimeout(function() {
                obj.associateDiv.dialog('close');
            }, 400);// 为什么延迟，当点击联想层时可以保证其点击事件触发
        };
        obj.setData = function(data,obj){//成功请求数据后，添加数组数据
            if(!obj){
                obj = this;
            }
            var array = [];
            if(data){
                array = data;
            }
            $(obj.inputObj).data("htw_data",array);
        };
        obj.getData = function(val){//请求数据，如果数据结构不一样，或者有更复杂的业务，你应该重写此函数
            var associateObj = this;
            $.post(associateObj.url,val,function(list){
                if(list && list.data.length > 0){
                    associateObj.setData(list.data);
                    associateObj.associateDiv.dialog('open');
                    associateObj.associateDiv.empty();
                    for(var i = 0;i<list.data.length && i<associateObj.showCnt;i++){
                        var data = list.data[i];
                        var str = "<div id=div_'"+i+"' style='width:400px;height:40px'>" + data.ddz + "</div>";
                        associateObj.associateDiv.append(str);
                    }
                    associateObj.associateDiv.focus();
                    $("#"+htw_associate_div_id+" div").eq(0).focus(); 
                    $("#"+htw_associate_div_id+" div").eq(0).css("background", "#EE1289");
                    
                }else{
                	 var str = "<div id='div_0' style='width:100%'><h2>暂无数据 </h2></div>";
                     associateObj.associateDiv.append(str);
                }
            },"json");
        };
        obj.submitData = function(data,obj){};//提交函数
        obj.selectData=function(data,divObj,obj){//选择了其中一个联想数据
            var name = divObj.text();
            if(data && data.name){
                name = data.name;
            }
            $(obj.inputObj).val(name);
        };//选择了数据
        obj.position = function(obj){//定位
            if(!obj){
                obj = this;
            }
            var position = $(obj.inputObj).position();
//            obj.associateDiv.css("left",position.left+obj.offsetX + "px");
//            obj.associateDiv.css("top",position.top+$(obj.inputObj).height()+obj.offsetY + "px");
            obj.associateDiv.width(obj.getWidth(obj)+"px");
        };
        obj.getWidth=function(obj){//获取宽度
            if(!obj){
                obj = this;
            }
            var width = $(obj.inputObj).width()+obj.widthOffset;
            if(obj.width){
                width = obj.width+obj.widthOffset;
            }
            return width;
        };
        if(config){
            for ( var key in config) {
                obj[key] = config[key];
            }
        }
        obj.position(obj);
        $("#"+htw_associate_div_id+" div").live("mouseover",function(){
            $("#"+htw_associate_div_id+" div").css("background", "#fff");
            $(this).css("background", "#efeeff");
            var i = $(this).index();
            $(obj.inputObj).data("htw_associate_index",i);
        });
        $("#"+htw_associate_div_id+" div").live("click",function(){
            var i = $(this).index();
            $(obj.inputObj).data("htw_associate_index",i);
            var datas = $(obj.inputObj).data("htw_data");
            obj.selectData(datas[i],$(this),obj);
            obj.associateDiv.dialog('close');
        });
        
        $(obj.inputObj).keyup(obj.keyupfn);
        //$(obj.inputObj).blur(obj.blurfn);
        $(window).resize(function(){
            obj.position;
        });
        return obj;
    }
});