/**
 * 工程名: Zblog
 * 文件名: PhoneUserController.java
 * 包名: com.zblog.web.backend.controller
 * 日期: 2015年12月6日上午8:53:35
 * Copyright (c) 2015, 暴走兄弟 All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.zblog.web.backend.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zblog.core.dal.entity.PhoneUser;
import com.zblog.service.FavorService;
import com.zblog.service.PhoneUserService;

/**
 * 类名: PhoneUserController <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年12月6日 上午8:53:35 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Controller
@RequestMapping("/luser")
public class PhoneUserController {
	
	@Autowired
	PhoneUserService phoneUserService;
	
	// 客户端上传登陆启动等详细信息
	@RequestMapping(value="/updateInfo", method = {RequestMethod.GET},produces="application/json;charset=utf-8")
	@ResponseBody
	public String postPhoneUserInfo(@RequestHeader HttpHeaders headers){
		PhoneUser phoneUser = new PhoneUser();
		phoneUser.setAppid(Integer.parseInt(headers.getFirst("appid")));
		phoneUser.setAppversion(headers.getFirst("appversion")+"");
		phoneUser.setDate(new Date());
		phoneUser.setImei(headers.getFirst("imei")+"");
		phoneUser.setOsversion(headers.getFirst("osversion"));
		phoneUser.setLang(headers.getFirst("lang"));
		phoneUser.setPhone_type(headers.getFirst("phone_type"));
		phoneUser.setTimestamp(headers.getFirst("timestamp"));
		phoneUser.setClient_type(headers.getFirst("client_type"));
		System.out.println("ssssssssssssssssssss");
		return phoneUserService.insert(phoneUser)+"";
	}
	
	// 收藏信息
	public void getFavorImg(){
		
	}
	
	// 获取app配置信息
	public void getAppConfig(){
		
	}
	
	
	
}

