/**
 * 工程名: SpringMVC3Demo
 * 文件名: AppColumn.java
 * 包名: com.demo.model.models
 * 日期: 2015年11月23日下午4:17:32
 * QQ: 378640336
 *
*/

package com.demo.model.models;

import com.infrastructure.project.base.model.interfaces.ICUDEable;
import com.infrastructure.project.base.model.models.EnableEntity;

/**
 * 类名: AppColumn <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月23日 下午4:17:32 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class AppColumn extends EnableEntity<Integer> implements ICUDEable{
	
	Integer appid = 0;
	Integer columnid = 0;
	Catalog catalog;

	public Integer getAppid() {
		return appid;
	}

	public void setAppid(Integer appid) {
		this.appid = appid;
	}

	public Integer getColumnid() {
		return columnid;
	}

	public void setColumnid(Integer columnid) {
		this.columnid = columnid;
	}

	public Integer getCataid() {
		return cataid;
	}

	public void setCataid(Integer cataid) {
		this.cataid = cataid;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}
	
	
}

