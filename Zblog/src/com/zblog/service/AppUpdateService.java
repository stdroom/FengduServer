/**
 * 工程名: Zblog
 * 文件名: AppUpdateService.java
 * 包名: com.zblog.service
 * 日期: 2015年12月21日下午5:16:58
 * QQ: 378640336
 *
*/

package com.zblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zblog.core.dal.entity.AppUpdate;
import com.zblog.core.dal.mapper.AppUpdateMapper;

/**
 * 类名: AppUpdateService <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年12月21日 下午5:16:58 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Service
public class AppUpdateService {
	
	@Autowired
	private AppUpdateMapper appUpdateMapper;
	
	public void insertAppUpdate(AppUpdate appUpdate){
		appUpdateMapper.insertAppUpdate(appUpdate);
	}
	public void updateAppUpdate(AppUpdate appUpdate){
		appUpdateMapper.updateAppUpdate(appUpdate);
	}
	public AppUpdate findAppUpdateByAppid(int appid){
		return appUpdateMapper.findAppUpdateByAppid(appid);
	}
}

