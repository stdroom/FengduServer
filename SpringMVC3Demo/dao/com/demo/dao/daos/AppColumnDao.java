/**
 * 工程名: SpringMVC3Demo
 * 文件名: AppColumnDao.java
 * 包名: com.demo.dao.daos
 * 日期: 2015年11月23日下午4:31:28
 * QQ: 378640336
 *
*/

package com.demo.dao.daos;

import org.springframework.stereotype.Repository;

import com.demo.dao.interfaces.IAppColumnDao;
import com.demo.model.models.AppColumn;
import com.infrastructure.project.base.dao.daos.EnableEntityDao;

/**
 * 类名: AppColumnDao <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月23日 下午4:31:28 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Repository("AppColumnDao")
public class AppColumnDao extends EnableEntityDao<Integer, AppColumn> implements IAppColumnDao{

}

