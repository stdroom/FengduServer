/**
 * 工程名: Zblog
 * 文件名: AppColumn.java
 * 包名: com.zblog.core.dal.entity
 * 日期: 2015年11月25日下午2:41:41
 * QQ: 378640336
 *
*/

package com.zblog.core.dal.entity;
/**
 * 类名: AppColumn <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月25日 下午2:41:41 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class AppColumn{
	
	
	private int appid = 0;
	private int cataid = 0;
	private int columnid = 0;
	private String name = "";
	
	private int id = 0;
	
	private int version = 0;
	private boolean enable = true;
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public int getCataid() {
		return cataid;
	}
	public void setCataid(int cataid) {
		this.cataid = cataid;
	}
	public int getColumnid() {
		return columnid;
	}
	public void setColumnid(int columnid) {
		this.columnid = columnid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
}

