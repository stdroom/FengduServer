/**
 * 工程名: Zblog
 * 文件名: PhoneUser.java
 * 包名: com.zblog.core.dal.entity
 * 日期: 2015年11月27日下午3:52:23
 * QQ: 378640336
 *
*/

package com.zblog.core.dal.entity;

import java.util.Date;

/**
 * 类名: PhoneUser <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月27日 下午3:52:23 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class PhoneUser extends BaseEntity{

	int iid;
	/** app版本 */
	String appversion ;
	/** 手机型号 */
	String phone_type;
	/** 手机imei */
	String imei;
	/** 操作系统版本 */
	String osversion;
	/** 语言 */
	String lang;
	/** 操作系统 */
	String client_type;
	/** appid */
	Integer appid;
	/** 此次登录的请求时间 */
	Date date;
	Integer httpcount;
	/** 时间戳 用于判断是否为同一次的请求 */
	String timestamp;
	
	// 经度
	String longitude = "";
	// 纬度
	String latitude = "";
	//国家
	String country = "";
	// 省
	String province = "";
	// 市
	String city = "";
	// 区
	String district = "";
	// 地址
	String address = "";
	// 渠道
	String channel = "";
	public String getAppversion() {
		return appversion;
	}
	public void setAppversion(String appversion) {
		this.appversion = appversion;
	}
	public String getPhone_type() {
		return phone_type;
	}
	public void setPhone_type(String phone_type) {
		this.phone_type = phone_type;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getOsversion() {
		return osversion;
	}
	public void setOsversion(String osversion) {
		this.osversion = osversion;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getClient_type() {
		return client_type;
	}
	public void setClient_type(String client_type) {
		this.client_type = client_type;
	}
	public Integer getAppid() {
		return appid;
	}
	public void setAppid(Integer appid) {
		this.appid = appid;
	}
	public Integer getHttpcount() {
		return httpcount;
	}
	public void setHttpcount(Integer httpcount) {
		this.httpcount = httpcount;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
}

