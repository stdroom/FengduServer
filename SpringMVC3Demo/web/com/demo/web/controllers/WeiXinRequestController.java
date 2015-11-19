package com.demo.web.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.infrastructure.project.common.extension.StringHelper;
import com.weixinapi.handler.DefaultHandler;
import com.weixinapi.handler.MessageListener;
import com.weixinapi.message.TextMessage;

@Controller
@RequestMapping(value = "/weixinrequest")
public class WeiXinRequestController {
	
	@RequestMapping(value="/process", method = {RequestMethod.GET})
	public void processGet(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, IOException{
		String signature = request.getParameter("signature");// 微信加密签名
		String timestamp = request.getParameter("timestamp");// 时间戳
		String nonce = request.getParameter("nonce");// 随机数
		String echostr = request.getParameter("echostr");// 随机字符串

		// 重写totring方法，得到三个参数的拼接字符串
		List<String> list = new ArrayList<String>(3) {
			private static final long serialVersionUID = 1L;
			public String toString() {
				return this.get(0) + this.get(1) + this.get(2);
			}
		};
		String TOKEN="";
		list.add(TOKEN);
		list.add(timestamp);
		list.add(nonce);
		Collections.sort(list);// 排序
		String tmpStr = StringHelper.sha1(list.toString());// SHA-1加密
		Writer out = response.getWriter();
		if (signature.equals(tmpStr))
			out.write(echostr);// 请求验证成功，返回随机码
		else
			out.write("");
		out.flush();
		out.close();
	}
	
	@RequestMapping(value="/process", method = {RequestMethod.POST})
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		InputStream inputStream = request.getInputStream();
		OutputStream outputStream = response.getOutputStream();

		final DefaultHandler defaultHandler = DefaultHandler.newInstance(); 
		
		defaultHandler.addIMessageListener(new MessageListener(){
			
			@Override
			public void onTextMessage(TextMessage msg) {
				System.out.println("收到微信消息："+msg.getContent());
				      
				TextMessage textMessage = new TextMessage();
				textMessage.setFromUserName(msg.getToUserName());
				textMessage.setToUserName(msg.getFromUserName()); 
				textMessage.setCreateTime(msg.getCreateTime()); 
				textMessage.setContent(msg.getContent());
				defaultHandler.callback(textMessage);
				
			}
		});
		
		//必须调用这两个方法
        //如果不调用close方法，将会出现响应数据串到其它Servlet中。
		defaultHandler.process(inputStream, outputStream);//处理微信消息 
		defaultHandler.close();//关闭Session	
	}

}
