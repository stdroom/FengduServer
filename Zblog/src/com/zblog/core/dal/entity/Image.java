/**
 * ������: spmvc03
 * �ļ���: Image.java
 * ����: com.sxt.bean
 * ����: 2015��11��18������7:29:35
 * Copyright (c) 2015, �����ֵ� All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.zblog.core.dal.entity;

/**
 * ����: Image <br/>
 * ����: . <br/>
 * ����: 2015��11��18�� ����7:29:35 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class Image extends BaseEntity{
	
	private Boolean enable = false;
	
	private String contextPath = "";
	
	private String contextHtml = "";
	
	private Integer currentPage = 0;
	
	private String currentPageUrl = "";
	
	private Integer cata_id = 0;
	
	private Integer hasNext = 0;
	
	private String baseUrl = "";
	
	private Integer isParseError = 0;

	private String exception = "";
	
	
	// ���� ·��
	private String imgPaths = "";
	// ԭʼ·��
	private String srcImgpaths = "";
	// �ƴ洢·��
	private String yunImgPaths = "";
	
	// ԭʼ·��
	private String thumbSrc = "";
	// �ƴ洢·��
	private String thumbYun = "";
	// ����·��
	private String thumbNail = "";
	
	private Integer width = 0;
	private Integer height = 0;
	
	private Integer zan = 0;
	private Integer favor = 0;
	
	
	private Integer pageNum;
	
	private String title;
	
	public Image(){
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getContextHtml() {
		return contextHtml;
	}

	public void setContextHtml(String contextHtml) {
		this.contextHtml = contextHtml;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String getCurrentPageUrl() {
		return currentPageUrl;
	}

	public void setCurrentPageUrl(String currentPageUrl) {
		this.currentPageUrl = currentPageUrl;
	}

	public Integer getCata_id() {
		return cata_id;
	}

	public void setCata_id(Integer cata_id) {
		this.cata_id = cata_id;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public Integer getHasNext() {
		return hasNext;
	}

	public void setHasNext(Integer hasNext) {
		this.hasNext = hasNext;
	}

	public Integer getIsParseError() {
		return isParseError;
	}

	public void setIsParseError(Integer isParseError) {
		this.isParseError = isParseError;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getImgPaths() {
		return imgPaths;
	}

	public void setImgPaths(String imgPaths) {
		this.imgPaths = imgPaths;
	}

	public String getSrcImgpaths() {
		return srcImgpaths;
	}

	public void setSrcImgpaths(String srcImgpaths) {
		this.srcImgpaths = srcImgpaths;
	}

	public String getYunImgPaths() {
		return yunImgPaths;
	}

	public void setYunImgPaths(String yunImgPaths) {
		this.yunImgPaths = yunImgPaths;
	}

	public String getThumbSrc() {
		return thumbSrc;
	}

	public void setThumbSrc(String thumbSrc) {
		this.thumbSrc = thumbSrc;
	}

	public String getThumbYun() {
		return thumbYun;
	}

	public void setThumbYun(String thumbYun) {
		this.thumbYun = thumbYun;
	}

	public String getThumbNail() {
		return thumbNail;
	}

	public void setThumbNail(String thumbNail) {
		this.thumbNail = thumbNail;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getZan() {
		return zan;
	}

	public void setZan(Integer zan) {
		this.zan = zan;
	}

	public Integer getFavor() {
		return favor;
	}

	public void setFavor(Integer favor) {
		this.favor = favor;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
}

