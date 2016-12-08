package com.weinxi.entity.template;

import java.io.Serializable;

public class TemplateData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 661816262429463025L;

	private TemplateFirst first;
	
	private TemplateDate day;
	
	private TemplateUser user;
	
	private TemplateContent content;
	
	private TemplateRemark remark;

	public TemplateFirst getFirst() {
		return first;
	}

	public void setFirst(TemplateFirst first) {
		this.first = first;
	}

	public TemplateDate getDay() {
		return day;
	}

	public void setDay(TemplateDate day) {
		this.day = day;
	}

	public TemplateUser getUser() {
		return user;
	}

	public void setUser(TemplateUser user) {
		this.user = user;
	}

	public TemplateContent getContent() {
		return content;
	}

	public void setContent(TemplateContent content) {
		this.content = content;
	}

	public TemplateRemark getRemark() {
		return remark;
	}

	public void setRemark(TemplateRemark remark) {
		this.remark = remark;
	}
}
