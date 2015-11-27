/**
 * 工程名: Zblog
 * 文件名: PhoneUserService.java
 * 包名: com.zblog.service
 * 日期: 2015年11月27日下午4:05:02
 * QQ: 378640336
 *
*/

package com.zblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zblog.core.dal.entity.PhoneUser;
import com.zblog.core.dal.mapper.BaseMapper;
import com.zblog.core.dal.mapper.PhoneUserMapper;

/**
 * 类名: PhoneUserService <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月27日 下午4:05:02 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Service
public class PhoneUserService extends BaseService{

	@Autowired
	private PhoneUserMapper phoneUserMapper;
	
	@Override
	protected BaseMapper getMapper() {
		
		return phoneUserMapper;
	}

	public PhoneUser loadByPhoneUser(PhoneUser phoneUser){
		PhoneUser temp = phoneUserMapper.loadByPhoneUser(phoneUser);
		return temp;
	}
}

