/**
 * 工程名: Zblog
 * 文件名: WelcomeService.java
 * 包名: com.zblog.service
 * 日期: 2015年12月21日下午5:19:26
 * QQ: 378640336
 *
*/

package com.zblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zblog.core.dal.entity.Welcome;
import com.zblog.core.dal.mapper.WelcomeMapper;

/**
 * 类名: WelcomeService <br/>
 * 功能: 欢迎页逻辑. <br/>
 * 日期: 2015年12月21日 下午5:19:26 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Service
public class WelcomeService {

	@Autowired
	private WelcomeMapper welcomeMapper;
	
	public void insertWelcome(Welcome welcome){
		welcomeMapper.insertWelcome(welcome);
	}
	
	public void updateWelcome(Welcome welcome){
		welcomeMapper.updateWelcome(welcome);
	}
	
	public Welcome findWelcomeByAppid(int appid){
		return welcomeMapper.findWelcomeByAppid(appid);
	}
}

