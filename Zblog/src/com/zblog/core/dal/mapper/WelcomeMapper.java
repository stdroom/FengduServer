/**
 * 工程名: Zblog
 * 文件名: FavorMapper.java
 * 包名: com.zblog.core.dal.mapper
 * 日期: 2015年12月15日上午11:29:30
 * QQ: 378640336
 *
*/

package com.zblog.core.dal.mapper;

import java.util.Date;

import com.zblog.core.dal.entity.Favor;
import com.zblog.core.dal.entity.Welcome;

/**
 * 类名: FavorMapper <br/>
 * 功能: 收藏表. <br/>
 * 日期: 2015年12月15日 上午11:29:30 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public interface WelcomeMapper {
	public void insertWelcome(Welcome welcome);
	public void updateWelcome(Welcome welcome);
	public Welcome findWelcomeByAppid(int appid);
}

