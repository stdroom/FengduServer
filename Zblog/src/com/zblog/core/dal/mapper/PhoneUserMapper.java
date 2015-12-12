/**
 * 工程名: Zblog
 * 文件名: PhoneUserMapper.java
 * 包名: com.zblog.core.dal.mapper
 * 日期: 2015年11月27日下午4:03:14
 * QQ: 378640336
 *
*/

package com.zblog.core.dal.mapper;

import com.zblog.core.dal.entity.PhoneUser;

/**
 * 类名: PhoneUserMapper <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月27日 下午4:03:14 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public interface PhoneUserMapper extends BaseMapper{

	public PhoneUser loadByPhoneUser(int id);
	
	public void inserPhoneUser(PhoneUser phoneUser);
}

