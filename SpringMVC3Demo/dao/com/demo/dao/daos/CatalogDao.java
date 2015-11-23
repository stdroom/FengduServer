/**
 * 工程名: SpringMVC3Demo
 * 文件名: CatalogDao.java
 * 包名: com.demo.dao.daos
 * 日期: 2015年11月23日下午4:31:11
 * QQ: 378640336
 *
*/

package com.demo.dao.daos;

import org.springframework.stereotype.Repository;

import com.demo.dao.interfaces.ICatalogDao;
import com.demo.model.models.Catalog;
import com.infrastructure.project.base.dao.daos.EnableEntityDao;

/**
 * 类名: CatalogDao <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月23日 下午4:31:11 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Repository("CatalogDao")
public class CatalogDao extends EnableEntityDao<Integer, Catalog> implements ICatalogDao{

}

