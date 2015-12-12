/**
 * 工程名: Zblog
 * 文件名: MyHeaderInterceptor.java
 * 包名: com.zblog.web.interceptor
 * 日期: 2015年11月27日下午3:40:23
 * QQ: 378640336
 *
*/

package com.zblog.web.interceptor;

import java.sql.Time;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zblog.core.dal.entity.PhoneUser;
import com.zblog.service.PhoneUserService;

/**
 * 类名: MyHeaderInterceptor <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月27日 下午3:40:23 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class MyHeaderInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private PhoneUserService phoneUserService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		System.out.println("开始了来来来来来来来");
//		PhoneUser phoneUser = new PhoneUser();
//		String appid = request.getHeader("appid");
//		String osversion = request.getHeader("osversion");
//		String client_type = request.getHeader("client_type");
//		String imei = request.getHeader("imei");
//		String lang = request.getHeader("lang");
//		String phone_type = request.getHeader("phone_type");
//		String timestamp = request.getHeader("timestamp");
//		phoneUser.setAppid(Integer.parseInt(appid));
//		phoneUser.setOsversion(osversion);
//		phoneUser.setClient_type(client_type);
//		phoneUser.setImei(imei);
//		phoneUser.setLang(lang);
//		phoneUser.setPhone_type(phone_type);
//		phoneUser.setTimestamp(timestamp);
//		phoneUser.setDate(new Date());
//		phoneUser.setHttpcount(1);
//		System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
////		PhoneUser result = phoneUserService.loadByPhoneUser(phoneUser);
//		if(result!=null){
//			int httpcount = result.getHttpcount()+1;
//			result.setHttpcount(httpcount);
//			phoneUserService.update(result);
//		}else{
//			phoneUserService.insert(phoneUser);
//		}
//		System.out.println("test");
		return super.preHandle(request, response, handler);
	}

	
}

