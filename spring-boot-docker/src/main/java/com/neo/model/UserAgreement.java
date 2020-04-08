package com.neo.model;

import java.io.Serializable;

public class UserAgreement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String url;
	
	private String createTime;
	
	private String updateTime;
	
	//冗余字段
	private String operator;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "UserAgreement [id=" + id + ", url=" + url + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", operator=" + operator + "]";
	}

	  
}
