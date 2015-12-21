/**
 * 工程名: Zblog
 * 文件名: AppUpdate.java
 * 包名: com.zblog.core.dal.entity
 * 日期: 2015年12月21日下午2:15:14
 * QQ: 378640336
 *
*/

package com.zblog.core.dal.entity;
/**
 * 类名: AppUpdate <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年12月21日 下午2:15:14 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class AppUpdate {
	private String appid;
	private int versionCode;
	private String versionName;
	private String downloadUrl;
	
	// 提示信息
	private String updateLog;
	
	// 一句话 提示日志
	private String simpleLog;
	// 更新等级	1：强制更新 2：点击更新 3：提示更新
	private Integer updateLevel;

	public AppUpdate(){
	}
	
	public int getVersionCode() {
		return versionCode;
	}
	
	public void setVersionCode(String versionCode) {
		if (!"".equals(versionCode)){
			this.versionCode = Integer.parseInt(versionCode);
		} else{
			this.versionCode = 0;
		}
	}
	
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public String getUpdateLog() {
		return updateLog;
	}
	public void setUpdateLog(String updateLog) {
		this.updateLog = updateLog;
	}

	public String getSimpleLog() {
		return simpleLog;
	}

	public void setSimpleLog(String simpleLog) {
		this.simpleLog = simpleLog;
	}

	public Integer getUpdateLevel() {
		return updateLevel;
	}

	public void setUpdateLevel(Integer updateLevel) {
		this.updateLevel = updateLevel;
	}

	public void setVersionCode(int versionCode) {
		this.versionCode = versionCode;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
}

