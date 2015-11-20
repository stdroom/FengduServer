/**
 * 工程名: SpringMVC3Demo
 * 文件名: ImageDao.java
 * 包名: com.demo.dao.daos
 * 日期: 2015年11月20日下午2:15:46
 * QQ: 378640336
 *
*/

package com.demo.dao.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.dao.interfaces.IAccountDao;
import com.demo.dao.interfaces.IImageDao;
import com.demo.model.models.Account;
import com.demo.model.models.Image;
import com.infrastructure.project.base.dao.daos.EnableEntityDao;

/**
 * 类名: ImageDao <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月20日 下午2:15:46 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Repository("ImageDao")
public class ImageDao extends EnableEntityDao<Integer, Image> implements IImageDao{
	
}

