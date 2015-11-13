package com.yiya.bean;


public class WebPage extends BaseBean {
	
		private Integer id;//   主键id	private String name;//   页面名称	private String typeid;//   页面类型id web_type.id	private String localPath;//   页面路径	private String title;//   页面标题	private String keyword;//   关键字	private String description;//   页面描述	private Integer deleted;//   删除状态 0=未删除，1=已删除	private String templateContent;//   页面模板内容	private java.sql.Timestamp createTime;//   创建时间	private Integer createBy;//   创建人	private java.sql.Timestamp updateTime;//   修改时间按	private Integer updateBy;//   修改人
		public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public String getName() {	    return this.name;	}	public void setName(String name) {	    this.name=name;	}	public String getTypeid() {	    return this.typeid;	}	public void setTypeid(String typeid) {	    this.typeid=typeid;	}		public String getLocalPath() {
		return localPath;
	}
	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}
	public String getTitle() {	    return this.title;	}	public void setTitle(String title) {	    this.title=title;	}	public String getKeyword() {	    return this.keyword;	}	public void setKeyword(String keyword) {	    this.keyword=keyword;	}	public String getDescription() {	    return this.description;	}	public void setDescription(String description) {	    this.description=description;	}	public Integer getDeleted() {	    return this.deleted;	}	public void setDeleted(Integer deleted) {	    this.deleted=deleted;	}	public String getTemplateContent() {	    return this.templateContent;	}	public void setTemplateContent(String templateContent) {	    this.templateContent=templateContent;	}	public java.sql.Timestamp getCreateTime() {	    return this.createTime;	}	public void setCreateTime(java.sql.Timestamp createTime) {	    this.createTime=createTime;	}	public Integer getCreateBy() {	    return this.createBy;	}	public void setCreateBy(Integer createBy) {	    this.createBy=createBy;	}	public java.sql.Timestamp getUpdateTime() {	    return this.updateTime;	}	public void setUpdateTime(java.sql.Timestamp updateTime) {	    this.updateTime=updateTime;	}	public Integer getUpdateBy() {	    return this.updateBy;	}	public void setUpdateBy(Integer updateBy) {	    this.updateBy=updateBy;	}
}
