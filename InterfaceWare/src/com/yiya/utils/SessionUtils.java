package com.yiya.utils;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.yiya.bean.SysUser;
import com.yiya.utils.Constant.SuperAdmin;

/**
 * 
 * Cookie 工具类
 *
 */
public final class SessionUtils {
	
	protected static final Logger logger = Logger.getLogger(SessionUtils.class);
	
	private static final String SESSION_USER = "session_user";

	private static final String SESSION_VALIDATECODE = "session_validatecode";//验证码
	
	
	private static final String SESSION_ACCESS_URLS = "session_access_urls"; //系统能够访问的URL
	
	
	private static final String SESSION_MENUBTN_MAP = "session_menubtn_map"; //系统菜单按钮
	
	private static final String SESSION_zdbm="session_zdbm" ;
	private static final String SESSION_zdmc="" ;
	private static final String SESSION_sscs="" ;

	
	/**
	  * 设置session的值
	  * @param request
	  * @param key
	  * @param value
	  */
	 public static void setAttr(HttpServletRequest request,String key,Object value){
		 request.getSession(true).setAttribute(key, value);
	 }
	 
	 
	 /**
	  * 获取session的值
	  * @param request
	  * @param key
	  * @param value
	  */
	 public static Object getAttr(HttpServletRequest request,String key){
		 return request.getSession(true).getAttribute(key);
	 }
	 
	 /**
	  * 删除Session值
	  * @param request
	  * @param key
	  */
	 public static void removeAttr(HttpServletRequest request,String key){
		 request.getSession(true).removeAttribute(key);
	 }
	 
	 /**
	  * 设置用户信息 到session
	  * @param request
	  * @param user
	  */
	 public static void setUser(HttpServletRequest request,SysUser user){
		 request.getSession(true).setAttribute(SESSION_USER, user);
	 }

	 /**
	  * 从session中获取用户信息
	  * @param request
	 * @return 
	  * @return SysUser
	  */
	 public static  SysUser getUser(HttpServletRequest request){
		return (SysUser) request.getSession(true).getAttribute(SESSION_USER);
	 }
	 
	 
	 /**
	  * 设置站点编码 到session
	  * @param request
	  * @param user
	  */
	 public static void setZdbm(HttpServletRequest request,SysUser zdbm){
		 request.getSession(true).setAttribute(SESSION_zdbm, zdbm);
	 }

	 /**
	  * 从session中获取站点编码信息
	  * @param request
	 * @return 
	 * @return 
	  * @return SysUser
	  */
	 public static   SysUser getZdbm(HttpServletRequest request){
		return (SysUser) request.getSession(true).getAttribute(SESSION_zdbm);
	 }
	 
	 
	 /**
	  * 设置站点名称信息 到session
	  * @param request
	  * @param user
	  */
	 public static void setZdmc(HttpServletRequest request,SysUser zdmc){
		 request.getSession(true).setAttribute(SESSION_zdmc, zdmc);
	 }

	 /**
	  * 从session中获取站点名称信息
	  * @param request
	 * @return 
	  * @return SysUser
	  */
	 public static  SysUser getZdmc(HttpServletRequest request){
		return  (SysUser) request.getSession(true).getAttribute(SESSION_zdmc);
	 }
	 
	 
	 /**
	  * 设置所属城市 到session
	  * @param request
	  * @param user
	  */
	 public static void setSscs(HttpServletRequest request,SysUser sscs){
		 request.getSession(true).setAttribute(SESSION_sscs, sscs);
	 }

	 /**
	  * 从session中获取用户信息
	  * @param request
	 * @return 
	  * @return SysUser
	  */
	 public static  SysUser getSscs(HttpServletRequest request){
		return (SysUser) request.getSession(true).getAttribute(SESSION_sscs);
	 }
	 
	 
	 
	 
	 /**
	  * 从session中获取用户信息
	  * @param request
	  * @return SysUser
	  */
	 public static Integer getUserId(HttpServletRequest request){
		 SysUser user = getUser(request);
		 if(user != null){
			 return user.getId();
		 }
		return null; 
	 }
	 
	 
	 /**
	  * 从session中获取用户信息
	  * @param request
	  * @return SysUser
	  */
	 public static void removeUser(HttpServletRequest request){
		removeAttr(request, SESSION_USER);
	 }
	 
	 
	 /**
	  * 设置验证码 到session
	  * @param request
	  * @param user
	  */
	 public static void setValidateCode(HttpServletRequest request,String validateCode){
		 request.getSession(true).setAttribute(SESSION_VALIDATECODE, validateCode);
	 }
	 
	 
	 /**
	  * 从session中获取验证码
	  * @param request
	  * @return SysUser
	  */
	 public static String getValidateCode(HttpServletRequest request){
		return (String)request.getSession(true).getAttribute(SESSION_VALIDATECODE);
	 }
	 
	 
	 /**
	  * 从session中获删除验证码
	  * @param request
	  * @return SysUser
	  */
	 public static void removeValidateCode(HttpServletRequest request){
		removeAttr(request, SESSION_VALIDATECODE);
	 }
	 
	 /**
	  * 判断当前登录用户是否超级管理员
	  * @param request
	  * @return
	  */
	 public static boolean isAdmin(HttpServletRequest request){ //判断登录用户是否超级管理员
		 //String user = (String) getUser(request);
		 SysUser user = (SysUser)getUser(request);
		 if(user == null  ){
			 return false;
		 }
		 return true;
	 }
	 
	 
	 
	 /**
	  * 判断当前登录用户是否超级管理员
	  * @param request
	  * @return
	  */
	 public static void setAccessUrl(HttpServletRequest request,List<String> accessUrls){ //判断登录用户是否超级管理员
		 setAttr(request, SESSION_ACCESS_URLS, accessUrls);
	 }
	 
	 
	 
	 /**
	  * 判断URL是否可访问
	  * @param request
	  * @return
	  */
	 public static boolean isAccessUrl(HttpServletRequest request,String url){ 
		 List<String> accessUrls = (List)getAttr(request, SESSION_ACCESS_URLS);
		 if(accessUrls == null ||accessUrls.isEmpty() || !accessUrls.contains(url)){
			 return false;
		 }
		 return true;
	 }
	 
	 
	 /**
	  * 设置菜单按钮
	  * @param request
	  * @param btnMap
	  */
	 public static void setMemuBtnMap(HttpServletRequest request,Map<String,List> btnMap){ //判断登录用户是否超级管理员
		 setAttr(request, SESSION_MENUBTN_MAP, btnMap);
	 }
	 
	 /**
	  * 获取菜单按钮
	  * @param request
	  * @param btnMap
	  */
	 public static List<String> getMemuBtnListVal(HttpServletRequest request,String menuUri){ //判断登录用户是否超级管理员
		 Map btnMap  = (Map)getAttr(request, SESSION_MENUBTN_MAP);
		 if(btnMap == null || btnMap.isEmpty()){
			 return null;
		 }
		 return (List<String>)btnMap.get(menuUri);
	 }
	 
//		private static final String SESSION_ACCESS_URLS = "session_access_urls"; //系统能够访问的URL
//		
//		
//		private static final String SESSION_MENUBTN_MAP = "session_menubtn_map"; //系统菜单按钮
	
}