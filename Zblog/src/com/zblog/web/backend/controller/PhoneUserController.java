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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zblog.core.dal.entity.AppUpdate;
import com.zblog.core.dal.entity.PhoneUser;
import com.zblog.core.dal.entity.Welcome;
import com.zblog.core.util.StringCompress;
import com.zblog.service.AppUpdateService;
import com.zblog.service.FavorService;
import com.zblog.service.PhoneUserService;
import com.zblog.service.WelcomeService;

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
	@Autowired
	WelcomeService welcomeService;
	@Autowired
	AppUpdateService appUpdateService;
	
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
		
		phoneUser.setAddress(decodeUtf8(headers.getFirst("address")));
		phoneUser.setCity(decodeUtf8(headers.getFirst("city")));
		phoneUser.setCountry(decodeUtf8(headers.getFirst("country")));
		phoneUser.setDistrict(decodeUtf8(headers.getFirst("district")));
		phoneUser.setProvince(decodeUtf8(headers.getFirst("province")));
		phoneUser.setLatitude(headers.getFirst("latitude"));
		phoneUser.setLongitude(headers.getFirst("longitude"));
		phoneUser.setChannel(decodeUtf8(headers.getFirst("channel")));
		System.out.println("ssssssssssssssssssss");
		return StringCompress.compress(phoneUserService.insert(phoneUser)+"");
	}
	
	// 收藏信息
	public void getFavorImg(){
		
	}
	
	// 获取app配置信息
	public void getAppConfig(){
		
	}
	
	private String decodeUtf8(String str){
		try {
			if(!"".equals(str)){
				str = URLDecoder.decode(str,"UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	// app 获取版本更新信息
	@RequestMapping(value="/upgradeInfo", method = {RequestMethod.GET},produces="application/json;charset=utf-8")
	@ResponseBody
	public String getAppUpdateInfo(@RequestHeader HttpHeaders headers){
		HashMap<String,Object> map = new HashMap<String,Object>();
		if(headers.containsKey("appid")){
			AppUpdate update = appUpdateService.findAppUpdateByAppid(Integer.parseInt(headers.getFirst("appid")));
			if(update!=null){
				map.put("status", "1");
				map.put("results", update);
			}else{
				map.put("status", "0");
			}
		}else{
			map.put("status", "0");
		}
		return StringCompress.compress(JSONObject.toJSONString(map));
	}
	
	// app 获取首页信息
	@RequestMapping(value="/welcomeInfo", method = {RequestMethod.GET},produces="application/json;charset=utf-8")
	@ResponseBody
	public String getWelcomeInfo(@RequestHeader HttpHeaders headers){
		HashMap<String,Object> map = new HashMap<String,Object>();
		if(headers.containsKey("appid")){
			Welcome welcome = welcomeService.findWelcomeByAppid(Integer.parseInt(headers.getFirst("appid")));
			if(welcome!=null){
				map.put("status", "1");
				map.put("results", welcome);
			}else{
				map.put("status", "0");
			}
		}else{
			map.put("status", "0");
		}
		return StringCompress.compress(JSONObject.toJSONString(map));
	}
}

