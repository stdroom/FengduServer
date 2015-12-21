/**
 * 工程名: Zblog
 * 文件名: FavorMapper.java
 * 包名: com.zblog.core.dal.mapper
 * 日期: 2015年12月15日上午11:29:30
 * QQ: 378640336
 *
*/

package com.zblog.core.dal.mapper;


import com.zblog.core.dal.entity.AppUpdate;
import com.zblog.core.dal.entity.Favor;

/**
 * 类名: FavorMapper <br/>
 * 功能: 收藏表. <br/>
 * 日期: 2015年12月15日 上午11:29:30 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public interface AppUpdateMapper {
	public void insertAppUpdate(AppUpdate appUpdate);
	public void updateAppUpdate(AppUpdate appUpdate);
	public AppUpdate findAppUpdateByAppid(int appid);
}

